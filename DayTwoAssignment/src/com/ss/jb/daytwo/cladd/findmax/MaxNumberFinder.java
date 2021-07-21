package com.ss.jb.daytwo.cladd.findmax;

import java.util.Random;

/**
 * MaxNumberFinder.java
 * Finds the maximum value in a 2d array of numbers and reports its position
 * @author Justin
 *
 */
public class MaxNumberFinder
{

	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int height = rnd.nextInt(50) + 1;
		int width = rnd.nextInt(50) + 1;
		int[][] table = new int[height][width];
		int iHighest = 0; //outer index of highest value
		int jHighest = 0; //inner index of highest value
		int highest = Integer.MIN_VALUE;
		
		
		
		//First up, populate the array with random numbers
		//Using Arrays.fill or Arrays.setAll is too complex and unreadable with ND arrays, go with loops
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				table[i][j] = rnd.nextInt();
			}
		}
		
		
		/**
		 * How to locate the highest element
		 * 1.) Could sort then search, but even this wouldn't be better than O(n log n) 
		 * and we'd need to construct a hashtable during the sorting process anyway, as we want to report 
		 * the position of the highest value, not the highest value itself
		 * 2.) Can just do a linear search, which runs in O(n) time no matter what. 
		 * This is already faster than 1 above, so let's go with that
		 * edge cases
		 * 1.)
		 * multiple cells are populated with the same value, which is the highest
		 * Every such cell is then the highest and any one could be reported
		 * If we make the comparison table[i][j] > highest, with highest initialized to the min value,
		 * This does in fact report an accurate result in that the earliest index was the highest value
		 * If we make the comparison table[i][j] >= highest, this is also technically accurate, as
		 * it would report the last cell as the highest value.
		 * Typically when searching an array, we get back the first index of what we are looking for,
		 * So let's go with that here
		 */
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (table[i][j] >= highest)
				{
					highest = table[i][j];
					iHighest = i;
					jHighest = j;
				}
			}
		}
		
		System.out.printf("The highest value was %d, located at (%d, %d)", highest, iHighest, jHighest);
	}
}
