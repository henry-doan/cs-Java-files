package dataStructures;


public class NodeTemplate<T> { 
	private T data;
//	privateNode<T> nextNode; // reference to next node
	
	public NodeTemplate(T data) { 
		/* constructor body */ 
	}
	
	public void setData(T data) { 
		/* method body */
	}
	
	public T getData() {
		return data; 
		/* method body */
	}
	
	public void setNext(NodeTemplate<T> next) { 
		/* method body */
	}
	public NodeTemplate<T> getNext() {
		return null; 
		/* method body */
	} 
}

//private class Node {
//	public Object data;
//	public Node next;
//}