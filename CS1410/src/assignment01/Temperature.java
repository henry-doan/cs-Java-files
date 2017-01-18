package assignment01;

import java.util.Scanner;

/**
 * This class gets the Celsius value of any fahrenheit input.
 *
 * @author  Henry Doan
 * @version January 17, 2017
 */

public class Temperature {

	/**
	 * Main method to run all the other methods in order.
	 */
	
	public static void main(String[] args) {
		welcome();
		calculation();
	}
	
	
	/**
	 * welcome method shows a welcome text in a string and a line separation.
	 */
	
	public static void welcome() {
		System.out.println("Hello! Welcome to the Temperture,\nwhere this program will calculate Celsius with any given Fahrenheit value!");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	/**
	 * Calculation method where the program gets the user input and used a scanner to do so and initialize the scanner as a integer variable for 
	 * shorter code. then use math library and logic to get the end result.
	 */
	
	public static void calculation() {
		// message prompt to get the user input.
		System.out.println("Enter in a Fahrenheit for this program to Celsius counter part:");
		
		// initializing a new scanner with the user input to be a int, scanning the next input in the console for the integer for the degree fahrenheit all in one line.
		int Fahrenheit = new Scanner(System.in).nextInt();
		
		// subtract 32 from the input
		int fahrenheitMinus32 = Fahrenheit - 32;
		
		// divide 5 / 9 , but for an int 5/9 is 0.555 repeating which as an int get truncated to 0 so this is always 0, to get around it I multiple by 100 for it to be truncated as an int not zero to 55.555 repeating which get truncated to 55
		int integerDivision = ( 5 * 100 / 9);
		
		// then times the fahrenheit minus 32 and the integer and also undoing the 100 so it will be accurate and same as multipling by 1 in a sense and we will get celsius
		int celsius = (integerDivision * fahrenheitMinus32) / 100;

		// final message
		System.out.println(Fahrenheit + " degrees Fahrenheit is approximately: " + celsius + " degrees Celsius!");
	}

}
