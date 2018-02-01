package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.UserAddress;
import vn.plusplusc.ecommerce.repository.UserAddressRepository;
/**
*
* @author manhcuong
*/
@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    public UserAddress getAddressByUserIdAndStatus(String userId, int status) {
        return userAddressRepository.findByUserIdAndStatus(userId, status);
    }

}
