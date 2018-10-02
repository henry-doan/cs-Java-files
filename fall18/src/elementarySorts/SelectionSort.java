package elementarySorts;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
		System.out.print("Start : ");
		for(int x = 0; x < arr.length; x++) {
			System.out.print(" " + arr[x]);
		}
		System.out.println(" ");
		
		int first, temp;
		int count = 1;
		for (int i = arr.length - 1; i > 0; i--, count++) {
			first = 0;
			for(int j = 1; j <= i; j++) {
				if( arr[j] < arr[first]) 
					first = j;
			}
			temp = arr[first];
			arr[first] = arr[i];
			arr[i] = temp;
		
		System.out.print("Pass " + count + ": ");
		for(int x = 0; x < arr.length; x++) {
			System.out.print( " " + arr[x]);
		}
		System.out.println(" ");
		
		}

	}

}
