package recursionexamples;

public class TowersOfHanoiSolution {
	
	public static void solveTowers(int disks, int sourcePeg, int destinationPeg, int tempPeg) {
		if (disks == 1) {
			System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
			return;
		
		}
		
		solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);
		
		System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
		
		solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);

	}

	public static void main(String[] args) {
		int startPeg = 1;
		int endPeg = 3;
		int tempPeg = 2;
		int totalDisks = 3;
		
		solveTowers(totalDisks, startPeg, endPeg, tempPeg);
	}

}
