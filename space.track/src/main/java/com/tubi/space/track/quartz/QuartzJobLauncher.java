package com.tubi.space.track.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartzJobLauncher extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(QuartzJobLauncher.class);
 
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
            log.info("{}_{} was completed successfully", job.getName(), jobExecution.getId());
        } catch (Exception e) {
            log.error("Encountered job execution exception!", e);
        }
	}

}
