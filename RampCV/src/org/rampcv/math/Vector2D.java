package org.rampcv.math;

public class Vector2D {
	
	public int x;
	public int y;
	
	public Vector2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public Vector2D add(Vector2D v2) {
		
		int x = this.getX() + v2.getX();
		int y = this.getY() + v2.getY();
		
		return new Vector2D(x, y);
	}
	
	//magnitude of a vector
	//formulae: square root of x1 power 2 + x2 power 2
	public double mag() {
		double mag = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
		return mag;
	}
	
	//direction of a vector
	//formulae: -> res = y/x -> atan(res) or tan-1(res)
	public double dir() {
		return Math.atan(this.getY() / this.getX());
	}
	
	//dist of two vectors
	//formulae: square root of x2 - x1 power of 2 + y2 - y2 power of 2
	public double dist(Vector2D v2) {
		double dist = Math.sqrt(Math.pow(v2.getX() - this.getX(), 2) + Math.pow((v2.getX() - this.getX()), 2));
		return dist;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
