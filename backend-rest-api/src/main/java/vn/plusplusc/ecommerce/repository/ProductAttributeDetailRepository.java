package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.ProductAttributeDetail;
/**
*
* @author manhcuong
*/
public interface ProductAttributeDetailRepository extends CrudRepository<ProductAttributeDetail, Long> {

    @Query("SELECT pad FROM ProductAttributeDetail pad WHERE pad.productId = :productId")
    Iterable<ProductAttributeDetail> findAllByProductId(@Param("productId") long productId);

    @Query("SELECT pad FROM ProductAttributeDetail pad WHERE pad.productId = :productId AND pad.attributeId = :attributeId")
    ProductAttributeDetail findByProductIdAndAttributeId(@Param("productId") long productId, @Param("attributeId") long attributeId);

}
