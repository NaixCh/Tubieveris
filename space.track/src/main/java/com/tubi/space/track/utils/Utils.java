package com.tubi.space.track.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Random;

import com.tubi.space.track.constants.TYPE;

public class Utils {
	
	private static Random r = new Random();
	
	private Utils() {}
	
	public static float randomizeScale() {
		float rangeMin = 0.8f,
			rangeMax = 1.0f;
	    return BigDecimal.valueOf(rangeMin + (rangeMax - rangeMin) * r.nextFloat())
				.round(new MathContext(2, RoundingMode.HALF_UP))
				.floatValue();
	}
	
	public TYPE calculateType(HashMap<String, String> items) {
		final int poolsize = 0;
		/*items.entrySet()
			.stream()
			.reduce((s1, s2) -> Integer.parseInt(s1.getValue()) + Integer.parseInt(s2.getValue()));*/
		int percent = r.nextInt(101);
		
		
		
		return TYPE.AST;
	}
	
}
