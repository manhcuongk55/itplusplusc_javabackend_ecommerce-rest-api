package vn.plusplusc.ecommerce.api;

/**
 *
 * @author manhcuong
 */
public class APIName {

	public static final String VERSION_SUPPLIER = "api/v1";
	// version
	public static final String VERSION = "api/v1/{company_id}";

	// charset
	public static final String CHARSET = "application/json;charset=utf-8";

	// action user
	public static final String LOGIN = VERSION + "user/login";
	public static final String LOGOUT = VERSION + "user/logout";

	// SSO
	public static final String OAUTH_LOGIN = VERSION + "oauth/login";
	public static final String OAUTH_IMPLICIT_LOGIN = VERSION + "oauth/implicit/login";
	public static final String CHECK_API_KEY = VERSION + "oauth";

	// product api links
	public static final String PRODUCTS = VERSION + "/products";
	public static final String PRODUCTS_BY_CATEGORY = "/category";
	public static final String PRODUCT_BY_ID = "/detail/{product_id}";
	public static final String PRODUCT_BY_IDS = "/list";
	public static final String PRODUCTS_FILTER_LIST = "/filter";
	public static final String PRODUCT_DETAILS = "/productdetails/{product_id}";
	public static final String PRODUCT_ATTRIBUTES = VERSION + "/productattributes";
	public static final String PRODUCT_CREATE = "/create";
	public static final String PRODUCTS_DELETE = "/delete";
	public static final String PRODUCTS_UPDATE = "/update";
	// supplier api links
	public static final String SUPPLIERS = VERSION_SUPPLIER + "/suppliers";
	public static final String SUPPLIER_COMPANYID = VERSION + "/suppliers";
	public static final String SUPPLIER_BY_CATEGORY = "/category";
	public static final String SUPPLIER_BY_ID = "/detail/{supplier_id}";
	public static final String SUPPLIER_BY_IDS = "/list";
	public static final String SUPPLIER_FILTER_LIST = "/filter";
	public static final String SUPPLIER_DETAILS = "/supplierdetails/{supplier_id}";
	public static final String SUPPLIER_ATTRIBUTES = VERSION + "/supplierattributes";
	public static final String SUPPLIER_CREATE = "/create";
	public static final String SUPPLIER_DELETE = "/delete";
	public static final String SUPPLIER_UPDATE = "/update";
	// category api links
	public static final String CATEGORIES = VERSION + "/categories";
	public static final String CATEGORIES_BY_SUPPLIER_ID = VERSION + "/categories/{supplier_id}";
	public static final String CATEGORIES_ID = VERSION + "/categories/{id}";

	// company api link
	public static final String COMPANIES = "/companies";
	public static final String COMPANIES_SEARCH_BY_ID = COMPANIES + "/{company_id}";

	// user api link
	public static final String USERS = VERSION + "/users";
	public static final String USER_REGISTER = "/register";
	public static final String USER_LIST = "/list";
	public static final String USERS_LOGIN = "/login";
	public static final String USERS_LOGOUT = "/logout";
	public static final String USER_DETAILS = "/detail/{userId}";
	public static final String UPDATE_USER = "/update";
	public static final String DELETE_USER = "/delete";
	public static final String CHANGE_PASSWORD_USER = "/changePassword";

	// review api link
	public static final String REVIEWS = VERSION + "/reviews";
	public static final String REVIEWS_BY_PRODUCT_ID = "/{id}";
	public static final String REVIEWS_ADD = "/add";

	// Orders
	public static final String ORDERS = VERSION + "/orders";
	public static final String ORDER_CREATE = "/create";
	public static final String ORDERS_BY_COMPANY = "/listOrder";
	public static final String ORDERS_DETAIL_BY_COMPANY = "detail/{order_id}";
	public static final String CHANGE_STATUS_ORDERS_BY_COMPANY = "/delete/{order_id}/{status}";

	// auth APIs
	public static final String AUTH_API = VERSION + "/auth";
	public static final String SESSION_DATA = "/session/data";
	public static final String USER_LOGOUT = "/logout";
	public static final String ADMIN_LOGIN_API = "/admin/login";

	// Categories APIs
	public static final String CATEGORIES_API = VERSION + "/categories";
	public static final String CATEGORIES_ADD = "/create";
	public static final String CATEGORIES_UPDATE = "/update";
	public static final String CATEGORIES_DELETE = "/delete";
	public static final String CATEGORIES_DETAIL = "/detail/{category_id}";
	public static final String CATEGORIES_LIST = "/list";

	// Types APIs
	public static final String TYPES_API = "/types";
	public static final String TYPES_ADD = "/create";
	public static final String TYPES_UPDATE = "/update";
	public static final String TYPES_DELETE = "/delete";
	public static final String TYPES_DETAIL = "/detail/{type_id}";
	public static final String TYPES_LIST = "/list";

	// Upload file API
	public static final String UPLOAD_API = VERSION + "/upload";
	public static final String UPLOAD_FILE = "/file";
	
	// wallet
	public static final String WALLET = VERSION + "/wallet";
}
