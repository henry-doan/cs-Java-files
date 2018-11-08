package hashtables;

import java.util.*;
public class hashTableDemo {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		Hashtable h1 =  new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		h1 = (Hashtable)h.clone();
		
		System.out.println("values in clone: " + h1);
		
		h.clear();
		
		System.out.println("after clearing: " + h);

	}

}
