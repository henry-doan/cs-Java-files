package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Super class for all the effect and have variables that all effect should have.
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 24th, 2017
 */
abstract public class Effect implements Animatable
{
	// Fields
    protected Point position;
	protected BufferedImage image;
	protected GameState game;
	protected int framecounter;
	protected int velocityX, velocityY;
	
	/** Constructor, This initialize the game and position of all effect
     * 
     * @param game      game state that the object is in
     * @param position  the location of the effect started
     */
	public Effect (GameState game, Point position)
	{
		this.game = game;
		this.position = position;
		
	}
	
	/**
	 * Draws the image associated with this effect, centered on the effect's
	 * location.  (Note:  It is up to the subclass to initialize the image
	 * variable.)
	 * 
	 * @param g a graphics context
	 */
	public void draw (Graphics2D g)
	{
        Point c = getLocation();
        
        g.drawImage(image,  c.x-image.getWidth()/2, c.y-image.getHeight()/2, null); 
	}
	
	/**
	 * Returns the location of this effect.
	 * 
	 * Caution:  The returned Point object may / may not be stored
	 * in this effect.  The caller should not change the contents of the
	 * returned Point object.
	 * 
	 * @return a Point object that corresponds to the location of this effect
	 */
	public Point getLocation ()
	{
		return position;
	}
	
}
