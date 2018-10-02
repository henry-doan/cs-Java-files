package lab05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tester {
	public static void main(String[] args){
		List<String> test = Arrays.asList("1", "10", "2");
		
//		test.sort(null);
		test.sort(new StringAsNumberComparator());
		
		// Anonymous method
//		test.sort(new Comparator<String> () {
//			@Override
//			public int compare(String lhs, String rhs) {
//				int leftAsNum = Integer.parseInt(lhs);
//				int rightAsNum = Integer.parseInt(rhs);
//				
//				return leftAsNum - rightAsNum;
//			}
//		});
		
		System.out.println(test);
	}
	
	private static class StringAsNumberComparator implements Comparator<String> {
		@Override
		public int compare(String lhs, String rhs) {
			int leftAsNum = Integer.parseInt(lhs);
			int rightAsNum = Integer.parseInt(rhs);
			
			return leftAsNum - rightAsNum;
		}
	}
}
