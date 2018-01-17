
package vn.plusplusc.ecommerce.service.orders;

import java.util.List;

import vn.plusplusc.ecommerce.database.model.OrderPayment;

/**
 *
 * @author Louis Duong
 */
public interface OrderPaymentService {
    public OrderPayment getOrderPaymentByOrderId(Long orderId);
}
