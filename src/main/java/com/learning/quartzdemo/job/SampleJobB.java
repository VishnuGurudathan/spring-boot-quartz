/**
 * 
 * quartz-demo : SampleJobB.java
 */
package com.learning.quartzdemo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.learning.quartzdemo.event.EventLog;
import com.learning.quartzdemo.service.SampleService;

/**
 * 
 * quartz-demo : com.learning.quartzdemo.job
 *
 * 
 * @author vishnu.g
 *
 * 09-Jun-2019
 * 
 */
public class SampleJobB implements Job{
	@Autowired
    private SampleService sampleService;
	
    private static final Logger logger = LoggerFactory.getLogger(SampleJobB.class);


    @Override
    public void execute(JobExecutionContext context) {
    	try {
			logger.debug("scheduler instanceId for job {} is : {}",SampleJobB.class.getName(), context.getScheduler().getSchedulerInstanceId());
			EventLog.storeLog( context.getScheduler().getSchedulerInstanceId(), "Test", SampleJobB.class.getSimpleName());
		} catch (SchedulerException exc) {
			logger.error("error in fetching scheduler info, caused by - {}", exc.getMessage());
		}
    	sampleService.printTime();
    }
}

