package wn;

import edu.princeton.cs.algs4.Digraph;

/*
 *  An immutable data type of an ancestral path between two vertices
 *  v and w in a digraph is a directed path from v to a common ancestor 
 *  x, together with a directed path from w to the same ancestor
 *  x. A shortest ancestral path is an ancestral path 
 *  of minimum total length.
 *
 *  @author Henry Doan
 */
public class SAP {
	/*
	 *  Constructor takes a digraph (not necessarily a DAG).
	 *  
	 *  @param G - a digraph.
	 */
	public SAP(Digraph G) {
		
	}

	/*
	 *  Is the digraph a directed acyclic graph?
	 *  
	 *  @return true - the digraph is a directed acyclic graph.
	 *          false - the digraph is not a directed acyclic graph.
	 */
	public boolean isDAG() {
		return false;
		
	}

	/*
	 * Is the digraph a rooted DAG?
	 * 
	 * @return true - the digraph is a rooted directed acyclic graph.
	 *         false - the digraph is not a rooted directed acyclic graph.
	 */
	public boolean isRootedDAG() {
		return false;	
	}

	/* 
	 * Length of shortest ancestral path between v and w; -1 if no such path.
	 * 
	 * @param v - int point in the graph.
	 *        w - int point in the graph.
	 * @return - the length of the shortest ancestral path.
	 */
	public int length(int v, int w) {
		return w;	
	}

	/*
	 * A common ancestor of v and w that participates in a 
	 * shortest ancestral path; -1 if no such path.
	 * 
	 * @param v - int point in the graph.
	 *        w - int point in the graph.
	 * @return - the common ancestor.
	 *         -1 - if there is no such path.
	 */
	public int ancestor(int v, int w) {
		return -1;
	}

	/*
	 * Length of shortest ancestral path between any 
	 * vertex in v and any vertex in w; -1 if no such path.
	 * 
	 * @param v - int vertex in the graph.
	 *        w - int vertex in the graph.
	 * @return - the common ancestor.
	 *         -1 - if there is no such path.
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return -1;
		
	}

	/* 
	 * A common ancestor that participates in shortest 
	 * ancestral path; -1 if no such path.
	 *
	 * @param v - int vertex in the graph.
	 *        w - int vertex in the graph.
	 * @return - the common ancestor.
	 *         -1 - if there is no such path.
	 */
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return -1;
		
	}

	/*
	 * Do unit testing of this class.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
