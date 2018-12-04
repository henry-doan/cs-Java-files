package wn;

import edu.princeton.cs.algs4.In;
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
	/* 
	 * Constructor takes a WordNet object.
	 * 
	 * @param wordnet -- word net object initialized. 
	 */
	public Outcast(WordNet wordnet) {
		
	}
	
	/*
	 * Given an array of WordNet nouns, return an outcast.
	 * 
	 * @param nouns -- string array of nouns from the word net.
	 * @return -- the outcast.
	 */
	public String outcast(String[] nouns) {
		return null;
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
