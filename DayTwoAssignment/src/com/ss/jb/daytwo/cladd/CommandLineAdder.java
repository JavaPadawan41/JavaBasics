package com.ss.jb.daytwo.cladd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * CommandLineAdder.java
 * accepts numeric arguments from the commandline sums them
 * @author Justin
 *
 */
public class CommandLineAdder
{

	/**
	 * adds together 
	 * @param args sequence of numeric arguments
	 */
	public static void main(String[] args)
	{
		ArrayList<Double> parsedArgs = new ArrayList<Double>(args.length);
		double sum;
		String stringSum;
		String message = "";
		int i;
		
		//Three possibilities
		//1 - No args provided. In that case, simply output a message to the user stating as much
		//2 - Args provided, but some of them are not convertible to numeric - Treat all as strings and
		//3 - Args provided, all convertible to doubles. Make conversion, sum, then present the results
		try
		{
			//Case 1 - empty arg list, so just tell the user what happened
			if (args.length == 0)
			{
				message = "No command line arguments were specified";
			}
			//Case 2 - Try to treat everything as numeric, failover to strings if exception raised
			else
			{
				//Can take advantage of the Arrays.stream to perform the conversion and addition without
				//writing a for loop
				sum = Arrays.stream(args).map(x -> Double.parseDouble(x)).reduce(0d, (l, r) -> l + r);
				message = String.format("The sum of command line arguments is %.2f", sum);
			}	
		}
		catch (NumberFormatException e)
		{
			//Could use another Stream here, but String.join seems a bit simpler
			stringSum = String.join("", args);
			message = "The 'sum' (concatenation) of command line arguments is " + stringSum;
		}
		finally
		{
			System.out.println(message);
		}
	}
}
