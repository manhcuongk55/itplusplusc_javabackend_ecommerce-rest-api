package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.UserToken;
/**
*
* @author manhcuong
*/
public interface UserTokenRepository extends CrudRepository<UserToken, String> {

}
