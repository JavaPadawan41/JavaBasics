/**
 * 
 */
package com.ss.jb.daythree.walkdir;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Justin
 *
 */
public class DirectoryWalkerDemo
{

	/**
	 * Demonstrates the DirectoryWalker class
	 * @param args: accepts a single argument specifying a path from which to begin walking
	 */
	public static void main(String[] args)
	{
		DirectoryWalker dw;
		Stream<Path> pathStream = null;
		Iterator<Path> pi;
		Scanner kbd;
		String root;
		
		try
		{
			//If args were specified, assume the first arg is a path. Otherwise, ask the user for a path
			if (args.length > 0)
			{
				root = args[0];
			}
			else
			{
				kbd = new Scanner(System.in);
				System.out.print("Please enter a valid path: ");
				root = kbd.nextLine().trim();
				kbd.close();				
			}
			
			//Supplying an empty string to paths.Get() results in a Path object for the CWD
			if (root.length() == 0)
				System.out.println("Specified Path was empty. Walking current working directory...");
			
			//Construct the object and get the stream to process the directory structure
			dw = new DirectoryWalker(root);
			pathStream = dw.getDirectoryStream();
			pi = pathStream.iterator();
			pi.forEachRemaining(p -> System.out.println(p.getFileName()));
		}
		catch (IllegalArgumentException e) //Thrown by the constructor if a bad path is supplied
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e) //Thrown by getDirectoryStream() if the directory cannot be walked
		{
			e.printStackTrace();
		}
		catch (UncheckedIOException e)
		{
			System.out.println("Unable to walk the structure of the directory " +
					"because access to one or more files/folders was denied");
		}
		finally
		{
			if (pathStream != null) // Need to make sure to close the stream
				pathStream.close();
		}
		
		

	}

}
