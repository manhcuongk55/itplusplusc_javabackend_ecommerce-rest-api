/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package vn.plusplusc.ecommerce.api.request.model;

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
public class UserListRequestModel {
    public String searchKey;
    public int sortCase;
    public Boolean ascSort;
    public int pageNumber;
    public int pageSize;
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public int getSortCase() {
		return sortCase;
	}
	public void setSortCase(int sortCase) {
		this.sortCase = sortCase;
	}
	public Boolean getAscSort() {
		return ascSort;
	}
	public void setAscSort(Boolean ascSort) {
		this.ascSort = ascSort;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
    
    
}
