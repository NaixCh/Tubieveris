package com.tubi.space.track.utils;

import java.util.Map;
import java.util.Random;

import com.tubi.space.track.constants.Size;
import com.tubi.space.track.constants.Type;

public class Utils {
	
	private static Random random = new Random();
	private static final int MAX_NUMBER = 101; 
	
	private Utils() {}
	
	public static float randomizeScale() {
		float rangeMin = 0.0f,
			rangeMax = 1.0f;		
	    return rangeMin + (rangeMax - rangeMin) * random.nextFloat();
	}
	
	public static Type calculateType(Map<String, String> items) {
		int number = random.nextInt(MAX_NUMBER);
		return (number < Integer.parseInt(items.get(Type.RKT.toString()))) ? Type.RKT 
				: (number < Integer.parseInt(items.get(Type.RKT.toString())) + 
						Integer.parseInt(items.get(Type.STT.toString()))) ? Type.STT : Type.AST;
	}
	
	public static Size calculateSize(Map<String, String> items) {
		int number = random.nextInt(MAX_NUMBER);
		return (number < Integer.parseInt(items.get(Size.S.toString()))) ? Size.S
				: (number < Integer.parseInt(items.get(Size.S.toString())) + 
						Integer.parseInt(items.get(Size.M.toString()))) ? Size.M : Size.L;
	}
}
