package OverloadedMethods;

public class OverloadedMethods {
	
	public static void main( String[] args) {
		// Creates an array of integer, Double, and character.
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6};
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
		Character[] characterArray = { 'H', 'E', 'L', 'L','O'};
		
		System.out.println("Array integerArray contains:");
		printArray( integerArray );
		System.out.println("\nArray doubleArray contains:");
		printArray( doubleArray );
		System.out.println("\nArray characterArray contains:");
		printArray( characterArray );
	}

	// Prints the integer array
	public static void printArray(Integer[] inputArray) {
		//display array elements
		for (Integer element : inputArray)
			System.out.printf( "%s", element);
		
		System.out.println();
	}
	
	// Prints the Double array
	public static void printArray(Double[] inputArray) {
		//display array elements
		for (Double element : inputArray)
			System.out.printf( "%s", element);
		
		System.out.println();
	}
	
	// Prints the character array
	public static void printArray(Character[] inputArray) {
		//display array elements
		for (Character element : inputArray)
			System.out.printf( "%s", element);
		
		System.out.println();
	}
		
}
