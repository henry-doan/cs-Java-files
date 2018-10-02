package ElementarySorts;

import java.security.SecureRandom;
import java.util.Arrays;

// effiecent
// sorts an arr by splitting it into two equal size sub arrays
// then sort each sub array then merging them into on lrg arr
// recursion
// o(n log n)
public class MergeSortTest {

	public static void mergeSort(int[] data) {
		sortArr(data, 0, data.length - 1);
	}
	
	private static void sortArr(int[] data, int low, int high) {
		if ((high - low) >= 1) {
			int mid1 = (low + high) / 2;
			int mid2 = mid1 + 1;
			
			System.out.printf("split:  %s%n", subarrString(data, low, high));
			System.out.printf("        %s%n", subarrString(data, low, mid1));
			System.out.printf("        %s%n%n", subarrString(data, mid2, high));
			
			sortArr(data, low, mid1);
			sortArr(data, mid2, high);
			
			merge(data, low, mid1, mid2, high);
		}
	}

	private static void merge(int[] data, int left, int mid1, int mid2, int right) {
		int ltIndex = left;
		int	rtIndex = mid2;
		int combinedIndex = left;
		int[] combined = new int[data.length];
		
		System.out.printf("merge:  %s%n", subarrString(data, left, mid1));
		System.out.printf("        %s%n", subarrString(data, mid2, right));
		
		while (ltIndex <= mid1 && rtIndex <= right) {
			if (data[ltIndex] <= data[rtIndex]) {
				combined[combinedIndex++] = data[ltIndex++];
			} else {
				combined[combinedIndex++] = data[rtIndex++];
			}
		}
		
		if (ltIndex == mid2) {
			while (rtIndex <= right) {
				combined[combinedIndex++] = data[rtIndex++];
			}
		} else {
			while (ltIndex <= mid1) {
				combined[combinedIndex++] = data[ltIndex++];
			}
		}
		
		for (int i = left; i <= right; i++) {
			data[i] = combined[i];
		}
		
		System.out.printf("        %s%n%n", subarrString(data, left, right));
	
	}

	private static String subarrString(int[] data, int low, int high) {
		StringBuilder temp = new StringBuilder();
		
		for (int i = 0; i < low; i++) {
			temp.append("  ");
		}
		
		for (int i = low; i <= high; i++) {
			temp.append(" " + data[i]);
		}
		
		return temp.toString();
	}

	public static void main(String[] args) {
SecureRandom gen = new SecureRandom();
		
		int[] data = gen.ints(10, 10, 91).toArray();
		
		System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
		mergeSort(data);
		System.out.printf("Sorted array: %s%n%n", Arrays.toString(data));
	}

}
