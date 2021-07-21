package com.ss.jb.daytwo.cladd.shapes;

/**
 * Triangle.java
 * Simple class to represent a triangle
 * @author Justin W Walthers
 *
 */
public class Triangle implements Shape
{
	//PRIVATE MEMBERS
	private double sideA;
	private double sideB;
	private double sideC;
	
	//CONSTRUCTORS
	/**
	 * Creates a new instance of Triangle
	 * @param sideA The length of the first side
	 * @param sideB The length of the second side
	 * @param sideC the length of the third side
	 * @throws IllegalArgumentException if an invalid triangle is specified
	 */
	public Triangle(double sideA, double sideB, double sideC)
	{
		if (!(sideA + sideB > sideC || sideA + sideC > sideB || sideB + sideC > sideA))
		{
			throw new IllegalArgumentException(String.format("A triangle with sides (%d, %d, %d) is not valid", 
															sideA, sideB, sideC));
		}
		
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	/**
	 * Computes the area of the triangle
	 * @return double: The area of the triangle
	 */
	@Override
	public double calculateArea()
	{
		//To calculate the area of a triangle with sides A, B, C, we can use Heron's formula
		//A = SQRT(s * (s - a) * (s - b) * (s - c)), where s is the half-perimeter
		double semiPerimeter = (this.sideA + this.sideB + this.sideC) / 2;
		
		return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
		
	}

}
