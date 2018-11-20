package undirectedGraphs;

public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
		bfs(G, s);
		assertcheck(G, s);
	}
	
	public BreadthFirstPaths(Graph G, Iterable<Integer>sources) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		validateVertices(sources);
		bfs(G,sources);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
