package vn.plusplusc.ecommerce.api.orders;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.request.model.AuthRequestModel;
import vn.plusplusc.ecommerce.api.request.model.OrderRequestModel;
import vn.plusplusc.ecommerce.api.request.model.ProductInfo;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.api.response.util.ResponseUtil;
import vn.plusplusc.ecommerce.database.model.OrderAddress;
import vn.plusplusc.ecommerce.database.model.OrderDetail;
import vn.plusplusc.ecommerce.database.model.Orders;
import vn.plusplusc.ecommerce.database.model.Payment;
import vn.plusplusc.ecommerce.database.model.Product;
import vn.plusplusc.ecommerce.database.model.User;
import vn.plusplusc.ecommerce.database.model.UserAddress;
import vn.plusplusc.ecommerce.database.model.UserToken;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.ecommerce.service.OrdersService;
import vn.plusplusc.ecommerce.service.UserAddressService;
import vn.plusplusc.ecommerce.service.UserService;
import vn.plusplusc.ecommerce.service.UserTokenService;
import vn.plusplusc.ecommerce.service.orders.OrderAddressImpl;
import vn.plusplusc.ecommerce.service.orders.OrderDetailImpl;
import vn.plusplusc.ecommerce.service.product.ProductService;
import vn.plusplusc.util.Constant;
import vn.plusplusc.util.UniqueID;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author manhcuong
*/
@RestController
@RequestMapping(value = APIName.ORDERS)
public class OrdersAPI extends AbstractBaseAPI {

    @Autowired
    OrdersService ordersService;
    @Autowired
    UserService customerService;
    @Autowired
    UserTokenService userTokenService;
    @Autowired
    UserAddressService userAddressService;
    @Autowired
    OrderAddressImpl orderAddressImpl;
    @Autowired
    ProductService productService;
    @Autowired
    OrderDetailImpl orderDetailImpl;
    @Autowired
    ResponseUtil responseUtil;

    @RequestMapping(value = APIName.ORDER_CREATE, method = RequestMethod.POST, produces = APIName.CHARSET)
    @ResponseBody
    public ResponseEntity<APIResponse> addOrders(
            @PathVariable Long company_id,
            @RequestBody OrderRequestModel orderRequest) {

        Date createDate = new Date();
        //Create Order General Info
        Orders orders = new Orders();
        orders.setUserId(orderRequest.getUser().getUserId());
        orders.setCompanyId(company_id);
        orders.setCustomerEmail(orderRequest.getUser().getEmail());
        orders.setCustomerFirstname(orderRequest.getUser().getFirstName());
        orders.setCustomerMiddlename(orderRequest.getUser().getMiddleName());
        orders.setCustomerLastname(orderRequest.getUser().getLastName());
        orders.setStatus(Constant.ORDER_STATUS.PENDING.getStatus());
        orders.setCreatedAt(createDate);
        orders.setUpdatedAt(createDate);
        ordersService.save(orders);
        
        //Crerate User address
        UserAddress userAddress = null;
        if (orderRequest.getUser().getUserId() == null || orderRequest.getUser().getUserId().isEmpty()) {
            userAddress = new UserAddress();
            userAddress.setUserId(orderRequest.getUser().getUserId());
            userAddress.setAdress(orderRequest.getUser().getAddress());
            userAddress.setPhone(orderRequest.getUser().getPhone());
            userAddress.setFax(orderRequest.getUser().getFax());
            userAddress.setCity(orderRequest.getUser().getCity());
            userAddress.setCountry(orderRequest.getUser().getCountry());
            userAddress.setStatus(Constant.STATUS.ACTIVE_STATUS.getValue());
            userAddressService.save(userAddress);
        }else{
            userAddress = userAddressService.getAddressByUserIdAndStatus(orderRequest.getUser().getUserId(), Constant.STATUS.ACTIVE_STATUS.getValue());
        }

        //Craete Order Address Info
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setAdressId(userAddress.getAdressId());
        orderAddress.setOrderId(orders.getId());
        orderAddress.setCreatedAt(createDate);
        orderAddressImpl.saveOrUpdate(orderAddress);

        if (orderRequest.getProductList().size() > 0) {
            for (ProductInfo productInfo : orderRequest.getProductList()) {
                Product product = productService.getProductById(company_id, productInfo.getProductId());
                if (product != null) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(orders.getId());
                    orderDetail.setProductId(product.getProductId());
                    orderDetail.setName(product.getName());
                    orderDetail.setPrice(product.getSalePrice());
                    orderDetail.setQuantity(productInfo.getQuantity());
                    orderDetail.setPaymentId(company_id);
                    orderDetail.setCreatedAt(createDate);
                    orderDetailImpl.saveOrUpdate(orderDetail);
                }
            }
        }
        return responseUtil.successResponse(orders);
    }

    @ApiOperation(value = "get orders by company id", notes = "")
    @RequestMapping(value = APIName.ORDERS_BY_COMPANY, method = RequestMethod.GET, produces = APIName.CHARSET)
    public String getOrdersCompanyId(
            @PathVariable(value = "id") Long companyId,
            @RequestParam(defaultValue = Constant.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize) {

        //http://localhost:8080/api/orders/1?pagenumber=1&pagesize=2
        Page<Orders> orders = ordersService.findAllByCompanyId(companyId, pageNumber, pageSize);
        return writeObjectToJson(new StatusResponse(200, orders.getContent(), orders.getTotalElements()));

    }
}
