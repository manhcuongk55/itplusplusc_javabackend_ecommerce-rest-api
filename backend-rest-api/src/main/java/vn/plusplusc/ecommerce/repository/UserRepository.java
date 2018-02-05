package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.User;
/**
*
* @author manhcuong
*/
public interface UserRepository extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {
	@Query("SELECT u FROM User u WHERE u.google_id = :google_id")
	User findByGoogleID(@Param("google_id") String google_id);
	
	@Query("SELECT u FROM User u WHERE u.face_id = :face_id")
	User findByFaceID(@Param("face_id") String face_id);
	
    User findByEmailAndCompanyIdAndStatus(String email, Long companyId, int status);

    User findByUserIdAndCompanyIdAndStatus(String userId, Long companyId, int status);
    
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.companyId = :companyId")
    User findByEmail(@Param("email") String email, @Param("companyId") long companyId);
}
