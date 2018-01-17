/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package vn.plusplusc.ecommerce.auth;

import vn.plusplusc.ecommerce.database.model.User;
/**
*
* @author manhcuong
*/
public interface AuthUserFactory {
    
    AuthUser createAuthUser (User user);
}
