package hashtables;

import java.util.Hashtable;

public class Size {

	public static void main(String[] args) {
		Hashtable marks = new Hashtable(); 
		
		marks.put("tweener", new Integer(345)); 
		marks.put("krantz", new Double(245.78));
		marks.put("burrows", new Integer(790)); 
		marks.put("tancredi", new Double(365.98)); 
		marks.put("bellick", new Integer(435));

		System.out.println("Size is: "+ marks.size()); 
	}

}
