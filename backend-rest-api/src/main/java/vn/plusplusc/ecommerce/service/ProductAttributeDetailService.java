package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.ProductAttributeDetail;
import vn.plusplusc.ecommerce.repository.ProductAttributeDetailRepository;
/**
*
* @author manhcuong
*/
@Service
public class ProductAttributeDetailService {

    @Autowired
    private ProductAttributeDetailRepository productAttributeDetailRepository;

    public Iterable<ProductAttributeDetail> findAllByProductId(long productId) {
        return productAttributeDetailRepository.findAllByProductId(productId);
    }

    public ProductAttributeDetail findByProductIdAndAttributeId(long productId, long attributeId) {
        return productAttributeDetailRepository.findByProductIdAndAttributeId(productId, attributeId);
    }

}
