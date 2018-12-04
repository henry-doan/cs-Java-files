package wn;

/*
 * An immutable data type of WordNet groups words into 
 * sets of synonyms called synsets and describes semantic relationships 
 * between them. The class connects a hyponym to a hypernym and some helper
 * method to inform us about the word net.
 * 
 * @author Henry Doan
 */
public class WordNet {
	 /* 
	  * Constructor takes the name of the two input files.
	  * 
	  * @param synsets -- string of synssets file.
	  *         hypernym -- string of hypernyms file.
	  * @throws NullPointerException --  if any argument is null or an empty string.
	  *         IllegalArgumentException -- if the input does not correspond to a rooted DAG.
	  */
	 public WordNet(String synsets, String hypernyms) {
		 if (synsets == "" || synsets == null || hypernyms == null || hypernyms == "" ) {
			 throw new NullPointerException();
		 }
			 
	 }

	 /*
	  * Returns all WordNet nouns.
	  * 
	  * @return -- all ths nows in the word net.
	  */
	 public Iterable<String> nouns() {
		return null;
		 
	 }

	 /* 
	  * Is the word a WordNet noun?
	  * 
	  * @param word -- a string of the checking.
	  * @return true -- if word is a noun.
	  *         false -- if word is not a noun.
	  * @throws NullPointerException -- if any argument is null or an empty string.
	  */
	 public boolean isNoun(String word) {
		 if (word == "" || word == null) {
			 throw new NullPointerException();
		 }
		return false;
		 
	 }

	 /* 
	  * Distance between nounA and nounB (defined below)
	  * 
	  * @param nounA -- string, the first noun we are comparing to.
	  *         nounB -- string, the second noun we are comparing to.  
	  * @return  -- the distance between the two nouns.
	  * @throws NullPointerException -- if any argument is null or an empty string.
	  *         IllegalArgumentException -- unless both of the noun arguments are WordNet nouns.
	  */
	 public int distance(String nounA, String nounB) {
		 if (nounA == "" || nounA == null || nounB == null || nounB == "" ) {
			 throw new NullPointerException();
		 }
		return 0;
		 
	 }

	 /*
	  * S synset (second field of synsets.txt) that is 
	  * the common ancestor of nounA and nounB
	  * in a shortest ancestral path (defined below).
	  * 
	  * @param nounA -- string, the first common ancestor.
	  *         nounB -- string, the second common ancestor.     
	  * @return  -- the shortest ancestral path between the two nouns.
	  * @throws NullPointerException -- if any argument is null or an empty string.
	  *         IllegalArgumentException -- unless both of the noun arguments are WordNet nouns.
	  */
	 public String sap(String nounA, String nounB) {
		 if (nounA == "" || nounA == null || nounB == null || nounB == "" ) {
			 throw new NullPointerException();
		 }
		return nounB;
		 
	 }
	 
	 /*
	  * Unit testing of the methods (not graded) 
	  */
	 public static void main(String[] args) {
	
	 }
}
