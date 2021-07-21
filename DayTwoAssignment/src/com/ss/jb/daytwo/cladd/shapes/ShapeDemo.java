package com.ss.jb.daytwo.cladd.shapes;

public class ShapeDemo
{

	public static void main(String[] args)
	{
		
		Circle c = new Circle(5d);
		Square s = new Square(5d);
		Triangle t = new Triangle(3, 4, 5);
		
		c.display();
		s.display();
		t.display();

	}

}
