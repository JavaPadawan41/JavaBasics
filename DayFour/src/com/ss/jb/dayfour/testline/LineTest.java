/**
 * 
 */
package com.ss.jb.dayfour.testline;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Jay
 *
 */
public class LineTest
{
	
	@Test
	public void testIsParallelTo()
	{
		//Parallellism means that the lines have the same slope
		//Slope = rise / run = (y2 - y1) / (x2 - x1)
		//Potential problem here is with vertical lines. They are parallel, but both have undefined slope. 
		//Need to check this condition for sure
		//4 partitions to check: Vertical lines, diagonal lines, horizontal lines, lines of zero length
		//In general, two distinct lines are considered parallel if they are each parallel to a third line
		//This is useful for horizontal and vertical lines because distinct vertical lines are considered parallel by this reasoning
		//same for vertical lines
		//Other definitions of parallel lines include:
		//Euclid: two lines are parallel if they are coplanar and share no points in common/do not intersect
		//Equivalence relation states that a line is parallel to itself
		//Some definitions state that non-parallel lines are lines that meet at exactly one point
		//Overall, it seems as though lines should be considered parallel to themselves
		
		//Start by testing horizontal lines
		Line h1 = new Line(0, 0, 10, 0);
		Line h2 = new Line(0, 0, 10, 0);
		Line h3 = new Line(0, 0, 10, 10);
		Line h4 = new Line(10, 10, 20, 10);
		
		//Lines h1, h2, and h4 should be considered parallel to each other
		assertTrue(h1.parallelTo(h2));
		assertTrue(h1.parallelTo(h4));
		assertTrue(h2.parallelTo(h1));
		assertTrue(h2.parallelTo(h4));
		assertTrue(h4.parallelTo(h1));
		assertTrue(h4.parallelTo(h2));
		assertTrue(h1.parallelTo(h1));
		
		//h3 should be considered not parallel to any of the other three lines
		assertFalse(h3.parallelTo(h1));
		assertFalse(h3.parallelTo(h2));
		assertFalse(h3.parallelTo(h4));
		
		//Next, test diagonal lines
		Line d1 = new Line(0, 0, 10, 10);
		Line d2 = new Line(0, 0, 10, 10);
		Line d3 = new Line(5, 10, 2, 4);
		Line d4 = new Line(2, 3, 12, 13);
		
		//d1, d2, and d4 should be considered parallel to each other
		assertTrue(d1.parallelTo(d2));
		assertTrue(d1.parallelTo(d4));
		assertTrue(d2.parallelTo(d1));
		assertTrue(d2.parallelTo(d4));
		assertTrue(d4.parallelTo(d1));
		assertTrue(d4.parallelTo(d2));
		assertTrue(d1.parallelTo(d1));
		
		//d3 should be considered not parallel to the other lines
		assertFalse(d3.parallelTo(d1));
		assertFalse(d3.parallelTo(d2));
		assertFalse(d3.parallelTo(d4));
		
		//Next, test vertical lines
		Line v1 = new Line(0, 0, 0, 10);
		Line v2 = new Line(0, 0, 0, 10);
		Line v3 = new Line(11, 10, 14, 32);
		Line v4 = new Line(25, 3, 25, 13);
		
		//v1, v2, and v4 should be considered parallel to each other
		assertTrue(v1.parallelTo(v2));
		assertTrue(v1.parallelTo(v4));
		assertTrue(v2.parallelTo(v1));
		assertTrue(v2.parallelTo(v4));
		assertTrue(v4.parallelTo(v1));
		assertTrue(v4.parallelTo(v2));
		assertTrue(v1.parallelTo(v1));
		
		//d3 should be considered not parallel to the other lines
		assertFalse(v3.parallelTo(v1));
		assertFalse(v3.parallelTo(v2));
		assertFalse(v3.parallelTo(v4));
	}
	
	@Test
	public void testGetSlope()
	{
		//There are 3 partitions for this test - Horizontal lines, diagonal lines, veritcal lines
		//Horizontal and digaonal lines should return numerical values, while verticla lines should have NaN as their slope
		
		//Test a horizontal line first
		double expected = (0d - 0d) / (10d - 0d);
		double actual = (new Line(0, 0, 10, 0)).getSlope();
		assertEquals(expected, actual, 0.0001);
		
		//Next, test a diagonal line with positive slope
		expected = (15d - 7d) / (5d - 2d);
		actual = (new Line(2, 7, 5, 15)).getSlope();
		assertEquals(expected, actual, 0.0001);
		
		//Then, test a diagonal line with negative slope
		expected = (9d - 14d) / (5d - 2d);
		actual = (new Line(2, 14, 5, 9)).getSlope();
		assertEquals(expected, actual, 0.0001);
		
		//Finally, test a vertical line
		expected = Double.NaN;
		actual = (new Line(0, 0, 0, 10)).getSlope();
		assertEquals(expected, actual, 0.0001);
	}
	
	@Test
	public void testGetDistance()
	{
		//Test the distance of a horizontal line
		double expected = Math.sqrt(Math.pow((20d - 10d), 2d) + Math.pow((10d - 10d), 2d));
		double actual = (new Line(10, 10, 20, 10)).getDistance();
		assertEquals(expected, actual, 0.0001);
		
		//Test the distance of a diagonal line with positive slope
		expected = Math.sqrt(Math.pow((3d - 0d), 2d) + Math.pow((14d - 0d), 2d));
		actual = (new Line(0, 0, 3, 14)).getDistance();
		assertEquals(expected, actual, 0.0001);
		
		//Test the distance of a diagonal line with negative slope
		expected = Math.sqrt(Math.pow((11d - 5d), 2d) + Math.pow((14d - 26d), 2d));
		actual = (new Line(5, 26, 11, 14)).getDistance();
		assertEquals(expected, actual, 0.0001);
		
		//Test the distance of a vertical line
		expected = Math.sqrt(Math.pow((5d - 5d), 2d) + Math.pow((9d - 17d), 2d));
		actual = (new Line(5, 17, 5, 9)).getDistance();
		assertEquals(expected, actual, 0.0001);
	}

}
