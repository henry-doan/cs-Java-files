package ElementarySorts;

import java.util.Arrays;

public class ShellSort {
	public static void sort(int[] arr) {
		int inner, outer;
		int temp;
		
		int h = 1;
		while ( h <= arr.length / 3) {
			h = h * 3 + 1;
		}
		
		while (h > 0)
		{
			for (outer = h; outer < arr.length; outer++)  {
				temp = arr[outer];
				inner = outer;
				
				while (inner > h - 1 && arr[inner - h] >= temp) {
					arr[inner] = arr[inner - h];
					inner -= h;
				}
				arr[inner] = temp;
			}
			
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int[] arr = {5,3,0,2,4,1,0,5,2,3,1,4};
		System.out.println("Before: "  + Arrays.toString(arr));
		sort(arr);
		System.out.println("After: "  + Arrays.toString(arr));
	}

}
