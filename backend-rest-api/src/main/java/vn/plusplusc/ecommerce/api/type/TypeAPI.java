package vn.plusplusc.ecommerce.api.type;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.api.response.util.ResponseUtil;
import vn.plusplusc.ecommerce.database.model.Category;
import vn.plusplusc.ecommerce.database.model.Type;
import vn.plusplusc.ecommerce.repository.CategoryRepository;
import vn.plusplusc.ecommerce.repository.TypeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manhcuong
 */
@RestController
@Api(value = "type API")
public class TypeAPI extends AbstractBaseAPI {
	
	@Autowired
    protected ResponseUtil responseUtil;
    @Autowired
    TypeRepository repository;

    @ApiOperation(value = "getTypes")
    @RequestMapping(value = APIName.TYPES_API, method = RequestMethod.GET, produces = APIName.CHARSET)
    public ResponseEntity<APIResponse> getTypes() {

        List<Type> types = (List<Type>) repository.findAll();
        return responseUtil.successResponse(types);

    }
}
