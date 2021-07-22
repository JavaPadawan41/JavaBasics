package com.ss.jb.daythree.walkdir;

/**
 * DirectoryWalker.java
 * Simple class for recursively walking through a directory
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryWalker
{
	private Path root;
	
	/***
	 * Creates a new instance of DirectoryWalker
	 * @param path String that evaluates to the root of the directory structure to walk
	 * @throws InvalidPathException
	 */
	public DirectoryWalker(String path) throws InvalidPathException, IllegalArgumentException
	{
		this(Paths.get(path));
	}
	
	/***
	 * Creates a new instance of DirectoryWalker
	 * @param path Path that represents the root of the directory structure to walk
	 * @throws InvalidPathException
	 */
	public DirectoryWalker(Path path) throws IllegalArgumentException
	{
		//Need to throw up an exception if what was provided is not a directory
		if (!Files.isDirectory(path))
		{
			throw new IllegalArgumentException("The specified path was not a directory");
		}
		this.root = path;
		
	}
	
	/***
	 * 
	 * Walks the directory depth first and recursively, returning a stream to the contents therein
	 * @return Stream<File> Stream to the contents of the object's root directory
	 */
	public Stream<Path> getDirectoryStream() throws IOException
	{
		return Files.walk(this.root);
	}
}
