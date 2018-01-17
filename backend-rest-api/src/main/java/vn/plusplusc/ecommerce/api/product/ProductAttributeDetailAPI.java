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
import vn.plusplusc.ecommerce.database.model.ProductAttributeDetail;
import vn.plusplusc.ecommerce.service.ProductAttributeDetailService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author manhcuong
*/
@RestController
@Api(value = "ProductAttributeDetail API")

public class ProductAttributeDetailAPI extends AbstractBaseAPI {

    @Autowired
    ProductAttributeDetailService productAttributeDetailService;

    @ApiOperation(value = "getProductDetail")
    @RequestMapping(value = APIName.PRODUCT_DETAILS, method = RequestMethod.GET, produces = APIName.CHARSET)
    public String getProductDetail(@PathVariable(value = "product_id") Long productId) {

        List<ProductAttributeDetail> productdetails = (List<ProductAttributeDetail>) productAttributeDetailService.findAllByProductId(productId);
        if (productdetails != null) {
            return writeObjectToJson(new StatusResponse(200, productdetails));
        } else {
            statusResponse.setResult("not found");
        }

        return writeObjectToJson(statusResponse);
    }

}
