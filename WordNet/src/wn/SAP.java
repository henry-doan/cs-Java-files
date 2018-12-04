package wn;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * An immutable data type of an ancestral path between two vertices
 * v and w in a digraph is a directed path from v to a common ancestor 
 * x, together with a directed path from w to the same ancestor
 * x. A shortest ancestral path is an ancestral path 
 * of minimum total length.
 *
 * @author Henry Doan
 */
public class SAP {
	private Digraph digraph;

	/*
	 * Constructor takes a digraph (not necessarily a DAG).
	 *  
	 * @param G -- a digraph.
	 * @throws NullPointerException -- if any argument is null.
	 */
	public SAP(Digraph G) {
		if (G == null) {
			 throw new NullPointerException();
		 }
	}

	/*
	 * Is the digraph a directed acyclic graph?
	 *  
	 * @return true -- the digraph is a directed acyclic graph.
	 *         false -- the digraph is not a directed acyclic graph.
	 */
	public boolean isDAG() {
		return false;
		
	}

	/*
	 * Is the digraph a rooted DAG?
	 * 
	 * @return true -- the digraph is a rooted directed acyclic graph.
	 *         false -- the digraph is not a rooted directed acyclic graph.
	 */
	public boolean isRootedDAG() {
		return false;	
	}

	/* 
	 * Length of shortest ancestral path between v and w; -1 if no such path.
	 * 
	 * @param v -- int point in the graph.
	 *        w -- int point in the graph.
	 * @return -- the length of the shortest ancestral path.
	 * @throws IndexOutOfBoundsException -- if the argument is not in the range of 0 and digraph v - 1.
	 */
	public int length(int v, int w) {
		if (v < 0 || v > digraph.V() - 1 || w < 0 || w > digraph.V() - 1 ) {
			throw new IndexOutOfBoundsException();
		}
		return w;	
	}

	/*
	 * A common ancestor of v and w that participates in a 
	 * shortest ancestral path; -1 if no such path.
	 * 
	 * @param v -- int point in the graph.
	 *        w -- int point in the graph.
	 * @return -- the common ancestor.
	 *         -1 -- if there is no such path.
	 * @throws IndexOutOfBoundsException -- if the argument is not in the range of 0 and digraph v - 1.
	 */
	public int ancestor(int v, int w) {
		if (v < 0 || v > digraph.V() - 1 || w < 0 || w > digraph.V() - 1 ) {
			throw new IndexOutOfBoundsException();
		}
		return -1;
	}

	/*
	 * Length of shortest ancestral path between any 
	 * vertex in v and any vertex in w; -1 if no such path.
	 * 
	 * @param v -- int vertex in the graph.
	 *        w -- int vertex in the graph.
	 * @return -- the common ancestor.
	 *         -1 -- if there is no such path.
	 * @throws NullPointerException -- if any argument is null.
	 * 		   IndexOutOfBoundsException -- if the argument is not in the range of 0 and digraph v - 1.
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		if (v == null || w == null) {
			throw new NullPointerException();
		}
		
		for (Integer i : v) {
			if (i < 0 || i > digraph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		for (Integer i : w) {
			if (i < 0 || i > digraph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		return -1;
		
	}

	/* 
	 * A common ancestor that participates in shortest 
	 * ancestral path; -1 if no such path.
	 *
	 * @param v -- int vertex in the graph.
	 *        w -- int vertex in the graph.
	 * @return -- the common ancestor.
	 *         -1 -- if there is no such path.
	 * @throws NullPointerException -- if any argument is null.
	 * 		   IndexOutOfBoundsException -- if the argument is not in the range of 0 and digraph v - 1.
	 */
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		if (v == null || w == null) {
			throw new NullPointerException();
		}
		
		for (Integer i : v) {
			if (i < 0 || i > digraph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		for (Integer i : w) {
			if (i < 0 || i > digraph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		return -1;
		
	}

	/*
	 * Loads up the files and start the sap process.
	 */
	public static void main(String[] args) {
	    In in = new In(args[0]);
	    Digraph G = new Digraph(in);
	    SAP sap = new SAP(G);
	    while (!StdIn.isEmpty()) {
	        int v = StdIn.readInt();
	        int w = StdIn.readInt();
	        int length   = sap.length(v, w);
	        int ancestor = sap.ancestor(v, w);
	        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
	    }
	}
}
