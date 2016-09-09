package a2;

import java.util.Scanner;

/* 
 * Instructions for students:
 * 
 * Use the main method only to make calls to the other methods to test them.  
 * The correct operation of your methods should not depend in any way on the
 * code in main.
 * 
 * Do not do any printing within the method bodies, except the main method.
 * 
 * Leave your testing code in main -- you will be graded on this.
 *  
 * You must include Javadoc comments for all methods below. See the 
 * assignment specifications for more details. 
 */

/**
 * A collection of methods for the second assignment of CS 1410. An assortment of 
 * methods that does multiple function and has different purposes.
 * 
 * @author Henry Doan
 */
public class MethodCollection {

	public static void main(String[] args) {	
		countTokens("this is a test");
		countTokensThatAreNotInt("this is a 12 test");
		describeSign(-2);
		isEvenlyDivisibleBySeven(14);
		makeLine('+', '-', 28);
		makeSquare(12, 12);
		capitalizeLastCharacter("raft");
		capitalizeLastCharactersInSentence("This is a test");	
	}

	/**
	 * Returns the number of tokens (as identified by the s.next() method on
	 * Scanners s) that appears in the parameter sentence. For example,
	 * countTokens("this is a test") should return 4, and countTokens("") should
	 * return 0.
	 * 
	 * IMPLEMENTATION NOTE: This will require a while loop. Use a Scanner to
	 * split the string into individual words. You may not use more advanced
	 * Java functions that do the token counting for you.
	 */
	public static int countTokens(String sentence) {

		int count = 0;
		Scanner s = new Scanner(sentence);
		while (s.hasNextLine()){
			s.next();
			count++;
		};
		s.close();
		System.out.println(count);
		return count;
	}


	/**
	 * Returns the number of tokens (as identified by the s.next() method on
	 * Scanners s) in the parameter sentence that are not an int, as identified
	 * by s.hasNextInt(). For example, countTokensThatAreNotInt("this is 12 a
	 * test") should return 4, and countTokensThatAreNotInt("12") should return
	 * 0.
	 * 
	 * IMPLEMENTATION NOTE: This will require a while loop. Use a Scanner to
	 * split the string into individual words. Use an if statement to figure out
	 * whether to count the token or not.
	 */
		
	public static int countTokensThatAreNotInt(String sentence) {
		int count = 0;
		Scanner s = new Scanner(sentence);
		while (s.hasNextLine()){
			s.next();
			count++;
			if (s.hasNextInt()) {
				count--;
			};
			String regex = "^[0-9]$";
			if (sentence == regex) {
				count = 0;
			};
		};
		s.close();
		System.out.println(count);
		return count;
	}
	
	/*
	 * This describeSign method has a parameter of an integer which is named 
	 * integerValue.The method then has two if statements with the first one 
	 * having the condition of if the integerValue is less than zero (0) then 
	 * prints out negative
	 * 
	 * The next if statement is comparing if the integerValue is greater
	 * than or equal to zero (0) print our non-negative, with the return of 
	 * intergerValue. 
	 * 
	 * @params intergerValue  a variable that represents a number from the input in the parameters when calling the method in main.
	 * @return                returns the value of the number. 
	 * 
	 */
	public static int describeSign(Integer integerValue) {
		if (integerValue < 0) {
			System.out.println("negative");
		};
		if (integerValue >= 0) {
			System.out.println("non-negative");
		};
		return integerValue;
	}
	
	/*
	 * This method called isEvenlyDivisibleBySeven takes the integer varaible called
	 * integerValue. This method has an if else statement of taking the integerValue 
	 * and using the modulus operator of % of seven and if it is equal to zero (0) then
	 * print out true. Else print out false. with the return of integerValue;
	 * 
	 * @params intergerValue  a variable that represents a number from the input in the parameters when calling the method in main.
	 * @return                returns the value of the number.
	 * 
	 */
	
	public static int isEvenlyDivisibleBySeven(Integer integerValue) {
		
		if (integerValue % 7 == 0 ) {
			System.out.println("true");
		} else {
			System.out.println("false");
		};
		return integerValue;
	}

