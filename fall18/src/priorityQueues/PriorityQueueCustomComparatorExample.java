package priorityQueues;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueCustomComparatorExample {

	public static void main(String[] args) {
		Comparator<String> stringLengthComparator = new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}

		};
		
		/*
		 * The above Comparator can also be created using lambda expression like this => 
		 * 
		 * Comparator<String> stringLengthComparator = (s1,s2) {
		 *      return s1.length() - s2.length();
		 *  };
		 *  
		 *  Which can be shortened even further like this 
		 *  
		 *  Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);
		 *  */
		
		PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);
	
		namePriorityQueue.add("Lisa");
		namePriorityQueue.add("Robert");
		namePriorityQueue.add("John");
		namePriorityQueue.add("Chris");
		namePriorityQueue.add("Angelina");
		namePriorityQueue.add("Joe");
		
		while(!namePriorityQueue.isEmpty()) { 
			System.out.println(namePriorityQueue.remove());
		}
	}

}
