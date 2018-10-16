package ac;

import java.util.Comparator;

/*
 * An Immutable data type that is a auto complete term.
 * This class also compares terms in three orders.
 * 
 * @author Henry Doan
 * @version October 13, 2018
 */
public class Term implements Comparable<Term> {
	private String termQuery;
	private double termWeight;
	
	/*
	 * Initialize a term with the given query 
	 * string and weight.
	 * 
	 * @param query -- a searched term 
	 *        weight -- number of how much the gross made
	 * 
	 */
	public Term(String query, double weight) {
		if (query == null) {
			throw new java.lang.NullPointerException();
		}
		
		if (weight < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		
		termQuery = query;
		termWeight = weight;
	}
	
	/*
	 * Compare the terms in descending order by weight.
	 * 
	 * @return a comparator of the terms in reverse order by weight
	 */
	public static Comparator<Term> byReverseWeightOrder(){
		 return new Comparator<Term>(){
			 public int compare(Term v, Term w) {
				 double vweight = v.termWeight;
				 double wweight = w.termWeight;
				 
				 if ( vweight > wweight) {
					 return -1;
				 }				
				 
				 if (vweight == wweight) {
					return 0;
				 }
				 
				 return 1;
				 
	         } 
	     };
	}
	
	/*
	 * Compare the terms in lexicographic order but using 
	 * only the first r characters of each query.
	 * 
	 * @param r -- number of characters to search
	 * @return compare -- order of the search term of r characters.
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		
		return new Comparator<Term>(){
			public int compare(Term v, Term w) {
				String vquery = v.termQuery;
				String wquery = w.termQuery;
				
				// get the substring from the beginning of the query to r characters.
				String vSub = vquery.substring(0, r);
				String wSub = wquery.substring(0, r);
				
				// compare the query
				int compare = vSub.compareToIgnoreCase(wSub);

				// return the order
				return compare; 
	         } 
	     };
		
	}
	
	/*
	 *  Compare the terms in lexicographic order by query.
	 * 
	 * @param that -- a term to compare to.
	 * @return compare -- number which indicates the order.
	 */
	@Override
	public int compareTo(Term that) {
		String q1 = this.termQuery;
		String q2 = that.termQuery;
		 
		// compare the query
		int compare = q1.compareToIgnoreCase(q2);

		// return the order
		return compare; 
	}

	/*
	 * Return a string representation of the term in the following 
	 * format: the weight, followed by a tab, followed by the 
	 * query.
	 * 
	 * @return result -- a string with the correct format.
	 */
	public String toString() {
		String result = termWeight + "\t" + termQuery;
		return result;	
	}
}
