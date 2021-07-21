package com.ss.jb.daytwo.cladd.shapes;

public class Square implements Shape
{
	//PRIVATE MEMBERS
	double width;
	
	//CONSTRUCTORS
	/**
	 * Creates a new instance of Square
	 * @param width the width of the square
	 */
	public Square(double width)
	{
		this.width = width;
	}
	
	/**
	 * Computes the area of the shape
	 * @return double: The area of the shape 
	 */
	@Override
	public double calculateArea()
	{
		// TODO Auto-generated method stub
		return Math.pow(this.width, 2);
	}

}
