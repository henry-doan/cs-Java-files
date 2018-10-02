package game;
import java.util.List;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Path class to draw the class and the percentage of the completionof the path
 * 
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version March 30, 2017
 */

public class Path {
	private List<Point> pathCoordinates;
	
	/** This constructor does the following:
     *     - It creates a new array (or ArrayList) to hold the path coordinates,
     *          and stores it in the path variable.
     *     - It reads a number of coordinates, n, from the scanner.
     *     - It loops n times, each time scanning a coordinate x,y pair, creating an
     *         object to represent the coordinate, and storing the coordinate object in the path.
     * 
     * @param s  a Scanner set up by the caller to provide a list of coordinates
     */
	public Path(Scanner s) {
	    pathCoordinates = new ArrayList<Point>();
	    int count = s.nextInt();
	    
	    for (int i = 0; i < count; i++) { 
	      int x = s.nextInt();
	      int y = s.nextInt();
	      Point points = new Point(x , y);
	      pathCoordinates.add(points);
	    }
	    
	}

    /**
      * Draws the current path to the screen (to wherever the graphics object points)
      * using a highly-visible color.
      * 
      * @param g   a graphics object
      */  
  
	 public void drawPath(Graphics g)
	  {
	    g.setColor(Color.RED);
	    
    	Graphics2D g2 = (Graphics2D) g; // thickness of lines
    	g2.setStroke(new BasicStroke(6));
    	
	    for (int i = 1; i < pathCoordinates.size() - 1 ; i++) {
	    	// Draws the line
	    	g.drawLine((int) pathCoordinates.get(i).getX() , (int) pathCoordinates.get(i).getY() , (int) pathCoordinates.get(i + 1).getX(), (int) pathCoordinates.get(i + 1 ).getY());
	    }
	  }
	 
	 /** 
	  * Returns the total length of the path. Since the path
	  * is specified using screen coordinates, the length is
	  * in pixel units (by default).
	  * 
	  * @return the length of the path
	  */
	  public double getPathLength() {
		  double totalLength = 0.0;
		  double lineLength = 0.0;
		    
		  for (int i = 1; i < pathCoordinates.size() - 1; i++) {
			  
			  double x1 = pathCoordinates.get(i).getX();
			  double y1 = pathCoordinates.get(i).getY();
			  double x2 = pathCoordinates.get(i +1).getX();
			  double y2 = pathCoordinates.get(i + 1).getY();
			  
			  lineLength = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
			  totalLength += lineLength;
		  }
		  return totalLength;
	  }
	  
	  /** 
	   * Given a percentage between 0% and 100%, this method calculates
	   * the location along the path that is exactly this percentage
	   * along the path. The location is returned in a Point object
	   * (int x and y), and the location is a screen coordinate.
	   * 
	   * If the percentage is less than 0%, the starting position is
	   * returned. If the percentage is greater than 100%, the final
	   * position is returned.
	   * 
	   * If students don't want to use Point objects, they may 
	   * write or use another object to represent coordinates. 
	   *
	   * Caution: Students should never directly return a Point object
	   * from a path list. It could be changed by the outside caller.
	   * Instead, always create and return new point objects as
	   * the result from this method.
	   * 
	   * @param percentTraveled a distance along the path
	   * @return the screen coordinate of this position along the path
	   */
	   public Point getPathPosition (double percentTraveled) {
		   
		   if (percentTraveled <= 0.0) {
			   return new Point((Point)pathCoordinates.get(0));
		   }
		   
		   if (percentTraveled >= 1.0) {
			   return new Point((Point)pathCoordinates.get(pathCoordinates.size() - 1));
		   }
		   
		    
		   double distanceLeft = getPathLength() * percentTraveled;

		   double lineLength = 0.0;
		   Point lineStart = null;
		   Point lineEnd = (Point)pathCoordinates.get(0);
		    
		   
		   for (int i = 1; i < pathCoordinates.size(); i++) {
			   Point currentPoint =  pathCoordinates.get(i);
			   lineStart = lineEnd;
			   lineEnd = currentPoint;
			   lineLength = lineStart.distance(lineEnd);
		      
			   // when finished
			   if (lineLength >= distanceLeft) {
				   break;
			   }
		    	
			   // subtract the distance traveled from the line length
			   distanceLeft -= lineLength;
		   }

		   double percentage = distanceLeft / lineLength;

		   int x = (int)Math.round((1.0 - percentage) * (int)lineStart.getX() + ((int)distanceLeft / (int)(100.0 * lineLength) + percentage) * (int)lineStart.getX());
		   int y = (int)Math.round((1.0D - percentage) * (int)lineStart.getY() + ((int)distanceLeft / (int)(100.0 * lineLength) + percentage) * (int)lineStart.getY());

		   return new Point(x, y);
	}
}
