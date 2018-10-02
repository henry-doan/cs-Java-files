package dataStructures;

// class to rep one node in a list
// anything in the same package can access
public class ListNode<E> {
	E data; // data for the node
	ListNode<E> nextNode; // reference to the next node in the list

	// Constructor create a list node
	ListNode(E object) {this(object, null);}
	
	// constructor that refers to a object and next node
	ListNode(E object, ListNode<E> node) {
		data = object;
		nextNode = node;
	} 
	
	// return reference to data in node
	E getData() { return data; }
	
	// return reference to next node in list
	ListNode<E> getNext() { return nextNode; }

}

