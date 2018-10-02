package elementarySorts;

// in place comparrison sort and a O time complexity
// bad for large list
// swap witht he lower order 
// on the left is final form and sorted
// ineffiecient
// runs o(n^2) time
public class Selection {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = 0; j < N; j++) 
				if (Elementarysort.less(a[j], a[min])) min = j;
			Elementarysort.exch(a,i,min);
		}
	}
}
