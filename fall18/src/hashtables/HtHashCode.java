package hashtables;

import java.util.*;

public class HtHashCode {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");
		System.out.println("hash code is: "+ h.hashCode());
	}

}
