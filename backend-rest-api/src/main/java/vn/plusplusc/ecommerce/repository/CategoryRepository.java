package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.Category;

import java.util.List;
/**
*
* @author manhcuong
*/
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>, JpaSpecificationExecutor<Category> {

    Category findByCategoryId(@Param("categoryId") Long categoryId);

    Iterable<Category> findByCompanyId(@Param("companyId") Long companyId);

    Category findByCategoryIdAndStatus(long categoryId, int status);

    List<Category> findAllByCategoryIdInAndCompanyIdAndStatus(List<Long> categoryIds, long companyId, int status);

}
