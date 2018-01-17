/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.plusplusc.ecommerce.scheduler;

import org.springframework.stereotype.Component;
/**
*
* @author manhcuong
*/
@Component
public abstract class JobWorker {
    
    public abstract JobType getJobType();
    public abstract String getJobName();
    public abstract void setJobName(String name);
    public abstract Boolean isQueueEmpty();
    public abstract void doWork();
    
    public static enum JobType {
        // Allow run single thread for each schedule
        SINGLE, 
        // Allow run multi-thread for each schedule & manage by thread pool size
        MULTIPLE 
    }
}
