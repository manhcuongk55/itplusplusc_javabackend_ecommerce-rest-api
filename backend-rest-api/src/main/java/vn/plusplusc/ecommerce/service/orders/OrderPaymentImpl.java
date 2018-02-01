package vn.plusplusc.ecommerce.service.orders;

import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.database.model.OrderPayment;
import vn.plusplusc.ecommerce.service.AbstractBaseService;
/**
*
* @author manhcuong
*/
@Component
public class OrderPaymentImpl extends AbstractBaseService implements OrderPaymentService {

//    @Autowired
//    OrderPaymentRepository orderPaymentRepository;

    @Override
    public OrderPayment getOrderPaymentByOrderId(Long orderId) {
        try {
            return null;
//            return orderPaymentRepository.findOneByOrderIdAndStatus(orderId, Constant.STATUS.ACTIVE_STATUS.getValue());
        } catch (Exception ex) {
            System.out.println("error when get order payment : " + ex.getLocalizedMessage());
            return null;
        }
    }

}
