package com.tubi.space.track.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tubi.space.track.batch.OverwriteListener;
import com.tubi.space.track.batch.Processor;
import com.tubi.space.track.batch.RestItemReader;
import com.tubi.space.track.domain.Debris;
import com.tubi.space.track.domain.Satellite;

@Configuration
@EnableBatchProcessing
public class BatchStepConfig {
	
	private static final String QUERY = "INSERT INTO DEBRIS (OBJECT_ID, OBJECT_NAME, RA_OF_ASC_NODE, MEAN_MOTION, TYPE, SIZE, SCALE, INCLINATION) VALUES (:objectId, :objectName, :raOfAscNode, :meanMotion, :type, :size, :scale, :inclination)";
	
	@Bean
	JdbcBatchItemWriter<Debris> jdbcWriter(DataSource datasource) {
		return new JdbcBatchItemWriterBuilder<Debris>()
	        .dataSource(datasource)
	        .sql(QUERY)
	        .beanMapped()
	        .build();
	}
	
	@Bean
	Processor processor(Map<String, String> size, Map<String, String> type) {
		return new Processor(size, type);
	}
	
	@Bean
	Step step(StepBuilderFactory stepBuilder,
			Processor processor,
			JdbcBatchItemWriter<Debris> writer,
			RestConfig config,
			OverwriteListener listener) {
		return stepBuilder.get("DFJ_etl_step")
				.<Satellite, Debris>chunk(100)
				.reader(new RestItemReader(config))
				.processor(processor)
				.writer(writer)
				.listener(listener)
				.build();
	}
}
