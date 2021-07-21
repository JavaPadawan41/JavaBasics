package com.ss.jb.daytwo.cladd.shapes;

public interface Shape
{
	double calculateArea();
	default void display()
	{
		System.out.printf("The area of this %s is %.2f square units.\n", this.getClass().getSimpleName(), this.calculateArea());
	}
}
