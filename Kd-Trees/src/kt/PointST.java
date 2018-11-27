package kt;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

public class PointST<Value> {
	// what all PointST have
	private RedBlackBST<Point2D, Value> rbbst;
	private int numOfPoints;
	
	/*
	 * Construct an empty symbol table of rbbst and the size.
	 */
	public PointST() {
		rbbst = new RedBlackBST<>();
		numOfPoints = rbbst.size();
	}
	
	/*
	 * Is the symbol table empty? 
	 * 
	 * @return true -- is empty
	 *         false -- is not empty
	 */
	public boolean isEmpty() {
		if (numOfPoints == 0) {
			return true;
		}
		
		return false;
	}
	 
	/*
	 * Return number of points 
	 * 
	 * @return numOfPoints -- the number of Points
	 */
	public int size() {
		return numOfPoints;
	}
	
	/*
	 * Associate the value val with point p
	 * 
	 * @params p -- point2D that we are looking at.
	 * 		   val -- the value of the point
	 * @throw nullPointerException if the params are null.
	 */
	public void put(Point2D p, Value val) {
		if(p == null || val == null) {
			throw new NullPointerException();
		}
		
		// use the bst helper method to input the p and the value
		rbbst.put(p, val);
	}    
	
	/*
	 * Value associated with point p 
	 * 
	 * @params p -- point2D that we are looking at.	 
	 * @return the value from the given point.
	 * @throw nullPointerException if the params are null.
	 */
	public Value get(Point2D p) {
		if (p == null) {
			throw new NullPointerException();
		}
		
		// use the bst helper method to receive a value from a point
		return rbbst.get(p);
	}
	
	/*
	 * Does the symbol table contain point p?
	 *
	 * @params p -- point2D that we are looking at.
	 * @return true -- if the table has the point.
	 *         false -- if the table does not have the point.
	 * @throw nullPointerException if the params are null.
	 */
	public boolean contains(Point2D p) {
		if (p == null) {
			throw new NullPointerException();
		}
		
		// use the bst helper method to check if the table has the point
		return rbbst.contains(p);
	}
	
	/*
	 * All points in the symbol table 
	 * 
	 * @return all the points in the table
	 */
	public Iterable<Point2D> points() {
		// use the bst helper method to return all the keys
		return rbbst.keys();
	}
	
	/*
	 * All points that are inside the rectangle 
	 * 
	 * return pts -- queue of all the pts in the rectangle
	 * @throw nullPointerException if the params are null
	 */
	public Iterable<Point2D> range(RectHV rect) {
		// corner case
		if (rect == null) {
			throw new NullPointerException();
		}
		
		// create a queue to store the pts
		Queue<Point2D> pts = new Queue<>();
		
		// look through all the points in the table
		for (Point2D pt : rbbst.keys()) {
			// see if there are any in the rectangle
			if (rect.contains(pt)) {
				// add it to queue
				pts.enqueue(pt);
			}
		}
		
		// return only the ones in the rectangle
		return pts;
	}
	
	/*
	 * A nearest neighbor to point p; null if the symbol table is empty 
	 * 
	 * @params p -- point2D that we are looking at.
	 * @return null -- if the table is empty.
	 * 		   neighbor -- the point closest to point p,
	 * @throw nullPointerException if the params are null.
	 */
	public Point2D nearest(Point2D p) {
		// corner cases
		if (p == null) {
			throw new NullPointerException();
		}
		
		if (rbbst.isEmpty()) {
			return null;
		}
		
		// Initially have a default distance and neighbor be the max of the table for now.
		double distance = rbbst.max().distanceTo(p);
		Point2D neighbor = rbbst.max();
		
		// look through all the points 
		for (int i = 0; i < numOfPoints; i++) {
			// see if the point is close to p
			if (rbbst.select(i).distanceTo(p) < distance) {
				// reset the distance and neighbor to what we found
				neighbor = rbbst.select(i);
				distance = neighbor.distanceTo(p);
			}
		}
		
		// return the closest point
		return neighbor;
	}
     
	/*
	 * Unit testing of the methods (not graded) 
	 */
	public static void main(String[] args) {
		
	}

}
