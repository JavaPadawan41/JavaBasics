/***
 * GuessingGame.java
 * Class that simulates a simple numerical guessing game
 */
package smoothstack.jb.dayone.guessinggame;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{

	private static final int MIN_VALUE = 1;
	private static final int MAX_VALUE = 100;
	
	public static void main(String[] args)
	{
		Random rnd = new Random();
		int actual = rnd.nextInt(100) + 1;
		int guess;
		boolean isCorrect, shouldContinue;
		int i = 0;
		String errMsg = String.format("Invalid Guess. Must be an integer between %d and %d", MIN_VALUE, MAX_VALUE);
		String prompt, incorrectResponse, userInput;
		
		do
		{
			incorrectResponse = i < 4 ? errMsg : String.format("Sorry: %d", actual);
			try
			{
				userInput = getGuess(MIN_VALUE, MAX_VALUE);
				guess = Integer.parseInt(userInput.trim());
				
				//Validate that the input is in the range of 1-100 and error message if not
				if (!isInRange(guess, MIN_VALUE, MAX_VALUE))
				{		
					System.out.println(incorrectResponse);
					shouldContinue = true;
				}
				else
				{
					//Answer is considered correct if it is within the closed interval [actual - 10, actual + 10]
					isCorrect = isInRange(guess, actual - 10, actual + 10);
					
					//What prompt to display to the user depends both on whether this was their last guess, 
					//and whether they were correct in their guess
					prompt = isCorrect ? String.valueOf(actual) : 
						i == 4 ? incorrectResponse : "Sorry, guess agin."; 
					System.out.println(prompt);
					
					//The looping should continue only if the user was not correct
					shouldContinue = !isCorrect;
				}
			}
			catch (NumberFormatException e)
			{
				//If the user entered an invalid response, display the error message, and continue the loop
				System.out.println(incorrectResponse);
				shouldContinue = true;
			}
			
			i++;
			
		//Iteration should only continue until user is correct or until 5 tries exhausted, whichever comes first
		} while (shouldContinue && i < 5);

	}
	
	/***
	 * Prompts the user for their guess of an integer value
	 * @param minValue: The minimum value to guess
	 * @param maxValue: The maximum value to guess
	 * @return int: The value entered by the user
	 * @throws InputMismatchException: If user failed to enter an integer value
	 * @throws NoSuchElementException: If input is empty
	 */
	private static String getGuess(int minValue, int maxValue) throws InputMismatchException, NoSuchElementException
	{
		String guess;
		Scanner kbd = new Scanner(System.in);
		String prompt = String.format("Guess an integer value between %d and %d: ", minValue, maxValue);
		
		//Prompt and attempt to get input
		System.out.print(prompt);
		guess = kbd.nextLine();
		kbd.close();
		
		return guess;
	}
	
	/**
	 * Determines if value is within the closed interval [minValue, maxValue]
	 * @param value The value to check
	 * @param minValue the minimum value of the closed interval
	 * @param maxValue the maximum value of the closed interval
	 * @return bool
	 */
	private static boolean isInRange(int value, int minValue, int maxValue)
	{
		return (value >= minValue) && (value <= maxValue);
	}

}
