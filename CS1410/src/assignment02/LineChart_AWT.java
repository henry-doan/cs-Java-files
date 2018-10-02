package assignment02;
import org.jfree.chart.ChartPanel;

import java.io.File;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {

   public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Milliseconds","Degrees Fahrenheit to Celsius",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      	// initializing a new scanner with the user input to be a int, scanning the next input in the console for the integer for the degree fahrenheit all in one line.
   		int N=0;
     	final long start = System.nanoTime();

      	while (N != 100) {
      	int Fahrenheit = N;
   		
   		// subtract 32 from the input
   		int fahrenheitMinus32 = Fahrenheit - 32;
   		
   		// divide 5 / 9 , but for an int 5/9 is 0.555 repeating which as an int get truncated to 0 so this is always 0, to get around it I multiple by 100 for it to be truncated as an int not zero to 55.555 repeating which get truncated to 55
   		int integerDivision = ( 5 * 100 / 9);
   		
   		// then times the fahrenheit minus 32 and the integer and also undoing the 100 so it will be accurate and same as multipling by 1 in a sense and we will get celsius
   		int celsius = (integerDivision * fahrenheitMinus32) / 100;

   		// final message
//   		System.out.println(Fahrenheit + " degrees Fahrenheit is approximately: " + celsius + " degrees Celsius!");
   	    
        // end the time 
        final long end = System.nanoTime();

		// output the results and message
//		System.out.println("The loop has finshed \n");
		
		// do some math to convert the nano seconds into milliseconds
		Long milliseconds = ((end - start) / 1_000_000);
		String time = "" + milliseconds +"";
		System.out.println("time it takes" + time);
   		dataset.addValue( N , "Calulations" , time );
   		N++;
      }
      
      return dataset;
   }
   
   public static void main( String[ ] args ) {
      LineChart_AWT chart = new LineChart_AWT(
         "Time to convert Fahrenheit to Celius" ,
         "Time to convert Fahrenheit to Celius");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}