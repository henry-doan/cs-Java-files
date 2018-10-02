package elementarySorts;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {9,7,5,3,1,8,6,4,2,0};
		System.out.print("Before: ");
		for(int x: arr) {
			System.out.print(x + " ");
		}
		System.out.println(" ");
		
		int tmp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(arr[i] < arr[j-1]) {
					tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
			System.out.print("pass " + i + ":  " );
			for( int x: arr) {
				System.out.print(x + " ");
			}
			System.out.println(" ");
		}
		System.out.println("Done");
	}

}
