package com.ss.jb.weekone.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import com.ss.jb.weekone.functional.FunctionDemo;
import com.ss.jb.weekone.lambdas.LambdaDemos;
import com.ss.weekone.recursion.RecursionDemo;

public class WeekOneTest
{
	@Test
	public void testDoubling()
	{
		FunctionDemo fd = new FunctionDemo();
		assertEquals(fd.doubling(Arrays.asList(new Integer[] {1, 2, 3})), 
								 Arrays.asList(new Integer[] {2, 4, 6}));
		
		assertEquals(fd.doubling(Arrays.asList(new Integer[] {6, 8, 6, 8, -1})), 
				 Arrays.asList(new Integer[] {12, 16, 12, 16, -2}));
		
		assertEquals(fd.doubling(Arrays.asList(new Integer[] {})), 
				 Arrays.asList(new Integer[] {}));
	}
	
	@Test
	public void testIsOdd()
	{
		Function<Integer, Boolean> iof = LambdaDemos.isOdd();
		
		//Test on negative numbers
		assertTrue(iof.apply(-1));
		assertFalse(iof.apply(-2));
		
		//Test on zero
		assertFalse(iof.apply(0));
		
		//Test on positive numbers
		assertTrue(iof.apply(1));
		assertFalse(iof.apply(2));
	}
	
	@Test
	public void testIsPalindrome()
	{
		Function<Integer, Boolean> ipf = LambdaDemos.isPalindrome();
		//Apply on negative numbers
		assertFalse(ipf.apply(-123456789));
		assertTrue(ipf.apply(-123454321));
		assertTrue(ipf.apply(-1));
		
		//Test on zero
		assertTrue(ipf.apply(0));
		
		//Test on positive integers
		assertTrue(ipf.apply(11));
		assertTrue(ipf.apply(2));
		assertFalse(ipf.apply(2346112));
		assertTrue(ipf.apply(54445));
	}
	
	public void testIsPrime()
	{
		Function<Integer, Boolean> ipf = LambdaDemos.isPrime();
		
		List<Integer> first50Primes = Arrays.asList(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 
				61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 
				167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229});
		
		//Test against the first 50 primes
		for (int i = 1; i < 230; i++)
		{
			assertEquals(ipf.apply(i), first50Primes.contains(i));
		}
	}
	
	@Test
	public void testRecursion()
	{
		RecursionDemo rd = new RecursionDemo();
		
		//Test cases provided by the assignment
		assertTrue(rd.groupSumClump(0, new int[] {2, 4, 8}, 10));
		assertTrue(rd.groupSumClump(0, new int[] {1, 2, 4, 8, 1}, 14));
		assertFalse(rd.groupSumClump(0, new int[] {2, 4, 4, 8}, 14));
		
		//Some additional test cases
		assertFalse(rd.groupSumClump(0, new int[] {1, 1, 1, 1}, 1));
		assertTrue(rd.groupSumClump(0, new int[] {1, 1, 1, 1}, 0));
		assertTrue(rd.groupSumClump(0, new int[] {1, 1, 1, 1}, 4));
		assertFalse(rd.groupSumClump(0, new int[] {}, 4));
		assertTrue(rd.groupSumClump(0, new int[] {}, 0));
	}
	
	@Test
	public void testRightDigit()
	{
		FunctionDemo fd = new FunctionDemo();
		
		assertEquals(fd.rightDigit(Arrays.asList(new Integer[] {1, 22, 93})), Arrays.asList(new Integer[] {1, 2, 3}));
		assertEquals(fd.rightDigit(Arrays.asList(new Integer[] {16, 8, 886, 8, 1})), 
				Arrays.asList(new Integer[] {6, 8, 6, 8, 1}));
		
		assertEquals(fd.rightDigit(Arrays.asList(new Integer[] {10, 0})), 
				Arrays.asList(new Integer[] {0, 0}));
		
		assertEquals(fd.rightDigit(Arrays.asList(new Integer[] {14, -14})), 
				Arrays.asList(new Integer[] {4, 4}));
		
		assertEquals(fd.rightDigit(Arrays.asList(new Integer[] {})), 
				Arrays.asList(new Integer[] {}));
	}
}
