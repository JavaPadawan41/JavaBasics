/**
 * PatternPrinter.java
 * Prints the patterns specified in Java Basics Day 1 Assignment 1
 * @author Justin W Walthers
 *
 */
package smoothstack.jb.dayone.patternprint;

import java.util.Arrays;



public class PatternPrinter
{
	private static final char STAR = '*';
	private static final char DOT = '.';
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		printPattern(1);
		printPattern(2);
		printPattern(3);
		printPattern(4);
	}
	
	/***
	 * Prints the pattern required by Day 1 Assignment one
	 * @param invert Whether the pattern is to be inverted
	 * @param patternNumber
	 */
	private static void printPattern(int patternNumber)
	{
		int start, end, increment, charCount, length;
		char justify;
		
		//Inversion happens on the even numbered patterns
		boolean invert = patternNumber % 2 == 0 ? true : false;
		
		//Initialize the loop variables depending on whether the pattern should be inverted
		if (invert)
		{
			start = 5;
			end = 0;
			increment = -1;
		}
		else
		{
			start = 1;
			end = 6;
			increment = 1;
		}
		
		//Justification of string is dependent on pattern number
		switch (patternNumber)
		{
			case 1: case 2:
				justify = 'l';
				break;
			case 3: case 4:
				justify = 'c';
				break;
			default:
				justify = 'l';
				break;
		}
		
		//Print the first line of the pattern
		System.out.println(patternNumber + ")\n");
		
		//Then, use loops to print the various lines of the pattern
		for (int i = start; i != end; i += increment)
		{
			//5th line is essentially the same, regardless of pattern. Only need to alter the justification (but not really)
			if (i == 5)
			{
				System.out.println(buildLine(DOT, 9, 9, justify));
			}
			else
			{
				////Because patterns 3 and 4 need to be centered in a string of length 9, these need to be set differentially
				length = patternNumber < 3 ? i : 9;
				charCount = patternNumber > 2 ? (i * 2) - 1 : i;
				System.out.println(buildLine(STAR, charCount, length, justify));
			}
		}
	}
	
	/***
	 * Builds a string of length l containing charCountinstances of c, padded according to padStyle
	 * @param c char from which to build the new string
	 * @param count instances of c to include in the new string
	 * @param justify. Whether to place the characters in the left, ('l'), right ('r'), or center ('c') of the string. Default 'l'
	 * @return String
	 */
	private static String buildLine(char c, int charCount, int length, char justify)
	{
		int padLength = (length - charCount) / 2; //length of the padding for centering
		char[] patternChars = new char[charCount]; //char array for building the actual line pattern
		String pattern; //the pattern for the new line
		Arrays.fill(patternChars, c); //Fill the array with instances of c, so it can be used in a String constructor
		String newLine;
		
		pattern = new String(patternChars);
		
		//Use String.format to place the pattern justified in the string, padded with spaces
		switch (justify)
		{
			case 'c':
				/**
				 * Center justification is tricky
				 * Have to put equal amount of padding on both sides of the pattern string p
				 * total Length of desired string is L
				 * 
				 * Length of padding on either side is pl = (L - len(p)) / 2
				 * Achieve the correct padding by:
				 * 1.) place pattern in right-justified string of length pl + len(p)
				 * The, place result from above in left-justified string of length L
				 */
				newLine = String.format("%-" + length + "s", String.format("%" + (padLength + pattern.length()) + "s", pattern));
				break;
			case 'r':
				//Right justify is easy, simply use the proper String.format specifiers
				newLine = String.format("%" + length + "s", pattern);
				break;
			default:
				//Left justify is easy, simply use the proper String.format specifiers
				newLine = String.format("%-" + length + "s", pattern);
				break;
		}
		
		return newLine;
	}
	

}
