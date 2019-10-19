package com.tubi.space.track.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchStepConfig {
	
	@Bean
	Step step(StepBuilderFactory stepBuilder) {
		return stepBuilder.get("DFJ_etl_step")
				.<String, String>chunk(100)
				.reader(null)
				.writer(null)
				.build();
	}
}
