package com.tubi.space.track.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;

import com.tubi.space.track.constants.Size;
import com.tubi.space.track.constants.Type;

public class Utils {
	
	private static Random r = new Random();
	private static final int MAX_NUMBER = 101; 
	
	private Utils() {}
	
	public static float randomizeScale() {
		float rangeMin = 0.0f,
			rangeMax = 1.0f;		
	    return BigDecimal.valueOf(rangeMin + (rangeMax - rangeMin) * r.nextFloat())
				.round(new MathContext(2, RoundingMode.HALF_UP))
				.floatValue();
	}
	
	public static Type calculateType(Map<String, String> items) {
		int number = r.nextInt(MAX_NUMBER);
		return (number < Integer.parseInt(items.get(Type.RKT.toString()))) ? Type.RKT 
				: (number < Integer.parseInt(items.get(Type.RKT.toString())) + 
						Integer.parseInt(items.get(Type.STT.toString()))) ? Type.STT : Type.AST;
	}
	
	public static Size calculateSize(Map<String, String> items) {
		int number = r.nextInt(MAX_NUMBER);
		return (number < Integer.parseInt(items.get(Size.S.toString()))) ? Size.S
				: (number < Integer.parseInt(items.get(Size.S.toString())) + 
						Integer.parseInt(items.get(Size.M.toString()))) ? Size.M : Size.L;
	}
}
