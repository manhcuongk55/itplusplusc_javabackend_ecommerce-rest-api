/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package vn.plusplusc.ecommerce.service.auth;

import vn.plusplusc.ecommerce.database.model.User;
import vn.plusplusc.ecommerce.database.model.UserToken;
/**
 *
 * @author manhcuong
 */
 
public interface AuthService {
    
    public User getUserByEmailAndCompanyIdAndStatus (String email, Long companyId, int status);

    public UserToken createUserToken(User adminUser, boolean keepMeLogin);
    
    public User getUserByUserIdAndCompanyIdAndStatus (String userId, Long companyId, int status);
    
    public UserToken getUserTokenById (String id);
    
    public void deleteUserToken (UserToken userToken);
}
