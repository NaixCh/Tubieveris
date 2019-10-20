package com.tubi.space.track.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.tubi.space.track.config.GameConfig;
import com.tubi.space.track.domain.Debris;
import com.tubi.space.track.domain.Satellite;
import com.tubi.space.track.utils.Utils;

public class Processor implements ItemProcessor<Satellite, Debris> {
	
	private long counter = 0;
	
	@Autowired
	private GameConfig config;

	@Override
	public Debris process(Satellite item) throws Exception {
		counter++;
		Debris debris = new Debris();
		debris.setObjectId(item.getOBJECT_ID());
		debris.setObjectName(item.getOBJECT_NAME());
		debris.setRaOfAscNode(item.getRA_OF_ASC_NODE());
		debris.setMeanMotion(item.getMEAN_MOTION());
		debris.setScale(String.valueOf(Utils.randomizeScale()));
		return debris;
	}

}
