package dataStructures;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**  A linked list is a sequence of nodes with efficient
 *   element insertion and removal. This class 
 *     contains a subset of the methods of the standard
 *       java.util.LinkedList class.
 */
public class LinkedList {
	private class Node {
		public Object data;
		public Node next;
	}
	
	/**
	 *   A list iterator allows access of a position in a linked list.
	 *   This interface contains a subset of the methods of the 
	 *   standard java.util.ListIterator interface. The methods for
	 *   backward traversal are not included.
	 */
	@SuppressWarnings("rawtypes")
	public ListIterator listIterator() {
		return new LinkedListIterator();
	}
	
	@SuppressWarnings("rawtypes")
	private class LinkedListIterator implements ListIterator {
		private Node position;
		private Node previous;
		
		public LinkedListIterator() {
			position = null;
			previous = null;
		}
		
		public Object next() {
			if (!hasNext())
				throw new NoSuchElementException();
			previous = position;
			if ( position == null)
				position = first;
			else position = position.next;
			return position.data;
		}
		
		public boolean hasNext() {
			if (position == null)
				return first != null;
			else
				return position.next != null;
		}
		
		public void remove() {
			if ( previous == position)
				throw new IllegalStateException();
			if (position == first) {
				removeFirst();
			} else {
				previous.next = position.next;
			}
			position = previous;
		}
		
		public void set(Object obj) {
			if (position == null)
				throw new NoSuchElementException();
			position.data = obj;
		}
		
		public void add(Object obj) {
			if ( position == null) {
				addFirst(obj);
				position = first;
			} else {
				Node newNode = new Node();
				newNode.data = obj;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			previous = position;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	private Node first;
	
	public LinkedList() {
		first = null;
	}
	
	public Object getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}
	
	public void addFirst(Object obj) {
		Node newNode = new Node();
		newNode.data = obj;
		newNode.next = first;
		first = newNode;
	}
	
	public Object removeFirst() {
		if ( first == null)
			throw new NoSuchElementException();
		Object obj = first.data;
		first = first.next;
		return obj;
	}
	
	
	
	
	
	
	
	
	
}
