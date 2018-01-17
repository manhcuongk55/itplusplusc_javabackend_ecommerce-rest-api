package vn.plusplusc.ecommerce.service.supplier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Supplier;
import vn.plusplusc.ecommerce.database.model.SupplierCategory;
import vn.plusplusc.ecommerce.database.model.SupplierCategoryId;
import vn.plusplusc.ecommerce.repository.SupplierRepository;
import vn.plusplusc.ecommerce.repository.specification.SupplierSpecification;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository SupplierRepository;

    // currently this method is implement just for testing
    @Override
    public Iterable<Supplier> findAllSupplier() {
        return SupplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(long companyId, long SupplierId) {
        return SupplierRepository.findOne(SupplierId);
    }

//    @Override
//    public List<Object[]> getSupplierById(long SupplierId) {
////        return SupplierRepository.findBySupplierId(SupplierId);
//        return null;
//    }

    @Override
    public Page<Supplier> getByCompanyId(long companyId, int pageNumber, int pageSize) {
        return SupplierRepository.findByCompanyId(companyId, new PageRequest(pageNumber, pageSize));
    }

    @Override
    public Page<Supplier> getByCompanyIdAndCategoryId(long companyId, long categoryId, int pageNumber, int pageSize) {
        return null;
//        return SupplierRepository.findByCategoryId(companyId, categoryId, new PageRequest(pageNumber, pageSize));
    }

    @Override
    public Page<Supplier> doFilterSearchSortPagingSupplier(long comId, long catId, long attrId, String searchKey, double mnPrice, double mxPrice, int minRank, int maxRank, int sortKey, boolean isAscSort, int pSize, int pNumber) {
        return SupplierRepository.findAll(new SupplierSpecification(comId, catId, attrId, searchKey, mnPrice, mxPrice, minRank, maxRank, sortKey, isAscSort), new PageRequest(pNumber, pSize));
    }

    @Override
    public Iterable<Supplier> getSuppliersById(long companyId, List<Long> SupplierIds) {
        return SupplierRepository.findBySupplierIds(companyId, SupplierIds);
    }

    @Override
    public Supplier save(Supplier Supplier) {
        Supplier.setSupplierId(null);
        return SupplierRepository.save(Supplier);
    }

    @Override
    public Supplier update(Supplier Supplier) {
        return SupplierRepository.save(Supplier);
    }

    @Override
    public void saveSupplierCategory(SupplierCategory Supplier) {
//        SupplierRepository.saveSupplierCategory(Supplier.getSupplierId(), Supplier.getCategoryId());
    }

    @Override
    public void deleteSupplierCategory(SupplierCategory Supplier) {
//        SupplierRepository.deleteSupplierCategory(Supplier.getSupplierId());
    }
}
