package com.tubi.space.track.batch;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.tubi.space.track.domain.Debris;
import com.tubi.space.track.domain.Satellite;
import com.tubi.space.track.utils.Utils;

public class Processor implements ItemProcessor<Satellite, Debris> {
	
	private Map<String, String> type;
	private Map<String, String> size;

	public Processor(Map<String, String> size, Map<String, String> type) {
		this.type = type;
		this.size = size;
	}

	@Override
	public Debris process(Satellite item) throws Exception {
		Debris debris = new Debris();
		debris.setObjectId(item.getOBJECT_ID());
		debris.setObjectName(item.getOBJECT_NAME());
		debris.setRaOfAscNode(item.getRA_OF_ASC_NODE());
		debris.setMeanMotion(item.getMEAN_MOTION());		
		debris.setType(Utils.calculateType(type).toString());
		debris.setSize(Utils.calculateSize(size).toString());
		debris.setScale(String.valueOf(Utils.randomizeScale()));
		return debris;
	}

}
