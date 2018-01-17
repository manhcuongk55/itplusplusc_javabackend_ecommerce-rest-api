package vn.plusplusc.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import vn.plusplusc.ecommerce.database.model.Payment;
/**
*
* @author manhcuong
*/
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    
    Payment findByPaymentId(Long paymentId);
}
