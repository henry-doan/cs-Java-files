package dataStructures;

import java.util.NoSuchElementException;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		list.insetAtFront(-1);
		list.print();
		list.insetAtFront(0);
		list.print();
		list.insetAtBack(1);
		list.print();
		list.insetAtBack(5);
		list.print();
		
		try {
			int removedItem = list.removeFromFront();
			System.out.printf("%n%d removed%n", removedItem);
			list.print();
			
			removedItem = list.removeFromFront();
			System.out.printf("%n%d removed%n", removedItem);
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf("%n%d removed%n", removedItem);
			list.print();
			
			removedItem = list.removeFromBack();
			System.out.printf("%n%d removed%n", removedItem);
			list.print();
					
		} catch (NoSuchElementException err) {
			err.printStackTrace();
		}
	}
}
