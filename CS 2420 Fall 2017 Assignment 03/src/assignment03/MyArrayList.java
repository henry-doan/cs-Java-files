package assignment03;

public class MyArrayList<E> implements UtahList<E> {
	
	Object[] arrayList = new Object[5];
	int front = 0;
    int rear = -1;
	float multiRate;
	int constantRate;
	int arrayModificationCount = 0;
	
	@Override
	public E getElement(int index) {
		if (index >= arrayList.length){ 
    		throw new IndexOutOfBoundsException();
    	}
		int arrayIndex = (int) (Math.ceil(index + front) % arrayList.length);
    	return (E) arrayList[arrayIndex];
	}

	@Override
	public void setElement(int index, E data) {
		if (index >= arrayList.length){ 
    		throw new IndexOutOfBoundsException();
    	}
		int arrayIndex = (int) (Math.ceil(index + front) % arrayList.length);
		arrayList[arrayIndex] = data;

    	arrayModificationCount++;
	}

	@Override
	public void insert(int index, E data) {
		if (index >= arrayList.length){ 
    		throw new IndexOutOfBoundsException();
    	}
		
		int arrayIndex = (int) (Math.ceil(index + front) % arrayList.length);
		
		Object[] temp = new Object[arrayList.length];
	    
		for(int i = 0; i < arrayIndex; i++) {
			temp[i] = arrayList[arrayIndex];

	    	arrayModificationCount++;
	    }
	    
		temp[arrayIndex] = data;
	    
		for(int i = arrayIndex + 1; i < arrayList.length; i++) {
			temp[i] = arrayList[arrayIndex - 1];

	    	arrayModificationCount++;
	    }
		
		arrayList = temp;
	}
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
    private void ensureCapacity (int desiredCapacity) {
    	if (desiredCapacity != arrayList.length) {
    		Object[] newArray = new Object[(arrayList.length * 2)];

        	arrayModificationCount++;
    		for(int i = 0; i < arrayList.length; i++) {
    			newArray[i] = arrayList[i];

    	    	arrayModificationCount++;
    		}
    		
    		arrayList = newArray;
    	} 
    
    }

	@Override
	public E remove(int index) {
		if (index >= arrayList.length){ 
    		throw new IndexOutOfBoundsException();
    	}
		
		int arrayIndex = (int) (Math.ceil(index + front) % arrayList.length);
		
		Object[] temp = new Object[arrayList.length];
		
		int internalCounter = 0;
		for(int i = 0; i < arrayList.length; i++){
		    if( i != arrayIndex ){
		        temp[internalCounter] = arrayList[i];
		        internalCounter++;

		    	arrayModificationCount++;
		    }

	    	arrayModificationCount++;
		}
		temp[temp.length] = null;
		arrayList = temp;
		
		return (E) arrayList;
	}

	@Override
	public int size() {
		return arrayList.length;
	}

	@Override
	public int getModificationCount() {
		return arrayModificationCount;
	}

	@Override
	public void resetModificationCount() {
		arrayModificationCount = 0;
	}

}
