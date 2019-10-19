package com.tubi.space.track.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="rest")
public class RestConfig {
	private String baseUrl;
	private String authPath;
	private String userName;
	private String password;
	private String query;
}
