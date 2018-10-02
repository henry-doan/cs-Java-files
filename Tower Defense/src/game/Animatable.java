package game;

import java.awt.Graphics2D;

/**
 * Have an interface for Animatable and has all of the methods that other classes should inherit from.
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 17th, 2017
 */

public interface Animatable {
	public void update();

	public void draw(Graphics2D g);

}
