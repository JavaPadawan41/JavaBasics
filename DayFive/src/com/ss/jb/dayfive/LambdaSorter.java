package com.ss.jb.dayfive;



import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * LambdaSorter.java
 * Uses lambda expressions to sort strings by various properties
 * @author Justin W Walthers
 *
 */
public class LambdaSorter
{

	private String[] data;
	private Random rnd;
	
	/***
	 * Creates a new instance of LambdaSorter
	 * @param data Data with which to fill the sorter
	 */
	public LambdaSorter(String[] data)
	{
		if (data == null)
			throw new NullPointerException("data");
		if (Arrays.stream(data).anyMatch((s) -> s == null))
			throw new NullPointerException("data cannot contain nulls");
		
		this.data = data.clone();
		this.rnd = new Random();
	}
	
	/***
	 * Sorts the internal array according to the comparator c
	 * @param c The comparator b which to sort
	 */
	private void sortBy(Comparator<? super String> c)
	{
		Arrays.sort(this.data, c);
	}
	
	/***
	 * Sorts the instance data by length of string
	 * @param reverse Whether to reverse sort
	 */
	public void sortByLength(boolean reverse)
	{
		Comparator<String> c = reverse ? (String a, String b) -> b.length() - a.length() : 
			(String a, String b) -> a.length() - b.length();
			
		this.sortBy(c);
	}
	
	/***
	 * Sorts the instance data by the first character
	 */
	public void sortByFirstChar() throws IndexOutOfBoundsException
	{
		this.sortBy((String a, String b) -> a.charAt(0) - b.charAt(0));
	}
	
	/***
	 * Sorts the instance data such that any sequence starting with 'e' or 'E' is placed first, followed by everything else sorted by first character
	 */
	public void sortByEFirst()
	{
		Comparator<String> c = (String a, String b) ->
		a.toLowerCase().charAt(0) == 'e' && b.toLowerCase().charAt(0) == 'e' ? 0 :
		a.toLowerCase().charAt(0) == 'e' ? -1 : 
		b.toLowerCase().charAt(0) == 'e' ? 1 : a.charAt(0) - b.charAt(0);
		
		this.sortBy(c);
	}
	
	/***
	 * Sorts the instance data such that any sequence starting with 'e' or 'E' is placed first, followed by everything else sorted by first character,
	 * but uses a static helper method to achieve this
	 */
	public void sortByEFirstWithHelper()
	{
		this.sortBy((String a, String b) -> LambdaSorter.eFirstComparator(a, b));
	}
	
	/***
	 * Shuffles the contents of the instance data
	 */
	public void shuffle()
	{
		this.sortBy((a, b) -> this.rnd.nextInt());
	}
	
	public static int eFirstComparator(String a, String b)
	{
		return
		a.toLowerCase().charAt(0) == 'e' && b.toLowerCase().charAt(0) == 'e' ? 0 :
		a.toLowerCase().charAt(0) == 'e' ? -1 : 
		b.toLowerCase().charAt(0) == 'e' ? 1 : a.charAt(0) - b.charAt(0);
	}
	
	public String[] getData()
	{
		return this.data.clone();
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(this.data);
	}
}
