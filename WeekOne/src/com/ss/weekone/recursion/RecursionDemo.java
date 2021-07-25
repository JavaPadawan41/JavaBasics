package com.ss.weekone.recursion;

public class RecursionDemo
{
	public boolean groupSumClump(int start, int[] values, int target)
	{
		boolean canAttain;
		int i = start + 1;
		int newTarget; //newTarget would be the target to hit if we include the current group
		
		//What is the trivial case?
		//There are two, as I see it - First, there is one unchecked entry in the array
		//adding it to identity either produces the result or it doesn't
		//Second, there remain only entries of the same value 
		//and summing them along with identity either produces the target or it doesnt
		
		//Can do this one of two ways
		//First - int start could refer to a sort of 'running' total. Then the problem is how do we keep
		//track of which values we've taken? Could keep making new sub-arrays with what remains, but that's going
		//to be very space inefficient. 
		//Second, start could refer to at which index we start looking, and we could simply keep a 'running target'
		///by subtracting from the target on each recursion? This seems to make more sense
		//In that case, the trivial cases are as follows:
		//1 - The unchecked portion of the array is down to a single value and that value either equals the target or not
		//2 - The unchecked portion of the array is down to a group of adjacent identical values and they either sum to the target or not
		
		//The key insight is one of groups
		//A group is a collection of adjacent entries with the same value (can have group size of 1)
		//For any group, we can choose to take it or leave it
		//So, for a group, we need to determine if we can reach the target by taking it or leaving it
		//
		
		//array of length 1
		
		//Code for case 1 above
		if (start > values.length - 1)
		{
			canAttain = target == 0;
		}
		else
		{
			newTarget = target - values[start];
			
			//How do we check for adjacent duplicate values? Says we get one loop - Can use a while loop?
			//we would loop while still inside the bounds of the array and while the values inside are identical to what's at start
			//Can keep subtracting from the target value in this loop to get the new target
			while (i < values.length && values[i] == values[start])
			{
				newTarget -= values[i++];
			}
			
			//There are two possibilities - Either include the current 'group' (values[i] is a group of 1)
			//or exclude it. Try them both to get the possibilities
			canAttain = groupSumClump(i, values, newTarget) || groupSumClump(i, values, target);
		
		}	
		
		return canAttain;	
	}
}
