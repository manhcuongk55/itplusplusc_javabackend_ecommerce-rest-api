package vn.plusplusc.ecommerce.api.wallet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.controller.AbstractBaseController;
import vn.plusplusc.ecommerce.api.request.model.WalletRequest;
import vn.plusplusc.ecommerce.api.response.model.APIResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.database.model.UserToken;
import vn.plusplusc.ecommerce.database.model.Wallet;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.ecommerce.service.UserTokenService;
import vn.plusplusc.ecommerce.service.wallet.WalletService;
import vn.plusplusc.util.Constant;

/**
 *
 * @author manhcuong
 */
@RestController
@RequestMapping(APIName.WALLET)
public class WalletApi extends AbstractBaseController {
	@Autowired
	private WalletService wallService;
	@Autowired
	private UserTokenService userTokenService;

	@RequestMapping(method = RequestMethod.POST, produces = APIName.CHARSET)
	public ResponseEntity<APIResponse> transition(@PathVariable Long company_id, HttpServletRequest request, @RequestBody WalletRequest walletRequest) {
		String authToken = request.getHeader(Constant.HEADER_TOKEN);
		UserToken userToken = userTokenService.getTokenById(authToken);
		if (userToken != null) {
			String user_id = userToken.getUserId();
			Wallet wallet = wallService.findByUserId(user_id);
			if(wallet != null) {
				int type = walletRequest.getType();
				float money = wallet.getMoney();
				if(type == 0){
					money = money + walletRequest.getMoney();
				}else if(type ==1){
					money = money - walletRequest.getMoney();
				}
				wallet.setMoney(money);
				wallService.updateWallet(wallet);
			}
			return responseUtil.successResponse(wallet.getMoney());
		} else {
			throw new ApplicationException(APIStatus.ERR_UNAUTHORIZED);
		}

	}

}
