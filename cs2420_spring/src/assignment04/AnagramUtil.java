package assignment04;

import java.util.Comparator;
import java.util.Scanner;

public class AnagramUtil {
	
	/*
	 * This method returns the sorted version of the input string. 
	 * The sorting must be accomplished using an insertion sort. 
	 * If a null argument is passed, the method should return null. 
	 */
	public static String sort(String word) {
		if(word == null) {
			return null;
		}
		
		return word;
	}
	
	/*
	 * This generic method sorts the input array using an insertion sort 
	 * and the input Comparator object. If a null argument is passed, the 
	 * method should throw a NullPointerException.
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> compara) {
		if(arr == null || compara == null) {
			throw new NullPointerException();
		}
		
		for (int index = 0; index < arr.length; index++) {
			T indexOfSmallestElement = arr[index];
			int iterator;
			
			for (iterator = index - 1; iterator >= 0 && compara.compare(arr[iterator], indexOfSmallestElement) > 0; iterator--) {
				arr[iterator + 1] = arr[iterator];
			}
			
			arr[iterator + 1] = indexOfSmallestElement;
		}
	}
	
	/*
	 * This method returns true if the two input strings are anagrams of each other, 
	 * otherwise returns false. If either argument is null, the method should 
	 * return false.
	 */
	public static boolean areAnagrams(String leftHandSide, String rightHandSide) {
		if ( leftHandSide.length() != rightHandSide.length()) {
			return false;
		}
		
		String sortedLhs = sort(leftHandSide);
		String sortedRhs = sort(rightHandSide);
		
		return sortedLhs.equals(sortedRhs);
	}
	
	/*
	 * This method returns the largest group of anagrams in the input array of words, 
	 * in no particular order. It returns an empty array if there are no anagrams in 
	 * the input array, or if a null argument is passed in. You may assume that there
	 * will only ever be one largest group of anagrams in a list of words for testing. 
	 * There are no restrictions on maintaining the original array.  
	 */
	public static String[] getLargestAnagramGroup(String[] incomingArr) {
		String [] lrgAnagramArr = new String[incomingArr.length]; 
				
		if(incomingArr == null) {
			return lrgAnagramArr;
		}
		
		return incomingArr;	
	}
	
	/*
	 * Behaves the same as the previous method, but reads the list of words from a 
	 * file using a Java Scanner. It is assumed that the file contains one word per 
	 * line. If the file does not exist or is empty, the method returns an empty array 
	 * because there are no anagrams.  
	 */
	public static String[] getLargestAnagramGroup(Scanner scanner) {
		return null;
	}
}
