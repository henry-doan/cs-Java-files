package hashtables;

import java.util.Hashtable;
import java.util.Set;

public class HTkeySet {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		Set sKey = h.keySet(); 
		
		System.out.println("key set: "+ sKey); 
	}

}
