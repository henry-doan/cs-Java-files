package m1;

import java.util.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Midterm1 {
	public static void main(String[] args) {
		Stack<Boolean> s = new Stack<>();
		s.push(true);
		s.push(false);
		s.pop();
		StdOut.println("next: " + s.peek());
		s.push(false);
		s.push(true);
		s.pop();
		StdOut.println(s);
	}
}
