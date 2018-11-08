package hashtables;

import java.util.Hashtable;
import java.util.Set;

public class Values {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();

		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		Set s = h.entrySet(); 
		System.out.println("collection values: "+ h.values());
	}

}
