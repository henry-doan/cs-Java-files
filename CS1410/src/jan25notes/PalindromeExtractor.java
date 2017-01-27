package jan25notes;

import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;

public class PalindromeExtractor {
	/**  
	 * Application entry point.  This is where  
	 * execution starts.  This application allows  
	 * a user to select a text file and then reports  
	 * all the palindromes found in that file  
	 * to the console.  
	 *  
	 * @param args (not used)  
	 */ 
	
	public static void main (String[] args) {
		try {
		File f = new File ("Yankee.txt");
		    Scanner in = new Scanner(f);     
		    while (in.hasNext())     {     
		    		String word = in.next();     
		    		word = removePunctuation(word);         
		    		System.out.println(word);     
		    	} 
		} catch (IOException e) {
			System.out.println("Cannot open Yankee.txt");
		}
	}
	
	/**  
	 * Returns a copy of the string with all  
	 * punctuation and other non letters removed 
	 * and all characters converted to lowercase.  
	 *  
	 * @param s  a string to convert  
	 * @return   a copy of the string with punctuation removed  
	 */ 
	static public String removePunctuation (String s) {
		String converted = ""; 
		int pos = 0; 
		while (pos < s.length()) {
			char ch = s.charAt(pos); 
			if (Character.isLetter(ch))
				converted = converted + ch;
				pos++;
		} 
		return converted.toLowerCase();
	}
}
