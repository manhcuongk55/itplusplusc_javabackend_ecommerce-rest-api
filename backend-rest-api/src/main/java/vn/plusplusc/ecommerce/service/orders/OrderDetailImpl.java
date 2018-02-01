
package vn.plusplusc.ecommerce.service.orders;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.database.model.OrderDetail;
import vn.plusplusc.ecommerce.repository.OrderDetailRepository;
import vn.plusplusc.ecommerce.service.AbstractBaseService;

/**
*
* @author manhcuong
*/
@Component
public class OrderDetailImpl extends AbstractBaseService implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;
    
    @Override
    public OrderDetail saveOrUpdate(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
    
    @Override
    public List<OrderDetail> getListOrderDetail(Long orderId) {
        return orderDetailRepository.findAllByOrderId(orderId);
    }

    
    
}
