package lab06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class IteratorPractice {
	public static void main(String[] args){
		
		List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
//		
//		for(int i = 0; i <list.size(); i++ ){
//			list.remove(i);
//		}
//		
//		System.out.println(list);
		
		for(int number : list) {
			list.remove(0);
		}
		
		System.out.println(list);

		
		
		
		
		
		
		
		
		
		
		
//		
//		SortedSet<Integer> ss = new TreeSet<>();
//		
//		//How we like to see this
//		for(int element : ss) {
//			System.out.println(element);
//		}
//		
//		//But this is what it is really doing
//		Iterator<Integer> iter = ss.iterator();
//		while(iter.hasNext()) {
//			int element = iter.next();
//			System.out.println(element);
//		}
//		
//		//Same thing, different loop
//		for(Iterator<Integer> it = ss.iterator(); it.hasNext();) {
//			int element = it.next();
//			System.out.println(element);
//		}
//		
//		// this works for ANY collection:
//		Collection<Integer> collection = new ArrayList<>();
//		collection = new LinkedList<Integer>();
//		collection = new HashSet<>();
//		collection = new Vector<>();
//		collection = new PriorityQueue<>();
//		
//		Queue<Integer> q = new LinkedList<>();
//		q = new PriorityQueue<>();
//		
//		Stack<Integer> stack = new Stack<>();
//		
//		Iterator<Integer> iterator = null;
//		iterator = collection.iterator();
//		iterator = q.iterator();
//		iterator = stack.iterator();
//		iterator.hasNext();
//		
//		for(int whatever : collection) {
//			System.out.println(whatever);
//		}
//		
//		for(int something : q) {
//			System.out.println(something);
//		}
//		
//		for(int nothing : stack) {
//			System.out.println(nothing);
//		}
		
		// Does that help?
}

}
