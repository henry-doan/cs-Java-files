package recursionexamples;

import java.math.BigInteger;

public class FactorialCalculatorBigNum {
	
	public static BigInteger factorial(BigInteger num) {
		if (num.compareTo(BigInteger.ONE) <= 0) { //test base
			return BigInteger.ONE; // base case
		} else { // recursion step
			return num.multiply(
						factorial(num.subtract(BigInteger.ONE))
					);
		}
	}

	public static void main(String[] args) {
		for (int counter = 0; counter <= 50; counter ++) {
			System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
		}

	}

}
