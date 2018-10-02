package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * A class that gets specific coordinates of objects
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 17th, 2017
 */

public class GetPathCoords extends JPanel implements ActionListener, MouseListener {
	
		private static final long serialVersionUID = 42L;

		// Fields (object variables)

		private BufferedImage backdrop; // the background image
		private Timer time;

		private ArrayList<Point> arrayOfPairCoords = new ArrayList<Point>();

		// Students will add a few more fields (object variables) to keep
		// track of their path object, the circle position (as a percentage),
		// and possibly a Timer object.

		// Methods

		public GetPathCoords() {
			try {
				// InputStream objects are an alternative to File objects.
				// I use them to make it easier to locate resources - resources
				// can be in a directory, .jar, on the web, etc..
				//
				// Get the 'resource' from the
				// adjoining resource directory. Java will return an 'InputStream'
				// that you can use to read or scan through the resource.

				// Get the object that loaded this class, because it keeps track
				// of -where- things are loaded from for us. (A very advanced
				// technique, please use this code.)

				ClassLoader myLoader = this.getClass().getClassLoader();

				// Load the background image

				InputStream imageStream = myLoader.getResourceAsStream("resources/path_2.jpg");
				backdrop = javax.imageio.ImageIO.read(imageStream); // A handy
																	// helper method

				// Create a scanner that points to our text file (with the path
				// points in it)

				// Students may uncomment this code:
				InputStream pointStream = myLoader.getResourceAsStream("resources/path_2.txt");
				Scanner input = new Scanner(pointStream); // Scan from the text
				// file.

				// Build the path object (using the scanner).

				// Set the size of this panel to match the size of the image.

				Dimension panelSize = new Dimension(backdrop.getWidth(), backdrop.getHeight());

				this.setMinimumSize(panelSize);
				this.setPreferredSize(panelSize);
				this.setMaximumSize(panelSize);
				addMouseListener(this);

				// Create a timer (for animation), have it call our actionPerformed
				// method 60 times a second.
				time = new Timer(16, this);

				 input.close ();
			} catch (IOException e) {
				// On error, just print a message and exit.

				System.err.println("Could not load one of the files.");
				System.exit(0); // Bail out.
			}
		}

		/**
		 * Draws the image, path, and the animating ball.
		 * 
		 * (The background is not cleared, it is assumed the backdrop fills the
		 * panel.)
		 * 
		 * @param g
		 *            the graphics object for drawing on this panel
		 */
		public void paint(Graphics g) {
			// Draw the background.

			g.drawImage(backdrop, 0, 0, null);

			// Have the path object draw itself.

		}

		/**
		 * The actionPerformed method is called (from the GUI event loop) whenever
		 * an action event occurs that this object is listening to.
		 * 
		 * For our test panel, we assume that the Timer has expired, so we advance
		 * our small sphere along the path.
		 * 
		 * @param e
		 *            the event object
		 */
		public void actionPerformed(ActionEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX() + " " + e.getY());

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
}
