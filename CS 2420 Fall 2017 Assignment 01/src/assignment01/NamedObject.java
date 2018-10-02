package assignment01;

/**
 * This class implements 
 *
 * @author  Henry Doan 
 * @version August 25, 2017
 */

public class NamedObject {

	private String name;
	private Object object;
	
	/**
	 * Constructor to construct a namedOject with a string name and object.
	 *
	 * @param name - Any non-null String
	 * @param object - An object passed threw
	 */

	public NamedObject(java.lang.String n, java.lang.Object object) {
		if( n == null ) 
			throw new IllegalArgumentException();
		this.name = n;
		this.object = object;
	}

	/**
	 * Returns the name of this NamedObject.
	 *
	 * @return name - name of the NamedObject.
	 */
	public java.lang.String getName() {
		return name;	
	}
	
	/**
	 * Returns the object stored in this NamedObject.
	 *
	 * @return object - object of the NamedObject.
	 */
	public java.lang.Object getObject() {
		return object;	
	}
	
	/**
	 * Changes the name of this named object to a new name.
	 *
	 */
	public void setName(java.lang.String newName) {
		this.name = newName;
	}
	
	/**
	 * Returns true iff this NamedObject and and the other NamedObject have the same names and objects (using .equals).
	 *
	 * @param other - an object being compared.
	 * @return true - if this object equals other object being compared
	 * @return false - if the name or object is not the same name
	 * @return true - for else
	 */
	@Override
	public boolean equals(Object other) {
		if (this.equals(other))
			return true;
		if (!name.equals(((NamedObject) other).getName()))
			return false;
		if (!other.equals(other)) {
			return false; 
		}
		return true;
	}
	
	/**
	 * Returns a hash value for this NamedObject.
	 *
	 * @return result - hash code result.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}
	
	/**
	 * Given an array of non-null Strings, this method will return a chain of NamedObjects containing the Strings as Names.
	 *
	 * @param data - An non-empty array of non-null Strings
	 * @return String[] - a chain of named objects whose names match the Strings in data
	 */
	public static NamedObject chain(java.lang.String[] data) {
		if(data.length == 0 || data == null) {
			throw new java.lang.NullPointerException();
		}
		
		NamedObject previous = new NamedObject(data[data.length-1], null);

		for (int i = data.length - 2; i >= 0; i--){
			NamedObject current = new NamedObject(data[i], previous);
			previous = current;
		}
		
		return previous;
	}
	
	/**
	 * This method extracts and returns the names stored in a chain of NamedObjects.
	 *
	 * @param chain - A NamedObject chained to 0 or more other chained NamedObjects
	 * @return chainResult - an array of Strings corresponding to the names in the chain
	 */
	public static java.lang.String[] unchain(NamedObject chain) {
		int chainLength = 0;
		
		NamedObject currentObject = chain;
		while (currentObject.getObject() != null) {
			chainLength++;
			currentObject = (NamedObject) currentObject.getObject();
		}
		
		String[] chainResult = new String[chainLength]; 
		currentObject = chain;
		for(int i = 0; i < chainResult.length; i++ ) {
			chainResult[i] = currentObject.getName();
			currentObject = (NamedObject) currentObject.getObject();
		}
		
		return chainResult;
		
	}

}
