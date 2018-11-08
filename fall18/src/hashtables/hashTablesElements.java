package hashtables;
import java.util.*;

public class hashTablesElements {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		Enumeration e = h.elements();
		System.out.println("display values");
		
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}

}
