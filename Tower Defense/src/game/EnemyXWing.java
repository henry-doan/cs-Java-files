package game;

import java.awt.Point;

/**
 * A Class for a specific enemy that extends the enemy class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 17th, 2017
 */

public class EnemyXWing extends Enemy {
	
	/** Constructor, This initialize the Image of the x wing and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the ship
     */
	public EnemyXWing(String pathname, GameState game) {
		super(pathname, game);
		this.xWingImage = new ResourceLoader().getImage("X-Wing.png");
		
		// have the x wing start at 0 percents .
		percent = 0.0;
	}
	
	/**
	 * update method of what changes to the game state 
	 * 
	 * The percentage of the Accerlation
	 * 
	 * to adjust the lives and remove it from 
	 * 
	 * This overrides the inherited method in the super class
	 */
	@Override
	public void update() {
		percent += 0.0007;
		
		if (percent >= 1.0) {
			game.adjustLives(-1);
			game.removeAnimatable(this);
			percent = 0;
		}
	}

	/**
	 * Get a location of what percent the of the enemy on the path it is.
	 * 
	 * This overrides the inherited method in the super class
	 */
	@Override
	public Point getLocation() {
		this.update();
		return currentPath.getPathPosition(percent);
	}

}
