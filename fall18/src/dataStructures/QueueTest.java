package dataStructures;

import java.util.NoSuchElementException;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		
		queue.enqueue(-1);
		queue.print();
		queue.enqueue(0);
		queue.print();
		queue.enqueue(1);
		queue.print();
		queue.enqueue(5);
		queue.print();
		
		boolean continueLoop = true;
		
		while (continueLoop) {
			try {
				int removedItem = queue.dequeue();
				System.out.printf("%n%d dequeue %n", removedItem);
				queue.print();
			} catch (NoSuchElementException err) {
				continueLoop = false;
				err.printStackTrace();
			}
		}

	}

}
