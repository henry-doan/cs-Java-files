package assignment08;

public class DEPQueue {
	String[] heapArr;
	private int size;
	private long swapCount;
	private long comparisonCount;
	
	DEPQueue() {
		this.size = 10;
		this.swapCount = 0;
		this.comparisonCount = 0;
		heapArr = new String[this.size];
	}
	
	public  void  insert (String data){
		if (isEmpty()) {
			heapArr[0] = data;
		}
		if (isFull()) {
			heapArr = new String[this.size * 2];
		}
        this.size++;
        heapArr[this.size] = data;
        this.size = heapArr.length;
        if (size > 1) {
        	uppwardHeapify();
        }
	}
	
	public void buildMinHeap() {
        for (int n = 1; n < heapArr.length; n++) {
            int current = n;
            int parent = (current-1)/2;
            
            while (current != parent && heapArr[parent].compareTo(heapArr[current]) > 0) {
            	this.comparisonCount++;
                String temp = heapArr[parent];
                heapArr[parent] = heapArr[current];
                heapArr[current] = temp;
                
                current = parent;
                parent = (current-1)/2;
            }            
        }
	}
	
	private  class DEPQueIndex {
		String data;
		int minHeapIndex;
		int maxHeapIndex;
		
		DEPQueIndex( String data, String[] minHeap, String[] maxHeap) {
			int minHeapIndex = getHeapIndex(data, minHeap);
			int maxHeapIndex = getHeapIndex(data, maxHeap);
		}

		private int getHeapIndex(String value, String[] array) {
			int count = 0;
			for(int i = 0; i < array.length; i++) {
				count++;
			    if(array[i].equals(value)) {
			        break;
			    }
			}
			return count;
		}

	}
	
	public  String  removeMin () { 
		String removedElement = "";
        for (int n = heapArr.length - 1; n > 0; n--) {
            int swapPos = 0;
            int fixPos = n;
            
            while (fixPos != swapPos) {                
                String temp = heapArr[swapPos];
                heapArr[swapPos] = heapArr[fixPos];
                heapArr[fixPos] = temp;
                removedElement = heapArr[fixPos];
                this.swapCount++;
                downwardHeapify();               
            }
        }
        return removedElement;
	}
	
	public  String  removeMax (String removeThis) {
		String removedElement = removeThis;
		for (int n = heapArr.length - 1; n > 0; n--) {
	           int swapPos = 0;
	           int fixPos = n;
               this.swapCount++;
               
	           while (fixPos != swapPos) {                
	               String temp = heapArr[swapPos];
	               heapArr[swapPos] = heapArr[fixPos];
	               heapArr[fixPos] = temp;
	               removedElement = heapArr[fixPos];
	               this.swapCount++;
	               
	               uppwardHeapify();
	           }
	    }
		return removedElement;
	} 
	
	
	private void uppwardHeapify() {
        String temp;
        int nextString = size();
        while (nextString != 1 && heapArr[nextString].compareTo(heapArr[nextString / 2 ]) > 0) {
        	this.comparisonCount++;
            temp = heapArr[nextString];
            heapArr[nextString] = heapArr[ nextString / 2 ];
            heapArr[nextString / 2 ] = temp;
            nextString = nextString / 2;
            this.swapCount++;
        }
    }

	private void downwardHeapify() {
        String temp;
        int nextString = 0;
        while (nextString * 2 <= size ()) {
            int child = 2 * nextString; 
            if (child < size() && heapArr[child].compareTo(heapArr[child + 1]) > 0) {
            	this.comparisonCount++;
            	child++;
            }
            if (heapArr[nextString].compareTo(heapArr[child]) > 0) {
            	this.comparisonCount++;
            	temp = heapArr[nextString];
            	heapArr[nextString] = heapArr[child];
            	heapArr[child] = temp;
            	this.swapCount++;
                nextString = size();
            } 
            else;
            nextString = this.size; 
        }
    }
	
    private boolean isFull() { 
        return (this.size == heapArr.length-1);
    }
	
	private boolean isEmpty() {
        return (this.size == 0);
	}
	
	public int  size () {
		return this.size;
	}
	
	public long getComparisonCount ( ) {
		return this.comparisonCount;
	}
	
	public  long  getSwapCount ( ) {
		return this.swapCount;
		
	}
}
