package hashtables;

import java.util.Hashtable;

public class ToString {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();

		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");
		
		System.out.println("string equivalent of map: "+ h.toString() ); 
	}

}
