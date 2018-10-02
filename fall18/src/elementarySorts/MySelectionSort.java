package ElementarySorts;

public class MySelectionSort {
	
	public static int[] sSort( int[] arr ) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index])
					index = j;
			}	
			int smallerNum = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNum;
		}
		return arr;
	}

	public static void main(String[] args) {

		int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
		int[] arr2 = sSort(arr1);
		for (int i:arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}

}
