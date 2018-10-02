package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A Class for loading resources 
 * 
 * @author Henry Doan with partner of Tom Nguyen
 * @version April 17th, 2017
 */

public class ResourceLoader {
	private static Map<String, BufferedImage> imageMap;
	private static Map<String, Path> pathMap;
	
	static private ResourceLoader instance;
	
//	private BufferedImage imageResults;
	private static Path pathResult;
	
	static ClassLoader myLoader;
	
	ResourceLoader() {
		imageMap = new HashMap<String, BufferedImage>();
		pathMap = new HashMap<String, Path>();
		myLoader = this.getClass().getClassLoader();
	}
	
	public static ResourceLoader getLoader (){
        if (instance == null)
          instance = new ResourceLoader ();

        return instance;
    }
	
	public BufferedImage getImage(String imageName) {
		if(imageMap.containsKey(imageName)) {
			return imageMap.get(imageName);
		}
		
		try {
			
			// Locate the file, get a stream for it.
            
    		ClassLoader myLoader = this.getClass().getClassLoader();
	        InputStream imageStream = myLoader.getResourceAsStream("resources/" + imageName);
	        
	        // Read the image.
	        
	        BufferedImage result;
	        result = javax.imageio.ImageIO.read(imageStream);  // A handy helper method
	        
	        // Put the BufferedImage into our map (use the filename as the key)
	        
	        imageMap.put(imageName, result);
	        
	        // Return the image.
	        
	        return result;
        } catch (IOException e) {
            // On error, just print a message and exit.  
            //   (You should make sure the files are in the correct place.)
            
            System.err.println ("Could not load one of the image " + imageName);
            System.exit(0);  // Bail out.
        	return null;
        } 
		
	
		
	}
	
	public Path getPath(String pathName) {
		if(pathMap.containsKey(pathName)) {
			return pathMap.get(pathName);
		}
		
			
        InputStream pointStream = myLoader.getResourceAsStream("resources/" + pathName);
        Scanner in = new Scanner (pointStream);
            
        pathResult = new Path(in);
            
        pathMap.put(pathName, pathResult);
    
		return pathResult;
	}
}
