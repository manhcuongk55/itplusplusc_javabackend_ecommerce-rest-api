package vn.plusplusc.ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import vn.plusplusc.ecommerce.database.model.Company;
/**
*
* @author manhcuong
*/
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query("SELECT c FROM Company c")
    Iterable<Company> findAll(Long companyId);

    @Query("SELECT c FROM Company c WHERE c.company_id = :company_id")
    Company findByCompanyId(@Param("company_id") Long company_id);
    
}
