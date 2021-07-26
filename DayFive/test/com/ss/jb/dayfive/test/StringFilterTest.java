package com.ss.jb.dayfive.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ss.jb.dayfive.StringFilterDemo;

public class StringFilterTest
{
	@Test public void testStringFilter()
	{
		List<String> actual;
		List<String> expected;
		
		//Test that null values raises exception
		assertThrows(NullPointerException.class, () -> {StringFilterDemo.filter(null);});
		assertThrows(NullPointerException.class, () -> {StringFilterDemo.filter(" ", null);});
		
		//Test that Filtration works to select only strings that begin with a and have 3 letters
		actual = StringFilterDemo.filter("Toasty", "achoo", "Ach", "ach", "and ", "and123");
		expected = Arrays.asList(new String[] {"ach", "and ", "and123"});
		assertEquals(expected, actual);
		
		//Test that filtering empty list returns empty list
		actual = StringFilterDemo.filter();
		expected = Arrays.asList(new String[] {});
		assertEquals(expected, actual);
	}
}
