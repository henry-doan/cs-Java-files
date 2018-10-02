package recursionexamples;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {

	public static void main(String[] args) {
		System.out.print("Enter a dirextory or a file: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String directory = input.nextLine();
		
		System.out.println(getSize(new File(directory)) + " bytes");

	}

	private static long getSize(File file) {
		long size = 0;
		
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; files != null && i < files.length; i++) {
				size += getSize(files[i]); //recursive call
			}
		} else { //base case
			size += file.length();
		}
		
		return size;
	}

}
