package ep;

/*
 * An immutable data type that represents the board for the 8 puzzle.
 * 
 * @author Henry Doan
 * @version October 23, 2018
 */
public class Board {
	private int boardSize;
	private int[][] board;
	
	/*
	 * Construct a board from an N-by-N array of blocks.
	 * 
	 * @param where blocks[i][j] = block in row i, column j
	 */
	public Board(int[][] blocks) {
		
	}
	
	/*
	 * Board size N.
	 * 
	 * @return board size
	 */
	public int size() {
		return 0;
		
	}
	
	/*
	 * Number of blocks out of place.
	 * 
	 * @return blocks out of place.
	 */
	public int hamming() {
		return 0;
	}
	
	/*
	 * Sum of Manhattan distances between blocks and goal.
	 * 
	 * @return sum of Manhattan distances.
	 */
	public int manhattan() {
		return 0;
	}
	
	/*
	 * Is this board the goal board?
	 * 
	 * @return true -- boolean on if it is the goal board
	 *         false -- boolean on if it is not the goal board
	 */
	public boolean isGoal() {
		return false;
	}
	
	/*
	 * Is this board solvable?
	 * 
	 * @return true -- boolean on if the board is able to solve
	 *         false -- boolean on if the board is not able to be solved.
	 */
	public boolean isSolvable() {
		return false;
	}
	
	/*
	 * Does this board equal y?
	 * 
	 * @return true -- boolean on if the board is equal to y.
	 *         false -- boolean on if the board is not equal to y.
	 */
	public boolean equals(Object y) {
		return false;
	}
	 
	/*
	 * All neighboring boards.
	 * 
	 * @return 
	 */
	public Iterable<Board> neighbors() {
		return null;
	}
	 
	/*
	 * String representation of this board.
	 * 
	 * @return result -- string of 
	 */
	public String toString() {
		return "";
	}
	
	/*
	 * Unit Testing
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}