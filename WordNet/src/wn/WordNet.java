package wn;


public class WordNet {
	 /* 
	  * Constructor takes the name of the two input files.
	  * 
	  * @params synsets - string of synssets file.
	  *         hypernym - string of hypernyms file.
	  */
	 public WordNet(String synsets, String hypernyms) {
		 
	 }

	 /*
	  * Returns all WordNet nouns.
	  * 
	  * @return - all ths nows in the word net.
	  */
	 public Iterable<String> nouns() {
		return null;
		 
	 }

	 /* 
	  * Is the word a WordNet noun?
	  * 
	  * @params word - a string of the checking.
	  * @return true - if word is a noun.
	  *         false - if word is not a noun.
	  */
	 public boolean isNoun(String word) {
		return false;
		 
	 }

	 /* 
	  * Distance between nounA and nounB (defined below)
	  * 
	  * @params nounA - string, the first noun we are comparing to.
	  *         nounB - string, the second noun we are comparing to.  
	  * @return  - the distance between the two nouns.
	  */
	 public int distance(String nounA, String nounB) {
		return 0;
		 
	 }

	 /*
	  * S synset (second field of synsets.txt) that is 
	  * the common ancestor of nounA and nounB
	  * in a shortest ancestral path (defined below).
	  * 
	  * @params nounA - string, the first common ancestor.
	  *         nounB - string, the second common ancestor.     
	  * @return  - the shortest ancestral path between the two nouns.
	  */
	 public String sap(String nounA, String nounB) {
		return nounB;
		 
	 }
	 
	 /*
	  * Unit testing of the methods (not graded) 
	  */
	 public static void main(String[] args) {
	
	 }
}
