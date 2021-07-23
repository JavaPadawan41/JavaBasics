package com.ss.jbdaythree.fileappend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/***
 * FileAppendDemo.java
 * @author Justin W Walthers
 * Demonstrates the act of using a FileStream to append data to a file
 */
public class FileAppendDemo
{

	public static void main(String[] args)
	{
		String [] sampleData = new String[] {"This is a line to be appended to the file\n",
											 "This is also a line to be appended to the file\n"};
		String fileName;
		File outputFile;

		// If there are no command line args, get a filename from the user. Otherwise, use the arg provided
		if (args.length == 0)
		{
			try (Scanner kbd = new Scanner(System.in))
			{
				System.out.print("Please enter the name of file to which to append: ");
				fileName =  kbd.nextLine();	
			}
			catch (NoSuchElementException e)
			{
				System.out.println("No data was found in the input buffer. Exiting...");
				return;
			}
		}
		else
		{
			fileName = args[0]; 
		}
		
		outputFile = new File("src\\resources", fileName);
		
		//Buffered OutputStream can be faster in cases where you are iterating over a lot of lines, writing them one at a time
		//Setting the 2nd parameter of the FileOutputStream constructor to true will set the output to append instead of overwrite
		try (BufferedOutputStream b = new BufferedOutputStream(
				new FileOutputStream(outputFile.getAbsolutePath(), true)))
		{
			for (String s: sampleData)
			{
				b.write(s.getBytes());
			}
		} 
		//Lots of exceptions can be thrown
		//FileNotFound exception if the file does not exist, SecurityException if no permission to write
		//IoException when trying to close the stream
		//
		catch (FileNotFoundException | SecurityException e)
		{
			// TODO Auto-generated catch block
			System.out.printf("Could not append to %s because the file does not exist\n", 
					outputFile.getAbsolutePath());
		} 
		catch (IOException e)
		{
			System.out.println("An exception occurred when trying to close the FileOuputStream");
		}
	}

}
