package kt;

public class PointST<Value> {
	private int numOfPoints;
	
	/*
	 * Construct an empty symbol table of points.
	 * 
	 */
	public PointST() {
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
	 */
	public void put(Point2D p, Value val) {
		
	}    
	
	/*
	 * Value associated with point p 
	 */
	public Value get(Point2D p) {
	}
	
	/*
	 * Does the symbol table contain point p?
	 */
	public boolean contains(Point2D p) {
	
	}
	
	/*
	 * All points in the symbol table 
	 */
	public Iterable<Point2D> points() {
 
	}
	
	/*
	 * All points that are inside the rectangle 
	 */
	public Iterable<Point2D> range(RectHV rect) {
		
	}
	
	/*
	 * A nearest neighbor to point p; null if the symbol table is empty 
	 */
	public Point2D nearest(Point2D p) {
		
	}
     
	/*
	 * Unit testing of the methods (not graded) 
	 */
	public static void main(String[] args) {

	}

}
