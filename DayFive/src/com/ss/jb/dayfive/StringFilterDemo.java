package com.ss.jb.dayfive;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/***
 * StringFilterDemo.java
 * Class that demonstrates using Streams and Lambdas to filter a list of strings
 * @author Jay
 *
 */
public class StringFilterDemo
{
	//Regex will find anything that's not a letter character, 
	//which we can use to count the number of letters in the string
	private static Pattern p = Pattern.compile("[^A-Za-z]", 
			Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
	
	/***
	 * Selects from the sequence args only those strings that begin with 'a' and have exactly 3 letters
	 * @param args Sequence of strings to filter
	 * @return List<String>
	 * @throws NullPointerException if args is null or contains nulls
	 */
	public static List<String> filter(String...args) throws NullPointerException
	{
		if (args == null)
			throw new NullPointerException ("args");
		if (Arrays.stream(args).anyMatch((s) -> s == null))
			throw new NullPointerException("Argument list cannot contain nulls");
		
		//The replaceAll method will drop from the string anything that isn't
		//A letter so we can count up only letter characters
		return Arrays.stream(args).filter((s) -> s.startsWith("a") && 
				p.matcher(s).replaceAll("").length() == 3).collect(Collectors.toList());
	}
}
