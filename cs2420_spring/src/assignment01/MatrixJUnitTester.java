/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
 */
package assignment01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Matrix class
 * 
 * @author Miriah Meyer & Henry Doan
 * @version January 11, 2018
 */
public class MatrixJUnitTester {

	Matrix 
		oneByOne, 
		threeByTwo, 
		twoByThree, 
		twoByThreeToo, 
		twoByTwoResult, 
		twoByTwo, 
		zeroTwoByTwo, 
		infinityTwoByTwo,
		negativeTwoByTwo;
	/*Initialize some matrices we can play with for every test!*/
	
	@Before
	public void setup() {
		threeByTwo = new Matrix(new int[][]
                {{1, 2, 3},
				 {2, 5, 6}});
		
		twoByThree = new Matrix(new int[][]
                {{4, 5},
				 {3, 2},
				 {1, 1}});
		
		twoByThreeToo = new Matrix(new int[][]
                {{3, 4},
				 {5, 6},
				 {8, 7}});
		
		oneByOne = new Matrix(new int[][]
				{{1}});
		
		twoByTwo = new Matrix(new int[][]
                {{1, 2},
				 {3, 4}});
		
		zeroTwoByTwo = new Matrix(new int[][]
                {{0, 0},
				 {0, 0}});
		
		infinityTwoByTwo = new Matrix(new int[][]
                {{Integer.MAX_VALUE, Integer.MAX_VALUE},
				 {Integer.MAX_VALUE, Integer.MAX_VALUE}});
		
		negativeTwoByTwo = new Matrix(new int[][]
                {{-1, -2},
				 {-3, -4}});
		// this is the known correct result of multiplying M1 by M2
		twoByTwoResult = new Matrix(new int[][]
                                    {{13, 12},
									 {29, 26}});
	}
	
	// Times Tests
	@Test
	public void timesWithBalancedDimensions() {
		Matrix matrixProduct = threeByTwo.times(twoByThree);
		Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
	}
	
	@Test
	public void timesWithUnbalancedDimensions(){
		Matrix matrixProduct = threeByTwo.times(oneByOne);
		Assert.assertEquals(matrixProduct, null);
	}
	
	@Test
	public void timesWithZero(){
		Matrix matrixProduct = twoByTwo.times(zeroTwoByTwo);
		Assert.assertEquals(matrixProduct, zeroTwoByTwo);
	}
	
	@Test 
	public void timesWithInfinity() {
		Matrix matrixProduct = twoByTwo.times(infinityTwoByTwo);
		Assert.assertEquals(matrixProduct, infinityTwoByTwo);
	}

	@Test 
	public void timesWithNegative() {
		Matrix matrixProduct = twoByTwo.times(negativeTwoByTwo);
		Matrix testingProduct = new Matrix(new int[][]
                {{-7, -10},
				 {-15, -22}});
		Assert.assertEquals(matrixProduct, testingProduct);
	}
	
	// plus tests
	@Test
	public void plusWithUnbalancedRow(){
		Matrix matrixSum = threeByTwo.plus(twoByTwo);
		Assert.assertEquals(matrixSum, null);
	}
	
	@Test
	public void plusWithUnbalancedColumn(){
		Matrix matrixSum = threeByTwo.plus(twoByThree);
		Assert.assertEquals(matrixSum, null);
	}
	
	@Test
	public void plusWithNegative() {
		Matrix matrixSum = twoByTwo.plus(negativeTwoByTwo);
		Matrix testingProduct = new Matrix(new int[][]
            {{0, 0},
			 {0, 0}});
		Assert.assertEquals(matrixSum, testingProduct);
	}
	
	@Test
	public void plusWithInfinity() {
		Matrix matrixSum = twoByTwo.plus(infinityTwoByTwo);
		Assert.assertEquals(matrixSum, infinityTwoByTwo);
	}
	
	@Test
	public void plusWithZero() {
		Matrix matrixSum = twoByTwo.plus(zeroTwoByTwo);
		Assert.assertEquals(matrixSum, twoByTwo);
	}
	
	// toString test
	@Test
	public void twoByTwoToString() {
		String resultString = "13 12" + "\n" + "29 26" + "\n";
		Assert.assertEquals(resultString, twoByTwoResult.toString());
	}
	
	// equals tests
	@Test
	public void twoEqualMatrixes () {
		Boolean results =  twoByThree.equals(twoByThreeToo);
		Assert.assertTrue(results);
	}
	
	@Test
	public void twoUnEqualMatrixes () {
		Boolean resultsUnequal =  twoByThree.equals(threeByTwo);
		Assert.assertFalse(resultsUnequal);
	}
	
	@Test
	public void UnEqualObjects () {
		String twoByThreeString = "{4, 5}, {3, 2},{1, 1}";
		Boolean resultsUnequal =  twoByThree.equals(twoByThreeString);
		Assert.assertFalse(resultsUnequal);
	}
}
