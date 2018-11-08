package hashtables;
import java.util.*;

public class htEntreysent {

	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		
		h.put(3, "Geeks");
		h.put(2, "Geeks");
		h.put(1, "isBest");

		Set s = h.entrySet();
		System.out.println("set entries: " + s);
		

	}

}
