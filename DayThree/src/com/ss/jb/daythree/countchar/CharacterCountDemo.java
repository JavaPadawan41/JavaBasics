package com.ss.jb.daythree.countchar;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharacterCountDemo
{

	public static void main(String[] args)
	{
		String needle;
		CharacterCounter cc;
		Path inputPath = Paths.get("src",  "resources", "ccdemo.txt");
		int count;
		
		// If there are no command line args, get a filename from the user. Otherwise, use the arg provided
		if (args.length == 0)
		{
			try (Scanner kbd = new Scanner(System.in))
			{
				System.out.print("Please enter the name of file to which to append: ");
				needle =  kbd.nextLine();	
			}
			catch (NoSuchElementException e)
			{
				System.out.println("No data was found in the input buffer. Exiting...");
				return;
			}
		}
		else
		{
			needle = args[0]; 
		}
		
		try
		{
			//Count the instances of needle and display a message to the user
			cc = new CharacterCounter(inputPath.toString(), needle);
			count = cc.count();
			System.out.printf("The needle '%s' occurred %d times in the file %s", needle, count, inputPath.toString());
			
		} catch (IOException e) 
		{
			System.out.printf("The file %s could not be opened for reading ", inputPath.toString());
		}
		
		
	}

}
