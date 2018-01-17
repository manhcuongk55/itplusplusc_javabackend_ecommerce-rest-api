package vn.plusplusc.ecommerce.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
*
* @author manhcuong
*/
/*
 * A sample class for adding error information in the response
 */
@XmlRootElement
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}
