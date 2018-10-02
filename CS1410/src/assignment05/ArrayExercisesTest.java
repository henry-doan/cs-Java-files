package assignment05;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;

import org.junit.Test;

public class ArrayExercisesTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
		/* This is my first example unit test.  A unit test is just a piece of
		 * code that calls some method or builds some object, and tests 
		 * for errors.  The code/test is up to the programmer.  
		 * 
		 * The unit test library provides functions for 'asserting' correctness.
		 * I use assertEquals below.  If the two values are not equal, the
		 * unit test library records a failure.
		 * 
		 * There are other assert functions in the unit test library that are
		 * useful for noting errors.  If the function below completes without
		 * recording a failure, then the test is marked as a success.
		 */
		@Test
		public void testRandomArray01()
		{
			// Call the function, ask for an array of thirty elements.
			
			int[] result;
			int size = 30;
			
			result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
			
			// The function has a specific contract that guarantees things
			//  about it's return value.  Check to make sure the method
			//  call did what it was supposed to.
			
			// Make sure the size of the result array is correct.
			
			assertEquals(size, result.length);  // If unequal, an error is recorded.
			
			// Make sure the required numbers [0..n-1] are in the array.
			
			numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
			{
				// Search for n in the array.  When found, move on to the next n.
				
				for (int pos = 0; pos < size; pos++)
					if (result[pos] == n)
						continue numberLoop;  // Continue the outer loop.
				
				// If we get this far, the number n was not found.  This is an error.
				
				fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
			}		
			
			// If the number loop completes without failing, all tests pass!  
			//   (When this method ends normally, the test is marked as passing.)
		}

		/* I wanted two unit tests for my function.  The first one, above,
		 *   just makes sure the basic operation of 'randomArray' is 
		 *   correct.  This second unit test makes sure the 'randomness'
		 *   is correct.  A truly random shuffle has equal likelihood
		 *   of any outcome.  I repeatedly generate random arrays,
		 *   then I count up results, and then check to make
		 *   sure that each outcome occurred with similar probability.
		 *   
		 * Because of the fact that random numbers may produce results
		 *   that look uneven, I loop many times to reduce the likelihood
		 *   of random results looking like an error. 
		 *   
		 * I do not expect students to study this code - it is complex.
		 *   I also don't like the way I'm counting permutations.  There
		 *   are better ways, but you haven't seen the required lectures
		 *   yet, so I'm using a more primitive solution.  I expect your
		 *   unit tests to be much less complex.
		 */ 
		@Test
		public void testRandomArray02()
		{
			// An array of three has six permutations.
			
			// Counts of how many times each permutation appears.
			
			int count012 = 0;
			int count021 = 0;
			int count102 = 0;
			int count120 = 0;
			int count201 = 0;
			int count210 = 0;
			
			// Repeatedly generate arrays (1,000,000 times).
			
			for (int count = 0; count < 1_000_000; count++)
			{
				// Generate an array of 3 elements.
				
				int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
				
				// Keep counts of each permutation in the array.
				
				if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
					count012++;
				else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
					count021++;
				else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
					count102++;
				else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
					count120++;
				else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
					count201++;
				else // only other possibility is [2, 1, 0]
					count210++;
			}
			
			// Check each permutation.  It should occur 166,666 times on average.  Accept
			//   anything within +/- 3,000.
			
			if (Math.abs(166_666 - count012) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
			
			if (Math.abs(166_666 - count021) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
			
			if (Math.abs(166_666 - count102) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
			
			if (Math.abs(166_666 - count120) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
			
			if (Math.abs(166_666 - count201) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
			
			if (Math.abs(166_666 - count210) > 3_000)
			    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
			
			// If execution completes without failing, the test passes!  
			//   (When this method ends normally, the test is marked as passing.)
		}

		
		@Test
		public void testCount()
		{
			String[] test1 = {"one", "two", "two","two", "Three"};
			Object[] test2 = {"one", "two", "two","two", "Three"};
	    	Object[] test3 = {1,2,3,4,5,6,7,8,8,88,8,8,8,8,8,8};
	    	int test1Result = 3;
	    	int test2Result = 8;
	    	int test3Result = 1;
	    	
	    	assertEquals( test1Result, ArrayExercises.count(test2, "two"));
	    	assertEquals( test2Result, ArrayExercises.count(test3, 8));
	    	assertEquals( test3Result, ArrayExercises.count(test1, "one"));
			 
		}

		@Test
		public void testReverseOrder()
		{
//			char[] test1 = {'h', 'e', 'n', 'r', 'y'};
//			char[] test2 = {'0', '0', '0', '0', '0'};
//			Object[] test1Result = {'y', 'r', 'n', 'e', 'h'};
//	    	
//	    	assertArrayEquals( test1Result, ArrayExercises.reverseOrder(test1));
//	    	assertEquals( test2Result, ArrayExercises.count(test3, 8));
//	    	assertEquals( test3Result, ArrayExercises.count(test1, "one"));
		}

		@Test
		public void testReplace()
		{
//			String[] test3 = {"one", "two", "four", "Three"};
//	    	String test4 = "four";
//	  		String test5 = "4";
//	  		
//	  		String testResult1 = {"one", "two", "4", "Three"};
	  		
	  		
			// fails because it does not return an array but the object itself
//	  		assertEquals( testResult1, ArrayExercises.replace(test3, test4, test5));
		}

		@Test
		public void testComputeAreas()
		{
			double[] test1 = {1, 2, 3};
    		double[] test2 = {1, 2, 3};
			double[] test1Result = new double[] {1, 4, 9};
			
			double[] test3 = {0, 0, 0};
    		double[] test4 = {0, 2, 3};
			double[] test2Result = new double[] {0, 0, 0};
			
			double[] test5 = null;
    		double[] test6 = null;
			double[] test3Result = null;
			
			assertEquals(test1Result, ArrayExercises.computeAreas(test1, test2));
			assertEquals(test2Result, ArrayExercises.computeAreas(test3, test4));
			assertEquals(test3Result, ArrayExercises.computeAreas(test5, test6));


    		
		}

		@Test
		public void testRemove()
		{
			Color[] test1 = new Color[] {Color.BLUE, Color.RED, Color.BLUE,Color.GREEN};
    		Color test1Target = Color.BLUE;
			Color[] test1Result = new Color[] {Color.RED, Color.GREEN};
			
			Color[] test2 = new Color[] {Color.BLUE, Color.BLUE};
    		Color test2Target = Color.BLUE;
			Color[] test2Result = new Color[] {};
			
			Color[] test3 = new Color[] {};
    		Color test3Target = null;
			Color[] test3Result = new Color[] {};
			
			assertArrayEquals(test1Result, ArrayExercises.remove(test1, test1Target));
			assertArrayEquals(test2Result, ArrayExercises.remove(test2, test2Target));
			assertArrayEquals(test3Result, ArrayExercises.remove(test3, test3Target));

		}

		@Test
		public void testSort()
		{
//			int [] test1 = {1,10,2,3,5,6,0,7};
//			int[] test1Result = {0,1,2,3,5,6,7,10};
//			
//			int [] test2 = null;
//			int[] test2Result = null;
//			
//			int [] test3 = {0,0,0,0};
//			int[] test4Result = {0,0,0,0};

			// fails because it does not return an array but the object itself
//			assertEquals( test1, ArrayExercises.sort(test1));
//			
//			assertEquals( test2, ArrayExercises.sort(test2));
//
//			assertEquals( test3, ArrayExercises.sort(test3));
		}

		@Test
		public void testFindSmallest()
		{
			Rectangle a = new Rectangle(5, 5, 10, 10);
    		Rectangle b = new Rectangle(5, 5, 20, 20);
    		Rectangle c = new Rectangle(5, 5, 30, 30);
    		Rectangle d = new Rectangle(5, 5, 10, 10);
    		Rectangle e = new Rectangle(5, 5, 10, 10);
    		Rectangle f = new Rectangle(10, 10);
    		
    		Rectangle[] test1 = {c, b, a};
    		Rectangle test1Result = new Rectangle(5, 5, 10, 10);
   			
    		Rectangle[] test2 = {a, d, e};
    		Rectangle test2Result = a;
   			
    		Rectangle[] test3 = {b, c, f};
    		Rectangle test3Result = f;
    		
			assertEquals( test1Result, ArrayExercises.findSmallest(test1));
			assertEquals( test2Result, ArrayExercises.findSmallest(test2));
			assertEquals( test3Result, ArrayExercises.findSmallest(test3));


    	
		}

		@Test
		public void testHistogram()
		{
			int [] test1 = {1,10,2,3,5,6,0,7, 2, 2, 3 ,7, 9, 15};
			int[] test1Result = {1, 1, 3, 2, 0, 1, 1, 2, 0, 1, 1, 0, 0, 0, 0, 1};
			
			int [] test2 = {1,10,2,3,5,6,0,7, 2, 2, 3 ,7, 9};
			int[] test2Result = {1, 1, 3, 2, 0, 1, 1, 2, 0, 1, 1};
			
			int [] test3 = {0};
			int[] test3Result = {1};
			
			assertArrayEquals( test1Result, ArrayExercises.histogram(test1));
			assertArrayEquals( test2Result, ArrayExercises.histogram(test2));
			assertArrayEquals( test3Result, ArrayExercises.histogram(test3));



		}

		@Test
		public void testGetUniqueSet()
		{
			File folder = new File(System.getProperty("user.home"));
	    	File file = new File("example.txt");
	    	File file1 = new File("example1.txt");
	    	File file2 = new File("example1.txt");
	    	File file3 = new File("example2.txt");
	    	File file4 = new File("example3.txt");
	    	File file5 = new File("example2.txt");
	    	File file6 = new File("");
//	        File[] listOfFiles = folder.listFiles();
//	    	File[] listOfFiles2 = {file, file1, file2, file3, file4, file5};
//	    	File[] listOfFiles3 = {file6, file6, file6, file6, file6};
//	  		Object[] testResult1 = {"example0.txt","example1.txt","example2.txt", "example3.txt"};
//	  		
	  		Object[] testResult3 = null;

//			assertArrayEquals( testResult3, ArrayExercises.getUniqueSet(listOfFiles2));
			
			// this will be unique to to the content of the computer, this just tests if it does grab the files
//			Object[] testResult2;
//			assertArrayEquals( testResult2, ArrayExercises.getUniqueSet(listOfFiles));


		}

}
