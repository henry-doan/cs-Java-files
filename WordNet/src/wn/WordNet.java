package wn;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SeparateChainingHashST;

/*
 * An immutable data type of WordNet groups words into 
 * sets of synonyms called synsets and describes semantic relationships 
 * between them. The class connects a hyponym to a hypernym and some helper
 * method to inform us about the word net.
 * 
 * @author Henry Doan
 */
public class WordNet {
	// what all the word net has
	private Digraph graph;
	private SAP sap;
	private SeparateChainingHashST<String, Queue<Integer>> wordToIntegerMap;
	private SeparateChainingHashST<Integer, String> integerToWordMap;
	
	 /* 
	  * Constructor takes the name of the two input files.
	  * 
	  * @param synsets -- string of synssets file.
	  *         hypernym -- string of hypernyms file.
	  * @throws NullPointerException --  if any argument is null or an empty string.
	  *         IllegalArgumentException -- if the input does not correspond to a rooted DAG.
	  */
	 public WordNet(String synsets, String hypernyms) {
		 // corner case
		 if (synsets == "" || synsets == null || hypernyms == null || hypernyms == "" ) {
			 throw new NullPointerException();
		 }
		 // initialize the maps
		 wordToIntegerMap = new SeparateChainingHashST<>();
		 integerToWordMap = new SeparateChainingHashST<>();
		 int vertices = 0;
		 In in = new In(synsets);
		 // look in the file and read the data
		 while (in.hasNextLine()) {
			 vertices++;
			 String[] line = in.readLine().split(",");
			 String[] words = line[1].split(" ");
			 Integer number = Integer.valueOf(line[0]);
			 integerToWordMap.put(Integer.valueOf(line[0]), line[1]);
			 for (int i = 0; i < words.length; i++) {
				 Queue<Integer> wordToIntegerMapQueue = wordToIntegerMap.get(words[i]);
				 if (wordToIntegerMapQueue == null) {
					 // add the numbers to the queue
					 wordToIntegerMapQueue = new Queue<>();
					 wordToIntegerMapQueue.enqueue(number);
					 wordToIntegerMap.put(words[i], wordToIntegerMapQueue);
				 } else {
					 if (!contains(wordToIntegerMapQueue, number)) {
						 wordToIntegerMapQueue.enqueue(number);
					 }
				 }
			 }
		 }
		 // create a graph
		 graph = new Digraph(vertices);
		 in = new In(hypernyms);
		 while (in.hasNextLine()) {
			 String[] line = in.readLine().split(",");
			 for (int i = 1; i < line.length; i++)
				 graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[i]));
		 }
		 sap = new SAP(graph);
		 if (!sap.isRootedDAG()) throw new IllegalArgumentException("hypernyms must be a rooted DAG");
	 }

	 /*
	  * Helper method with seeing if the item
	  * is in the iterable.
	  * 
	  * @return true -- contain the item.
	  * 	        false -- does not contain the item.
	  */
	 private <Item> boolean contains (Iterable<Item> iterable, Item item) {
		 // check to see if the item is in the query
		 for (Item query : iterable) {
			 if (query == item) return true;
		 }
		 return false;
	 }
	 
	 /*
	  * Returns all WordNet nouns.
	  * 
	  * @return -- all the nouns in the word net.
	  */
	 public Iterable<String> nouns() {
		 // use the separate chaining hash helper method
		 return wordToIntegerMap.keys(); 
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
		 // corner case
		 if (word == "" || word == null) {
			 throw new NullPointerException();
		 }
		 // use the separate chaining hash helper method
		return wordToIntegerMap.contains(word);
		 
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
		 // corner case
		 if (nounA == "" || nounA == null || nounB == null || nounB == "" ) {
			 throw new NullPointerException();
		 }
		 // use the helper method get to integers
		 Iterable<Integer> integerA = wordToIntegerMap.get(nounA);
		 Iterable<Integer> integerB = wordToIntegerMap.get(nounB);
		 // use sap helper method for the length
		 return sap.length(integerA, integerB);
	 }

	 /*
	  * Synset (second field of synsets.txt) that is 
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
		 // corner case
		 if (nounA == "" || nounA == null || nounB == null || nounB == "" ) {
			 throw new NullPointerException();
		 }
		 // use the helper method get to integers
		 Iterable<Integer> integerA = wordToIntegerMap.get(nounA);
		 Iterable<Integer> integerB = wordToIntegerMap.get(nounB);
		 
		 // helper method to get the ancestor
		 return integerToWordMap.get(sap.ancestor(integerA, integerB)); 
	 }
	 
	 /*
	  * Unit testing of the methods (not graded) 
	  */
	 public static void main(String[] args) {
		 WordNet wordnet = new WordNet("wn/synsets.txt", "wn/hypernyms.txt");
		 String word = "Aberdeen";
		 Integer number = 71;
		 int graphNumber = 78;
			
		 System.out.print(word + ":");
		 for (Integer i : wordnet.wordToIntegerMap.get(word))
			 System.out.print(" " + i);
						
		 System.out.println(number + ": " + wordnet.integerToWordMap.get(number));
			
		 System.out.println("\nGraph Vertices: " + wordnet.graph.V() + ", Expected: 82192");
		 System.out.println("Graph Edges: " + wordnet.graph.E() + ", Expected: 84505");
		 System.out.print(graphNumber + ":");
		 for (int num : wordnet.graph.adj(graphNumber))
			 System.out.print(" " + num);
			
		 System.out.println("\n\n\n");
		 System.out.println(wordnet.sap("drum", "keyboard"));
	 }
}
