package game;

import java.awt.Point;

public class SaltTower extends Tower
{

    /** Constructor - contract needed.  
     *     (What does the constructor set up?  This contract, provided by the
     *     student, may be short, but it should clearly describe how the
     *     new object is set up (or configured).
     *     
     * @param game      What is this for?
     * @param position  What is this for?
     */public SaltTower (GameState game, Point p)
	{
		super(game, p);
		
		this.image = ResourceLoader.getLoader().getImage("salt.png");
	}
	
    /**
     * Update - called once a frame on active effects.
     * (Detail needed - students should breifly descrive the behavior
     * of this type of object.)
     */
	@Override
	public void update()
	{
        Enemy c = game.findNearestEnemy(position);
        if (c == null)
            return;
        
        if (c.getLocation().distance(position) < 50)
        	System.out.println("Enemy nearby");
	}

}
