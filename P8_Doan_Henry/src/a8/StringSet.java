package a8;

// A StringSet is a collection of non-null strings, with no duplicates
// (i.e., no two elements may be equal).  
public class StringSet {
    private DynamicArray2 dynamicStringSet;
      
    /**
	 * Creates an empty dynamicStringSet object with the new class of DynamicArray2.
	 */
    public StringSet() {
    		dynamicStringSet = new DynamicArray2();
    }
    
    /**
     * Throws an IllegalArgumentException if e is null. but if add e to the set if 
     * it does not contains e yet.	
     * @params String e is the item we want to add 
     **/
    public void insert(String e) {
    		if ( e == null) {
    			throw new IllegalArgumentException();
    		}
    		
    		if (contains(e)) {
    			return;
    		}
    		dynamicStringSet.add(e);
    }
    
    /**
     * Throws an IllegalArgumentException if e is null. see if the set has e
     * @params String e is the item we want to add 
     * @return true if the set has e
     * @return false if the set not have e
     **/
   
    public boolean contains(String e) {
	    	if ( e == null) {
	    		throw new IllegalArgumentException();
		}
	    	
	    	for (int i = 0; i < dynamicStringSet.size(); i++) {
	    		if (dynamicStringSet.get(i) == e) {
	    			return true;
	    		}
	    	}
		
        return false;
    }
    
    /**
     * Throws an IllegalArgumentException if e is null. remove e from set
     * @params String e is the item we want to add 
     **/
    
    public void remove(String e) {
     	if ( e == null) {
	    		throw new IllegalArgumentException();
		}
     	for (int i = 0; i < dynamicStringSet.size(); i++) {
	    		if (dynamicStringSet.get(i).equals(e)) {
	    			dynamicStringSet.remove(i);
	    		}
	    	}
    }
    
    /**
     * Returns the number of strings in the set
     **/
    // 
    public int size() {
    		return dynamicStringSet.size();
    }  
    
    /**
     * Throws an IllegalArgumentException if e is null. Computes and returns the union 
     * of the StringSet that calls this method and theStringSet argument to the method.
     * the union has a copy inserted to the union it self.
     * @params String other is the item we want to add 
     **/
    
    public StringSet union(StringSet other) {
	    	if (other == null) {
	    		throw new IllegalArgumentException();
	    	}
	    	StringSet union = new StringSet();
	    	for (int i = 0; i < dynamicStringSet.size(); i++) {
	    		union.insert(dynamicStringSet.get(i));
	    	}
	    	
	    	for (int j = 0; j < other.size(); j++) {
	    		union.insert(other.dynamicStringSet.get(j));
	    	}
	    	
	    	return union;
    }

    	
    // Computes and returns the intersection of the StringSet that calls this method and the 
    // StringSet argument to the method.
    // The original StringSets should not be changed. The intersection set contains every 
    // element that is in both of the StringSets and no other elements.
    /**
     * Throws an IllegalArgumentException if e is null. Computes and returns the 
     * Intersection of the string set. and have the element of the string set the
     * other element we want to add.
     * 
     * @params String other is the item we want to add 
     **/
    public StringSet intersection(StringSet other) {
	    	if (other == null) {
	    		throw new IllegalArgumentException();
	    	}
	    	
	    	StringSet intersection = new StringSet();
	    	for (int i = 0; i < dynamicStringSet.size(); i++) {
	    		if (other.contains(dynamicStringSet.get(i))) {
	    			intersection.insert(dynamicStringSet.get(i));
	    		}
	     }
	    	return intersection;
    }

    /**
     * Returns a formatted string version of this set
     * @return results as a string
     **/
    public String toString() {
	    	String result = "{";
			if (size() > 0) {
				result += dynamicStringSet.get(0);
			}
			for (int i = 1; i < size(); i++) {
				result += ", " + dynamicStringSet.get(i);
			}
			return result + "}";    	
		
    }
}