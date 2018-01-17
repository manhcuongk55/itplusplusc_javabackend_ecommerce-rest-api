package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.SupplierAttributeDetail;
/**
*
* @author manhcuong
*/
public interface SupplierAttributeDetailRepository extends CrudRepository<SupplierAttributeDetail, Long> {

    @Query("SELECT pad FROM SupplierAttributeDetail pad WHERE pad.supplierId = :supplierId")
    Iterable<SupplierAttributeDetail> findAllBySupplierId(@Param("supplierId") long supplierId);

    @Query("SELECT pad FROM SupplierAttributeDetail pad WHERE pad.supplierId = :supplierId AND pad.attributeId = :attributeId")
    SupplierAttributeDetail findBySupplierIdAndAttributeId(@Param("supplierId") long supplierId, @Param("attributeId") long attributeId);

}
