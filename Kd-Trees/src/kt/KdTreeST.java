package kt;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTreeST<Value> {
	private Node root;
	private int size;
	
	private class Node {
		private Point2D pt;
		private RectHV rect;
		private Node rt, lt;
		private Value val;
		
		public Node(Point2D p, Value v, RectHV incomingRect) {
			pt = p;
			val = v;
			rect = incomingRect;
		}
	}
	
	public KdTreeST() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() { 
		return size == 0; 
	}
	
	public int size() { 
		return size; 
	}

	public void put(Point2D pt, Value val) {
		if (pt == null || val == null) {
		throw new NullPointerException();
	}
		root = put(null, root, pt, val, true);
	}
	
	private Node put(Node prev, Node n, Point2D pt, Value val, boolean isVt) {
		if (n == null) {
			size++;
			return new Node(pt, val, createRect(n, pt, isVt));
		}
		
		double com = ptcompare(n, pt, isVt);

		if (com < 0 ) {
			n.lt = put(n, n.lt, pt, val, !isVt);
		} else if (com > 0 ) {
			n.rt = put(n, n.rt, pt, val, !isVt);
		} else if (n.pt.equals(pt)) {
			n.val = val;
		} else {
			n.rt = put(n, n.rt, pt, val, !isVt);
		}
		
		return n;
	}
	
	private RectHV createRect(Node n, Point2D pt, boolean isVt) {
		double neg = -Double.MAX_VALUE;
		double pos = Double.MAX_VALUE;
		
		if (n == null) {
			return new RectHV(neg, neg, pos, pos);
		}
		
		double com = ptcompare(n, pt, !isVt);
		double rectXMin = n.rect.xmin();
		double rectXMax = n.rect.xmax();
		double rectYMin = n.rect.ymin();
		double rectYMax = n.rect.ymax();
		double y = n.pt.y();
		double x = n.pt.x();
		
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
		
		return null;
	}

	private double ptcompare(Node n, Point2D pt, boolean b) {
		if (b) {
			return pt.x() - n.pt.x();
		} else {
			return pt.y() - n.pt.y();
		}
	}

	public Value get(Point2D pt) {
		if (pt == null) {
			throw new NullPointerException();
		}
		
		return get(root, pt);
	}
	
	private Value get(Node n, Point2D pt) {
		if (n == null || pt == null) {
			throw new NullPointerException();
		}
		
		boolean horiz = false;
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
	
	private boolean contains(Point2D p) {
		if (p == null) {
			throw new NullPointerException();
		}
	    return get(p) != null;
	}
	
	/**
	 * all points in the symbol table
	 * 
	 * @return
	 */
	public Iterable<Point2D> points() {
		Queue<Point2D> pts = new Queue<>();
		Queue<Node> queue = new Queue<>();
		queue.enqueue(root);
		
		while (!queue.isEmpty()) {
			Node n = queue.dequeue();
			
			if (n == null) continue;
			
			pts.enqueue(n.pt);
			queue.enqueue(n.lt);
			queue.enqueue(n.rt);
		}
		
		return pts;
	}
	
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new NullPointerException();
		}
		
		Queue<Point2D> rangePts = new Queue<>();
		
		range(rect, rangePts, root);
		
		return rangePts;
	}
	
	private void range(RectHV rect, Queue<Point2D> rectPts, Node node) {
		if (node == null || !rect.intersects(node.rect)) {
			return;
		}
		
		if (rect.contains(node.pt)) {
			rectPts.enqueue(node.pt);
		}
		
		range(rect, rectPts, node.lt);
		range(rect, rectPts, node.rt);
	}
	
	public Point2D nearest(Point2D pt) {
		if (pt == null) {
			throw new NullPointerException();
		}
		
		return nearest(pt, root, root.pt);
	}
	
	private Point2D nearest(Point2D pt, Node n, Point2D nearestPt) {
		if (n == null || n.rect.distanceSquaredTo(pt) > nearestPt.distanceSquaredTo(pt)) {
			return nearestPt;
		}
		
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
		
		return nearestPt;
	}

	
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
