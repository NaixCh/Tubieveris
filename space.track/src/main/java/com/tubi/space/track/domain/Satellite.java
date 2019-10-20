package com.tubi.space.track.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Satellite implements Serializable {
	private String ORDINAL;
	private String COMMENT;
	private String ORIGINATOR;
	private String NORAD_CAT_ID;
	private String OBJECT_NAME;
	private String OBJECT_TYPE;
	private String CLASSIFICATION_TYPE;
	private String INTLDES;
	private String EPOCH;
	private String EPOCH_MICROSECONDS;
	private String MEAN_MOTION;
	private String ECCENTRICITY;
	private String INCLINATION;
	private String RA_OF_ASC_NODE;
	private String ARG_OG_PERICENTER;
	private String MEAN_ANOMALY;
	private String EPHEMERIS_TYPE;
	private String ELEMENT_SET_NO;
	private String REV_AT_EPOCH;
	private String BSTAR;
	private String MEAN_MOTION_DOT;
	private String MEAN_MOTION_DDOT;
	private String FILE;
	private String TLE_LINE0;
	private String TLE_LINE1;
	private String TLE_LINE2;
	private String OBJECT_ID;
	private String OBJECT_NUMBER;
	private String SEMINATOR_AXIS;
	private String PERIOD;
	private String APOGEE;
	private String PERIGEE;
}
