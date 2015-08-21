import static org.junit.Assert.*;

import java.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import junit.*;


/**
 * @author      Michael Maynard 
 * @version     N/A                 (current version number of program)
 * @since       2015-08-20          (the version of the package this class was first added to)
 */

interface PrimeNumberGenerator3 {

	 List<Integer> generate(int startingValue, int endingValue);

	 boolean isPrime(int value);

	}

public class MakesPrimesFinal implements PrimeNumberGenerator3{

	public static void main(String[] args){
		
		//just initializing the values
		int start = 1;
		int end = 2;
		
		boolean notAnInt = false;
		
		Scanner input = new Scanner(System.in);
		MakesPrimesFinal primesF = new MakesPrimesFinal();
		System.out.println(" Go ahead and enter a starting value (must be an integer) ");
		
		//is the user input valid? Closes the program if input is invalid
		try{
			start = input.nextInt();
		}
		catch (InputMismatchException e){
			System.out.println("Sorry, that's not an integer. Please feel free to run the program again! ");
			System.exit(0);
			notAnInt = true;
		}
		
		 System.out.println("Thanks! Now please enter an ending value (again, this has to be an integer): ");	 
		
		try{
			end = input.nextInt();
		 }
		catch (NumberFormatException e){
			System.out.println("Sorry, that's not an integer. Please feel free to run the program again! ");
			System.exit(0);
			notAnInt = true;
		}
		//is this still true or did the flag change to false as the result of a non-int from the user
		assertFalse(notAnInt);
		//generate an ascending or descending list of primes
		if(start<end){
		primesF.generate(start, end);
		}
		if (start>end){
		primesF.generateReverse(start, end);
		}		
		//primesF.testPrimes(start);
		
		//System.out.println("----------");
		
		//System.out.println(primesF.generate(start, end));
	}
	
	/**
	 * This is the ascending prime list                         (1)
	 * <p>
	 * iterates through a range of values until the limit
	 * is reached and then prints out the primes.   [2]
	 * 
	 * <p>
	 * 
	 *
	 * @param  integer startingValue,integer endingValue          (3)
	 * @return null/just a formality in my use of this method
	 */
	public List<Integer> generate(int startingValue, int endingValue) {
		for(startingValue = 1; startingValue <= endingValue;startingValue++){
			if(isPrime(startingValue)){
				//generate(startingValue,endingValue).add(startingValue);
				//testPrimes(startingValue, endingValue);
				testPrime(startingValue);
			 System.out.println(startingValue);
			}
		}
		return null;
	}
	
	/**
	 * This is the descending prime list                         (1)
	 * <p>
	 * iterates through a range of values until the lower limit
	 * is reached and then prints out the primes.   [2]
	 * 
	 * <p>
	 * 
	 *
	 * @param  integer startingValue,integer endingValue          (3)
	 * @return null/just a formality in my use of this method
	 */
	public List<Integer> generateReverse(int startingValue, int endingValue) {
		
			while(startingValue >= endingValue){
			if(isPrime(startingValue)){
			 System.out.println(startingValue);
			}
	//decrement driver
			startingValue--;
		}
		return null;
	}

	/**
	 * This determines if the number is prime                          (1)
	 * <p>
	 * iterates through a range of values until 
	 * comparing each number to all others
	 * until it knows if the number is prime.   [2]
	 * 
	 * <p>
	 * 
	 *
	 * @param  integer value          (3)
	 * @return boolean true if prime, false if not prime
	 */
	public boolean isPrime(int value) {
		for (int j = 2; j<value;++j){
			if (value % j == 0){
				return false;
			}
		}
		return true;
	}	
	
	
	/**
	 * This is my attempt at a junit test method                        (1)
	 * <p>
	 * double checks if the isPrime number is actually prime
	 * 
	 *   [2]
	 * 
	 * <p>
	 * 
	 *
	 * @param  integer value         (3)
	 * @return asserts results
	 */
	@Test
	public void testPrime(int value){
		System.out.println("testing if the values are correct: ");		
		assertTrue(value != 0);
		assertTrue(isPrime(value));
		
	}
}