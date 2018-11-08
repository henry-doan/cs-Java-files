package hashtables;

import java.util.Hashtable;

public class HtEmpty {
	
	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		h.clear();
		
		if(h.isEmpty()) 
			System.out.println("yes hash table is empty"); 
	}

}