	/**
	 * Returns a String of length width that begins and ends with the character
	 * edge and contains width-2 copies of the character inner in between. For
	 * example, if edge is '+', inner is '-', and width is 8, the method should
	 * return "+------+".
	 * 
	 * The method does not print anything. The parameter width must be greater
	 * than or equal to 2.
	 * 
	 * IMPLEMENTATION NOTE: This method is already completely implemented. There
	 * is no need for you to change anything.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int i = 0;
		while (i < width - 2) {
			line = line + inner;
			i = i + 1;
		}
		return edge + line + edge;
	}
	
	/*
	* This method uses the method make line to draw the top and bottom lines with the 
	* parameters of the corner characters, middle characters, and the width of how big
	* vertically the square is.
	* 
	* The make square method takes in a integer value of params of a width and height of how high 
	* and wide the square is.
	* 
	* The method was solved in two different ways, the first being the uncommented with the 
	* for loop and the second, being the commented out  lines with the while loop.
	* 
	* The uncommented has an integer variable of widthMinusTwo which is the width minus 2 
	* to represent the middle space of the square horizontally. The next String variable
	* outside is calling the method makeline with the parameters of the symbols of the 
	* corners and the line with the width. The middle variable is the length of the 
	* widthMinusTwo and replace it with a blank space with the length. The System out prints
	* the top of the box with the appropriate length and the for statement is used as the height 
	* of the box and repeat the middle with two sides for however long the height is. Then call the make line 
	* to close the box and return the middle variable. 
	* 
	* The second way of the way of making a square is similar to the for loop way but with the
	* while loop and the h variable of zero. The while sees if the width is bigger than 
	* two, then print out the out and another while loop checking if the height is bigger
	* than two then the sides and the middle with increasing the h counter until the height 
	* is met. Also increase the widthMinusTwo until the width is met with returning middle.
	* 
	* @params width  a integer representing the wide set
	* @params height  a integer representing the vertical set
	*  return        spaces that stretch the box to match the height and width.
	*/
	public static String makeSquare(int width, int height) {
		int widthMinusTwo = width - 2;
//		int h = 0;
		String outside = makeLine('+', '-', width);
		String middle = new String(new char[widthMinusTwo]).replace("\0", " ");
		System.out.println(outside);
		for (int i = 0; i < widthMinusTwo; i += 1 ) {
			System.out.println("|" + middle + "|");
		}
		System.out.println(outside);
//		while (widthMinusTwo <  width ){
//			System.out.println(outside);
//			while (h < height - 2) {
//				System.out.println("|" + middle + "|");
//				h++;
//			}
//			widthMinusTwo++;
//		}
		

		return middle;
	}
	
	/**
	 * This method takes in a parameter of word and use the parameter to manipulate the word.
	 * This method had a lot of variables the first being an integer of the letter count of
	 * the word with the length element. The string back uses the word and has the substring of
	 * size of word and word minus one to get the last letter. Then the string uppercase uses
	 * the back variable to have the last letter be uppercase. The string front get the letters of 
	 * the front of the word minus the last letter and the string new word is the front concatenated with 
	 * uppercasing and system output the new word with the last letter capitalize with the new Word.
	 * 
	 * @params word  a input of an single word
	 * return        new word with the capital last letter
	 */
	public static String capitalizeLastCharacter(String word) {
		int sizeOfWord = word.length();
		String back = word.substring((sizeOfWord-1), (sizeOfWord)) ;
		String uppercasing = back.toUpperCase();
		String front = word.substring(0, word.length()-1);
		String newWord = front + uppercasing;
		System.out.println(newWord);
		return newWord;
	}

	/**
	 * This method takes in a parameter of a sentence consisting of mulitple words.
	 * There is a scanner s that makes a new scanner for sentence. The While loop checks to 
	 * scanner s has a next line and will call the the previous method of capitalizing the last
	 * letter of the word on the next scanner element. Then close the scanner and return the sentence 
	 * with all ending letters of each word be a capital letter.
	 * 
	 * @params sentence a string with multiple words
	 * return           sentence with last letter of the word being capitalized.
	 */
	public static String capitalizeLastCharactersInSentence(String sentence) {
		Scanner s = new Scanner(sentence);		
		while (s.hasNextLine()){
			capitalizeLastCharacter(s.next());
		}
		s.close();
		return sentence;
	}

}
