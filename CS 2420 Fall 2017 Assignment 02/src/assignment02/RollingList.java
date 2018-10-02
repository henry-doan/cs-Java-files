package assignment02;


import java.util.NoSuchElementException;

/**
 * <p>
 * A rolling list is just a list ADT backed by an array with performance roughly
 * equivalent or superior to a linked list for most operations.  This list
 * implementation can only hold double values.
 * </p>
 * 
 * <p>
 * This list ADT has a restricted set of operations: You can view and modify any
 * element of the list, but you can only add or remove elements from the front
 * or back end of the list.
 * </p>
 * 
 * <p>
 * The size and growth rate of the backing array is determined when each rolling
 * list is constructed. The initial size of the backing array is always 5. When
 * an element is added to the list, but the backing array is full, a new, larger
 * backing array is created and the elements are copied from the old array to
 * the new array. The size of the new backing array is determined as follows:
 * </p>
 * 
 * <p>
 * <i>newSize = ceiling(oldSize * relativeGrowthRate + absoluteGrowthRate)</i>
 * </p>
 * 
 * <p>
 * This class also keeps track of how many times modifications are made to the
 * backing array, and it provides static methods for getting and resetting this
 * count. (By keeping track of the number of times something was written into an
 * array, students can estimate the complexity of their solution.) As an absolute
 * rule, no unnecessary modifications should be made to the backing array.
 * </p>
 * 
 * <p>
 * For assignment 02, this class has additional specific implementation
 * requirements. Please review assignment 02 for details.
 * </p>
 * 
 * @author Henry Doan
 * @version 8-9-17
 */
public class RollingList
{
    // Constants
	Double[] backingArray;
	int front;
    int rear;
	float multiRate;
	int constantRate;
	int arrayModificationCount;
    // Fields

    // Constructor

    /**
     * <p>
     * Creates a new rolling array with no elements, a backing array of size 5,
     * and the specified growth rate. The growth rate parameters must ensure
     * that the backing array always grows when needed.
     * </p>
     * 
     * @param relativeGrowthRate
     *            the growth rate multiplier
     * @param absoluteGrowthRate
     *            the growth rate constant
     * @throws IllegalArgumentException
     *             iff the growth rate does not ensure growth of the backing
     *             array
     */
    public RollingList (float relativeGrowthRate, int absoluteGrowthRate)
    {
    	backingArray = new Double[5];
    	this.multiRate = relativeGrowthRate;
        this.constantRate = absoluteGrowthRate;
        this.front = 0;
        this.rear = -1;

    }

    // Private utility methods

    /**
     * <p>
     * This method ensures that the backing array has enough space to store some
     * number of elements (a desired capacity). Iff the backing array is too
     * small, this method creates a larger backing array and copies the list
     * elements into it. The larger backing array reference is then copied into the
     * backing array reference, and the capacity and first element locations are updated
     * to be correct.
     * </p>
     * 
     * <p>
     * (Note: Since list elements will be copied into a larger array, the array
     * modification count will be significantly increased.)
     * </p>
     * 
     * @param desiredCapacity
     *            the needed capacity of the backing array
     */
    private void ensureCapacity (int desiredCapacity)
    {
    	if (desiredCapacity != backingArray.length) {
    		Double[] newArray = new Double[(backingArray.length * 2)];
    		for(int i = 0; i < backingArray.length; i++) {
    			newArray[i] = backingArray[i];
    		}
    		
    		backingArray = newArray;
    	} 
    
    }

    // Supported list ADT operations.

    /**
     * <p>
     * Retrieves a value from the list.
     * </p>
     * 
     * @param i
     *            the element to retrieve
     * @return 
     *            the value of the specified element
     */
    public double getElement (int i)
    {
    	if (i >= backingArray.length){ 
    		throw new IndexOutOfBoundsException();
    	}
    	return backingArray[i];

    }

    /**
     * <p>
     * Changes an element's value in this list. Note: This will increase the
     * array modification count.
     * </p>
     * 
     * @param i
     *            the element to change
     * @param value
     *            the new value (any double) for this element
     */
    public void setElement (int i, double value)
    {
    	if (i >= backingArray.length){ 
    		throw new IndexOutOfBoundsException();
    	}
    	backingArray[i] = value;
    	arrayModificationCount++;
    }

    /**
     * 
     * <p>
     * Adds (appends) a value to the end of the list (increasing the element
     * count). The last entry is the entry with an element index of (length of
     * list) - 1.
     * </p>
     * 
     * @param value
     *            any double
     */
    public void append (double value)
    {
    	rear++;
    	backingArray[rear] = value;
    	arrayModificationCount++;
        
    }

    /**
     * <p>
     * Adds (inserts) a value before the first element in the list (increasing
     * the element count). The value becomes the first entry. The first entry is
     * the entry with an element index of 0.
     * </p>
     * 
     * @param value
     *            any double
     */
    public void prepend (double value)
    {
    	front++;
    	backingArray[front] = value;
    	arrayModificationCount++;    
        
    }

    /**
     * <p>
     * Removes the last entry in the list (decreasing the element count). The
     * last entry is the entry with an element index of (length of list) - 1.
     * </p>
     * 
     * @throws NoSuchElementException
     *             if the list is empty prior to this call
     */
    public void removeLast ()
    {
        if (backingArray[rear] == null) {
        	 throw new NoSuchElementException();
        }
        
        backingArray[rear] = null;
        arrayModificationCount++;
    }

    /**
     * <p>
     * Removes the first entry in the list (decreasing the element count). The
     * first entry is the entry with an element index of 0.
     * </p>
     * 
     * @throws NoSuchElementException
     *             if the list is empty prior to this call
     */
    public void removeFirst ()
    {
    	if (backingArray[0] == null) {
       	 throw new NoSuchElementException();
       }

       backingArray[front-1] = null;
       arrayModificationCount++;
        
    }

    /**
     * <p>
     * Returns the number of elements in this rolling list.
     * </p>
     * 
     * @return 
     *         the number of elements in this list
     */
    public int size ()
    {
    	int counter = 0;
    	for (int i = 0; i < backingArray.length; i ++) {
    	    if (backingArray[i] != null){
    	        counter ++;
    	    }
    	}
        return counter;
    }

    // Public utility methods (instrumentation)

    /**
     * <p>
     * Clears (sets to 0) the array modification count.
     * </p>
     */
    public void resetArrayModificationCount ()
    {
    	arrayModificationCount = 0;
    }
    

    /**
     * <p>
     * Returns the array modification count.
     * </p>
     * 
     * @return 
     *         a count of the number of times the backing array has changed
     */
    public int getArrayModificationCount ()
    {
        return arrayModificationCount;
    }

    /**
     * <p>
     * Returns the percentage of the backing array that is unused. Return values
     * will be between [0.0 and 1.0].
     * </p>
     * 
     * @return 
     *         the percentage of the backing array that is wasted space
     */
    public double wastedSpace ()
    {
    	int numberOfNull = 0;
    	for (int i = 0; i < backingArray.length; i++) {
    		if (backingArray[i] == null) {
    			numberOfNull++;
    		}
    	}
    	return (numberOfNull / backingArray.length);
    }
}
