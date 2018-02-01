package vn.plusplusc.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Company;
import vn.plusplusc.ecommerce.repository.CompanyRepository;
/**
*
* @author manhcuong
*/
@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findByCompanyId(Long companyId) {
        return companyRepository.findByCompanyId(companyId);
    }
}
