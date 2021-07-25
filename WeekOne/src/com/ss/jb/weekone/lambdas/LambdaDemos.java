package com.ss.jb.weekone.lambdas;

import java.util.function.Function;
import java.util.stream.IntStream;

public class LambdaDemos
{
	/***
	 * Returns a lambda expression that will determine whether an integer is odd
	 * @return Function<Integer, Boolean>
	 */
	public Function<Integer, Boolean> isOdd()
	{
		return (x) -> x % 2 == 1;
	}
	
	/***
	 * Returns a lambda expression that will determine whether an integer is prime
	 * @return Function<Integer, Boolean>
	 */
	public Function<Integer, Boolean> isPrime()
	{
		//There is no known method to efficiently determine whehter a number is prime.
		//The most widely known algorithm is as follows:
		//n == 1 ? not prime
		// n % 2 == 0 ? not prime
		//if n % 2 == 1: 
		//1 - Get x = sqrt(n)
		//2 = n % i == 0 for any i in [3, x] ? not prime
		
		/**
		 * The block below should perform this algorithm
		 * return (x) -> 
		{
			boolean prime = true;
			Double sqrtx;
			
			//Easy to rule out 1 and even numbers as prime
			if (x == 1 || x % 2 == 0)
			{
				prime = false;
			}
			else
			{
				//Otherwise, need to implement the algorithm above to detect primes
				sqrtx = Math.sqrt(x);
				for (int i = 3; i <= sqrtx; i = i + 2)
				{
					if (x % i == 0)
					{
						prime = false;
						break;
					}
				}
			}
			return prime;
		};
		 */
		
		//Try to condense the above into a single-liner using streams
		return (x) -> x == 1 || x % 2 == 0 ? false : 
			IntStream.iterate(3, i -> i <= Math.sqrt(x), i -> i + 3).noneMatch(i -> x % i == 0);
	}
	
	/***
	 * Returns a lambda that determines whether an integer is a palindrome
	 * @return
	 */
	public Function<Integer, Boolean> isPalindrome()
	{
		return (x) -> Integer.valueOf((new StringBuilder(String.valueOf(x))).reverse().toString()) == x;
	}
}
