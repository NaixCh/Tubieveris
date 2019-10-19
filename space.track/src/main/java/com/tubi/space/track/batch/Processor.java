package com.tubi.space.track.batch;

import org.springframework.batch.item.ItemProcessor;

import com.tubi.space.track.domain.Debris;
import com.tubi.space.track.domain.Satellite;

public class Processor implements ItemProcessor<Satellite, Debris> {

	@Override
	public Debris process(Satellite item) throws Exception {
		Debris debris = new Debris();
		debris.setObjectId(item.getOBJECT_ID());
		debris.setObjectName(item.getOBJECT_NAME());
		debris.setRaOfAscNode(item.getRA_OF_ASC_NODE());
		debris.setMeanMotion(item.getMEAN_MOTION());
		return debris;
	}

}
