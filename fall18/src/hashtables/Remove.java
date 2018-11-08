package hashtables;

import java.util.Hashtable;

public class Remove {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();

		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		h.remove(2);
		
		System.out.println("Values after remove: "+ h); 

	}

}
