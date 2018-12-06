package wn;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/*
 * An immutable data type that given a list of word net nouns
 * identify an outcast noun that is the least related to the 
 * others, as well as compute the sum of the distances between
 * each noun and every other one.
 *
 * @author Henry Doan
 */
public class Outcast {
	private WordNet wn;
	
	/* 
	 * Constructor takes a WordNet object.
	 * 
	 * @param wordnet -- word net object initialized. 
	 */
	public Outcast(WordNet wordnet) {
		// initialize a word net
		wn = wordnet;
	}
	
	/*
	 * Given an array of WordNet nouns, return an outcast.
	 * 
	 * @param nouns -- string array of nouns from the word net.
	 * @return -- the outcast.
	 */
	public String outcast(String[] nouns) {
		// st and max priority queue
		ST<Integer, String> st = new ST<>();
		MaxPQ<Integer> maxPQ = new MaxPQ<>();
		
		// loop through all the nouns
		for (int i = 0; i < nouns.length; i++){
			int distance = 0;
			// check the distances
			for (int j = 0; j < nouns.length; j++){
				distance += wn.distance(nouns[i], nouns[j]);
			}
			// add the distance to data structure
			maxPQ.insert(distance);
			st.put(distance, nouns[i]);
		}
		
		// return the outcast
		return st.get(maxPQ.max());
	}

	/*
	 * Loads up a file and start the outcast process.
	 */
	public static void main(String[] args) {
	    WordNet wordnet = new WordNet(args[0], args[1]);
	    Outcast outcast = new Outcast(wordnet);
	    for (int t = 2; t < args.length; t++) {
	        In in = new In(args[t]);
	        String[] nouns = in.readAllStrings();
	        StdOut.println(args[t] + ": " + outcast.outcast(nouns));
	    }
	}
}
