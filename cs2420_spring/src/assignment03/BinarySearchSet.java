package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Class representation of a generic Binary search set and implements sorted set class.
 * 
 * @author  Henry Doan
 * @version January 29, 2018
 * 
 * @param <E>
 *            -- the type of elements maintained by this set
 */
public class BinarySearchSet<E> implements SortedSet<E> {
	
	// variables all binary search set has
	E[] arrayAnyType;
	private int arrayElementSize;
	
	// exist if passed a comparator
	Comparator<? super E> incomingComparator;
	
	/**
	 * Create a binary search set with default values of the set
	 */
	public BinarySearchSet() {
		arrayAnyType = (E[]) new Object[20];
		arrayElementSize = 0;
	}
	
	/**
	 * If passed a comparator, then set that comparator to a variable.
	 * 
	 * @param comparator
	 * 	 				-- incoming comparator to be used
	 */
	public BinarySearchSet(Comparator<? super E> comparator) {
		this();
		incomingComparator = comparator;
	}
	
	/**
	 * @return The comparator used to order the elements in this set, or null if
	 *         this set uses the natural ordering of its elements (i.e., uses
	 *         Comparable).
	 */
	@Override
	public Comparator<? super E> getComparator() {
		if(incomingComparator == null) { 
			return null;
		}
		return incomingComparator;
	}

	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E first() throws NoSuchElementException {
		// see if the array and last element is existence
		if(isEmpty() || arrayAnyType[0] == null) { 
			throw new NoSuchElementException();
		}
		
		// return the first element
		return arrayAnyType[0];
	}
	
	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E last() throws NoSuchElementException {
		// see if the array or last element is existence
		if(isEmpty() || arrayAnyType[arrayElementSize - 1] == null) { 
			throw new NoSuchElementException();
		}
		
		// return the last element
		return arrayAnyType[arrayElementSize - 1];
	}

	/**
	 * Adds the specified element to this set if it is not already present and
	 * not set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	@Override
	public boolean add(E element) {
		// see if the array needs to grow
		if (arrayElementSize == arrayAnyType.length) {
			arrayAnyType = growArray(arrayAnyType);
		}

		// if the element is null or the set already has it
		if (this.contains(element) || element == null) {
			return false;
		}
		
		int index = binarySearch(arrayAnyType, element);
		
		// Look for a space to put the element and then add it in
		if (arrayAnyType[index] == null) {
			this.arrayElementSize++;
			arrayAnyType[index] = element;
			return true;
		} else {
			for (int i = arrayElementSize; i >= index; i--) {
				if (i != 0) {
					arrayAnyType[i] = arrayAnyType[i - 1];
				}
			}
			this.arrayElementSize++;
			arrayAnyType[index] = element;
			return true;
		}
	}
	
	/**
	 * Takes an array and split the array in the middle and check both
	 * right and left sides to be compared to the element that needs to 
	 * be checked for and changed the middle again and check both left and
	 * right side of the array. Then eventually find the elements.
	 * 
	 * @param arr
	 *            -- incoming array to be search
	 *        element
	 *        	  -- element that needs to be searched for.
	 * @return left the element we are searching for.
	 */
	private int binarySearch(E[] arr, E element) {
		
		// variables for binary Search
		int left = 0;
		int right = size();
		int middle;
		
		// case if it is a empty set.
		if(size() == 0) {
			return 0;
		}
		
		// binary search search left and right side of middle
		while(left < right) {
			
			// calculate the middle
			middle = (left + right) / 2;
			
			// check the left and right side
			if(comparison(arr[middle], element) < 0) {
				left = middle + 1;
			} else if (comparison(arr[left], element) > 0) {
				right = middle - 1;
			} else {
				right = middle;
			}
		}
		
		return left;
	}
	
	/**
	 * Using the incoming comparator to compare two elements or 
	 * use the Java comparable to compare the elements.
	 * 
	 * @param leftElement, rightElement
	 *            -- generic elements that need to be compared.
	 * @return comparison on left and right element.
	 */
	private int comparison(E leftElement, E rightElement) {
		if(incomingComparator != null) {
			return incomingComparator.compare(leftElement, rightElement);
		}
		
		return ((Comparable<E>)leftElement).compareTo(rightElement);
	}

