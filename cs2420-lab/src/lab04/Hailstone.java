package assignment02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class calculates the Hailstone sequence with any given number.
 * 
 * The hailstone sequence is simple, if and integer is even then divide by 2 and if it is odd then 
 * times by 3 and add one. 
 * 
 * Eventually if the sequence continue, it will eventually converges to the number 1, this this 
 * phenomenon is called the Collatz Conjecture.
 *
 * @author  Henry Doan
 * @version January 22, 2017
 */

public class Hailstone {

	public static void main(String[] args) {
		messageprompt();
	}
	
	public static void messageprompt() {
		// welcome message
		System.out.println("Hello, Welcome to the Hailstone program, lets begin but having you input a positve number: ");
		
		// initial variables
		// scanner to get the user's input
		Scanner userInput = new Scanner(System.in);
		// set the users input as the variable N for the number to be mutable
		int N = userInput.nextInt();
		
		// Have a copy of the user input so it can be unmutable
		int copyOfN = N;
		
		// have array list to store all of the number in the series during the calulation
		List seriesOfNumbers = new ArrayList();
		
		// have a counter to count the number of iterations
		int count = 0;
		
		// a loop to get the user to enter a positive number and then set the number to N
		while (N < 0) {
		    System.out.println("I'm sorry, please print a positive number: ");
		    N = userInput.nextInt();
		}
		
		// while the loop is not one the do the hailstone calculation
		while (N != 1) {
			// if it is even
			 if ( N % 2 == 0) {
				// do the calculation
				N = N / 2;
				
				// increment the count by 1
				count++;
				
				// push the number into storage in the array list
				seriesOfNumbers.add(N);
				
				// else it is odd
			} else {
				// do the calculation
				N = ((N * 3) + 1);
				
				// increment the count by 1
				count++;
				
				// push the number into storage in the array list
				seriesOfNumbers.add(N);
			}
			 userInput.close();
		}
		
		
		
		// print out the results
		System.out.println("Here is an array with the series numbers: " + seriesOfNumbers);
		
		System.out.println(copyOfN +" takes " + count + " times to interate in the series to converges to 1");
	}

}
