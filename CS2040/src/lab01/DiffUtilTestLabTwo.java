package lab01;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DiffUtilTestLabTwo {

	@Test
	public void testArrayNullReturnsNegativeOne() {
		int[] nullArray = null;
		int returnValue = DiffUtil.findSmallestDiff(nullArray);
		assertEquals(-1, returnValue);
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
}
