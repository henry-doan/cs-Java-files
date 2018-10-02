package game;

import java.awt.Point;

/**
 * A Class for a specific to move from the menu to the field that extends the effect class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */

public class TowerMoving extends Effect{
	
	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turret tower on the mouse
     */
    public TowerMoving (GameState game, Point position)
	{
		super(game, position);
		
		image = ResourceLoader.getLoader().getImage("Rapid_Turret_Lvl_1_-_Imperial.png");
	}
	
    /**
     * Update - 
     * the tower be on the mouse and then drop at the mouse release.
     * 
     * This overrides the inherited method in the super class
     */
	@Override
	public void update()
	{
		// to get the mouse position
		position = game.getMousePos();
		
		// if it is placed then place the tower and not follow the mouse and reset the mouse pressed
		if (game.getMousePressed())
		{
			game.addAnimatable(new TurrentTower(game, position));
			game.removeAnimatable(this);
			game.clearMousePressed();
		}
		
	}

}
