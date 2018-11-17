package searchingApps;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class MovieIndex {

	public static void main(String[] args) {
		ST<String, Bag<String>> st = new ST<String, Bag<String>>();
		In in = new In(args[0]);
		while(in.hasNextLine()) {
			String line = in.readLine();
			String[]names = line.split("/");
			String movie = names[0];
			for(int i = 1;i < names.length; i++) {
				String actor = names[i];
				if(!st.contains(actor)) st.put(actor, new Bag<String>());
				if(!st.contains(movie)) st.put(movie, new Bag<String>());
				st.get(actor).add(movie);
				st.get(movie).add(actor);
			}
		}
		StdOut.println("Done indexing files");
		StdOut.println();
		
		StdOut.println("Type thename of a performer or movie");
		while(!StdIn.isEmpty()) {
			String name = StdIn.readLine();
			if(st.contains(name)) {
				for(String s : st.get(name))
					StdOut.println("  " + s);
			}
			StdOut.println();
		}

	}

}
