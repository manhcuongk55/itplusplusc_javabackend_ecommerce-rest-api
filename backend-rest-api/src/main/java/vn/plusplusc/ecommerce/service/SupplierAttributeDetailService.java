package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.SupplierAttributeDetail;
import vn.plusplusc.ecommerce.repository.SupplierAttributeDetailRepository;
/**
*
* @author manhcuong
*/
@Service
public class SupplierAttributeDetailService {

    @Autowired
    private SupplierAttributeDetailRepository supplierAttributeDetailRepository;

    public Iterable<SupplierAttributeDetail> findAllBySupplierId(long supplierId) {
        return supplierAttributeDetailRepository.findAllBySupplierId(supplierId);
    }

    public SupplierAttributeDetail findBySupplierIdAndAttributeId(long supplierId, long attributeId) {
        return supplierAttributeDetailRepository.findBySupplierIdAndAttributeId(supplierId, attributeId);
    }

}
