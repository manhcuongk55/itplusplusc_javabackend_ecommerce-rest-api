/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package vn.plusplusc.ecommerce.api.request.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
*
* @author manhcuong
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestModel {
    public UserRequestModel user;
    public List<ProductInfo> productList;
	public UserRequestModel getUser() {
		return user;
	}
	public void setUser(UserRequestModel user) {
		this.user = user;
	}
	public List<ProductInfo> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}  
    
    
}
