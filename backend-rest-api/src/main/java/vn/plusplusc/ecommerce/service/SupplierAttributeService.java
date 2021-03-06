/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.ProductAttribute;
import vn.plusplusc.ecommerce.repository.ProductAttributeRepository;

/**
*
* @author manhcuong
*/
@Service
public class SupplierAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public Iterable<ProductAttribute> findAll() {
        return productAttributeRepository.findAll();
    }
}
