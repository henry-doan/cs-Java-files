package game;

/**
 * A Class for a specific enemy that extends the enemy class
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 24th, 2017
 */
public class EnemyCargoShip extends Enemy {
	/** Constructor, This initialize the Image of the cargo ship and inherits all the game and position 
	 * variables.
     *     
     * @param game      game state that the object is in
     * @param position  position of the ship
     */
	EnemyCargoShip (String pathname, GameState game)
	{
		// Call the superclass constructor
		
	    super(pathname, game);
		
	    this.xWingImage = ResourceLoader.getLoader().getImage("Rebels-cargo.png");
	}
	
    /**
     * Adjusts the cargo ship position to advance it along the path a small amount.
     * This overrides the inherited method in the super class
     */
	public void update ()
	{
		// Advance the ship 0.1% (one thousandth the distance)
        //   along the path, and redraw the screen.
        
        percent += 0.003;
        
        if (percent >= 1)
        {
        	game.adjustLives(-1);
        	game.removeAnimatable(this);
        }
	}
}
