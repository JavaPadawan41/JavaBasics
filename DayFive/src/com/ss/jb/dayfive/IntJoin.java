package com.ss.jb.dayfive;
/**
 * 
 */


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * IntJoin.java
 * Demonstrates java 8 features used to join lists of integers together
 * @author Justin W Walthers
 *
 */
public class IntJoin
{

	/***
	 * Joins the provided integers into a comma-delimited string in which each element is preceded by 'e' if even, 'o' if odd
	 * @param l Variable-length list of strings to join
	 * @return String
	 */
	public static String joinIntegers(int... l)
	{
		String s;
		
		//The following statement works by:
		//1 - Map each integer to a string, prefaced by 'e' if even, 'o' if odd
		//2 - collect the resulting stream into a String object via the Collectors.joining method
		s = Arrays.stream(l).mapToObj((int i) -> (i % 2 == 0 ? 'e' : 'o') + String.valueOf(i)).collect(Collectors.joining(","));
		
		return s;
	}

}
