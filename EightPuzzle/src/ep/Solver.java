package ep;

/*
 * An immutable data type that solves the 8 puzzle.
 * 
 * @author Henry Doan
 * @version October 23, 2018
 */
public class Solver {

	/*
	 * Find a solution to the initial board (using the A* algorithm)
	 */
	 public Solver(Board initial) {
		 if (initial == null) {
			 throw new java.lang.NullPointerException();
		 }
		 
//		 if (boardname.isSolvable() == false) {
//			 throw new java.lang.IllegalArgumentException();
//		 }
	 }
	 
	/*
	 * Min number of moves to solve initial board.
	 * 
	 * @return  -- int number of moves to solve.
	 */
	 public int moves()	{
		 return 0;
	 }
	 
	/*
	 * Sequence of boards in a shortest solution.
	 * 
	 * @return  -- boards to the shortest solution.
	 */	 
	 public Iterable<Board> solution() {
		return null;
		 
	 }
	 
	/*
	 * Solve a slider puzzle.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}