package ep;

import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/*
 *  An immutable data type that solves the 8 puzzle.
 * 
 * @author Henry Doan, Jeneve Castro, Tatiana Nicoara, Dimitar Ivanov   
 * @version November 8, 2018
 */
public class Solver {
    
	private class Move implements Comparable<Move> {
        private Move last;
        private Board board;
        private int numMoves = 0;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, Move last) {
            this.board = board;
            this.last = last;
            this.numMoves = last.numMoves + 1;
        }

        public int compareTo(Move move) {
            return (this.board.manhattan() - move.board.manhattan()) + (this.numMoves - move.numMoves);
        }
    }

    static Move lastMove;

    /**
     * Finds a solution to the initial board (using the A* algorithm)
     * 
     * @param initial
     */
    public Solver(Board initial) {
        MinPQ<Move> m = new MinPQ<Move>();
        m.insert(new Move(initial));

        MinPQ<Move> tm = new MinPQ<Move>();

        while(true) {
            lastMove = expand(m);
            if (lastMove != null || expand(tm) != null) return;
        }
    }

    private Move expand(MinPQ<Move> moves) {
        if(moves.isEmpty()) return null;
        Move bm = moves.delMin();
        if (bm.board.isGoal()) return bm;
        for (Board neighbor : bm.board.neighbors()) {
            if (bm.last == null || !neighbor.equals(bm.last.board)) {
                moves.insert(new Move(neighbor, bm));
            }
        }
        return null;
    }

    /*
	 * Is this board solvable?
	 * 
	 * @return true -- boolean on if the board is able to solve false -- boolean
	 * on if the board is not able to be solved.
	 */
    public boolean isSolvable() {
        return (lastMove != null);
    }

    /*
	 * Min number of moves to solve initial board.
	 * 
	 * @return int number of moves to solve with the manhattan.
	 */
    public int moves() {
        return isSolvable() ? lastMove.numMoves : -1;
    }

    /**
     *  Sequence of boards in a shortest solution
     * @return
     */
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;

        Stack<Board> moves = new Stack<Board>();
        while(lastMove != null) {
            moves.push(lastMove.board);
            lastMove = lastMove.last;
        }

        return moves;
    }
    
    public static void main(String[] args) {
        // create initial board from file
    	In in = new In("Resources/puzzle01.txt");
	    int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // check if puzzle is solvable; if so, solve it and output solution
        if (initial.isSolvable()) {
            Solver solver = new Solver(initial);
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }

        // if not, report unsolvable
        else {
            StdOut.println("Unsolvable puzzle");
        }
    }
}