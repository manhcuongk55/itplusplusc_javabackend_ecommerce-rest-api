
package vn.plusplusc.ecommerce.service.orders;

import vn.plusplusc.ecommerce.database.model.OrderAddress;

/**
*
* @author manhcuong
*/
public interface OrderAddressService {
    public OrderAddress saveOrUpdate(OrderAddress orderAddress);
    public OrderAddress getOrderAddressByOrderId(Long orderId);
}
