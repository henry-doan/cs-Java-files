package hashtables;

import java.util.Hashtable;
import java.util.Set;

public class PutAll {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		Hashtable h1 = new Hashtable();

		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		h1.putAll(h);
		
		System.out.println("Values in h1: "+ h1); 

	}

}
