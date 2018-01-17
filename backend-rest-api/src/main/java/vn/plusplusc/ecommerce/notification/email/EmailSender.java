/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.notification.email;

import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.notification.email.transport.EmailTransportConfiguration;
import vn.plusplusc.ecommerce.tracelogged.EventLogManager;
/**
*
* @author manhcuong
*/
@Component
public class EmailSender {

    //private String SmtpHost="localhost";
    private String smtpHost = "";
    private int smtpPort = 25;
    private Boolean isSmtps = false;

    public boolean SendEmail(String mailto, String Subject, String Body) {
        boolean status = true;
        try {
            EmailTransportConfiguration.configure(smtpHost, smtpPort, isSmtps);
            // Send email
            new EmailMessage()
                    .from("no-reply@mydomain.com")
                    .to(mailto)
                    .withSubject(Subject)
                    .withBody(Body)
                    .send();
        } catch (Exception e) {
            EventLogManager.getInstance().error("Send mail error: " + e.getMessage());
            status = false;
        }
        return status;
    }
}