	/**
	 * Grow the array and copy all elements over.
	 * 
	 * @param arrayThatNeedsToGrow
	 *            -- generic array that needs to grow
	 * @return arrayThatNeedsToGrow the new array that is grown
	 */
	private E[] growArray(E[] arrayThatNeedsToGrow) {
		// grow the array by two.
		E[] tmpArr = (E[]) new Object[arrayThatNeedsToGrow.length * 2];
		
		// copy all the elements to the new array
		for(int elementIndex = 0; elementIndex < arrayThatNeedsToGrow.length; elementIndex++) {
			tmpArr[elementIndex] = arrayThatNeedsToGrow[elementIndex];
		}
		
		return arrayThatNeedsToGrow = tmpArr;
	}

	/**
	 * Adds all of the elements in the specified collection to this set if they
	 * are not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean addAll(Collection<? extends E> elements) {
		// if the element has been changed
		boolean changed = false;
		
		// for each item in the elements set , see if it is changed and then add it.
		for(E item : elements) {
			if(changed == true) {
				this.add(item);
			} else {
				changed = this.add(item);
			}
	    }
		
		if(changed) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Removes all of the elements from this set. The set will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() {
		
		// Iterate through the array and set the elements to null.
		for(int arrIndex = 0; arrIndex < arrayElementSize; arrIndex++) {
			arrayAnyType[arrIndex] = null;
		}
		
		// set the size to 0 as well.
		arrayElementSize = 0;
	}
	
	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	@Override
	public boolean contains(Object element) {
		try {
			// case for empty set;
			if(size() == 0) {
				return false;
			}
			
			// binary search to get a index
			int index = binarySearch(arrayAnyType, (E) element);
			
			// see if the array contain the element
			if(arrayAnyType[index] == null) {
				return false;
			} else if (comparison(arrayAnyType[index], (E) element) == 0) {
				return true;
			}
			
			return false;
		}	catch(ClassCastException e) {
			// if no the right type
			return false;
		}
	}
	
	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	@Override
	public boolean containsAll(Collection<?> elements) {
		boolean containsAllElement = false;
		
		// see if the set contains the items
		for(Object item : elements) {
			if(this.contains(item)) {
				containsAllElement = true; 
			} else {
				containsAllElement = false;
			}
		}
		
		return containsAllElement;
	}
	
	/**
	 * @return true if this set contains no elements
	 */
	@Override
	public boolean isEmpty() {
		// base case
		if(arrayElementSize == 0) {
			return true;
		} else {
			// there is something in the array
			return false;
		}
	}

	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	@Override
	public boolean remove(Object element) {
		// if the array is empty
		if(isEmpty()) {
			return false;
		}
		
		// see if the set has the element
		if(this.contains(element)) {
			// look for the element
			int index = binarySearch(arrayAnyType, (E)element);
			
			for(int i = index; i < size(); i++) {
				
				// keep on iterating
				if(i != size() - 1) {
					arrayAnyType[i] = arrayAnyType[i + 1];
				}
				
				// delete the element
				arrayAnyType[i] = null;
			}
			
			// down size
			this.arrayElementSize--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean removeAll(Collection<?> elements) {
		boolean changed = false;
		
		// iterate through the list and take out all the elements
		for(Object item : elements) {
			if(changed == true) {
				this.remove(item);
			} else {
				changed = this.remove(item);
			}
		}
		
		if(changed) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return the number of elements in this set
	 */
	@Override
	public int size() {
		return this.arrayElementSize;
	}
	
	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	@Override
	public Object[] toArray() {
		// make a new array
		Object[] resultArr = null;
		
		// return an empty one
		if(arrayElementSize == 0) {
			return resultArr;
		} else {
			// make a new array with the proper size
			resultArr = new Object[arrayElementSize];
		}
		
		// copy items over
		for(int arrIndex = 0; arrIndex < arrayElementSize; arrIndex++) {
			if(arrayAnyType[arrIndex] == null) {
				break;
			} else {
				resultArr[arrIndex] = arrayAnyType[arrIndex];
			}
		}
		
		// return the resulting array
		return resultArr;
	}

}
