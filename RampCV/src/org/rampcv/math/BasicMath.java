package org.rampcv.math;

public class BasicMath {

	
	public static float lerp(float t, int v1, int v2) {
		return v1 + t * (v2 - v1);
	}
	
	public static float lerp(int t, int v1, int v2) {
		return v1 + t * (v2 - v1);
	}
	
}
