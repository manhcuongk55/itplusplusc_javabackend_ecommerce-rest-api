/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package vn.plusplusc.ecommerce.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.User;
import vn.plusplusc.ecommerce.repository.RoleRepository;
import vn.plusplusc.util.Constant;

/**
*
* @author manhcuong
*/

@Service
public class AuthUserFactoryImpl implements AuthUserFactory{
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public AuthUser createAuthUser(User user) {
        return new AuthUser(
                    user.getUserId(),
                    user.getEmail(),
                    user.getPasswordHash(),
                    getUserRoleString(user.getRoleId()),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getStatus() == Constant.STATUS.ACTIVE_STATUS.getValue()
            );
    }
    
    private String getUserRoleString (int roleId){
        try {
            return roleRepository.findOne(roleId).getName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
