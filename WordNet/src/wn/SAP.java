package wn;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.DepthFirstDirectedPaths;
import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Stack;

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
	private Digraph graph;

	/*
	 * Constructor takes a digraph (not necessarily a DAG).
	 *  
	 * @param G -- a digraph.
	 * @throws NullPointerException -- if any argument is null.
	 */
	public SAP(Digraph G) {
		// corner case
		if (G == null) {
			throw new NullPointerException();
		}
		// initialize the graph
		graph = new Digraph(G);
	}

	/*
	 * Is the digraph a directed acyclic graph?
	 *  
	 * @return true -- the digraph is a directed acyclic graph.
	 *         false -- the digraph is not a directed acyclic graph.
	 */
	public boolean isDAG() {
		// check the digraph cycle
		return !new DirectedCycle(graph).hasCycle();
	}

	/*
	 * Is the digraph a rooted DAG?
	 * 
	 * @return true -- the digraph is a rooted directed acyclic graph.
	 *         false -- the digraph is not a rooted directed acyclic graph.
	 */
	public boolean isRootedDAG() {
		// if it is not a directed acyclic graph
		if (!isDAG()) return false;
		
		// find root
		DepthFirstOrder dfo = new DepthFirstOrder(this.graph);
	    Integer rootVertex = dfo.post().iterator().next();
	    
	    // check the paths of the vertices 
	    DepthFirstDirectedPaths dfdp = new DepthFirstDirectedPaths(graph.reverse(), rootVertex);
	    for (int i = 0; i < graph.V(); i++) {
	    		if(!dfdp.hasPathTo(i)) return false;
	    }
	    
	    return true;
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
		// corner case
		if (v < 0 || v > graph.V() - 1 || w < 0 || w > graph.V() - 1 ) {
			throw new IndexOutOfBoundsException();
		}
		// add v and w to a stack
		Stack<Integer> vStack = new Stack<>();
    		vStack.push(v);
    		Stack<Integer> wStack = new Stack<>();
    		wStack.push(w);
    		// use helper method for length
	    return ancestorAndLength(vStack, wStack)[1];	
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
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
		// corner cases
		if (v == null || w == null) {
			throw new NullPointerException();
		}
		
		for (Integer i : v) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		for (Integer i : w) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		// helper method to get the length
		return ancestorAndLength(v, w)[0];
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
	private int[] ancestorAndLength(Iterable<Integer> v, Iterable<Integer> w){
		// corner cases
		if (v == null || w == null) {
			throw new NullPointerException();
		}
		
		for (Integer i : v) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		for (Integer i : w) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		// Data Structures to find the paths
	    BreadthFirstDirectedPaths vPaths = new BreadthFirstDirectedPaths(graph, v);
	    BreadthFirstDirectedPaths wPaths = new BreadthFirstDirectedPaths(graph, w);
	   
	    // DepthFirstOrder in a graph
	    DepthFirstOrder DFO = new DepthFirstOrder(graph);
	        
	    // Closest ancestor and length
	    int ancestor = -1;
	    int length = -1;
	   
	    // Start with reverse post order from the DFO
	    for (int i: DFO.reversePost()){
		    if (vPaths.hasPathTo(i) && wPaths.hasPathTo(i)){
			    // Common ancestor found, calculate the current length
			    int currentLength = vPaths.distTo(i) + wPaths.distTo(i);
			   
			    // See if it's closer than the current
			    if (currentLength < length || ancestor == -1){
				    ancestor = i;
				    length = currentLength;
			    } else break;
		    }
	    }
	   
	    // Returns an array where ancestorAndLength[0] = ancestor and ancestorAndLength[1] = length
	    int[] ancestorAndLength = {ancestor, length};
	    return ancestorAndLength;
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
		// corner cases
		if (v == null || w == null) {
			throw new NullPointerException();
		}
		
		for (Integer i : v) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		for (Integer i : w) {
			if (i < 0 || i > graph.V() - 1 ) {
				throw new IndexOutOfBoundsException();
			}
        }
		
		// use helper method to find the length
		return ancestorAndLength(v, w)[1];
	}
}
