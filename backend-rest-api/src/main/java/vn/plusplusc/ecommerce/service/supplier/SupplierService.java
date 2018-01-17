/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.service.supplier;

import java.util.List;
import org.springframework.data.domain.Page;

import vn.plusplusc.ecommerce.database.model.Supplier;
import vn.plusplusc.ecommerce.database.model.SupplierCategory;
import vn.plusplusc.ecommerce.database.model.SupplierCategoryId;

/**
 *
 * @author acer
 */
public interface SupplierService {
	// get all Supplier
	Iterable<Supplier> findAllSupplier();

	// get Supplier by id
	Supplier getSupplierById(long companyId, long SupplierId);

	// get Supplier by id
	// List<Object[]> getSupplierById(long SupplierId);
	// get by company id
	Page<Supplier> getByCompanyId(long companyId, int pageNumber, int pageSize);

	// get by company id category id
	Page<Supplier> getByCompanyIdAndCategoryId(long companyId, long categoryId, int pageNumber, int pageSize);

	// get filter
	Page<Supplier> doFilterSearchSortPagingSupplier(long comId, long catId, long attrId, String searchKey, double mnPrice,
			double mxPrice, int minRank, int maxRank, int sortKey, boolean isAscSort, int pSize, int pNumber);

	// get list Supplier by id
	Iterable<Supplier> getSuppliersById(long companyId, List<Long> SupplierIds);

	// save Supplier
	Supplier save(Supplier Supplier);

	// update Supplier
	Supplier update(Supplier Supplier);

	// save Supplier category
	void saveSupplierCategory(SupplierCategory Supplier);

	// delete Supplier category
	void deleteSupplierCategory(SupplierCategory Supplier);
}
