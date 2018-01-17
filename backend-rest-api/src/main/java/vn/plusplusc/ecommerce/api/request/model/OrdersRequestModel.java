
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
public class OrdersRequestModel {
    private String searchKey;
    private int sortCase;
    private boolean ascSort;
    private int pageNumber;
    private int pageSize;
    private int status;
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
	public boolean isAscSort() {
		return ascSort;
	}
	public void setAscSort(boolean ascSort) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
