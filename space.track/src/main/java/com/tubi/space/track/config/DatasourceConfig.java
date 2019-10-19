package com.tubi.space.track.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfig {
	
	@Bean(destroyMethod = "close")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource domainDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="batchDataSource", destroyMethod = "close")
    @ConfigurationProperties("batch.datasource")
    public DataSource batchDataSource() {
        return DataSourceBuilder.create().build();
    }
    
}
