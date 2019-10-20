package com.tubi.space.track.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Debris implements Serializable{
	private String objectId;
	private String objectName;
	private String raOfAscNode;
	private String meanMotion;
	private String type;
	private String size;
	private String scale;
	private Float inclination;
}
