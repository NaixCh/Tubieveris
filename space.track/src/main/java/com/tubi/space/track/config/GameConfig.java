package com.tubi.space.track.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class GameConfig {
	
	@Value("#{${game.percents.size:null}}")
	private Map<String, String> size;

	@Value("#{${game.percents.type:null}}")
	private Map<String, String> type;
	
	@Qualifier("size")
	@Bean
	public Map<String, String> size() {
		return size;
	}

	@Qualifier("type")
	@Bean
	public Map<String, String> type() {
		return type;
	}
}
