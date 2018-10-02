package OverloadedMethods;

public class CountOccurances {
	
	public static void main( String[] args) {
		Integer[] integerArr = { 1,2,3,4,5,3, 3};
		@SuppressWarnings("unused")
		Integer[] integerArrTwo = { 1,2,3,4, null, null};
		int findValue = 3;
		
		oursCountOccurrences(integerArr, findValue);
		
	}
	
	public static int oursCountOccurrences(Integer[] inputArray, int findValue) {
		int count = 0;
		
		for (int i = 0; i < inputArray.length; i++) {
			if( inputArray[i] == findValue ) 
				count ++;
			
		}
		
		return count;
	}
	
	
	// generic for list and array Collection <T> collection
	public static <T> int countOccurrences(T[] list, T itemToCount) {
		int count = 0;
		
		if(itemToCount == null) {
			for (T listItem : list)
				if (listItem == null)
					count ++;
		} else {
			for (T listItem : list)
				if(itemToCount.equals(listItem))
					count++;
		}
		
		return count;
	}
}
