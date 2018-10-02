package game;

import java.awt.Point;

/**
 * A class that will have the Turret tower on the menu and extends effect class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */
public class TurrentTowerMenuItem extends Effect{
	
	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turret tower on the menu
     */
	public TurrentTowerMenuItem (GameState game, Point position)
	{
		super(game, position);
		
		image = ResourceLoader.getLoader().getImage("Rapid_Turret_Lvl_1_-_Imperial.png");
	}
	
    /**
     * Update -
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
        	game.addAnimatable(new TowerMoving(game, position));
        	game.clearMousePressed();
        }
        		
	}

}
