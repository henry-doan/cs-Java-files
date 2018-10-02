package lab11;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Rectangle objects represent a rectangle shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Henry Doan
 * @version Spring 2017
 */
public class Rect extends Shape {
	 // Instance variables.

 
    private int width, height;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param diameter
     *              the diameter of this circle
     *
     * @param color
     *             the color of this circle
     */
    public Rect (int x, int y, int width, int height, Color color)
    {
    	// Call the superclass constructor.  This must be the first statement
    	//   in this constructor.
    	super( x, y, color );
    	this.width = width;
    	this.height = height;
    }

   

    /**
     * Draws the Rectangle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
    	g.setColor (color);
    	g.drawRect(x, y, width, height);
    	g.fillRect(x, y, width, height);
    }  
    
    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the shape
     */
    public boolean isInside (int targetX, int targetY)
    {
    	
    	// Make sure the distance from the click to the center is less
    	//   than the radius.  (Notice how I avoid a square root.)
    	
    	return targetX >= x &&
    		       targetX < x + width &&
    		       targetY >= y &&
    		       targetY < y + height;
    }

}
