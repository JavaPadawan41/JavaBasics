package com.ss.jb.dayfive.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ss.jb.dayfive.IntJoin;
import com.ss.jb.dayfive.LambdaSorter;
import com.ss.jb.dayfive.StringFilterDemo;

/***
 * Performs unit tests for the day five problems
 * @author Justin W Walthers
 *
 */
public class LambdaTest
{
	//Some basic test data
	private LambdaSorter ls;
	private LambdaSorter ls2;
	private LambdaSorter ls3;
	private LambdaSorter ls4;
	private LambdaSorter ls5;
	private LambdaSorter ls6;
	
	@Before
	public void setUp()
	{
		ls = new LambdaSorter(new String[]{"Barry", "Cisco", "Kaitlin", "Joe", "Iris", 
				"Ralph", "Gypsy", "Emily"});
		ls2 = new LambdaSorter(new String[] {"", "", ""});
		ls3 = new LambdaSorter(new String[] {"", " ", "", "  "});
		ls4 = new LambdaSorter(new String[] {});
		ls5 = new LambdaSorter(new String[]{"Barry", "John", "Jimmy","Bismuth", "Beth",   
				"Jack"});
		ls6 = new LambdaSorter(new String[]{"Exact", "Evan", "Emma"});
	}
	
	@Test
	public void testLambdaSort_sortByLength()
	{
		
		String[] expected;
		
		//Test that attempting to pass nulls throws an exception
		assertThrows(NullPointerException.class, () -> {new LambdaSorter(null);});
		assertThrows(NullPointerException.class, () -> {new LambdaSorter(new String[] {null, " ", "Toast"});});
		
		//Test that various sorting functions produce the expected result
		//Sorting by length should be Joe, Iris, Barry, Cisco, Ralph, Gypsy, Kaitlin
		//The reason for this is that the nature of the comparator produces a stable sort 
		//b/c strings of the same length are compared to give a result of 0, which means no transposition of the elements occurs
		expected = new String[] {"Joe", "Iris", "Barry", "Cisco", "Ralph", "Gypsy", "Emily", "Kaitlin"};
		ls.sortByLength(false);
		assertArrayEquals(ls.getData(), expected);
		
		//Test that reversed sorting works as expected
		expected = new String[] {"Kaitlin", "Barry", "Cisco", "Ralph", "Gypsy", "Emily", "Iris", "Joe"};
		ls.sortByLength(true);
		assertArrayEquals(ls.getData(), expected);
		
		//Test sorting by length with array of only empty strings
		expected = new String[] {"", "", ""};
		ls2.sortByLength(false);
		assertArrayEquals(ls2.getData(), expected);
		
		//Test sorting with empty some, but not all, strings
		expected = new String[] {"", "", " ", "  "};
		ls3.sortByLength(false);
		assertArrayEquals(ls3.getData(), expected);
		
		//Test sorting an empty array
		expected = new String[] {};
		ls4.sortByLength(false);
		assertArrayEquals(ls4.getData(), expected);		
	}
	
	@Test 
	public void testLambdaSort_sortByFirstChar()
	{
		//Test that sorting by first character works as expected
		//because of the nature of the comparator logic, sorts should be stable
		String[] expected = new String[] {"Barry", "Cisco", "Emily", "Gypsy", "Iris", "Joe", "Kaitlin", "Ralph"};
		ls.sortByFirstChar();
		assertArrayEquals(ls.getData(), expected);
		
		//Test stability of sorting by first character
		expected = new String[] {"Barry", "Bismuth", "Beth", "John", "Jimmy", 
				"Jack"};
		ls5.sortByEFirst();
		assertArrayEquals(ls5.getData(), expected);
		
		//Test SOrting of empty strings raises IndexOutofBounds exception
		assertThrows(IndexOutOfBoundsException.class, () -> {ls2.sortByFirstChar();});
		assertThrows(IndexOutOfBoundsException.class, () -> {ls3.sortByFirstChar();});
		
	}
	
	@Test
	public void testLambdaSort_SortByEFirst()
	{
		//Test that strings with E are placed first and that other elements are placed in alphabetical order
		String[] expected = new String[] {"Emily", "Barry", "Cisco", "Gypsy", "Iris", "Joe", "Kaitlin",   
				"Ralph"};
		
		ls.sortByEFirst();
		assertArrayEquals(ls.getData(), expected);
		
		//Test that Strings that begin with E are stably sorted
		expected = new String[] {"Exact", "Evan", "Emma"};
		ls6.sortByEFirst();
		assertArrayEquals(ls6.getData(), expected);
	}
	
	@Test
	public void testLambdaSort_SortByEFirstWithHelper()
	{
		//Test that strings with E are placed first and that other elements are placed in alphabetical order
		String[] expected = new String[] {"Emily", "Barry", "Cisco", "Gypsy", "Iris", "Joe", "Kaitlin",   
				"Ralph"};
		
		ls.sortByEFirst();
		assertArrayEquals(ls.getData(), expected);
		
		//Test that Strings that begin with E are stably sorted
		expected = new String[] {"Exact", "Evan", "Emma"};
		ls6.sortByEFirst();
		assertArrayEquals(ls6.getData(), expected);
	}
}
