package com.tubi.space.track.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class GameConfig {
	@Value("#{${game.percent.size:null}}")
	private Map<String, String> size;

	@Value("#{${game.percent.type:null}}")
	private Map<String, String> type;
}
