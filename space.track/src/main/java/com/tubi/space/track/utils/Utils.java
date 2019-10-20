package com.tubi.space.track.utils;

import java.util.HashMap;
import java.util.Random;

import com.tubi.space.track.constants.TYPE;

public class Utils {
	
	private static Random r = new Random();
	
	private Utils() {}
	
	public static float randomizeScale() {
		float rangeMin = 0.0f,
			rangeMax = 1.0f;		
	    return rangeMin + (rangeMax - rangeMin) * r.nextFloat();
	}
	
	public TYPE calculateType(HashMap<String, String> items) {
		final int poolsize = 0;
		items.entrySet()
			.stream()
			.reduce((s1, s2) -> Integer.parseInt(s1.getValue()) + Integer.parseInt(s2.getValue()));
		int percent = r.nextInt(101);
		
		
		
		return null;
	}
	
}
