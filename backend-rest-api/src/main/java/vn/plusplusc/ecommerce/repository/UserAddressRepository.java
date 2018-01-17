package vn.plusplusc.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import vn.plusplusc.ecommerce.database.model.UserAddress;
/**
*
* @author manhcuong
*/
public interface UserAddressRepository extends CrudRepository<UserAddress, String> {
    UserAddress findByUserIdAndStatus(String userId, int status);
    
    UserAddress findByAdressIdAndStatus(Long adressId, int status);
}
