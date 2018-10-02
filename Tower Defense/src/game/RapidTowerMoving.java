package game;

import java.awt.Point;

/**
 * A Class for a specific to move from the menu to the field that extends the effect class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */

public class RapidTowerMoving extends Effect{
	 
	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turret tower on the mouse
     */
	
    public RapidTowerMoving (GameState game, Point position)
	{
		super(game, position);
		
		image = ResourceLoader.getLoader().getImage("Rocket_Turret_Lvl_3_-_Imperial.png");
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
			game.addAnimatable(new RapidTower(game, position));
			game.removeAnimatable(this);
			game.clearMousePressed();
		}
		
	}

}
