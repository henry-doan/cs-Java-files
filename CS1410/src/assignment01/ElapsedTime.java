package assignment01;

import java.util.Scanner;

public class ElapsedTime {

	public static void main(String[] args) {
		welcome();
		calulation();
	}
	
	public static void welcome() {
		System.out.println("Hello! Welcome to the ElapsedTime,\nwhere this program will calulate the time with any given amount of seconds!");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	public static void calulation() {
		System.out.println("Enter the amount of seconds for the program to be converted: ");
		int userInputInSeconds = new Scanner(System.in).nextInt();
		int hours = userInputInSeconds / 3600;
		int minutes = (userInputInSeconds % 3600) / 60;
		int seconds = userInputInSeconds % 60;

		String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		System.out.println(timeString);
	}
}
