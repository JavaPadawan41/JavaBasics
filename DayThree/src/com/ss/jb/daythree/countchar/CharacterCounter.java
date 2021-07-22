package com.ss.jb.daythree.countchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/***
 * CharacterCounter.java
 * Counts the instances of a specified character sequence within a specified file
 * @author Justin
 *
 */
public class CharacterCounter
{
	private String pathToFile;
	private char[] needle;
	
	/***
	 * Creates a new instance of CharacterCounter
	 * @param path The path to the file in which to count characters
	 * @param needle the character sequence for which to search
	 */
	public CharacterCounter(String path, String needle)
	{
		//Check for nulls
		if (path == null)
			throw new IllegalArgumentException("Path cannot be null");
		
		if (needle == null)
			throw new IllegalArgumentException("Needle cannot be null");
		
		this.pathToFile = path;
		this.needle = needle.toCharArray();
	}
	
	public int count() throws IOException
	{
		int count = 0;
		char[] inputData = new char[this.needle.length];
		int offset = 0;
		
		//Could just use a FileInputStream, but for the kind of operation we are doing (reading line by line),
		//the bufferedReader will be more efficient
		try (BufferedReader b = Files.newBufferedReader(Paths.get(this.pathToFile)))
		{
			//We might think to use the readline() method here, but what if the needle contains a newline character?
			//What if it contains many newline characters?
			//Accounting for all of that seems problematic. 
			//Instead, read into a character array, 
			//then determine if the read data is equal to the needle using Arrays.equals()
			//Will need to keep a 'running scan' of the most recent N characters read in
			while(b.read(inputData, offset, 1) != -1)
			{
				count += Arrays.equals(needle, inputData) ? 1 : 0;
				
				//If we've not yet reached the length of the needle, keep incrementing offset 
				//to get a running scan
				//otherwise, shift the contents of the array 1 to the left, 
				//and place latest char into last position of array
				if (offset < needle.length - 1)
				{
					offset++;
				}
				else
				{
					System.arraycopy(inputData, 1, inputData, 0, inputData.length - 1);
				}	
			}
		}
	
		return count;
	}
}
