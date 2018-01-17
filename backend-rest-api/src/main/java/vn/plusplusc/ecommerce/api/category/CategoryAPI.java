package vn.plusplusc.ecommerce.api.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.api.response.util.ResponseUtil;
import vn.plusplusc.ecommerce.database.model.Category;
import vn.plusplusc.ecommerce.repository.CategoryRepository;

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
@Api(value = "category API")
public class CategoryAPI extends AbstractBaseAPI {
	
	@Autowired
    protected ResponseUtil responseUtil;
    @Autowired
    CategoryRepository repository;

    @ApiOperation(value = "getCategory")
    @RequestMapping(value = APIName.CATEGORIES, method = RequestMethod.GET, produces = APIName.CHARSET)
    public ResponseEntity<APIResponse> getCategories(@PathVariable(value = "company_id") Long companyId) {

        List<Category> categories = (List<Category>) repository.findByCompanyId(companyId);
        return responseUtil.successResponse(categories);

    }

    @RequestMapping(value = APIName.CATEGORIES, method = RequestMethod.POST, produces = APIName.CHARSET)
    @ResponseBody
    public ResponseEntity<APIResponse> addCatrgory(@PathVariable(value = "company_id") Long companyId,
            @RequestParam(name = "parent_id", required = false) Long ParentID,
            @RequestParam(name = "name", required = true) String name,
            @RequestParam(name = "status", required = false) Integer Status,
            @RequestParam(name = "position", required = false) Integer position,
            @RequestParam(name = "description", required = false) String description) {
        Category category = new Category();
        category.setCompanyId(companyId);
        category.setParentId(ParentID);
        category.setName(name);
        category.setStatus(Status);
        category.setPosition(position);
        category.setDescription(description);

        repository.save(category);
        return responseUtil.successResponse(category);

    }

    @RequestMapping(value = APIName.CATEGORIES_ID, method = RequestMethod.DELETE, produces = APIName.CHARSET)
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable(value = "id") Long categoryId) {
        System.out.println("category " + categoryId);
        Category category = repository.findByCategoryId(categoryId);
        if (category != null) {
            repository.delete(category);
            statusResponse = new StatusResponse(APIStatus.OK.getCode(), "delete account successfully");
        } else {
            statusResponse.setResult("not found");
        }

        return responseUtil.successResponse(statusResponse);

    }

    @RequestMapping(value = APIName.CATEGORIES_ID, method = RequestMethod.PUT, produces = APIName.CHARSET)
    public ResponseEntity<APIResponse> updateCategory(@PathVariable(value = "companyId") Long companyId,
            @PathVariable(value = "id") Long categoryId,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "status", required = false) Integer status,
            @RequestParam(name = "parent_id", required = false) Long ParentID,
            @RequestParam(name = "position", required = false) Integer position,
            @RequestParam(name = "description", required = false) String description) {

        Category category = repository.findByCategoryId(categoryId);

        if (category != null) {
            if (!name.equals("")) {
                category.setName(name);
            } else {
                statusResponse = new StatusResponse(APIStatus.OK.getCode(), "update name no successfully");
                return responseUtil.successResponse(statusResponse);
            }

            if (ParentID != null) {
                Category parent = repository.findOne(ParentID);
                if (parent != null && parent.getCompanyId() == category.getCompanyId()) {
                    category.setParentId(ParentID);
                } else {
                    statusResponse = new StatusResponse(APIStatus.OK.getCode(), "update parent_id no successfully");
                    return responseUtil.successResponse(statusResponse);
                }

            }
            if (status != null) {
                category.setStatus(status);
            }
            if (position != null) {
                category.setPosition(position);
            }
            if (description != null) {
                category.setDescription(description);
            }
            repository.save(category);
            statusResponse = new StatusResponse(APIStatus.OK.getCode(), category);
        }
        return responseUtil.successResponse(statusResponse);
    }
}
