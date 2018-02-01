/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.service.product;

import java.util.List;
import org.springframework.data.domain.Page;

import vn.plusplusc.ecommerce.database.model.Product;
import vn.plusplusc.ecommerce.database.model.ProductCategory;
import vn.plusplusc.ecommerce.database.model.ProductCategoryId;

/**
*
* @author manhcuong
*/
public interface ProductService {
    //get all product
    Iterable<Product> findAllProduct();
    //get product by id
    Product getProductById(long companyId, long productId);
    //get product by id
//    List<Object[]> getProductById(long productId);
    // get by company id
    Page<Product> getByCompanyId(long companyId, int pageNumber, int pageSize);
    //get by company id category id
    Page<Product> getByCompanyIdAndCategoryId(long companyId, long categoryId, int pageNumber, int pageSize);
    //get filter
    Page<Product> doFilterSearchSortPagingProduct(long comId, long catId, long attrId, String searchKey, double mnPrice, double mxPrice, int minRank, int maxRank, int sortKey, boolean isAscSort, int pSize, int pNumber);
    //get list product by id
    Iterable<Product> getProductsById(long companyId, List<Long> productIds);
    //save product
    Product save(Product product);
    //update product
    Product update(Product product);
    //save product category
    void saveProductCategory(ProductCategory product);
    //delete product category
    void deleteProductCategory(ProductCategory product);
}
