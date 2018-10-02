package recursionexamples;

import java.math.BigInteger;

public class FibonacciCalculator {
	private static BigInteger TWO = BigInteger.valueOf(2);

	public static BigInteger fib(BigInteger num) {
		if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)) {
			return num;
		} else {
			return fib(num.subtract(BigInteger.ONE)).add(fib(num.subtract(TWO)));
		}
		
	}
	public static void main(String[] args) {
		for ( int i = 0; i <= 40 ; i++) {
			System.out.printf("Fibonacci of %d is: %d%n", i, fib(BigInteger.valueOf(i)));
		}

	}

}
