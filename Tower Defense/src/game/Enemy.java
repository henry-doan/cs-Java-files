package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Super class for all the enemy and have variables that all enemy should have.
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 17th, 2017
 */
abstract public class Enemy implements Animatable {
	
	// fields
	protected Path currentPath;
	protected GameState game;
	protected BufferedImage xWingImage;
	protected double percent;
	
	/** Constructor, This initialize the path and set the percent to 0 and have the game state be itself
     * 
     * @param pathname  to load in the path
     * @param game      game state that the object is in
     */
	
	public Enemy (String pathname, GameState game)
	{
		this.percent = 0;
		this.currentPath = ResourceLoader.getLoader().getPath(pathname);
		this.game = game;
	}
	
	/**
     * Draws the image associated with this enemy, centered on the enemy's
     * location on the path.  (Note:  It is up to the subclass to initialize
     * the image variable.)
     * 
     * @param g a graphics context
     */
	public void draw (Graphics2D g)
	{
        Point c = getLocation();
        
        g.drawImage(xWingImage,  c.x-xWingImage.getWidth()/2, c.y-xWingImage.getHeight()/2, null); 
	}
	
	/**
     * Returns the location of this enemy on the path.  The location is
     * returned in a Point object (x, y coordinates).
     * 
     * Caution:  The returned Point object is not directly used by this
     * enemy.  Changing it will not affect the enemy's location.
     * 
     * @return a Point object that corresponds to the location of this enemy
     */
	public Point getLocation ()
	{
		return currentPath.getPathPosition(percent);
	}
}
