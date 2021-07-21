package com.ss.jb.daytwo.cladd.shapes;

import java.lang.Math;

public class Circle implements Shape
{
	//PRIVATE FIELDS
	private double radius;
	
	
	//CONSTRUCTOR
	/**
	 * Creates a new instance of Circle
	 * @param radius The radius of the circle
	 */
	public Circle(double radius)
	{
		this.radius = radius;
	}

	//IMPLEMENTS Shape
	@Override
	/**
	 * Computes the area of the circle
	 * @return double: The area of the circle
	 */
	public double calculateArea()
	{
		// TODO Auto-generated method stub
		return 2 * radius * Math.PI;
	}
}
