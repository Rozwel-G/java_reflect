package com.reol.code.testing.codeTest;
public class CalculateCircle {
	public int circleArea(Circle circle) {
		return circle.getRadius()*circle.getRadius()*3;
	}
	public int circlePerimeter(Circle circle) {
		return 6*circle.getRadius();
	}

}
