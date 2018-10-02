/**
 * 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * An application for testing the PathPoints class and the
 * PathPosition class.  The path is drawn on the screen, and
 * a ball follows along on the path.
 * 
 * @author Peter Jensen and Henry Doan with partner of Tom Nguyen
 * @version April 24th, 2017
 */
public class GameState {

	// Current mode (game over, playing, etc.)
	private boolean isGameOver, isPlaying;
	private int money, lives;
		
	// List of enemies, towers, etc.
	private double enemyAdvancement;
	private Tower currentTower;
	
	// Mouse location / status
    private Point mouseLoc; 
    private boolean isButtonPressed;
	
	// the background image
    private BufferedImage backdrop; 
   
    // game over image
    private BufferedImage GameOver;
    
    // path
    private Path towerDefensePath;
   
    // resource loader
    private ResourceLoader loader;
    
    // get image from folders
 	private BufferedImage xWing;
 	private BufferedImage TowerImage;
 	
 	// make list
 	private java.util.List<Animatable> active;
    private java.util.List<Animatable> expired;
    private java.util.List<Animatable> pending;
 	
    /**
     * Initializes the state.
     */
    public GameState() {
    	loader = ResourceLoader.getLoader();
    	
    	// load path
    	backdrop = loader.getImage("path2.png");
    	
    	// load game over pic
    	GameOver = loader.getImage("game_over.png");
    	
    	// Load enemy
    	xWing = loader.getImage("X-Wing.png");
    	    	
    	towerDefensePath = loader.getPath("path_2.txt");
    	
    	 // Assume the circle has traveled 0% along the path.
    	enemyAdvancement = 0.0;
    	
    	// List to store the Animatable
        active  = new ArrayList<Animatable>();
        expired = new ArrayList<Animatable>();
        pending = new ArrayList<Animatable>();


		// Initialize variables
		money = 100;
		lives = 10;
		mouseLoc = new Point(0,0);
		
		currentTower = null;
		
		// add the tower icons on the menu
		active.add(new TurrentTowerMenuItem(this, new Point(700, 300)));
		active.add(new RapidTowerMenuItem(this, new Point(700, 450)));
    }
    
    /**
     * Updating the path and lists
     */
    public void update() {
    	if (Math.random() < 0.005)
		{
    		// spawn the cargo ship
			if (Math.random() < 0.1)
			   active.add(new EnemyCargoShip("path_2.txt", this));
			else
				// spawn the x wing
			   active.add(new EnemyXWing("path_2.txt", this));
		}

    	// update the active object list
		for (Animatable a : active)
			a.update();
		
		// add and remove object from the list
		active.addAll(pending);
		pending.clear();
		
		active.removeAll(expired);
		expired.clear();
    }
    
	/**
     * Draws the image, path, and the animating ball.
     * 
     * (The background is not cleared, it is assumed the backdrop
     * fills the panel.)
     * 
     * @param g the graphics object for drawing on this panel
     */
    public void draw (Graphics2D g)
    {
        // Draw the background.
    	g.drawImage(backdrop,  0, 0, null);  
    	
    	// draw menu area
    	g.setColor(Color.WHITE);
   		g.fillRect(600, 0, 600, 600);
   	
		g.setColor(Color.BLUE);
		g.drawString("Lives: " + lives, 600, 100);
		g.drawString("Current Credit: " + money, 600, 200);
   		
    	// this will draw the image of the enemy
		for (Animatable a : active)
			a.draw(g);
    }
    
    /**
     *  return the backdrop width
     *  
     * @return the width of the backdrop
     */ 
    public int getBackgroundWidth() {
    	return backdrop.getWidth();
    }
    
    /**
     *  return the backdrop height
     *  
     * @return the height of the backdrop
     */ 
    public int getBackgroundHeight() {
    	return backdrop.getHeight();
    }

    /**
     *  remove the object from the Array list
     * 
     * @param temp a animatable object that is going to be moved in the expired list
     */ 
    public void removeAnimatable(Animatable temp) {
		this.expired.add(temp);
	}

    /**
     *  Add the object to the Array list
     * 
     * @param add a animatable object that is going to be add in the pending list
     */ 
	public void addAnimatable(Animatable add) {
		this.pending.add(add);
	}

	 /**
     *  adjust the money accordingly
     * 
     * @param change a number to adjust the money
     */ 
	public void adjustMoney(int change) {
		money += change;
		if (money < 0)
			money = 0;
	}

	 /**
     *  getter of the gameover boolean
     * 
     */
	public boolean isGameOverYet() {
		return isGameOver;
	}
	
	 /**
     *  adjust the Lives points accordingly
     *  @param change a number to adjust the lives
     */ 
	public void adjustLives(int change) {
		// add the change to the lives
		lives += change;
		if (lives <= 0) {
			// change game over to true
			isGameOver = true;
			
			// set lives to 0
			lives = 0;
		}
	}
	
	/**
	 * Draws the Gameover image
	 * 
	 * @param g a graphics 2d parameter
	 */
	 public void drawGO (Graphics2D g) {
		 g.drawImage(GameOver,  0, 0, null);
	 }
	
	/**
	 * Finds the enemy on the path that is closest to
	 * the point p.  If no enemies exist, null is returned.
	 * 
	 * @param p
	 * @return the nearest enemy, or null
	 */
	public Enemy findNearestEnemy(Point p)
	{
		Enemy closest = null;
		for(Animatable a: active)
			if(a instanceof Enemy) {
				Enemy e = (Enemy)a;
				if(closest == null){
					closest = e;
				} else if (e.getLocation().distance(p) < closest.getLocation().distance(p)) {
					closest = e;
				}
			}
		return closest;
	}
	
	public void  setMousePos (Point p)
	{
		mouseLoc = p;
	}
	
	public Point getMousePos()
    {
	    return mouseLoc;	
	}
	
	public void  setMousePressed  ()
    {
		isButtonPressed = true;
	}
	
	public void  clearMousePressed ()
    {
		isButtonPressed = false;	
	}
	
	public boolean getMousePressed ()
    {
		return isButtonPressed;
	}	

}
