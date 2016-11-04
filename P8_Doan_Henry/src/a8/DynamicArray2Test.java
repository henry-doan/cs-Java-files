package a8;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArray2Test {

	@Test
	public void dynamicArray2Test() {
		DynamicArray2();
		equal(new String[8]);
		equal(0);
		
	}
	public void sizeTest() {
		count = 3;
		
		size();
		equal(3);
		
		count = -3;
		
		size();
		equal(Throw exception);
		
		count = 11;
		
		size();
		equal(16);
	}
	public void addTest() {
		test = ""
		add(test);
		equal(data);
		
		test2 = "something"
		add(test2);
		equal([soemthing]);
		
		a = "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8";
		test3 = "something else"
		add(test3);
		equal([ a + "something else"]);
		
	}
	public void add2Test() {
		test = ""
		add(3, test);
		equal(data);
				
		test2 = "something"
		add(3 , test2);
		equal([soemthing]);
				
		a = "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8";
		test3 = "something else"
		add(3, test3);
		equal([ a + "something else"]);
	}
	public void removeTest() {
		String [] x = new string[8];
		a = "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8";
		x << a;
		
		test = 1
		remove(test);
		equal("1" + "3" + "4" + "5" + "6" + "7" + "8");
				
		test2 = -1
		remove(test2);
		equal("1" + "2" + "3" + "4" + "5" + "6" + "7");
				
				
		test3 = 0
		remove(test3);
		equal( "2" + "3" + "4" + "5" + "6" + "7" + "8";);
	}
	
}
