package prework;

import java.util.Scanner;

public class preworkex {

	public static void main(String[] args) {
//		logFunction();
//		logLoopFunction();
		logb(1000,10); 
	}
	
	public static void logFunction() {
		String word = "Put in a number and we will log it for you!";
		
		System.out.println(word);
		
		Scanner scan = new Scanner(System.in);
		double i = scan.nextInt();
		double logAnswer = Math.log10(i);
		System.out.println(logAnswer);
	}
	
	public static void logLoopFunction() {
		for (int i = 10; i <= 1000; i += 10 ){
			double logAnswer = Math.log10(i);
			System.out.println(i + " log is " + logAnswer );
		}
	}
	
	public static void logb( double x, double base ) {
		System.out.println(Math.log10(x) / Math.log10(base));
	}

}
