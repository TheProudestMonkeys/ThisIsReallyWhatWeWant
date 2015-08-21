import java.util.*;
import java.*;

interface PrimeNumberGenerator {

 List<Integer> generate(int startingValue, int endingValue);

 boolean isPrime(int value);

}

public class MakePrimes implements PrimeNumberGenerator{
		
	private boolean primeFlag;

	public static void main(String[] args){
		//initialize these values
		 int start = 0;
		 int end = 0;
		 
		//take user input
		Scanner userInput = new Scanner(System.in); 
		System.out.println(" Go ahead and enter a starting value (must be an integer) ");
		
		//is the user input valid? Closes the program if input is invalid
		try{
			start = userInput.nextInt();
		}
		catch (InputMismatchException e){
			System.out.println("Sorry, that's not an integer. Please feel free to run the program again! ");
			System.exit(0);
		}
		
		 System.out.println("Thanks! Now please enter an ending value (again, this has to be an integer): ");	 
		try{
			end = userInput.nextInt();
		 }
				catch (NumberFormatException e){
					System.out.println("Sorry, that's not an integer. Please feel free to run the program again! ");
					System.exit(0);
		}
		MakePrimes make = new MakePrimes();
		if (start < end){
		make.generate(start, end);
		}
		if (start > end){
		make.generateReverse(start, end);
		}
		//memory management
		userInput.close();
	}

@Override
public List<Integer> generate(int startingValue, int endingValue) {	
	
	for(startingValue = 1;startingValue<=endingValue;startingValue++){
	  	for (int j = 2; j < endingValue;j++){
	  	//the flag is initially set
	  		boolean primeFlag = true;
				if (startingValue % j == 0){
		//the flag will change if the number is not prime
					primeFlag = false;
					break;
				}
				if (primeFlag = true){
					isPrime(startingValue);
					break;
				}
	  	} 	
  }	
		//a formality
	return null;
}

public List<Integer> generateReverse(int startingValue, int endingValue) {	
	
		//decrementing while loop
	while (startingValue >= endingValue){
		startingValue--;
		int j = startingValue + 1;
	  		while(j >= endingValue){
	  	//the flag is initially set
	  		boolean primeFlag = true;
				if (startingValue % j == 0){
		//the flag will change if the number is not prime
					primeFlag = false;
					break;
				}
				if (primeFlag = true){
					isPrime(startingValue);
					break;
				}	
	  }
	  		startingValue--;
	  		j--;
	  		
	}	
		//a formality
	return null;
}

public boolean isPrime(int value) {
	System.out.println(value + " is prime! ");	
	return true;
	}	
}


