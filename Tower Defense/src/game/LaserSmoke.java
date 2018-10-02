package game;

import java.awt.Point;

/**
 * A class that will have the the laser smoke effect when shooting and extends effect class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 24th, 2017
 */
public class LaserSmoke extends Effect{

	/** Constructor, This initialize the Image of the turret tower and inherits all the game and position 
	 * variables. This also sets the frame to 0
     *     
     * @param game      game state that the object is in
     * @param position  position of the smoke
     * @param deltaVX   the velocity of the x point
     * @param deltaVY   the velocity of the y point
     */
	public LaserSmoke(GameState game, Point position, int deltaVX, int deltaVY) {
		super(game, position);
		
		this.image = ResourceLoader.getLoader().getImage("LaserSmoke.png");	
		this.velocityX = deltaVX;
		this.velocityY = deltaVY;
		this.framecounter = 0;
	}

	/**
     * Update 
     * increment the counter by one and if it is 30 then remove the smoke  and if it is still counting than do nothing
     * 
     * This overrides the inherited method in the super class
     */
	@Override
	public void update() {
		framecounter++;
		
		if(framecounter == 30) {
			game.removeAnimatable(this);
		}
		
		if(framecounter % 30 != 0)
			return;
	}

}
