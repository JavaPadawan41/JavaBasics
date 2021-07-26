package com.ss.jb.dayfive.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.ss.jb.dayfive.DateTimeDemo;

public class DateTimeTest
{
	private DateTimeDemo dtd;
	
	@Before
	public void setUp()
	{
		dtd = new DateTimeDemo();
	}
	
	@Test
	public void testCountMonthlyDays()
	{
		List<Integer> expectedDays = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		List<Integer> actualDays = dtd.countMonthlyDays(2021);
		int expected;
		int actual;
		
		//Test that lists are of same lenght
		assertEquals(expectedDays.size(), actualDays.size());
		
		//Test that elements are the same
		Iterator<Integer> expIter = expectedDays.iterator();
		Iterator<Integer> actIter = actualDays.iterator();
		
		while (expIter.hasNext() && actIter.hasNext())
		{
			expected = expIter.next();
			actual = actIter.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testGetPreviousThursday()
	{
		LocalDate prevThurs;
		LocalDate expected;
		LocalDate actual;
		
		//Test from today (a day before thursday)
		expected = LocalDate.of(2021, 7, 22);
		actual = dtd.getPreviousThursday(2021, 7, 26);
		
		assertEquals(expected, actual);
		
		//Test from a thursday
		expected = LocalDate.of(2021, 7, 22);
		actual = dtd.getPreviousThursday(2021, 7, 29);
		assertEquals(expected, actual);
		
		//Test from a day after thursday
		expected = LocalDate.of(2021,  7, 29);
		actual = dtd.getPreviousThursday(2021, 7, 31);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testIsFridayThe13th()
	{
		LocalDate refDate;
		
		//Test from a day that is friday the 13th
		refDate = LocalDate.of(2020, 11, 13);
		assertTrue(dtd.isFridayTheThirteenth(refDate));
		
		//Test from a friday that is not the 13th;
		refDate = LocalDate.of(2021, 7, 30);
		assertFalse(dtd.isFridayTheThirteenth(refDate));
		
		//Test from a 13th that is not a Friday
		refDate = LocalDate.of(2021, 7, 13);
		assertFalse(dtd.isFridayTheThirteenth(refDate));
	}
	
	@Test
	public void testListMondays()
	{
		LocalDate expected;
		LocalDate actual;
		
		//Test from a month that starts on a monday
		List<LocalDate> expectedMondays = new ArrayList<LocalDate>();
		expectedMondays.add(LocalDate.of(2021, 3, 1));
		expectedMondays.add(LocalDate.of(2021, 3, 8));
		expectedMondays.add(LocalDate.of(2021, 3, 15));
		expectedMondays.add(LocalDate.of(2021, 3, 22));
		expectedMondays.add(LocalDate.of(2021, 3, 29));
		
		List<LocalDate> actualMondays = dtd.listMondays(3);
		
		//Test for same number of elements
		assertEquals(expectedMondays.size(), actualMondays.size());
		
		//Test that each element is the same
		Iterator<LocalDate> expIter = expectedMondays.iterator();
		Iterator<LocalDate> actIter = actualMondays.iterator();
		
		while(expIter.hasNext() && actIter.hasNext())
		{
			expected = expIter.next();
			actual = actIter.next();
			
			assertEquals(expected, actual);	
		}
		
		//Test From a month that doesn't start on a Monday
		expectedMondays = new ArrayList<LocalDate>();
		expectedMondays.add(LocalDate.of(2021, 7, 5));
		expectedMondays.add(LocalDate.of(2021, 7, 12));
		expectedMondays.add(LocalDate.of(2021, 7, 19));
		expectedMondays.add(LocalDate.of(2021, 7, 26));
		
		actualMondays = dtd.listMondays(7);
		
		//Test for same number of elements
		assertEquals(expectedMondays.size(), actualMondays.size());
		
		//Test that each element is the same
		expIter = expectedMondays.iterator();
		actIter = actualMondays.iterator();
		
		while(expIter.hasNext() && actIter.hasNext())
		{
			expected = expIter.next();
			actual = actIter.next();
			
			assertEquals(expected, actual);	
		}
	}
	
	
}
