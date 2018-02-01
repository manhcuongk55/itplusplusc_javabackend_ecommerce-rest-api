package vn.plusplusc.ecommerce.api.supplier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.controller.AbstractBaseController;
import vn.plusplusc.ecommerce.api.request.model.CreateSupplierModel;
import vn.plusplusc.ecommerce.api.request.model.ListSupplierModel;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.model.PagingResponseModel;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.database.model.Category;
import vn.plusplusc.ecommerce.database.model.Supplier;
import vn.plusplusc.ecommerce.database.model.SupplierAttributeDetail;
import vn.plusplusc.ecommerce.database.model.SupplierCategory;
import vn.plusplusc.ecommerce.database.model.SupplierCategoryId;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.ecommerce.repository.CategoryRepository;
import vn.plusplusc.ecommerce.repository.SupplierCategoryRepository;
import vn.plusplusc.ecommerce.service.SupplierAttributeDetailService;
import vn.plusplusc.ecommerce.service.supplier.SupplierServiceImpl;
import vn.plusplusc.util.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
*
* @author manhcuong
*/
@Api(value = "suppliers")
@RestController
public class SupplierAPI extends AbstractBaseController {

	@Autowired
	private SupplierServiceImpl supplierService;
	@Autowired
	private SupplierAttributeDetailService supplierAttributeService;

	@Autowired
	private SupplierCategoryRepository supplierCategoryRepository;

	@Autowired
	private CategoryRepository categoryRepository;


