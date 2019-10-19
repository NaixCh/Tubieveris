package com.tubi.space.track.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeedDBJob implements Job {
	private static final Logger _log = LoggerFactory.getLogger(FeedDBJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.info("TESTING QUARTZ");
	}
}
