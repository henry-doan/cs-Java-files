package assignment06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;


/**
 * This class shows the behavior of each elements in the animation.
 * These are three fishes and a octopus swimming around.
 * 
 * The numbers
 * are just guess for what looks like and there is a pattern for some shapes
 * but are then changed to look right. This goes for all fishes below.
 *
 * @author  Henry Doan
 * @version March  10th, 2017
 */

public class Animation {

	/**
	 * This is the method shows the movement of each elements in the animation.
	 * 
	 * The elements have a set position in their own methods and then in this
	 * method is where it moves and characteristics. the fishes goes from left
	 * to right and right to left, but at different speed by dividing the initial x value by
	 * various numbers a higher number is a slower movement speed while the
	 * lowest value is the faster movements.
	 * 
	 * @param g Graphics object on which to draw
	 * @param t Number of milliseconds that have passed since animation started, represents the time
	 * @param height the starting point in the y axis
	 * @param width the starting point in the x axis
	 */

	public static void paintFrame(Graphics g, int t, int height, int width) {
		
		// as time is 1 minute
		if (t < 10000) {
			// having the fishes go in a pattern
			drawFish1(g, 0 + t / 5, 0 + (int) (50 * Math.sin(t * Math.PI / 1000)), 0 + t / 2000, Color.ORANGE);
			drawFish2(g, 0 - t / 20, 0 + (int) (50 * Math.cos(t * Math.PI / 1000)), 0 + t / 2000, Color.BLUE);
			drawFish3(g, 0 + t / 5, 0, 0, Color.ORANGE);
			drawOctopus(g, 0 - t / 3, 0 + (int) (50 * Math.tan(t * Math.PI / 1000)), 0 + t / 2000, Color.RED);
		}

	}

	/**
	 * This is the method draws the first fist starting from the right with
	 * specific positions of each element. This draws the entire fish. The numbers
	 * are just guess for what looks like and there is a pattern for some shapes
	 * but are then changed to look right. This goes for all fishes below.
	 * 
	 * @param g Graphics object on which to draw
	 * @param int x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color Color is the color that is all of the methods elements.
	 */

	public static void drawFish1(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 90, y + 50, 130, 80); // Draws the body	
		
		g.setColor(Color.BLACK);
		g.drawOval(x + 90, y + 50, 130, 80); // Outline body
		
		g.setColor(color);
		Polygon tail = new Polygon(); // Draws tail
        tail.addPoint(x + 90 - 130 / 2 , y + 50);
        tail.addPoint(x + 90 - 130 / 2 , y +  50 + 80 );
        tail.addPoint(x + 90, y + 50 + 80 / 2 );
        g.fillPolygon(tail);
        
        g.setColor(Color.black); // outline tail
        g.drawPolygon(tail);
       
        
        g.setColor(Color.black);
        g.fillOval(x + 90 + 130/2 + 130/5, y + (50 + 80/3), 80/5, 80/5); // draw the eyes
        
        g.setColor(Color.WHITE);
        Graphics2D g2 = (Graphics2D) g; // thickness of lines
        g2.setStroke(new BasicStroke(12));
        g.drawLine(x + 170, y + 58, x + 170, y + 122); // draws the stripes
       
