package com.tubi.space.track.config;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tubi.space.track.quartz.QuartzJobLauncher;

@Configuration
public class QuartzConfig {
	
	@Bean
	public JobDetail jobDetail(JobLauncher jobLauncher) {
		JobDataMap map = new JobDataMap();
		map.put("jobLauncher", jobLauncher);
		
		return JobBuilder.newJob()
				.ofType(QuartzJobLauncher.class)
				.storeDurably()
				.withIdentity("DFJ_Job_detail")
				.withDescription("Consume from Space Track and transform/feed the information to the database.")
				.usingJobData(map)
				.build();
	}
	
	@Bean
	public Trigger trigger(JobDetail job) {
	    return TriggerBuilder.newTrigger()
	    		.forJob(job)
	    		.withIdentity("DFJ_Trigger")
	    		.withDescription("Triggers the quartz job every hour")
	    		.withSchedule(SimpleScheduleBuilder.repeatHourlyForever())
	    		.build();
	}
}
