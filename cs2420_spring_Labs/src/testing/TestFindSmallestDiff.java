package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFindSmallestDiff {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
//	@Before
//	public void setup() {
//		System.out.println("This runs before every test case");
//	}
//	
//	@After
//	public void tearDown() {
//		System.out.println("This runs after every test case");
//	}
//	
//	@BeforeClass
//	public static void init() {
//		
//	}
//	
//	@AfterClass
//	public static void decon() {
//		
//	}
	// read the assignment and make test for them
	// catch end cases when finished, sizes of 1, many, single, null except
	// random data test and be weird with the test to break.
	
	@Test(expected=NullPointerException.class)
	public void checkNullArrayThrowsException() {
		DiffUtil.findSmallestDiff(null);
	}

	@Test
	public void checkBaseCaseEmptyArray() {
		int[] nullArray = new int[]{};
		int expected = -1;
		int returnValue = DiffUtil.findSmallestDiff(nullArray);
		Assert.assertEquals(expected, returnValue);
//		assertEquals(-1,DiffUtil.findSmallestDiff( new int[]{}));
	}
	
	@Test
	public void testArrayNullReturnsNegativeOne() {
		int[] nullArray = null;
		int expected = -1;
		int returnValue = DiffUtil.findSmallestDiff(nullArray);
		assertEquals(expected, returnValue);
	}

	@Test
	public void singleValueArray() {
		int[] nullArray = new int[1];
		int returnValue = DiffUtil.findSmallestDiff(nullArray);
		assertEquals(-1, returnValue);
	}
	
	@Test
	public void testSmallDiffInFirstTwo() {
		int[] arrayOfNums = new int[]{7, 10, 2, 45};
		int returnValue = DiffUtil.findSmallestDiff(arrayOfNums);
		assertEquals(3, returnValue);
	}
	
	@Test
	public void testSmallDiffInFirstTwoAscending() {
		int[] arrayOfNums = new int[]{43, 42};
		int returnValue = DiffUtil.findSmallestDiff(arrayOfNums);
		assertEquals(1, returnValue);
	}
	
	@Test
	public void testSmallDiffInFirstTwoDecsending() {
		int[] arrayOfNums = new int[]{42, 43};
		int returnValue = DiffUtil.findSmallestDiff(arrayOfNums);
		assertEquals(1, returnValue);
	}
	 
	 
}
