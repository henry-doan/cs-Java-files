package m1;

public class Brand {
	// what all brand should have
	private String[] branchQueue;
	private int size;
	
	/*
	 * Construct an empty brand array
	 */
	public Brand() {
		size = 0;
		branchQueue = new String[size];
	}
	
	/*
	 * Is the brand array empty?
	 * @return true -- boolean on the size is empty.
	 * 		   false --- boolean on the array isn't empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Return the number of items on the array
	 * @return size -- the number capacity of the array.
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Resize the underlying array holding the elements 
	 * Method from https://www.youtube.com/watch?v=GNr872PjQMI
	 * he said we can use.
	 * 
	 * @author Robert Sedgewick & Kevin Wayne
	 * @param capacity -- int that is the capacity of the queue.
	 */
	private void resize(int capacity) {
		assert capacity >= size;
		
		// create new array
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];
		
		// copy items over
		for (int i = 0; i < size; i++) {
			temp[i] = itemQueue[i];
		}
		
		// reassign the queue
		itemQueue = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
