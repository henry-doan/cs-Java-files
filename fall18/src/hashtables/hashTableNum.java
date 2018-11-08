package hashtables;

import java.util.*;

public class hashTableNum {

	public static void main(String[] args) {
		Hashtable marks = new Hashtable(); 
		marks.put("tweener", new Integer(345)); 
		marks.put("krantz", new Double(245.78));
		marks.put("burrows", new Integer(790)); 
		marks.put("tancredi", new Double(365.98)); 
		marks.put("bellick", new Integer(435));
		
		if (marks.contains(345))
			System.out.println("value found in table");
	}

}
