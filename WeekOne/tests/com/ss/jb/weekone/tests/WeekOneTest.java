package com.ss.jb.weekone.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.weekone.recursion.RecursionDemo;

public class WeekOneTest
{
	@Test
	public void testRecursion()
	{
		RecursionDemo rd = new RecursionDemo();
		
		assertTrue(rd.groupSumClump(0, new int[] {2, 4, 8}, 10));
		assertTrue(rd.groupSumClump(0, new int[] {1, 2, 4, 8, 1}, 14));
		assertFalse(rd.groupSumClump(0, new int[] {2, 4, 4, 8}, 14));
	}
}
