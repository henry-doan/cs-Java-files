package elementarySorts;

// bad for lrg list, simple, good for small data, statble
// in place o(1)
// insertion is faster than selection
// o(n^2) time
public class Insertion {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && Elementarysort.less(a[j], a[j-1]); j--) {
				Elementarysort.exch(a, j, j-1);
			}
		}
	}
}

//see page 245 for the missing methods