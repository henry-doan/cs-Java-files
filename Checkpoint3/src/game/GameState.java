package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/** 
 * This class is missing lots of contracts.  A wise student
 * will add them, as it will remind you about what each
 * method is for, and what it does.
 * 
 * @author Peter Jensen
 * @version April 12, 2017
 */
public class GameState
{
	private ResourceLoader loader;
	
	// Current mode (game over, playing, etc.)
	
	private boolean isGameOver, isPlaying;
	
    // Score, money, etc.
	
	private int credits, lives;
	
	// List of enemies, towers, etc.
	    
    private java.util.List<Animatable> active;
    private java.util.List<Animatable> expired;
    private java.util.List<Animatable> pending;
    
	// Mouse location / status

    private Point mouseLoc; 
    private boolean isButtonPressed;  // I renamed this variable in class to 'buttonActionPending'
                                      // For checkpoint 4, I also make sure to clear it at the end of the
                                      // game state update method.
    
    // Constructor
    
	public GameState ()
	{
        // Load resources
        
        loader = ResourceLoader.getLoader();
        
        // Make lists
        
        active  = new ArrayList<Animatable>();
        expired = new ArrayList<Animatable>();
        pending = new ArrayList<Animatable>();
        
        // Initialize the game.
        
        lives = 10;
        
        mouseLoc = new Point(0,0);
        
        // Initialize menu.
        
        active.add(new Backdrop());
        active.add(new SaltTowerMenuItem(this, new Point(700, 300)));
	}
	
	
	
	public void update ()
	{
		if (Math.random() < 0.05)
		{
			if (Math.random() < 0.1)
			   active.add(new EnemySCargo("path_2.txt", this));
			else
			   active.add(new EnemySnail("path_2.txt", this));
		}
		
		for (Animatable a : active)
			a.update();
		
		active.addAll(pending);
		pending.clear();
		
		active.removeAll(expired);
		expired.clear();
	}
	
	
	public void draw (Graphics2D g)
	{
		// Draw the menu / score / etc.
		
		g.setColor(Color.WHITE);
		g.fillRect(600,  0,  200,  600);
		
		g.setColor(Color.BLACK);
		g.drawString("Lives = " + lives, 650, 200);
		
        // Draw the Animatables
        
		for (Animatable a : active)
			a.draw(g);
        
	}
	
	// Helper methods for the other classes.
	
	public void adjustCredits (int amount)
	{
		credits += amount;
		
		if (credits < 0)
			credits = 0;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void adjustLives (int amount)
	{
		lives += amount;
		
		if (lives < 0)
			lives = 0;
	}
	
	public void removeAnimatable (Animatable expired)
	{
		this.expired.add(expired);
    }
	
	public void addAnimatable (Animatable a)
	{
		this.pending.add(a);  // Buggy
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
		// You'll need to write this code.
		
		return null;
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
