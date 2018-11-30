package kt;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;

/*
 * An mutable data type that is symbol table with Point2D.
 * 
 * @author Henry Doan
 * @version November 30, 2018
 */
public class KdTreeST<Value> {
	// what all KdtreeST have
	private Node root;
	private int size;
	
	/*
	 * Private class for a node data type in the tree.
	 */
	private class Node {
		// what all nodes have
		private Point2D pt;
		private RectHV rect;
		private Node rt, lt;
		private Value val;
		
		/*
		 * Construct an node with point, value and rectangle,
		 */
		public Node(Point2D p, Value v, RectHV incomingRect) {
			pt = p;
			val = v;
			rect = incomingRect;
		}
	}
	
	/*
	 * Construct an empty tree of root node and the size.
	 */
	public KdTreeST() {
		root = null;
		size = 0;
	}

	/*
	 * Is the tree empty? 
	 * 
	 * @return true -- is empty
	 *         false -- is not empty
	 */
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	/*
	 * Return the size of the tree
	 * 
	 * @return size -- the number of nodes
	 */
	public int size() { 
		return size; 
	}

	/*
	 * Associate the value val with point p
	 * 
	 * @params pt -- point2D that we are looking at.
	 * 		   val -- the value of the point
	 * @throw nullPointerException if the params are null.
	 */
	public void put(Point2D pt, Value val) {
		if (pt == null || val == null) {
			throw new NullPointerException();
		}
		// take the info into a recursive function
		root = put(null, root, pt, val, true);
	}
	
	/*
	 * Associate the value val with point p.
	 * 
	 * @params prev -- previous node
	 *         n -- current node
	 * 		   pt -- point2D that we are looking at.
	 * 		   val -- the value of the point
	 * @throw nullPointerException if the params are null.
	 * @return a new node if there is not a node.
	 *         n -- node, the node we inputted.
	 */
	private Node put(Node prev, Node n, Point2D pt, Value val, boolean isVt) {
		// if the node is empty, create a new node
		if (n == null) {
			size++;
			return new Node(pt, val, createRect(n, pt, isVt));
		}
		
		// comparator for the points for the node
		double com = ptcompare(n, pt, isVt);

		// logic on where to put the information
		if (com < 0 ) {
			n.lt = put(n, n.lt, pt, val, !isVt);
		} else if (com > 0 ) {
			n.rt = put(n, n.rt, pt, val, !isVt);
		} else if (n.pt.equals(pt)) {
			n.val = val;
		} else {
			n.rt = put(n, n.rt, pt, val, !isVt);
		}
		
		// return the node
		return n;
	}
	
	/*
	 * Create a rectangle. 
	 * 
	 * @params n -- node that the rectangle will be.
	 *         pt -- point2D that we are looking at.
	 * 		   isVt -- boolean on if the point is vertical.
	 * @return a new rectangle if the node is empty.
	 * 		   a rectangle with the correct values.
	 *         null -- if non of the conditions are meant.
	 * 	       
	 */
	private RectHV createRect(Node n, Point2D pt, boolean isVt) {
		double neg = -Double.MAX_VALUE;
		double pos = Double.MAX_VALUE;
		
		// if there is no node
		if (n == null) {
			return new RectHV(neg, neg, pos, pos);
		}
		
		// helper variables
		double com = ptcompare(n, pt, !isVt);
		double rectXMin = n.rect.xmin();
		double rectXMax = n.rect.xmax();
		double rectYMin = n.rect.ymin();
		double rectYMax = n.rect.ymax();
		double y = n.pt.y();
		double x = n.pt.x();
		
		// conditions on what kind of rectangle to return
		if (isVt && com < 0 ) {
			return new RectHV(rectXMin, rectYMin, rectXMax, y);
		}
		
		if (!isVt && com < 0 ) {
			return new RectHV(rectXMin, rectYMin, x, rectYMax);
		}
		
		if (isVt && com >= 0 ) {
			return new RectHV(rectXMin, y, rectXMax, rectYMax);
		}
		
		if (!isVt && com >= 0 ) {
			return new RectHV(x, rectYMin, rectXMax, rectYMax);
		}
		
		// else return null
		return null;
	}

	/*
	 * Compare the points base on if the the point is vertical
	 * or horizontal.
	 * 
	 * @params n -- node the current node we are working with.
	 * 	       pt -- point2D that we are looking at.
	 * 		   b -- boolean if the point is vertical.
	 * @return a double of the location of the points.
	 */
	private double ptcompare(Node n, Point2D pt, boolean b) {
		if (b) {
			return pt.x() - n.pt.x();
		} else {
			return pt.y() - n.pt.y();
		}
	}


	/*
	 * Value associated with point p. 
	 * 
	 * @params p -- point2D that we are looking at.	 
	 * @return the value from the given point with a recursive call to a helper function.
	 * @throw nullPointerException if the params are null.
	 */
	public Value get(Point2D pt) {
		// corner case
		if (pt == null) {
			throw new NullPointerException();
		}
		
		// call to a recursive function.
		return get(root, pt);
	}
	