	@ApiOperation(value = "get Suppliers", notes = "")
	@RequestMapping(path = APIName.SUPPLIERS, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getAllSuppliersCompanyId(@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_NUMBER) Integer pageNumber,
			@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_SIZE) Integer pageSize) {

		Page<Supplier> suppliers = supplierService.findAllSuppliers(pageNumber, pageSize);
		// statusResponse = new StatusResponse(APIStatus.OK.getCode(),
		// Suppliers.getContent(), Suppliers.getTotalElements());
		return responseUtil.successResponse(suppliers.getContent());
	}

	@ApiOperation(value = "get Supplier by company id", notes = "")
	@RequestMapping(path = APIName.SUPPLIER_COMPANYID, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getAllSuppliersCompanyId(@PathVariable("company_id") Long company_id,
			@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_NUMBER) Integer pageNumber,
			@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_SIZE) Integer pageSize) {

		Page<Supplier> suppliers = supplierService.getByCompanyId(company_id, pageNumber, pageSize);
		// statusResponse = new StatusResponse(APIStatus.OK.getCode(),
		// Suppliers.getContent(), Suppliers.getTotalElements());

		return responseUtil.successResponse(suppliers.getContent());
	}

	@ApiOperation(value = "get suppliers by Supplier id", notes = "")
	@RequestMapping(path = APIName.SUPPLIER_BY_ID, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getSupplierById(HttpServletRequest request, @PathVariable Long supplier_id,
			@PathVariable Long company_id) {
		System.out.println("id company : " + company_id.toString());
		// get Supplier
		Supplier p = supplierService.getSupplierById(company_id, supplier_id);
		if (p != null) {
			// get all attributes of Supplier
			// SupplierAttributeDetail pad =
			// SupplierAttributeService.findBySupplierIdAndAttributeId(Supplier_Id,
			// Constant.Supplier_ATTRIBUTE.DETAIL_IMAGES.getId());
			List<SupplierCategory> listSupplierCate = supplierCategoryRepository.getProCateBySupplierId(supplier_id);
			List<Map<String, Object>> listCate = new ArrayList<Map<String, Object>>();
			for (SupplierCategory result : listSupplierCate) {
				Map<String, Object> category = new HashMap();
				// find category name with categoryId
				Category cate = categoryRepository.findByCategoryId(result.getId().getCategoryId());
				if (cate != null) {
					category.put("text", cate.getName());
					category.put("id", cate.getCategoryId());
				}
				// add category name to list String
				listCate.add(category);
			}
			Map<String, Object> result = new HashMap();
			result.put("supplier", p);
			result.put("list_category", listCate);

			return responseUtil.successResponse(result);
		} else {
			throw new ApplicationException(APIStatus.GET_SUPPLIER_ERROR);
		}
	}

	@ApiOperation(value = "get list supplier by supplier ids", notes = "")
	@RequestMapping(path = APIName.SUPPLIER_BY_IDS, method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getListSupplierByIds(@PathVariable Long companyId,
			@RequestBody List<Long> SupplierIds) {

		if (SupplierIds != null && !SupplierIds.isEmpty()) {
			List<Supplier> Suppliers = (List<Supplier>) supplierService.getSuppliersById(companyId, SupplierIds);
			if (Suppliers != null) {
				// statusResponse = new StatusResponse(APIStatus.OK.getCode(),
				// Suppliers, Suppliers.size());
				return responseUtil.successResponse(Suppliers);
			} else {
				throw new ApplicationException(APIStatus.INVALID_PARAMETER);
			}
		} else {
			throw new ApplicationException(APIStatus.INVALID_PARAMETER);
		}

		// return writeObjectToJson(statusResponse);
	}

	@ApiOperation(value = "get Suppliers by category id", notes = "")
	@RequestMapping(value = APIName.SUPPLIER_BY_CATEGORY, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getSupplierByCategoryId(@PathVariable("companyId") Long companyId,
			@RequestParam Long categoryId,
			@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_NUMBER) Integer pageNumber,
			@RequestParam(required = false, defaultValue = Constant.DEFAULT_PAGE_SIZE) Integer pageSize) {

		Page<Supplier> Suppliers = supplierService.getByCompanyIdAndCategoryId(companyId, categoryId, pageNumber,
				pageSize);
		// return writeObjectToJson(new StatusResponse(APIStatus.OK.getCode(),
		// Suppliers.getContent(), Suppliers.getTotalElements()));
		return responseUtil.successResponse(Suppliers.getContent());
	}

	@ApiOperation(value = "filter Supplier list", notes = "")
	@RequestMapping(value = APIName.SUPPLIER_FILTER_LIST, method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getSupplierFilterList(HttpServletRequest request,
			@RequestBody ListSupplierModel listSupplier) {
		try {
			Page<Supplier> Suppliers = supplierService.doFilterSearchSortPagingSupplier(listSupplier.getCompanyId(),
					listSupplier.getCategoryId(), listSupplier.getAttributeId(), listSupplier.getSearchKey(),
					listSupplier.getMinPrice(), listSupplier.getMaxPrice(), listSupplier.getMinRank(),
					listSupplier.getMaxRank(), listSupplier.getSortCase(), listSupplier.getAscSort(),
					listSupplier.getPageSize(), listSupplier.getPageNumber());
			PagingResponseModel finalRes = new PagingResponseModel(Suppliers.getContent(), Suppliers.getTotalElements(),
					Suppliers.getTotalPages(), Suppliers.getNumber());
			return responseUtil.successResponse(finalRes);
		} catch (Exception ex) {
			throw new ApplicationException(APIStatus.GET_LIST_SUPPLIER_ERROR);
		}
	}

	@ApiOperation(value = "create supplier", notes = "")
	@RequestMapping(value = APIName.SUPPLIER_CREATE, method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> createSupplier(HttpServletRequest request,
			@RequestBody CreateSupplierModel supplierRequest) {
		try {
			Supplier supplier = new Supplier();
			supplier.setSupplierId(supplierRequest.getSupplierId());
			supplier.setAddress(supplierRequest.getAddress());
			supplier.setCompanyId(supplierRequest.getCompanyId());
			supplier.setCreateDate(new Date());
			supplier.setDescription(supplierRequest.getDescription());
			supplier.setName(supplierRequest.getName());
			supplier.setStatus(supplierRequest.getStatus());
			// create Supplier
			supplierService.save(supplier);
			// create Supplier categories
			for (Long categoriesId : supplierRequest.getListCategoriesId()) {
				SupplierCategoryId supplierCategoryId = new SupplierCategoryId();
				SupplierCategory supplierCategory = new SupplierCategory();
				supplierCategoryId.setCategoryId(categoriesId);
				supplierCategoryId.setSupplierId(supplier.getSupplierId());
				supplierCategory.setId(supplierCategoryId);
				System.out.println("id Supplier : " + supplier.getSupplierId().toString());
				supplierCategoryRepository.save(supplierCategory);
				// SupplierService.saveSupplierCategory(SupplierCategory);
			}
			return responseUtil.successResponse(supplier);
		} catch (Exception ex) {
			throw new ApplicationException(APIStatus.CREATE_SUPPLIER_ERROR);
		}
	}

	@ApiOperation(value = "delete Supplier list", notes = "")
	@RequestMapping(value = APIName.SUPPLIER_DELETE, method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> deleteSupplier(HttpServletRequest request, @RequestBody List<Long> ids,
			@PathVariable Long company_id) {
		try {
			for (Long id : ids) {
				Supplier Supplier = supplierService.getSupplierById(company_id, id);
				if (Supplier != null) {
					// //update status
					Supplier.setStatus(Constant.STATUS.DELETED_STATUS.getValue());
					supplierService.update(Supplier);
					List<SupplierCategory> listSupplierCate = supplierCategoryRepository.getProCateBySupplierId(id);
					for (SupplierCategory result : listSupplierCate) {
						// delete Supplier category
						supplierCategoryRepository.delete(result);
					}
				}
			}
			return responseUtil.successResponse(null);
		} catch (Exception ex) {
			throw new ApplicationException(APIStatus.DELETE_SUPPLIER_ERROR);
		}
	}

	@ApiOperation(value = "update Supplier", notes = "")
	@RequestMapping(value = APIName.SUPPLIER_UPDATE, method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> updateSupplier(HttpServletRequest request,
			@RequestBody CreateSupplierModel supplierRequest) {
		try {
			Supplier supplier = supplierService.getSupplierById(supplierRequest.getCompanyId(),
					supplierRequest.getSupplierId());
			if (supplier != null) {
				supplier.setSupplierId(supplierRequest.getSupplierId());
				supplier.setAddress(supplierRequest.getAddress());
				supplier.setCompanyId(supplierRequest.getCompanyId());
				supplier.setCreateDate(new Date());
				supplier.setDescription(supplierRequest.getDescription());
				supplier.setName(supplierRequest.getName());
				supplier.setStatus(supplierRequest.getStatus());
				// update Supplier
				supplierService.update(supplier);
				// delete old list Supplier category
				List<SupplierCategory> listSupplierCate = supplierCategoryRepository
						.getProCateBySupplierId(supplierRequest.getSupplierId());
				for (SupplierCategory result : listSupplierCate) {
					// delete Supplier category
					supplierCategoryRepository.delete(result);
				}
				// create new list Supplier categories
				for (Long categoriesId : supplierRequest.getListCategoriesId()) {
					SupplierCategoryId supplierCategoryId = new SupplierCategoryId();
					supplierCategoryId.setCategoryId(categoriesId);
					supplierCategoryId.setSupplierId(supplier.getSupplierId());
					SupplierCategory supplierCategory = new SupplierCategory();
					supplierCategory.setId(supplierCategoryId);
					supplierCategoryRepository.save(supplierCategory);
				}
				return responseUtil.successResponse(supplier);
			} else {
				throw new ApplicationException(APIStatus.GET_SUPPLIER_ERROR);
			}

		} catch (Exception ex) {
			throw new ApplicationException(APIStatus.UPDATE_SUPPLIER_ERROR);
		}
	}
}
