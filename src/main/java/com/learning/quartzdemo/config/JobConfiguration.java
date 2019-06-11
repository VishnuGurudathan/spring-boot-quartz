/**
 * 
 * quartz-demo : JobConfiguration.java
 */
package com.learning.quartzdemo.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.quartzdemo.job.SampleJobA;
import com.learning.quartzdemo.job.SampleJobB;

/**
 * 
 * quartz-demo : com.learning.quartzdemo.config
 *
 * 
 * @author vishnu.g
 *
 * 09-Jun-2019
 * 
 */
@Configuration
public class JobConfiguration {
	
	 @Bean
	    public JobDetail jobADetails() {
		 return JobBuilder.newJob(SampleJobA.class).withIdentity("sampleJobA")
				 .storeDurably().build();
	    }

	    @Bean
	    public Trigger jobATrigger(JobDetail jobADetails) {

	        return TriggerBuilder.newTrigger().forJob(jobADetails)

	                .withIdentity("sampleTriggerA")
	                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * * *"))
	                .build();
	    }


	    @Bean
	    public JobDetail jobBDetails() {
	        return JobBuilder.newJob(SampleJobB.class).withIdentity("sampleJobB")
	        		.storeDurably().build();
	    }

	    @Bean
	    public Trigger jobBTrigger(JobDetail jobBDetails) {

	        return TriggerBuilder.newTrigger().forJob(jobBDetails)

	                .withIdentity("sampleTriggerB")
	                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * ? * * *"))
	                .build();
	    }


}

