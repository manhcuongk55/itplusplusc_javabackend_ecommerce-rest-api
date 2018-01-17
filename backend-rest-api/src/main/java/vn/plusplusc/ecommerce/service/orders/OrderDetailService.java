
package vn.plusplusc.ecommerce.service.orders;

import java.util.List;

import vn.plusplusc.ecommerce.database.model.OrderDetail;

/**
 *
 * @author Louis Duong
 */
public interface OrderDetailService {
    public OrderDetail saveOrUpdate(OrderDetail orderDetail);
    public List<OrderDetail> getListOrderDetail(Long orderId);
}
