package gradeCalc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that Calculates the grade percentage in the console for CS1410 Spring 17 class
 * 
 * @author Henry Doan
 * @version April 30th, 2017
 */
public class GradeCalculator {
	
	// Fields
	
	// List to hold the scores
	static ArrayList<Double> labArr;
	static ArrayList<Double> labQuizArr;
	static ArrayList<Double> assignmentArr;
	static ArrayList<Double> writtenQuizArr;

	// scores as a percent
	static double labPercent;
	static double labQuizPercent;
	static double assignmentPercent;
	static double writtenQuizPercent;
	
	/**
     * The application entry point. This is where the welcome and ending prompt is
     * 
     * @param String[] args arguments input
     */
	public static void main(String[] args) {
		// welcome prompts
		System.out.println("Welcome to your CS1410 Spring 17 Grade Calculator");
		System.out.println("--------------------------------");
		
		// methods to get scores and set variables
		labScores();
		
		quizScores();
		
		assignmentScores();
		
		writtenQuizScores();
		
		// input the final grade
		scorePercentage();
		
		// make changes
		scoreChange();
		
		// ending prompt
		System.out.println("Thanking for using this CS1410 Spring 17 Grading Calculator");
	}
	
	/**
     * A method that has a prompt and reads in the users input 
     * to get the lab scores and add them to the array list.
     * 
     * @return 0 to not throw an error
     */
	public static double labScores() {
		// message prompt
		System.out.println("Input your lab scores: ");
		System.out.println("(press enter to enter a new score or a non number key with enter to move on to the next step)");
		
		// makes a new scanner
		Scanner labInput = new Scanner(System.in);
		
		// makes a new array list with length of 10 because there are at most 10 scores.
		labArr = new ArrayList<Double>(10);
		
		// while there is a next double number
		while (labInput.hasNextDouble()) {
			// if next input is not a double break out
			if (!labInput.hasNextDouble()) {
				break;
			}
			// add the users input in to the array list
			labArr.add(labInput.nextDouble());
		}
		
		// go to the next method
		tallyUpLabs();
		return 0;
	}
	
	/**
     * A method that has a prompt and reads in the users input 
     * to get the lab quiz scores and add them to the array list.
     */
	public static double quizScores() {
		// message prompt
		System.out.println("Input your lab quiz scores: ");
		System.out.println("(press enter to enter a new score or a non number key with enter to move on to the next step)");
		
		// makes a new scanner
		Scanner quizInput = new Scanner(System.in);
		
		// makes a new array list with length of 10 because there are at most 10 scores.
		labQuizArr = new ArrayList<Double>(10);
		
		while (quizInput.hasNextDouble()) {
			// if next input is not a double break out
			if (!quizInput.hasNextDouble()) {
				break;
			}
			
			// add the users input in to the array list
			labQuizArr.add(quizInput.nextDouble());
		}
		
		// go to the next method
		tallyUpLabquizzes();
		return 0;
	}
	
	/**
     * A method that has a prompt and reads in the users input 
     * to get the assignment scores and add them to the array list.
     * 
     * @return 0 to not throw an error
     */
	public static double assignmentScores() {
		// message prompt
		System.out.println("Input your assignment scores: ");
		System.out.println("(press enter to enter a new score or a non number key with enter to move on to the next step)");

		// makes a new scanner
		Scanner assignmentInput = new Scanner(System.in);
		
		// makes a new array list with length of 10 because there are at most 10 scores.
		assignmentArr = new ArrayList<Double>(10);
		
		while (assignmentInput.hasNextDouble()) {
			// if next input is not a double break out
			if (!assignmentInput.hasNextDouble()) {
				break;
			}
			
			// add the users input in to the array list
			assignmentArr.add(assignmentInput.nextDouble());
		}
		
		// go to the next method
		tallyUpAssignment();
		return 0;
	}
	
	/**
     * A method that has a prompt and reads in the users input 
     * to get the written quiz scores and add them to the array list.
     * 
     * @return 0 to not throw an error
     */
	public static double writtenQuizScores() {
		// message prompt
		System.out.println("Input your written quiz scores: ");
		System.out.println("(press enter to enter a new score or a non number key with enter to move on to the next step)");
		
		// makes a new scanner
		Scanner writtenQuizInput = new Scanner(System.in);
		
		// makes a new array list with length of 10 because there are at most 10 scores.
		writtenQuizArr = new ArrayList<Double>(10);
				
		while (writtenQuizInput.hasNextDouble()) {
			// if next input is not a double break out
			if (!writtenQuizInput.hasNextDouble()) {
				break;
			}
			
			// add the users input in to the array list
			writtenQuizArr.add(writtenQuizInput.nextDouble());
		}
			
		// go to the next method
		tallyUpWrittenQuiz();
		return 0;
	}
	
