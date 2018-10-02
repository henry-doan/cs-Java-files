package elementarySorts;

import java.util.Arrays;

public class HeapSort {
	
	private static int[] a;
	private static int n;
	private static int left;
	private static int right;
	private static int lrgest;
	
	public static void buildheap(int[] a) {
		n = a.length - 1;
		for( int i = n / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}

	public static void maxheap(int[] a, int i) {
		left = 2 * i;
		right = 2 * i + 1;
		
		if(left <= n && a[left] < a[i]) {
			lrgest = left;
		} else  {
			lrgest = i;
		}
		
		if(right <= n && a[right] < a[lrgest]) {
			lrgest = right;
		}
		
		if(lrgest != i) {
			exchange(i, lrgest);
			maxheap(a, lrgest);
		}
			
	}

	public static void exchange(int i, int j) {
		int t= a[i];
		a[i] = a[j];
		a[j] = t;
		
	}
	
	public static void sort(int[] myarr) {
		a = myarr;
		buildheap(a);
		for(int i = n; i > 0; i--) {
			exchange(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
	}

	public static void main(String[] args) {
		int [] num = { 55, 2, 93, 1, 23, 10, 66,12, 7, 54, 3 };
		System.out.println(Arrays.toString(num));
		sort(num);
		System.out.println(Arrays.toString(num));

	}

}
