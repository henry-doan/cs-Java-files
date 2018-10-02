package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Super class for all the towers and have variables that all towers should have.
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */
public abstract class Tower implements Animatable {
	
	protected Point position;
	protected BufferedImage image;
	protected GameState game;
	
	/** Constructor, This initialize and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turret tower 
     */ 
	public Tower (GameState game, Point position)
	{
		this.game = game;
		this.position = position;
	}
	
	/**
     * Draws the image associated with this tower, centered on the tower's
     * location.  (Note:  It is up to the subclass to initialize the image
     * variable.)
     * 
     * @param g a graphics context
     */
	public void draw (Graphics2D g)
	{
        Point c = getLocation();
        
        g.drawImage(image, c.x-image.getWidth()/2, c.y-image.getHeight()/2, null); 
	}
	
	
	/**
     * Returns the location of this tower.
     * 
     * Caution:  The returned Point object may / may not be stored
     * in this tower object.  The caller should not change the contents of the
     * returned Point object.
     * 
     * @return a Point object that corresponds to the location of this tower
     */
	public Point getLocation ()
	{
		return position;
	}
}