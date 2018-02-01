
package vn.plusplusc.ecommerce.service.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.database.model.OrderAddress;
import vn.plusplusc.ecommerce.repository.OrderAddressRepository;
import vn.plusplusc.ecommerce.repository.OrderDetailRepository;
import vn.plusplusc.ecommerce.service.AbstractBaseService;
/**
*
* @author manhcuong
*/
@Component
public class OrderAddressImpl extends AbstractBaseService implements OrderAddressService {

    @Autowired
    OrderAddressRepository orderAddressRepository;
    
    
    @Override
    public OrderAddress saveOrUpdate(OrderAddress orderAddress) {
        return orderAddressRepository.save(orderAddress);
    }
    
    
    
    @Override
    public OrderAddress getOrderAddressByOrderId(Long orderId) {
        return orderAddressRepository.findOneByOrderId(orderId);
    }
    
    
}
