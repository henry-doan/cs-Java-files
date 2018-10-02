package recursionexamples;

import java.util.Scanner;

public class ComputeFibonacci {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a fibonacci number: ");
		int index = input.nextInt();
		
		System.out.println("The Fibonacci number at index " + index + " is " + fib(index));

	}

	public static long fib(long index) {
		if (index == 0) //base case
			return 0;
		else if (index == 1) //base case
			return 1;
		else //recursive call
			return fib(index - 1) + fib(index - 2); 
	}

}
