package assignment03;

public class MyLinkedList<E> implements UtahList<E>, Iterable<E> {
	Node Head, Tail, Curr;
	private int size = 0;
	int nodeModificationCount = 0;
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(){
			
			Node cursor = Head;
			boolean calledNext = false;
			
			@Override
			public boolean hasNext() {
				return cursor != null ;
			}
			
			@Override
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				calledNext = true;
				E current = cursor.data;
				cursor = cursor.next;
				return current;
			}
			
			@Override
			public void remove(){
				if(calledNext) {
				// points the references.
				cursor.unlink();
				} else {
					throw new IllegalStateException();
				}
				
				
			}
			
			
		};
	}
	
	@Override
	public E getElement(int index) {
		if (index >= size){ 
    		throw new IndexOutOfBoundsException();
    	}
		
		if( Head.data.equals(index) ) {
		    Head = Head.next;
		    return Head.data;
		}
		
		Node temp = Head;
		
		while(temp != null && !temp.data.equals(index)) {
			temp = temp.next;
		}
		
		Curr = temp;
		
		return Curr.data;
	}

	@Override
	public void setElement(int index, E data) {
		if (index >= size){ 
    		throw new IndexOutOfBoundsException();
    	}
		
		Node temp = Head;
		
		while(temp != null && !temp.data.equals(index)) {
			temp = temp.next;
		}
		
		if(temp != null) {
			temp.next = new Node(temp.prev, temp.next, data);
		}
		
	}

	@Override
	public void insert(int index, E data) {
		if (index >= size){ 
    		throw new IndexOutOfBoundsException();
    	}

		Node temp = Head;
		if(Head.data.equals(index)) {
			temp.next = new Node(temp.prev, temp.next, data);
		   return;
		}
		
	}

	@Override
	public E remove(int index) {
		if(Head == null) {
			throw new RuntimeException();
		}
		
		if( Head.data.equals(index) ){
			Head = Head.next;
			return (E) Head;
		}
		
		Node cur  = Head;
		Node prev = null;
		
		while(cur != null && !cur.data.equals(index) ) {
			prev = cur;
			cur = cur.next;
		}

		if(cur == null) {
			throw new RuntimeException();
		}

		prev.next = cur.next;
		
		return (E) cur.prev;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int getModificationCount() {
		return nodeModificationCount;
	}

	@Override
	public void resetModificationCount() {
		nodeModificationCount = 0;
	}

	public void traveringHead() {
		Node tmp = Head;

		while(tmp != null) tmp = tmp.next;
	}
	
	private class Node {
		Node prev, next;
		E data;
		
		public Node(Node incomingPrev, Node incomingNext, E incomingData){
			this.prev = incomingPrev;
			this.next = incomingNext;
			this.data = incomingData;
		}
		
		public void setPrev(Node node) {
            prev = node;
        }
		
		public void setNext(Node node) {
            next = node;
        }
		
		public void setInfo(Node incomingData) {
            this.data = (E) incomingData;
        }

		public Node getPrev() {
            return prev;
        }
		
		public Node getNext() {
            return next;
        }
		
        public E getInfo() {
            return data;
        }	
	}

}
