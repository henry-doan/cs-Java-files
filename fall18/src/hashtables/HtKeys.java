package hashtables;

import java.util.Enumeration;
import java.util.Hashtable;

public class HtKeys {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		Enumeration e = h.keys();
		System.out.println("display keys");
		
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

}
