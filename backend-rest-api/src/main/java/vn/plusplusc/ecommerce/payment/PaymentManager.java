/*
 */
package vn.plusplusc.ecommerce.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.payment.PaymentMethod;
import vn.plusplusc.ecommerce.payment.StripePayment;
/**
*
* @author manhcuong
*/
@Component
public class PaymentManager {

    @Autowired
    private StripePayment stripePayment;
    

    public PaymentMethod createPaymentMethod(PaymentMethod.PaymentType type) {
        switch (type) {
            case STRIPE:
                return stripePayment;
//            case PAYPAL:
//                return new PaypalPayment();
            default:
                return null;
        }
    }

    public static Integer convertPriceByCurrency(Integer amount, Integer currencyType) {
        if (currencyType == PaymentMethod.currencyPaymentType.USD.getValue()) {
                return amount * 100;
        }
        return amount;
    }
    
    public static String getCurrencyByType(Integer currencyType) {
        if (currencyType == PaymentMethod.currencyPaymentType.USD.getValue()) {
                return PaymentMethod.currencyPaymentType.USD.getType();
        }
        return PaymentMethod.currencyPaymentType.USD.getType();
    }
}
