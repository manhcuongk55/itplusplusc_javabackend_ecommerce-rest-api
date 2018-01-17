
package vn.plusplusc.ecommerce.service.orders;

import vn.plusplusc.ecommerce.database.model.OrderAddress;

/**
 *
 * @author Louis Duong
 */
public interface OrderAddressService {
    public OrderAddress saveOrUpdate(OrderAddress orderAddress);
    public OrderAddress getOrderAddressByOrderId(Long orderId);
}
