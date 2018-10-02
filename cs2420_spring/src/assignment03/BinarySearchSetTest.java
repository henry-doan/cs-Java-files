package assignment03;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BinarySearchSetTest {
	
	@Test
	public void firstMethodTest() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(0);
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(3);
		
		assertEquals(true, testBSS.first().equals(0));
	}
	
	@Test
	public void lastMethodTest() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(0);
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(3);
		
		assertEquals(true, testBSS.last().equals(3));
	}
	
	@Test
	public void testAddingItems() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		assertEquals(true, testBSS.add(1));
	}
	
	@Test (expected=NullPointerException.class)
	public void addingNull()
	{
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(null);
		testBSS.add(3);
	}
	
	@Test
	public void containMethodTest(){
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(3);

		assertEquals(true, testBSS.contains(2));
	}
	
	@Test
	public void notContainMethodTest(){
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(3);

		assertEquals(false, testBSS.contains(123));
	}
	
	@Test
	public void emptySet() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();

		assertEquals(true, testBSS.isEmpty());
	}
	
	@Test
	public void unemptySet() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		
		testBSS.add(123456);
		assertEquals(false, testBSS.isEmpty());
	}
	
	@Test
	public void wasFullThenEmpty() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		
		testBSS.add(123);
		assertEquals(false, testBSS.isEmpty());
		testBSS.remove(123);
		assertEquals(true, testBSS.isEmpty());
	}
	
	@Test
	public void testRemoveSingleElement() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(123); 
		testBSS.remove(123);
		assertEquals(false, testBSS.contains(123));
	} 
	
	@Test
	public void toArrayMethodTest() {
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		
		testBSS.addAll(arrayList);
		
		Object[] objectArray = testBSS.toArray();
		for(int i = 0; i < objectArray.length - 1; i++) {
			assertEquals(i, objectArray[i]);
		}
	}
	
	@Test
	public void clearMethodTest(){
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		testBSS.add(1);
		testBSS.add(2);
		testBSS.add(3);
		
		testBSS.clear();
		assertEquals(true, testBSS.isEmpty());
	}
	
	// methods to help test time
	@Test
	public void containMethodTiming(){
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i = 0; i < 1000000; i++) {
			arrayList.add(i);
		}
		
		testBSS.addAll(arrayList);
		
		long startTime = System.nanoTime();
		for(int i = 0; i < testBSS.size(); i++) {
			testBSS.contains(i);
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		
//		System.out.println(duration);
	}
	
	@Test
	public void addMethodTiming(){
		BinarySearchSet<Integer> testBSS = new BinarySearchSet<Integer>();
		
		long startTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			testBSS.add(i);
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		
//		System.out.println(duration);
	}

}