	/*
	 * Value associated with point p 
	 * 
	 * @params n -- the current node we are working with.
	 *         p -- point2D that we are looking at.	 
	 * @return the value from the given point.
	 * @throw nullPointerException if the params are null.
	 */
	private Value get(Node n, Point2D pt) {
		// corner case
		if (n == null || pt == null) {
			throw new NullPointerException();
		}
		
		boolean horiz = false;
		
		// conditions to find the value of the point.
		if (horiz) {
			if (n.pt.x() < pt.x()) {
				return get(n.rt, pt);
			} else if ( n.pt.x() > pt.x()) {
				return get(n.lt, pt);
			} else {
				return (Value) n.val;
			}
		} else {
			if (n.pt.y() < pt.y()) {
				return get(n.rt, pt);
			} else if ( n.pt.y() > pt.y()) {
				return get(n.lt, pt);
			} else {
				return (Value) n.val;
			}
		}
	}
	
	/*
	 * Does the tree contain point p?
	 *
	 * @params p -- point2D that we are looking at.
	 * @return true -- if the tree has the point.
	 *         false -- if the tree does not have the point.
	 * @throw nullPointerException if the params are null.
	 */
	private boolean contains(Point2D p) {
		if (p == null) {
			throw new NullPointerException();
		}
		
	    return get(p) != null;
	}
	
	/**
	 * All points in the symbol tree.
	 * 
	 * @return pts -- queue with all the points.
	 */
	public Iterable<Point2D> points() {
		// create new queues
		Queue<Point2D> pts = new Queue<>();
		Queue<Node> queue = new Queue<>();
		
		// add the root
		queue.enqueue(root);
		
		// iterator to get all the items
		while (!queue.isEmpty()) {
			Node n = queue.dequeue();
			
			if (n == null) continue;
			
			pts.enqueue(n.pt);
			queue.enqueue(n.lt);
			queue.enqueue(n.rt);
		}
		
		// return all the pts
		return pts;
	}
	
	/*
	 * All points that are inside the rectangle. 
	 * 
	 * @params rect -- rectangle we are looking at.
	 * @return rangePts -- all the points in the rectangle.
	 * @throw nullPointerException if the params are null.
	 */
	public Iterable<Point2D> range(RectHV rect) {
		// corner case
		if (rect == null) {
			throw new NullPointerException();
		}
		
		// make a queue to store the points
		Queue<Point2D> rangePts = new Queue<>();
		
		// call recursive helper method
		range(rect, rangePts, root);
		
		// return the queue
		return rangePts;
	}
	
	/*
	 * Helper method to have all points that are inside the rectangle. 
	 * 
	 * @params rect -- rectangle we are looking at.
	 *         rectPts -- where we will store the points.
	 *         node -- the current node we are looking at.
	 * @return rangePts -- all the points in the rectangle.
	 * @throw nullPointerException if the params are null.
	 */
	private void range(RectHV rect, Queue<Point2D> rectPts, Node node) {
		// corner case
		if (node == null || !rect.intersects(node.rect)) {
			return;
		}
		
		// see if the rectangle has the points
		if (rect.contains(node.pt)) {
			rectPts.enqueue(node.pt);
		}
		
		// check the neighbors
		range(rect, rectPts, node.lt);
		range(rect, rectPts, node.rt);
	}
	
	/*
	 * A nearest neighbor to point p.
	 * 
	 * @params pt -- point2D that we are looking at.
	 * @return a recursive helper function to find the neighbors.
	 * @throw nullPointerException if the params are null.
	 */
	public Point2D nearest(Point2D pt) {
		// corner case
		if (pt == null) {
			throw new NullPointerException();
		}
		
		// return the recursive helper method
		return nearest(pt, root, root.pt);
	}
	
	/*
	 * A recursive helper method to find the nearest neighbor to point p.
	 * 
	 * @params pt -- point2D that we are looking at.
	 *         n -- node we are currently on.
	 *         nearestPt -- nearest point so far.
	 * @return a recursive helper function to find the neighbors.
	 */
	private Point2D nearest(Point2D pt, Node n, Point2D nearestPt) {
		// if the root.pt is the nearest
		if (n == null || n.rect.distanceSquaredTo(pt) > nearestPt.distanceSquaredTo(pt)) {
			return nearestPt;
		}
		
		// conditions to find the nearest.
		if (pt.distanceSquaredTo(nearestPt) > pt.distanceSquaredTo(n.pt)) {
			nearestPt = n.pt;
		}
	
		
		if (root.lt != null && root.lt.rect.contains(pt)) {
			nearestPt = nearest(pt, n.lt, nearestPt);
			nearestPt = nearest(pt, n.rt, nearestPt);
		} else {
			nearestPt = nearest(pt, n.rt, nearestPt);
			nearestPt = nearest(pt, n.lt, nearestPt);
		}
		
		// return the nearest
		return nearestPt;
	}

	/*
	 * Unit testing of the methods and loading up the file.
	 */
	public static void main(String[] args) {
		 String filename = args[0];
	     In in = new In(filename);
	     KdTreeST<Integer> kdtree = new KdTreeST<Integer>();
	     for (int i = 0; !in.isEmpty(); i++) {
	    	 double x = in.readDouble();
	         double y = in.readDouble();
	         Point2D p = new Point2D(x, y);
	         kdtree.put(p, new Integer(i)); 
	     }     
	}
}