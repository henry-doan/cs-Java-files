package ep;

import java.util.LinkedList;

/*
 * An immutable data type that represents the board for the 8 puzzle.
 * 
 * @author Henry Doan
 * @version November 3, 2018
 */

public class Board {
	private static final int SPACE = 0;
	private final int boardSize;
	static int numOutOfPlace;

	private final int[][] board;

	/**
	 * Construct a board from an N-by-N array of blocks Initializes and copies
	 * items in block array;
	 * 
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		boardSize = blocks.length;
		this.board = copy(blocks);
	}

	/**
	 * Uses a board from an N-by-N array of blocks (where blocks[i][j] = block
	 * in row i, column j)
	 * 
	 * @param blocks
	 * @return the block copy
	 */
	private int[][] copy(int[][] blocks) {
		int[][] copy = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				copy[i][j] = blocks[i][j];
			}
		}

		return copy;
	}

	/**
	 * Board size N
	 * 
	 * @return size of board.
	 */
	public int size() {
		return board.length;
	}

	/*
	 * Number of blocks out of place.
	 * 
	 * @return blocks out of place.
	 */
	public int hamming() {
		numOutOfPlace = 0;

		// check the position to see if it is out of place
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if (board[row][col] != 0 && board[row][col] != row * boardSize + col + 1) {
					numOutOfPlace++;
				}
			}
		}

		return numOutOfPlace;
	}

	/*
	 * Is this board the goal board?
	 * 
	 * @return true -- boolean on if it is the goal board and no blocks out of
	 * place. false -- boolean on if it is not the goal board and blocks are out
	 * of place.
	 */
	public boolean isGoal() {
		// see if there are blocks out of place or not.
		return hamming() == 0;
	}

	/*
	 * Does this board equal y?
	 * 
	 * @param y -- an object being compared.
	 * 
	 * @return true -- boolean on if the board is equal to y. false -- boolean
	 * on if the board is not equal to y.
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj.getClass() != this.getClass()) {
			return false;
		}

		Board that = (Board) obj;

		if (this.boardSize != that.boardSize) {
			return false;
		}

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (this.board[i][j] != that.board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isSpace(int block) {
		return block == SPACE;
	}

	/**
	 * Sum of Manhattan distances between blocks and goal
	 * 
	 * @return
	 */
	public int manhattan() {
		int sum = 0;
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board.length; col++)
				sum += calculateDistances(row, col);

		return sum;
	}

	/**
	 * Finds distances between blocks and goals
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private int calculateDistances(int row, int col) {
		int block = block(row, col);

		return (isSpace(block)) ? 0 : Math.abs(row - row(block)) + Math.abs(col - col(block));
	}

	/**
	 * Finds number of blocks
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private int block(int row, int col) {
		return board[row][col];
	}

	/**
	 * Finds number of rows
	 * 
	 * @param block
	 * @return
	 */
	private int row(int block) {
		return (block - 1) / size();
	}

	/**
	 * Finds number of columns
	 * 
	 * @param block
	 * @return
	 */
	private int col(int block) {
		return (block - 1) % size();
	}

	/**
	 * Swaps pieces by copying blocks and using a temperary one.
	 * 
	 * @param row1
	 * @param col1
	 * @param row2
	 * @param col2
	 * @return
	 */
	private int[][] swap(int row1, int col1, int row2, int col2) {
		int[][] copy = copy(board);
		int tmp = copy[row1][col1];
		copy[row1][col1] = copy[row2][col2];
		copy[row2][col2] = tmp;

		return copy;
	}

	/**
	 * Shows all neighboring boards
	 * 
	 * @return neighbors
	 */
	public Iterable<Board> neighbors() {
		LinkedList<Board> neighbors = new LinkedList<Board>();

		int[] location = spaceLocation();
		int spaceRow = location[0];
		int spaceCol = location[1];

		if (spaceRow > 0)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow - 1, spaceCol)));
		if (spaceRow < size() - 1)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow + 1, spaceCol)));
		if (spaceCol > 0)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol - 1)));
		if (spaceCol < size() - 1)
			neighbors.add(new Board(swap(spaceRow, spaceCol, spaceRow, spaceCol + 1)));

		return neighbors;
	}

	/**
	 * Shows where you are on board
	 * 
	 * @return location
	 */
	private int[] spaceLocation() {
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board.length; col++)
				if (isSpace(block(row, col))) {
					int[] location = new int[2];
					location[0] = row;
					location[1] = col;

					return location;
				}
		throw new RuntimeException();
	}

	/**
	 * String representation of this board (in the output format specified
	 * below)
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(size() + "\n");
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++)
				str.append(String.format("%2d ", block(row, col)));
			str.append("\n");
		}

		return str.toString();
	}

	/*
	 * Is this board solvable?
	 * 
	 * @return true -- boolean on if the board is able to solve false -- boolean
	 * on if the board is not able to be solved.
	 */
	public boolean isSolvable() {
		//see if the goal board is possible
		int inversions = 0;
		int[] grid = new int[board.length];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i] = board[i][j];
			}
		}
		
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == 0)
				continue; // we don't count blank in the inversions, so we can skip the rest
			for (int j = i; j < boardSize; j++) // check all board after i to see if any are larger than j
				if (grid[j] < grid[i] && boardSize != 0)
					inversions++;
		}
		
		boolean isEvenBoard = (boardSize % 2) == 0; // true if even, false if odd
		if (isEvenBoard) inversions += SPACE / boardSize; // if the board is even we must add which row 0 is on
		boolean isEvenInversions = (inversions % 2) == 0; // true if the total number of inversions is even
		
		return isEvenBoard == isEvenInversions; // an odd board is solvable with even inversions. 
	}
}

