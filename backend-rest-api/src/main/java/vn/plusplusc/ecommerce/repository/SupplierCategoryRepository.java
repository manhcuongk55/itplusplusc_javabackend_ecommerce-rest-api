package vn.plusplusc.ecommerce.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.plusplusc.ecommerce.database.model.SupplierCategory;
import vn.plusplusc.ecommerce.database.model.SupplierCategoryId;
/**
*
* @author manhcuong
*/

@Repository
@Transactional
public interface SupplierCategoryRepository extends CrudRepository<SupplierCategory, SupplierCategoryId> {
    //todo
    Iterable<SupplierCategory> findById(SupplierCategoryId SupplierId);
    
    @Query("SELECT p FROM SupplierCategory p WHERE p.id.supplierId = :supplierId")
    List<SupplierCategory> getProCateBySupplierId(@Param("supplierId") Long supplierId);
}
