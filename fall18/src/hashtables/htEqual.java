package hashtables;
import java.util.*;

public class htEqual {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		Hashtable h1 =  new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		h1 = (Hashtable)h.clone();
		
		if (h.equals(h1))
			System.out.println("is equal");

	}

}
