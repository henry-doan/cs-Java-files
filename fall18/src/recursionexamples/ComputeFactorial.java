package recursionexamples;

import java.util.Scanner;

public class ComputeFactorial {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		int n = input.nextInt();
		
		System.out.println("Factorial of " + n + " is " + factorial(n));
				
	}

	private static long factorial(int n) {
		if (n == 0) //base case
			return 1;
		else
			return n * factorial(n - 1); //recursive call
	}

}
