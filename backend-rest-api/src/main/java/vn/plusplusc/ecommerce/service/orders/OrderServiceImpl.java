
package vn.plusplusc.ecommerce.service.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.api.request.model.OrdersRequestModel;
import vn.plusplusc.ecommerce.database.model.Orders;
import vn.plusplusc.ecommerce.repository.OrdersRepository;
import vn.plusplusc.ecommerce.repository.specification.OrdersSpecification;
import vn.plusplusc.ecommerce.service.AbstractBaseService;

/**
 *
 * @author Louis Duong
 */
@Component
public class OrderServiceImpl extends AbstractBaseService implements OrderService {

    @Autowired
    OrdersRepository ordersRepository;
    
    /*
    ** Get list paging ,search sort for paging order
    */
    @Override
    public Page<Orders> doPagingOrders(OrdersRequestModel ordersRequestModel,Long companyId) {
        Page<Orders> listOrders = ordersRepository.findAll(new OrdersSpecification(companyId,ordersRequestModel.getSearchKey(), ordersRequestModel.getSortCase(), ordersRequestModel.isAscSort(),ordersRequestModel.getStatus()), new PageRequest(ordersRequestModel.getPageNumber(), ordersRequestModel.getPageSize()));
        return listOrders;
    }

    @Override
    public Orders getOrderByOrderIdAndCompanyID(Long orderId, Long companyId) {
        return ordersRepository.findOneByIdAndCompanyId(orderId, companyId);
    }

    @Override
    public void updateStatusOrder(Orders order) {
        ordersRepository.save(order);
    }

    
}
