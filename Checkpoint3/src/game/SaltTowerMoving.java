package game;

import java.awt.Point;

/**
 * Represents a salt tower that the user is moving with the mouse.
 * 
 * @author Peter Jensen
 * @version April 18, 2017
 */
public class SaltTowerMoving extends Effect
{

    /** Constructor - contract needed.  
     *     (What does the constructor set up?  This contract, provided by the
     *     student, may be short, but it should clearly describe how the
     *     new object is set up (or configured).
     *     
     * @param game      What is this for?
     * @param position  What is this for?
     */
    public SaltTowerMoving (GameState game, Point position)
	{
		super(game, position);
		
		image = ResourceLoader.getLoader().getImage("salt.png");
	}
	
    /**
     * Update - called once a frame on active effects.
     * (Detail needed - students should breifly descrive the behavior
     * of this type of object.)
     */
	@Override
	public void update()
	{
		position = game.getMousePos();
		
		if (game.getMousePressed())
		{
			game.addAnimatable(new SaltTower(game, position));
			game.removeAnimatable(this);
			game.clearMousePressed();
		}
		
	}

}
