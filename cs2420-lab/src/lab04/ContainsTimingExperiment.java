package lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is an example of running an experiment on the contains method of a LinkedList 
 * @author ryans
 */
public class ContainsTimingExperiment {

	private static final int ITER_COUNT = 100;

	public static void main(String[] args) {
		 // you spin me round baby, right round
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000);
		
		try(FileWriter fw = new FileWriter(new File("contains_experiment.tsv"))) { //open up a file writer so we can write to file.
			Random random = new Random();
			for(int exp = 10; exp <= 25; exp++) { // This is used as the exponent to calculate the size of the set.
				int size = (int) Math.pow(2, exp); 
				
				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				// SET UP!
				List<Integer> set = new ArrayList<>();
				for(int i = 0; i < size; i++) {
					set.add(i);
				}
				for (int iter = 0; iter < ITER_COUNT; iter++) {
					
					int findElement = random.nextInt(size); // This gets me a random int between 0 and size;
					
					// TIME IT!
					long start = System.nanoTime();
					set.contains(findElement);
					long stop = System.nanoTime();
					totalTime += stop - start;
				}
				double averageTime = totalTime / (double)ITER_COUNT;
				System.out.println(size + "\t" + averageTime); // print to console
				fw.write(size + "\t" + averageTime + "\n"); // write to file.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Charter charter = new Charter();
		charter.createChart(new File("contains_experiment.tsv"), new File("chart.png"));
	}
}
