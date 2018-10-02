package game;

import java.awt.Point;

/**
 * A Class for a specific turrent Tower that extends the tower class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 23th, 2017
 */
public class RapidTower extends Tower {
	
	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the turret tower
     */
	public RapidTower(GameState game, Point p) {
		super(game, p);
		this.image = ResourceLoader.getLoader().getImage("Rocket_Turret_Lvl_3_-_Imperial.png");
	}
	
	/**
     * Update - called once a frame on active effects.
     * the tower will find the nearest enemy with a helper method and if there is no enemy then do nothing
     * if there is and the enemy is in range then do the laser effect and remove the enemy and add money to
     * the total.
     * 
     * This overrides the inherited method in the super class
     */
	@Override
	public void update()
	{
		// helper method to find nearest enemy at the towers position
		Enemy c = game.findNearestEnemy(position);
		
        if (c == null)
            return;
        
    	// laser effect to have the laser reach the enemy from the tower
        if (c.getLocation().distance(position) < 50) {
        	game.addAnimatable(new LaserSmoke(game, position, c.getLocation().x - position.x, c.getLocation().y - position.y));
        	game.removeAnimatable(c);
        	game.adjustMoney(30);
        }
    }
}
