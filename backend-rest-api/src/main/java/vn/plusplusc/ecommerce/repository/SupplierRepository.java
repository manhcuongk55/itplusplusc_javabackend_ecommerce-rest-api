package vn.plusplusc.ecommerce.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.Supplier;
import vn.plusplusc.ecommerce.database.model.SupplierCategory;
import vn.plusplusc.ecommerce.database.model.SupplierCategoryId;

/**
 *
 * @author manhcuong
 */
public interface SupplierRepository
		extends PagingAndSortingRepository<Supplier, Long>, JpaSpecificationExecutor<Supplier> {
   
	Page<Supplier> findAll(Pageable pageable);
	
	Page<Supplier> findByCompanyId(@Param("companyId") long companyId, Pageable pageable);

	@Query("SELECT p FROM Supplier p WHERE p.companyId = :companyId AND p.supplierId IN (:supplierIds)")
	Iterable<Supplier> findBySupplierIds(@Param("companyId") long companyId,
			@Param("supplierIds") List<Long> supplierIds);

}
