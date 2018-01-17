/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.api.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.database.model.ProductAttribute;
import vn.plusplusc.ecommerce.service.ProductAttributeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
*
* @author manhcuong
*/
@RestController
@Api(value = "Productattribute API")
public class ProductAttributeAPI extends AbstractBaseAPI {

    @Autowired
    ProductAttributeService productAttributeService;

    @ApiOperation(value = "getProductAttribute")
    @RequestMapping(value = APIName.PRODUCT_ATTRIBUTES, method = RequestMethod.GET, produces = APIName.CHARSET)
    public String getProductAttribute() {

        List<ProductAttribute> productattribute = (List<ProductAttribute>) productAttributeService.findAll();
        return writeObjectToJson(new StatusResponse<>(HttpStatus.OK.value(), productattribute));

    }
    
}
