
package vn.plusplusc.ecommerce.service.orders;

import java.util.List;

import vn.plusplusc.ecommerce.database.model.OrderDetail;

/**
*
* @author manhcuong
*/
public interface OrderDetailService {
    public OrderDetail saveOrUpdate(OrderDetail orderDetail);
    public List<OrderDetail> getListOrderDetail(Long orderId);
}
