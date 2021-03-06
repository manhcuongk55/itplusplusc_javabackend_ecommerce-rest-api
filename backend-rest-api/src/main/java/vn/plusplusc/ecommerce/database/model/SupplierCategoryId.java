/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.database.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
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
@Embeddable
public class SupplierCategoryId implements Serializable{
//    @Id
    @Basic(optional = false)
    @Column(name = "supplier_id")
    private Long supplierId;

//    @Id
    @Basic(optional = false)
    @Column(name = "category_id")
    private Long categoryId;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long SupplierId) {
		this.supplierId = SupplierId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
    
}
