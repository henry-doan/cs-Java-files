package test;

import java.awt.Color;

public class testing {

	static double width;
	static double height;
	
	public static void main(String[] args) {
		
		System.out.println(doesSomething("hello"));
	}
	
	static private String doesSomething (String s)
    {
        String result = "";
        for (int p = 0; p < s.length(); p++){
        	System.out.println(s.charAt(p));
        	System.out.println(p);
            result = s.charAt(p) + result;
        }
        return result;
    }
	
	public static double Rect ( double area)
    {
    	width = ((area / 4) / 2);
    	height = ((area - (width * 2)) / 2);
    	
    	System.out.println("This is the width: " + width + " This is the height: " + height);
		return width;
    }

}