	/**
     * A method that has a a specific grading amount for labs and 
     * reads the list and does the math to calculates the grade percentage.
     * 
     * @return 0 to not throw an error
     */
	public static double tallyUpLabs() {
		// possible lab score for lab1  2    4    5    7   8    9   10   11   12
		double possibleLabScores = 25 + 20 + 15 + 20 + 0 + 10 + 0 + 10 + 25 + 10 ;
		
		// total user score
		double userLabScore = 0;
		
		// reads the array list
		for (int i = 0; i < labArr.size(); i++) {
			// getting a item in the array list
			Double temp = labArr.get(i);
			
			// adding the item to the total use score
			userLabScore = userLabScore + temp;
		}
		
		// math for percentage
		labPercent = (userLabScore / possibleLabScores) * 100;
				
		return 0;
	}
	
	/**
     * A method that has a a specific grading amount for lab quizzes and 
     * reads the list and does the math to calculates the grade percentage.
     * 
     * @return 0 to not throw an error
     */
	public static double tallyUpLabquizzes() {
		// possible scores for labquiz1  2    4    5
		double possibleLabQuizScores = 70 + 100 + 100 + 100 ;
		
		// total user score
		double userLabQuizScore = 0;

		// reads the array list
		for (int i = 0; i < labQuizArr.size(); i++) {
			// getting a item in the array list
			Double temp = labQuizArr.get(i);
			
			// adding the item to the total use score
			userLabQuizScore = userLabQuizScore + temp;
		}
		
		// math for percentage
		labQuizPercent = userLabQuizScore;		
		return 0;
	}
	
	/**
     * A method that has a a specific grading amount for assignments and 
     * reads the list and does the math to calculates the grade percentage.
     * 
     * @return 0 to not throw an error
     */
	public static double tallyUpAssignment() {
		// possible scores for assignment 1    2    3     4     5     6     cp1   cp2  cp3   cp4
		double possibleAssignmentScores = 75 + 75 + 100 + 100 + 140 + 100 + 100 + 75 + 125 + 100;
		
		// total user score
		double userAssignmentScore = 0;
		
		// reads the array list
		for (int i = 0; i < assignmentArr.size(); i++) {
			// getting a item in the array list
			Double temp = assignmentArr.get(i);
			
			// adding the item to the total use score
			userAssignmentScore = userAssignmentScore + temp;
		}
	
		// math for percentage
		assignmentPercent = (userAssignmentScore / possibleAssignmentScores) * 100;
		
		return 0;
	}
	
	/**
     * A method that has a a specific grading amount for written quizzes and 
     * reads the list and does the math to calculates the grade percentage.
     * 
     * @return 0 to not throw an error
     */
	public static double tallyUpWrittenQuiz() {
		// possible scores for          quiz#3  final   
		double possibleWrittenQuizScores = 100 + 100; 
		
		// total user score
		double userWrittenQuizScore = 0;
		
		// reads the array list
		for (int i = 0; i < writtenQuizArr.size(); i++) {
			// getting a item in the array list
			Double temp = writtenQuizArr.get(i);
			
			// adding the item to the total use score
			userWrittenQuizScore = userWrittenQuizScore + temp;
		}
		
		// set the variable to the total
		writtenQuizPercent = userWrittenQuizScore;
			
		return 0;
	}
	
	/**
     * A method that calculates the math for the percentage of the given scores
     * and also prompt it to the console.
     * 
     * @return 0 to not throw an error
     */
	public static double scorePercentage() {
		
		// 38% from assignments, 20% from homework, and 35% from quizzes
		
		double finalLabGrade = labPercent * 0.20;
		// math for percentage
		double finalQuizGrade = (((labQuizPercent + writtenQuizPercent) / 470) * 100) * 0.35;
		double finalAssignmentGrade = assignmentPercent * 0.38;
		
		// final grade prompt
		System.out.println("final grade for labs is: " + finalLabGrade);
		System.out.println("final grade for quizzes is: " + finalQuizGrade);
		System.out.println("final grade for assignments is: " + finalAssignmentGrade);
		
		// final grade
		double finalGrade = (finalLabGrade + finalQuizGrade + finalAssignmentGrade);
		
		System.out.println("final grade is around: " + finalGrade);
		return 0;
	}
	
	/**
     * A method that calls on other methods base on user result.
     * This is to see if there are changes in the data. 
     * 
     * TODO / NOTE the N for the changes requires a additional space after the initial input.
     * 
     * @return "" to not throw an error
     */
	public static String scoreChange() {
		System.out.println("Do you want to make changes? (y/n)" );
		Scanner userInput = new Scanner(System.in);
		if (userInput.hasNext() && userInput.next().equals("y")) {
			System.out.println("Do you Like you change? 1. Lab scores  2. Assigments 3. Lab quiz scores 4. Written quiz score" );
			Scanner userInput2 = new Scanner(System.in);
			if (userInput2.next().equals("1")) { 
				labScores();
			} else if (userInput2.next().equals("2")) {  
				assignmentScores();
			} else if (userInput2.next().equals("3")) { 
				quizScores();
			} else if (userInput2.next().equals("3")) {  
				writtenQuizScores();
			} else {
				System.out.println("invalid input");	 
			}
			scorePercentage();
			scoreChange();
			
		} else if ( userInput.next().equals("n")) {
			return "";
		} else {
			System.out.println("I'm sorry I didn't quite get that: ");
			scoreChange();
		}
		
		return "";
	}

}
