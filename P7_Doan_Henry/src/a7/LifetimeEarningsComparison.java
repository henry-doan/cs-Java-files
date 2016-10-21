package a7;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * This class ask for the user's input and gets the inputs for manipulate and calculations to get the final 
 * results and then takes everything and puts it in a presentable format in the final result.
 * 
 * @author Henry Doan
 *
 */
public class LifetimeEarningsComparison {
	public static void main(String[] args) {
		// Set the decimal format of how many places of the decimals.
		DecimalFormat decimalRounded = new DecimalFormat("#0.00");
		
		// The Prompt for the information needed
		String firstSalary = JOptionPane.showInputDialog("Whats the starter salary for Job1?");
		String firstRaisedPercentage = JOptionPane.showInputDialog("What is the yearly precentage rise?");
		
		String secondSalary = JOptionPane.showInputDialog("Whats the starter salary for Job2?");
		String secondRaisedPercentage = JOptionPane.showInputDialog("What is the yearly precentage rise?");
		
		String yearsWorked = JOptionPane.showInputDialog("How many years do you want to compare?");
		
		// Parsing the input that the user types in as a double and a integer for the year.
		double _firstSalary = Double.parseDouble(firstSalary);
		double _secondSalary = Double.parseDouble(secondSalary);
		
		double _firstRaisedPercentage = Double.parseDouble(firstRaisedPercentage);
		double _secondRaisedPercentage = Double.parseDouble(secondRaisedPercentage);
		
		int _yearsWorked = Integer.parseInt(yearsWorked);
		
		// Runs  the calculations by calling methods and classes with the right params 
		LifetimeEarnings job1 = new LifetimeEarnings(_firstSalary, _firstRaisedPercentage );
		LifetimeEarnings job2 = new LifetimeEarnings(_secondSalary, _secondRaisedPercentage );
		
		double[] job1Arr = job1.computeLifetimeEarnings(_yearsWorked);
		double[] job2Arr = job2.computeLifetimeEarnings(_yearsWorked);
		
		// The system results for the first  and second job with the job1 title and each print out of the index array with
		// the percentage math added and the grand total for both the jobs.
		System.out.println("Job 1:");
		for (int i = 0; i < job1Arr.length; i++) {
			System.out.println(decimalRounded.format(job1Arr[i]));
		}
		System.out.println("Job1 total: $" + decimalRounded.format(sumWages(job1Arr)) + "\n");
		
		System.out.println("Job 2:");
		for (int i = 0; i < job2Arr.length; i++) {
			System.out.println(decimalRounded.format(job2Arr[i]));
		}
		System.out.println("Job2 total: $" + decimalRounded.format(sumWages(job2Arr)));
	}
	
	/*
	 * This method takes in the double array parameter of the values of the wages each year in the number of the years the
	 * user inputed and then sums them all up for a grand total in a double type value. The way this is done is 
	 * having the a double variable of sum and a for loop to iterate through the array of the double values
	 * and adds the index to the sum for the total. then return the total.
	 * 
	 * @params double[] arr,     a array with the double values of the wages for each year.
	 * @return sum,              the total sum of all the values of the index together.
	 */
	
	public static double sumWages(double[] arr) {
		double sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;	
	}
}
