package lab4;

import java.awt.*;
import javax.swing.*;

/**
 * DrawingArea.java
 * 
 * This class represents the area where custom graphics can be drawn.
 */
public class DrawingArea extends JPanel {

	public void paintComponent(Graphics g) {
		drawHouse(g, 5, 50);
		int x = 5;
		int y = 50;
		int i = 0;
		while(i < 5) {
			drawHouse(g, x, y);
			x += 60;
			i++;
		}
	}
	
	public void drawHouse(Graphics g, int x, int y) {
		g.setColor(Color.RED);                  // Draw using red.
		g.drawRect(x, y, 50, 30);               // Draw a rectangle.
		g.drawRect(x + 25, 60, 10, 20);
		g.fillOval(x + 10, 10, 10, 10);
		g.drawLine(x, y, x + 25, y - 15);       // Draw first line of a triangle.
		g.drawLine(x + 25, y - 15, x + 50, y);
	}
}