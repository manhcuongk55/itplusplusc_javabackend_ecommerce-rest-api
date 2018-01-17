
package vn.plusplusc.ecommerce.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

import vn.plusplusc.ecommerce.database.model.OrderDetail;
/**
*
* @author manhcuong
*/
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Long> {
    
    List<OrderDetail> findAllByOrderId(Long orderId);
}
