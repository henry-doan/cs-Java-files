package ep;

import edu.princeton.cs.algs4.LinkedStack;

/*
 * An immutable data type that represents the board for the 8 puzzle.
 * 
 * @author Henry Doan, Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov   
 * @version November 8, 2018
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
		// set the size
		boardSize = blocks.length;
		
		// create a new board
		board = new int[boardSize][boardSize];
		
		// copy items over
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				board[row][col] = blocks[row][col];
			}
		}
		
	}
	
	/*
	 * Board size N.
	 * 
	 * @return board size
	 */
	public int size() {
		return boardSize;
	}
	
	/*
	 * Number of blocks out of place.
	 * 
	 * @return blocks out of place.
	 */
	public int hamming() {
		int numOutOfPlace = 0;
		
		// check the position to see if it is out of place
		for (int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {
				if (board[row][col] != 0 && board[row][col] != row * boardSize + col + 1) {
					numOutOfPlace++;
				}
			}	
		}
		
		return numOutOfPlace;
	}
	
	/*
	 * Sum of Manhattan distances between blocks and goal.
	 * 
	 * @return sum of Manhattan distances.
	 */
	public int manhattan() {
		int distSum = 0;
		for (int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {
				distSum += calcDist(row, col);
			}	
		}
		
		return distSum;
	}
	
	/**
	 * Finds distances between blocks and goals.
	 * 
	 * @param row -- number that represents the board row
	 *        col -- number that represents the board column
	 * @return the distances of the block and goals.
	 */

	private int calcDist(int row, int col) {
		int block = board[row][col];
		
		if (block == boardSize) {
			return 0;
		} else {
			return Math.abs(row - ((block - 1) / boardSize) + Math.abs(col - ((block - 1) % boardSize)) );
		}
	}

	/*
	 * Is this board the goal board?
	 * 
	 * @return true -- boolean on if it is the goal board and no blocks out of place.
	 *         false -- boolean on if it is not the goal board and blocks are out of place.
	 */
	public boolean isGoal() {
		// see if there are blocks out of place or not.
		return hamming() == 0;
	}
	
	/*
	 * Is this board solvable?
	 * 
	 * @return true -- boolean on if the board is able to solve
	 *         false -- boolean on if the board is not able to be solved.
	 */
	public boolean isSolvable() {
		// see if the goal board is possible
		return isGoal();
	}
	
	/*
	 * Does this board equal y?
	 * 
	 * @param y -- an object being compared.
	 * @return true -- boolean on if the board is equal to y.
	 *         false -- boolean on if the board is not equal to y.
	 */
	public boolean equals(Object y) {
		// if the value and objects are the same
		if (this == y && this.getClass() == y.getClass()) {
			return true;
		} 
		
		// cast y to a board 
		Board otherBoard = (Board) y;
		
		// see if all the values are the same of the two compared boards
		for (int row = 0; row < boardSize; row++) {
			for(int col = 0; col < boardSize; col++) {
				if (this.board[row][col] == otherBoard.board[row][col]) {
					return true;
				}
			}	
		}
		
		// else return false
		return false;
	}
	 
	/*
	 * All neighboring boards.
	 * 
	 * @return 
	 */
	public Iterable<Board> neighbors() {
	   	LinkedStack<Board> BoardStack = new LinkedStack<Board>();
	   	Board neighbor;
	   	int row, col;
	   	
	   	for(int i = 0; i < boardSize * boardSize; i++) {
	   		row = i / boardSize;
	   		col = i % boardSize;
	   		
	   		if (board[row][col] == 0) {
	   			if(row != boardSize - 1) {
	   				neighbor = new Board(board);
	   				neighbor.board[row][col] = neighbor.board[row + 1][col];
	   				neighbor.board[row + 1][col] = 0;
	   				BoardStack.push(neighbor);
	   			}
	   		}
		   	
	   		if(row != 0) {
		   		neighbor = new Board(board);
	   			neighbor.board[row][col] = neighbor.board[row - 1][col];
	   			neighbor.board[row][col + 1] = 0;
	   			BoardStack.push(neighbor);
	   		 }
	   		
	   		if(col != 0) {
	   			neighbor = new Board(board);
	   			neighbor.board[row][col] = neighbor.board[row][col - 1];
	   			neighbor.board[row][col-1] = 0;
	   		}
	   	}
		return BoardStack;
	}
	  
	/*
	 * String representation of this board.
	 * 
	 * @return result -- string of 
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(boardSize + "\n");
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				s.append(String.format("%2d ", board[i][j]));
		    }
			s.append("\n");
		}
		
		return s.toString();
	}
	
	/*
	 * Unit Testing
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