        g2.setStroke(new BasicStroke(12));
        g.drawLine(x + 140, y + 58, x + 140, y + 122);
        
	}

	/**
	 * This is the method draws the Second person starting from the right with
	 * specific positions of each element. Since this is a object that is lower
	 * than the first object, the y value has increase for all elements to be
	 * lower than the first fish but it is set higher to move it to the left.
	 * Then all of the elements that made up the fish is a little different than 
	 * the first person.
	 * 
	 * @param g Graphics object on which to draw
	 * @param int x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color Color is the color that is all of the methods elements.
	 */

	public static void drawFish2(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 750, y + 250, 130, 80); // Draws the body	
		
		g.setColor(Color.BLACK);
		g.drawOval(x + 750, y + 250, 130, 80); // Outline body
		
		g.setColor(Color.YELLOW);
		Polygon tail = new Polygon(); // Draws tail
        tail.addPoint(x + 1025 - 130 / 2 , y + 250);
        tail.addPoint(x + 1025 - 130 / 2 , y +  250 + 80 );
        tail.addPoint(x + 890, y + 250 + 80 / 2 );
        g.fillPolygon(tail);
        
        g.setColor(Color.black); // outline tail
        g.drawPolygon(tail);
       
        
        g.setColor(Color.black);
        g.fillOval(x + 675 + 130/2 + 130/5, y + (250 + 80/3), 80/5, 80/5); // draw the eyes
		
	}

	/**
	 * This is the method draws the Third fish starting from the lowest point of the window
	 * and this model is like the first fish but smaller.
	 * 
	 * @param g Graphics object on which to draw
	 * @param int x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double scale is the size increase or decrease in the method and
	 *           	 elements.
	 * @param Color Color is the color that is all of the methods elements.
	 */

	public static void drawFish3(Graphics g, int x, int y, double scale, Color color) {
		g.setColor(color);
		g.fillOval(x + 90, y + 400, 100, 50); // Draws the body	
		
		g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g; // thickness of lines
        g2.setStroke(new BasicStroke(2));
		g.drawOval(x + 90, y + 400, 100, 50); // Outline body
		
		g.setColor(color);
		Polygon tail = new Polygon(); // Draws tail
        tail.addPoint(x + 90 - 100 / 2 , y + 400);
        tail.addPoint(x + 90 - 100 / 2 , y +  400 + 50 );
        tail.addPoint(x + 90, y + 400 + 50 / 2 );
        g.fillPolygon(tail);
        
        g.setColor(Color.black); // outline tail
        g2.setStroke(new BasicStroke(2));
        g.drawPolygon(tail);
       
        
        g.setColor(Color.black);
        g.fillOval(x + 90 + 100/2 + 100/5, y + (400 + 50/3), 50/5, 50/5); // draw the eyes
        
        g.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(10)); // draws the strips 
        g.drawLine(x + 150, y + 405, x + 150, y + 445); 
       
        g2.setStroke(new BasicStroke(12));
        g.drawLine(x + 120, y + 405, x + 120, y + 445);
	}

	/**
	 * This is the method draws multiple oval in shape of circles, and have the
	 * ability to manipulate the size and in this case it is growing but having
	 * the scale be added on to the origin size and multiple it as the times
	 * goes.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param int
	 *            x is a number representing the value of the x, from left to
	 *            right positioning
	 * @param int
	 *            y is a number representing the value of the y, from top to
	 *            bottom positioning
	 * @param double
	 *            scale is the size increase or decrease in the method and
	 *            elements.
	 * @param Color
	 *            Color is the color that is all of the methods elements.
	 */
	public static void drawOctopus(Graphics g, double x, double y, double scale, Color color) {
		g.setColor(color);
		g.fillOval((int) x + 800, 450 + (int) y, 80, 50); // bottom body
		g.fillOval((int) x + 800, 410 + (int) y, 80, 80); // top body
		
		g.setColor(Color.black);
        g.fillOval((int)(x + 780 + 100/2 + 100/5), (int)(y + (450 + 50/3)), 50/5, 50/5); // Right the eyes
       
        g.fillOval((int)(x + 750 + 100/2 + 100/5), (int)(y + (450 + 50/3)), 50/5, 50/5); // draw the eyes
        
        Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.black);
        g2.setStroke(new BasicStroke(10)); // thickness of lines
        
        g.setColor(color);
        
        
        // This draws all of the tentacles but different transformation of the shape 
        for(double l = -100; l <= -5; l = l + 0.5)
        {
            double w = 50 * Math.sin(l*(3.1415926/180));
            int Y = (int)w;
            int X = (int)l;
            g.drawLine( (int) x + 810 + X, (int) y + 485 - Y, (int) x + 810 + X, (int) y + 485 - Y);
        }
        
        for(double l = -100; l <= -5; l = l + 0.5)
        {
            double w = 50 * Math.sin(l*(3.1415926/80));
            int Y = (int)w;
            int X = (int)l;
            g.drawLine( (int) x + 830 + X, (int) y + 485 - Y, (int) x + 830 + X, (int) y + 485 - Y);
        }
       
        for(double l = -100; l <= -5; l = l + 0.5)
        {
            double w = 50 * Math.sin(l*(3.1415926/180));
            int Y = (int)w;
            int X = (int)l;
            g.drawLine((int) x + 870 - X, (int) y + 485 - Y,(int) x + 870 - X, (int) y + 485 - Y);
         
        }
        
        for(double l = -100; l <= -5; l = l + 0.5)
        {
            double w = 50 * Math.sin(l*(3.1415926/80));
            int Y = (int)w;
            int X = (int)l;
            g.drawLine((int) x + 850 - X, (int) y + 485 - Y, (int) x + 850 - X, (int) y + 485 - Y);
         
        }
        
	}

}

