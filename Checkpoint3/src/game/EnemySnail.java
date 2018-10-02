package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class EnemySnail extends Enemy
{	
    /** Constructor - contract needed.  
     *     (What does the constructor set up?  This contract, provided by the
     *     student, may be short, but it should clearly describe how the
     *     new object is set up (or configured).
     *     
     * @param game      What is this for?
     * @param position  What is this for?
     */
    EnemySnail (String pathname, GameState game)
	{
		// Call the superclass constructor
		
		super(pathname, game);
		
	    this.image = ResourceLoader.getLoader().getImage("snail.png");
	}
	
    /**
     * Adjusts the snail's position to advance it along the path a small amount.
     */
	public void update ()
	{
		// Advance the circle 0.1% (one thousandth the distance)
        //   along the path, and redraw the screen.
        
        percentage += 0.001;
        
        if (percentage >= 1)
        {
        	game.adjustLives(-1);
        	game.removeAnimatable(this);
        }
	}
	
	
}
