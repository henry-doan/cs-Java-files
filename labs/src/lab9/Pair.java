package lab9;
//
import java.util.*;
public class Pair<T, U> {
	T left;
	U right;
	
	
	public Pair(T _left, U _right){
		left = _left;
		right = _right;
	}
	
	public String toString(){
		return "LEft: " + left + " Right: " + right;
	}
	
//	public boolean equals(Object o ){
//		if ( o instanceof Pair){
//			if( this.left.equals((Pair) a, left) && this.right.equals((Pair) 0).right)){
//				return true;
//			}
//		}
//		return false;
//	}
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("David", 10);
		System.out.println(pair);
		
		Pair< String, String> pair2= new Pair<String, String>("Matt", "hardy");
		System.out.println(pair2);
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Matt");
		strings.add("CS1410");
		System.out.println(strings);
		System.out.println(strings.indexOf("CS1410"));
		
		ArrayList<Pair<String, Integer>> array = new ArrayList<Pair<String, Integer>>();
		array.add(new Pair<String, Integer>("CS1410", 10));
		Pair<String, Integer> test = new Pair<String, Integer>("test", 10);
		array.add(1, test);
		System.out.println(array);
		array.remove(0);
		
		System.out.println(array);
		
		
	}
}
