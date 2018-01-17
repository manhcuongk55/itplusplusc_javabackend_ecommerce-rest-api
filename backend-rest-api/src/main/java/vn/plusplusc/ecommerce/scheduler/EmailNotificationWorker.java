/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.scheduler;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import vn.plusplusc.ecommerce.core.LocalQueueManager;
import vn.plusplusc.ecommerce.notification.email.EmailSender;
import vn.plusplusc.ecommerce.tracelogged.EventLogManager;

/**
*
* @author manhcuong
*/
@Component
public class EmailNotificationWorker extends JobWorker{

    //static Logger logger = Logger.getLogger("service");
    @Autowired private EmailSender emailSender;
  
    @Async
    @Override
    public void doWork(){
        if (!LocalQueueManager.getInstance().IsMailQueueEmpty()) {
           // EventLogManager.getInstance().info("doWork send notification email");
            Map<String, Object> request= LocalQueueManager.getInstance().getMailQueue();
            String emailAddress=(String)request.get("mail_address");
            String subject=(String)request.get("subject");
            String body=(String)request.get("body");
            EventLogManager.getInstance().info("EmailNotificationWorker Send email to=" +emailAddress);
            emailSender.SendEmail(emailAddress, subject, body);
        }
    }    
   private String jobName = "EmailNotificationWorker";
    @Override
    public String getJobName() {
        return this.jobName;
    }

    @Override
    public void setJobName(String name) {
        this.jobName=name;
    }
    
    @Override
    public synchronized Boolean isQueueEmpty() {
        return LocalQueueManager.getInstance().IsMailQueueEmpty();
    }

    @Override
    public JobType getJobType() {
       return JobType.MULTIPLE;
    }
    
}
