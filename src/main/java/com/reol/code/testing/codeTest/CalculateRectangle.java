package com.reol.code.testing.codeTest;

public class CalculateRectangle {
	public int rectangleArea(Rectangle rectangle) {
		return rectangle.getLength() * rectangle.getWidth();
	}
	
	public int rectanglePerimeter(Rectangle rectangle) {
		return rectangle.getLength()*2 + rectangle.getWidth()*2;
	}
}
