package com.tubi.space.track.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ResourceLoader;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig extends DefaultBatchConfigurer {
	
	@Bean
    public BatchDataSourceInitializer batchDataSourceInitializer(@Qualifier("batchDataSource") DataSource batchDataSource, ResourceLoader resourceLoader) {
        return new BatchDataSourceInitializer(batchDataSource, resourceLoader, new BatchProperties());
    }
	
	@Override
	@Autowired
	@DependsOn("batchDataSourceInitializer")
	public void setDataSource(@Qualifier("batchDataSource") DataSource batchDataSource) {
		super.setDataSource(batchDataSource);
	}

	
	@Bean
	Job job(JobBuilderFactory jobBuilder, Step step) {
		return jobBuilder.get("DFJ_etl")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
}
