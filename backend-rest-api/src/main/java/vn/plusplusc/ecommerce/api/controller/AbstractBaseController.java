/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.api.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import vn.plusplusc.ecommerce.api.response.util.ResponseUtil;
import vn.plusplusc.ecommerce.auth.AuthUser;
import vn.plusplusc.ecommerce.auth.service.CustomUserAuthService;
import vn.plusplusc.ecommerce.configs.AppConfig;
import vn.plusplusc.util.Constant;

/**
*
* @author manhcuong
*/
public abstract class AbstractBaseController {
    
    @Autowired
    private CustomUserAuthService userDetailsService;

    @Autowired
    AppConfig appConfig;
    
    @Autowired
    protected ResponseUtil responseUtil;
    
    public AuthUser getAuthUserFromSession(HttpServletRequest request) {
        String authToken = request.getHeader(Constant.HEADER_TOKEN);
        // try to load sessio
        AuthUser user = userDetailsService.loadUserByAccessToken(authToken);
        return user;
    }
}
