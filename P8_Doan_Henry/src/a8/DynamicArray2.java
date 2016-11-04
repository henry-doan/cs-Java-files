package a8;

//A more efficient version of the DynamicArray class created in lecture.
//
//Represents the dynamic array [data[0], data[1], ..., data[count-1]]
//In other words, the first count elements of data are elements of the 
//dynamic array. The remainder of data is room to grow.  When data fills 
//up, we allocate a new array that is twice as long. 
//0 <= count <= data.length is always true.
public class DynamicArray2 {

	private String[] data;   // the backing array
	private int count;       // the number of elements in the dynamic array
	
	/**
	 * Creates an empty dynamic array with room to grow.
	 * (DO NOT modify this method.)
	 */
	public DynamicArray2() {
		data = new String[8];
		count = 0;
	}
	
	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Calls the add method with the count and s as a parameter
	 * 
	 * @params String S  a string to add in to the array
	 */
	public void add(String s) {
		add(count, s);
	}
	
	/**
	 * If the parameter of I is greater than count and is negative, than throw an
	 * exception. If the count is greater than or equal to the string array length or
	 * if the array is at its maximum cap for receiving s into adding it to the array
	 * than make a new array that is 2 times it original size and push everything
	 * from the old array to the new then add in s and have the count increment and
	 * shift the position of the array over to the left one of the index. Then reassigns
	 * the old array to the new array. Else add s to the array.
	 * 
	 * @params int i the index
	 * @params String s the item we want to add
	 * 
	 */
	public void add(int i, String s) {	
		if ( i <  0 || i > count) {
			throw new IndexOutOfBoundsException();
		}
	
		if (count >= data.length) {
			String[] newArray = new String[data.length * 2];
			for (int x = 0; x < i; x++) {
				newArray[x] = data[x];
			}
			
			newArray[i] = s;
			count++;
			for(int j = data.length - 1; j < newArray.length; j++) {
				newArray[j] = newArray[j - 1];
			}
			data = newArray;
		} else {
			for (int x = count; x > i; x--) {
				data[i] = data[x - 1];
			}
			data[i] = s;
			count++;
		}
	
	
	}
	
	/**
	 * Throws an IndexOutOfBoundsException if i is not a valid index. removes the 
	 * element at the index.
	 * @param int i   index.
	 */
	public void remove(int i) {	
		if ( i <  0 || i >= data.length) {
			throw new IndexOutOfBoundsException();
		}
		
		for (int j = i; j < count; j++) {
			data[j] = data[j + 1];
		}
		
		count--;

	}
	
	/**
	 * Throws an IndexOutOfBoundsException if i is not a valid index. returns the data
	 * at the index.
	 * 
	 * @param int i   index.
	 * @return  whatever is the value for the index in the data array.
	 */
	public String get(int i) {
		if(i < 0 || i >= data.length) {
			throw new IndexOutOfBoundsException();
		}
		return data[i];
	}
	
	/**
	 * Throws an IndexOutOfBoundsException if i is not a valid index. have the index take 
	 * the value of s.
	 * 
	 * @param int i   index number.
	 * @return String s what we want to add
	 */
	public void set(int i, String s) {
		if(i < 0 || i >= data.length)
			throw new IndexOutOfBoundsException();
		data[i] = s;
	}
	
	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if(size() > 0) 
			result += get(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + get(i);
		
		return result + "]";
	}
}
