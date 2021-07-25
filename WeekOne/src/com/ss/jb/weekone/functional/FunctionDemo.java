package com.ss.jb.weekone.functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionDemo
{
	/***
	 * Returns a list of integers consisting of only the right-most digit of its corresponding entry in values
	 * @param values The list of integers to process
	 * @return List<Integer>
	 */
	public List<Integer> rightDigit(List<Integer> values)
	{
		return values.stream().map((x) -> Math.abs(x % 10)).collect(Collectors.toList());
	}
	
	/***
	 * Returns a list of integers whose members are the members of values multiplied by 2
	 * @param values The values to double
	 * @return List<Integer>
	 */
	public List<Integer> doubling(List<Integer> values)
	{
		return values.stream().map(x -> x * 2).collect(Collectors.toList());
	}
	
	/***
	 * Returns a list of Strings whose members are the members of values with all isntances of 'x' or 'X' removed
	 * @param values The strings to process
	 * @return List<String>
	 */
	public List<String> noX(List<String> values)
	{
		return values.stream().map(x -> x.replaceAll("[xX]", "")).collect(Collectors.toList());
	}
}
