package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A path test panel is a GUI panel that displays a tower
 * defense path on the screen, and animates a small object
 * moving along the path.
 * 
 * @author Peter Jensen and Henry Doan with partner of Tom Nguyen
 * @version March 22, 2017  (Update this)
 */
public class TowerDefense extends JPanel implements ActionListener, Runnable, MouseListener, MouseMotionListener 
{
   
    private static final long serialVersionUID = 42L;
  
    private Timer animationTimer;
    private GameState game;
    
    public TowerDefense ()
    {
        
    }
    
    public static void main (String[] args)
    {
        TowerDefense TD = new TowerDefense();
        
        TD.run();
    }
    
    /**
     * Builds the GUI for this application.  This method must
     * only be called/executed by the GUI thread. 
     */
    public void run ()
    {
        JFrame f = new JFrame("Star Wars TD");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setContentPane(this);
        
        game = new GameState();
        
        Dimension panelSize = new Dimension(game.getBackgroundWidth() + 200, game.getBackgroundHeight());
        
        this.setMinimumSize(panelSize);
        this.setPreferredSize(panelSize);
        this.setMaximumSize(panelSize);
        
        animationTimer = new Timer(10, this);
        animationTimer.start();
        
        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    /**
     * Draws the image, path, and the animating enemies by referring to the game draw method.
     * 
     * @param g the graphics object for drawing on this panel
     */
    public void paint (Graphics g)
    {
        game.draw((Graphics2D)g);
        // if the game is over then throw the game over image over the backdrop
        if (game.isGameOverYet())
        	game.drawGO((Graphics2D)g);
    }
    
    /**
     * The actionPerformed method is called (from the GUI event loop)
     * whenever an action event occurs that this object is listening to.
     * 
     * For our test panel, we assume that the Timer has expired, so
     * we advance our small sphere along the path.
     * 
     * @param e the event object 
     */
    public void actionPerformed (ActionEvent e)
    {
      // calls the update
        game.update();
        repaint();
    }
    
    /** 
     * The mousePressed event is called when a mouse button is first pressed.
     * If the click is a left-button, a point is added to the path.  If the
     * click is a right-button, a point is removed from the path.
     * 
     * @param e the event object 
     */    
    @Override 
    public void mousePressed(MouseEvent e)
    {
    	game.setMousePressed();
    }

    /* Unused mouse events - notice empty bodies on the same line.
     *   We need these methods becuase we implement MouseListener,
     *   but we don't use them.
     */
    
    @Override public void mouseClicked (MouseEvent e) {}
    @Override public void mouseEntered (MouseEvent e) {}
    @Override public void mouseExited  (MouseEvent e) {} 
    @Override public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		game.setMousePos(e.getPoint());
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		game.setMousePos(e.getPoint());
	}

}
