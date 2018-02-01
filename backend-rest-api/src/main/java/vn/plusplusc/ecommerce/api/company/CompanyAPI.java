package vn.plusplusc.ecommerce.api.company;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.controller.AbstractBaseController;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.database.model.Company;
import vn.plusplusc.ecommerce.service.CompanyService;

/**
 *
 * @author manhcuong
 */
@RestController
public class CompanyAPI extends AbstractBaseController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = APIName.COMPANIES, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getAllCompanies() {
		List<Company> companies = (List<Company>) companyService.findAll();
		return responseUtil.successResponse(new StatusResponse(200, companies));
	}

	@RequestMapping(value = APIName.COMPANIES_SEARCH_BY_ID, method = RequestMethod.GET, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> getCompanyById(@PathVariable(value = "company_id") long company_id) {
		Company companies = companyService.findByCompanyId(company_id);
		return responseUtil.successResponse(new StatusResponse(200, companies));
	}
}
