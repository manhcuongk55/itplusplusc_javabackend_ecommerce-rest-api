
package vn.plusplusc.ecommerce.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import vn.plusplusc.ecommerce.database.model.OrderAddress;
/**
*
* @author manhcuong
*/
public interface OrderAddressRepository extends PagingAndSortingRepository<OrderAddress, Long> {
    OrderAddress findOneByOrderId(Long orderId);
}
