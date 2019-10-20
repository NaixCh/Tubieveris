package com.tubi.space.track.domain;

import lombok.Data;

@Data
public class Debris {
	private String objectId;
	private String objectName;
	private String raOfAscNode;
	private String meanMotion;
	private String type;
	private String size;
	private String scale;
}
