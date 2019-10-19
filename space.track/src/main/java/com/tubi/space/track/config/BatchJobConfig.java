package com.tubi.space.track.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {
	
	@Bean
	Job job(JobBuilderFactory jobBuilder, Step step) {
		return jobBuilder.get("DFJ_etl")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
}
