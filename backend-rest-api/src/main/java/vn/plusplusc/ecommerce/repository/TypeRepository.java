package vn.plusplusc.ecommerce.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.Type;

/**
 *
 * @author manhcuong
 */
public interface TypeRepository extends PagingAndSortingRepository<Type, Long>, JpaSpecificationExecutor<Type> {

}
