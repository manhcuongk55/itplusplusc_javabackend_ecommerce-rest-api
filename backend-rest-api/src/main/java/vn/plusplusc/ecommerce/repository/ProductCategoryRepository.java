package vn.plusplusc.ecommerce.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.plusplusc.ecommerce.database.model.ProductCategory;
import vn.plusplusc.ecommerce.database.model.ProductCategoryId;

/**
*
* @author manhcuong
*/
@Repository
@Transactional
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, ProductCategoryId> {
    //todo
    Iterable<ProductCategory> findById(ProductCategoryId productId);
    
    @Query("SELECT p FROM ProductCategory p WHERE p.id.productId = :productId")
    List<ProductCategory> getProCateByProductId(@Param("productId") Long productId);
}
