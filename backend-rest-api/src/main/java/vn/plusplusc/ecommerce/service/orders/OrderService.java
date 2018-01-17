package vn.plusplusc.ecommerce.service.orders;

import org.springframework.data.domain.Page;

import vn.plusplusc.ecommerce.api.request.model.OrdersRequestModel;
import vn.plusplusc.ecommerce.database.model.Orders;

/**
 *
 * @author Louis Duong
 */
public interface OrderService {

    public Page<Orders> doPagingOrders(OrdersRequestModel ordersRequestModel, Long companyId);

    public Orders getOrderByOrderIdAndCompanyID(Long orderId, Long companyId);

    public void updateStatusOrder(Orders order);
}
