package Level1Task2;

import java.util.Random;


import java.util.Scanner;
  


public class Number_Guessing_Game {
    public static void main(String[] args) {
    	
    	int lowerBound = 1;
    	int upperBond = 100;
    	int maxAttempts =05;
    	
    	Random rand = new Random();
    	int targetNumber = rand.nextInt(upperBond - lowerBound +1)+ lowerBound;
    	
    	Scanner scanner = new Scanner(System.in);
    	int attempts = 0;
    	
    	while (attempts < maxAttempts) {
    		System.out.print("Enter your guess");
    	     int userGuess = scanner.nextInt();
    	     attempts++;
    	     
    	     if(userGuess == targetNumber) {
    	    	 System.out.println("Congratulations! You guessed the number in \" + attempts + \" attempts.");
    	     }else if (userGuess < targetNumber) {
    	    	 System.out.println("Try a higher number");
    	     }else {
    	    	 System.out.println("Try a lower number");
    	     }
    	     
    	     int remainingAttempts = maxAttempts - attempts;
    	     if (remainingAttempts > 0) {
    	    	 System.out.println("You haave " + remainingAttempts + "attempts left" );
    	     }else {
    	    	System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + "."); 
    	     }
    	   }
    	scanner.close();
	}
  }
