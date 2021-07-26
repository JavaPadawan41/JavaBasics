package com.ss.jb.dayfive.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.ss.jb.dayfive.IntJoin;

public class IntJoinTest
{
	@Test
	public void TestIntJoin()
	{
		//Test that sequential numbers work as expected
		assertEquals(IntJoin.joinIntegers(1, 2, 3, 4, 5), "o1,e2,o3,e4,o5");
		
		//Test that non-sequential numbers join as expected
		assertEquals(IntJoin.joinIntegers(44, 18, 99, 16, 21, 35), "e44,e18,o99,e16,o21,o35");
		
		//Test that empty sequence of integers produces empty string
		assertEquals(IntJoin.joinIntegers(), "");
	}
}
