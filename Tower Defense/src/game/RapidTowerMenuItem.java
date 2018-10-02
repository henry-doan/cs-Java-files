package game;

import java.awt.Point;

/**
 * A class that will have the Turret tower on the menu 
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */

public class RapidTowerMenuItem extends Effect{
	
	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turrent tower on the menu
     */
	public RapidTowerMenuItem (GameState game, Point position)
	{
		super(game, position);
		
		image = ResourceLoader.getLoader().getImage("Rocket_Turret_Lvl_3_-_Imperial.png");
	}
	
	 /**
     * Update - called once a frame on active effects.
     * when the mouse presses in range of the image, the tower with be moving with another class and added the object
     * to and animatable list and then release and clear the mouse click
     * 
     * This overrides the inherited method in the super class
     */
	@Override
	public void update()
	{
		if (game.getMousePressed() && game.getMousePos().distance(position) < 10)
        {
        	game.addAnimatable(new RapidTowerMoving(game, position));
        	game.clearMousePressed();
        }	
	}

}
