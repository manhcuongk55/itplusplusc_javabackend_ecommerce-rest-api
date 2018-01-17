/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.service.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.api.request.model.CreateCategoryRequestModel;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.api.response.util.ResponseUtil;
import vn.plusplusc.ecommerce.database.model.Category;
import vn.plusplusc.ecommerce.database.model.Company;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.ecommerce.repository.CategoryRepository;
import vn.plusplusc.ecommerce.repository.CompanyRepository;
import vn.plusplusc.ecommerce.repository.specification.CategorySpecifications;
import vn.plusplusc.ecommerce.service.AbstractBaseService;
import vn.plusplusc.util.Constant;

/**
 * @author tungn
 */
@Service
public class CategoriesServiceImpl extends AbstractBaseService implements CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private CategorySpecifications categorySpecifications;


    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> saveOrUpdate(List<Category> categories) {
        return (List<Category>) categoryRepository.save(categories);
    }

    @Override
    public Category getActiveById(long categoryId) {
        return categoryRepository.findByCategoryIdAndStatus(categoryId, 1);
    }

    @Override
    public List<Category> getAllActiveByIdsAndCompanyId(List<Long> categoryIds, long companyId) {
        return categoryRepository.findAllByCategoryIdInAndCompanyIdAndStatus(categoryIds, companyId, 1);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Page<Category> getAllActiveWithFilterSearchSort(long companyId, String keyword, int pageNumber, int pageSize, int sortCase, boolean ascSort) {
        Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

        // create specification
        Specification spec = categorySpecifications.doFilterSearchSort(companyId, keyword, sortCase, ascSort);
        return categoryRepository.findAll(spec, pageable);
    }

}
