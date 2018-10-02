package recursionexamples;

public class FactorialCalculator {
	public static long factorial(long number) {
		if (number <= 1) {
			return 1; // base case
		} else { // recursion step
			return number * factorial(number -1);
		}
	}
	
	public static void main(String[] args) {
		for (int counter = 0; counter <= 21; counter++) {
			System.out.printf("%d! = %d%n", counter, factorial(counter));
		}
	}
	

}
