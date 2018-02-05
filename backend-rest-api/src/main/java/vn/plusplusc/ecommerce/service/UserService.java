package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.User;
import vn.plusplusc.ecommerce.database.model.UserToken;
import vn.plusplusc.ecommerce.repository.UserRepository;
import vn.plusplusc.ecommerce.repository.UserTokenRepository;
import vn.plusplusc.ecommerce.repository.specification.UserSpecification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
/**
*
* @author manhcuong
*/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;
    
    public User getUserByEmail(String email, long companyId, int status) {
        return userRepository.findByEmailAndCompanyIdAndStatus(email, companyId, status);
    }

    public User save(User users) {
        return userRepository.save(users);
    }

    public User getUserByUserIdAndComIdAndStatus(String userId, Long companyId, int status) {
        return userRepository.findByUserIdAndCompanyIdAndStatus(userId, companyId, status);
    }

    public User getUserByActivationCode(String token) {
        UserToken userToken = userTokenRepository.findOne(token);

        if (userToken != null) {
            return userRepository.findOne(userToken.getUserId());
        } else {
            return null;
        }
    }
    
    public Page<User> doFilterSearchSortPagingUser(String userId,long companyId, String searchKey, int sortKey, boolean isAscSort, int pSize, int pNumber) {
        return userRepository.findAll(new UserSpecification(userId, companyId, searchKey, sortKey, isAscSort), new PageRequest(pNumber, pSize));
    }
    
    public User findUserByGoogleId(String google_id){
    	return userRepository.findByGoogleID(google_id);
    }
    public User findUserByFaceId(String face_id){
    	return userRepository.findByFaceID(face_id);
    }
}
