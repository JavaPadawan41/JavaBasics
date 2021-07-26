package com.ss.jb.weekone.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LambdaDemos
{

	/***
	 * Returns a lambda expression that will determine whether an integer is odd
	 * @return Function<Integer, Boolean>
	 */
	public static Function<Integer, Boolean> isOdd()
	{
		return (x) -> Math.abs(x % 2) == 1;
	}
	
	/***
	 * Returns a lambda expression that will determine whether an integer is prime
	 * @return Function<Integer, Boolean>
	 */
	public static Function<Integer, Boolean> isPrime()
	{
		//There is no known method to efficiently determine whether a number is prime.
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
			IntStream.iterate(3, i -> i <= Math.sqrt(x), i -> i + 2).noneMatch(i -> x % i == 0);
	}
	
	/***
	 * Returns a lambda that determines whether an integer is a palindrome
	 * @return
	 */
	public static Function<Integer, Boolean> isPalindrome()
	{
		/***
		 * Below should reverse the order of digits in an unsigned integer
		int tmp = x;
		int reversed = 0;
		int power;
		int remainder;
		
		for (power = 10; power <= x * 10; power *= 10)
		{
			remainder = tmp % 10 ;
			tmp = (tmp - remainder) / 10;
			reversed = (reversed * 10) + remainder;
			//reversed = (reversed * 10) + remainder * 10;
			//System.out.printf("%d, %d, %d\n", tmp, remainder, reversed);
		}
		*/
		
		//Should be the functional version of above
		return (a) -> IntStream.iterate(10, p -> p <= 10 * a, p -> p * 10)
				.map((i) -> (a % i) / (i / 10))
				.reduce(0, (s, e) -> (s * 10) + e) == a;
		
	}
}
