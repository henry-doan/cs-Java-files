package elementarySorts;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] list = {10,9,8,7,6,15,14,13,12,11,5,4,3,2,1};
		System.out.println("before: " + Arrays.toString(list));
		mergeSort(list);
		System.out.println("after: " + Arrays.toString(list));
	}

	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int[] left = ltHalf(arr);
			int[] right = rt(arr);
			
			mergeSort(left);
			mergeSort(right);
			
			merge(arr, left, right);
		}
		
	}

	private static void merge(int[] result, int[] left, int[] right) {
		int i1 = 0; 
		int i2 = 0;
		for( int i = 0; i < result.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2] )) {
				result[i] = left[i1];
				i1++;
			} else {
				result[i] = right[i2];
				i2++;
			}
		}
		
	}

	private static int[] rt(int[] arr) {
		int size1 = arr.length / 2;
		int size2 = arr.length - size1;
		int[] rt = new int[size2];
		for (int i = 0; i < size2; i++) {
			rt[i] = arr[i + size1];
		}
		return rt;
	}

	public static int[] ltHalf(int[] arr) {
		int size1 = arr.length / 2;
		int[] lt = new int[size1];
		for (int i = 0; i < size1; i++) {
			lt[i] = arr[i];
		}
		return lt;
	}

}
