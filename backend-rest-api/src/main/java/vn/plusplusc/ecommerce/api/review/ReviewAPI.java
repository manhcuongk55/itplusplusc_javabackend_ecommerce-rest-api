package vn.plusplusc.ecommerce.api.review;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.plusplusc.ecommerce.api.APIName;
import vn.plusplusc.ecommerce.api.AbstractBaseAPI;
import vn.plusplusc.ecommerce.api.response.model.StatusResponse;
import vn.plusplusc.ecommerce.api.response.util.APIStatus;
import vn.plusplusc.ecommerce.database.model.Review;
import vn.plusplusc.ecommerce.database.model.User;
import vn.plusplusc.ecommerce.database.model.UserToken;
import vn.plusplusc.ecommerce.exception.ApplicationException;
import vn.plusplusc.ecommerce.service.ReviewService;
import vn.plusplusc.ecommerce.service.UserService;
import vn.plusplusc.ecommerce.service.UserTokenService;
import vn.plusplusc.util.Constant;
import vn.plusplusc.util.UniqueID;
/**
*
* @author manhcuong
*/
@RestController
@RequestMapping(APIName.REVIEWS)
public class ReviewAPI extends AbstractBaseAPI {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    UserService userService;
    @Autowired
    UserTokenService userTokenService;

    @RequestMapping(value = APIName.REVIEWS_BY_PRODUCT_ID, method = RequestMethod.GET, produces = APIName.CHARSET)
    public String getReviewByProductId(@PathVariable(value = "id") Long productId, @RequestParam(value = "pagenumber", defaultValue = Constant.DEFAULT_PAGE_NUMBER,
            required = false) int pageNumber, @RequestParam(value = "pagesize", defaultValue = Constant.DEFAULT_PAGE_SIZE, required = false) int pageSize) {

        Page<Review> reviews = reviewService.findByProductId(productId, pageNumber, pageSize);
        return writeObjectToJson(new StatusResponse(200, reviews.getContent(), reviews.getTotalElements()));

    }

    @RequestMapping(value = APIName.REVIEWS_ADD, method = RequestMethod.POST, produces = APIName.CHARSET)
    public String createReview(
            HttpServletRequest request,
            @RequestBody Review reviewBody,
            @PathVariable Long companyId) {

        String token = request.getParameter("token");

        if (token != null && !token.isEmpty()) {
            Date now = new Date();
            UserToken usertoken = userTokenService.getTokenById(token); // get user token form database

            if (usertoken == null) {
                statusResponse = new StatusResponse(APIStatus.ERR_UNAUTHORIZED);
            } else if (usertoken.getExpirationDate().getTime() - now.getTime() > 0) {
                statusResponse = new StatusResponse(APIStatus.ERR_UNAUTHORIZED);
            } else {
                // find user by token id
                User user = userService.getUserByUserIdAndComIdAndStatus(usertoken.getUserId(), companyId, Constant.USER_STATUS.ACTIVE.getStatus());

                // validate user
                if (user != null && user.getUserId() != null && !user.getUserId().isEmpty()) {
                    // set user id for review
                    reviewBody.setUserId(user.getUserId());
                    // set company id
                    reviewBody.setCompanyId(companyId);
                    // set date created
                    reviewBody.setCreateDate(new Date());

                    reviewService.save(reviewBody);
                    statusResponse = new StatusResponse(APIStatus.OK);
                } else {
                    statusResponse = new StatusResponse(APIStatus.ERR_USER_NOT_EXIST);
                }
            }
        } else {
            statusResponse = new StatusResponse(APIStatus.INVALID_PARAMETER);
        }

        return writeObjectToJson(statusResponse);
    }

}
