package books;

import java.util.Collections;
import java.util.List;

/**
 * A class to test case the book class.
 * 
 * @author Henry Doan
 * @version September 8, 2018
 */

public class BookApp {

	/**
	 * Main method to call on other methods in the class
	 * @param args -- a string array of arguments
	 */
	public static void main(String[] args) {
		printBookList();
		numberOfBooks();
		printSortedBooks();
		printReversedBooks();
	}
	
	/**
	 * Prints the Bookslist
	 */
	public static void printBookList() {
		// creates a booklist with a Book helper function with a file path
		List<Book> booksList = Book.getList("src/books/books.csv");
		
		// prints out each book in the list
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
	
	/**
	 * Prints the number of books in the books list
	 */
	public static void numberOfBooks() {
		// creates a booklist with a Book helper function with a file path
		List<Book> booksList = Book.getList("src/books/books.csv");
		
		// prints out the size or the number of books in the list
		System.out.println("Number of books read in: " + booksList.size());
	}
	
	/**
	 * Prints sorted books in natural order
	 */
	public static void printSortedBooks() {
		// creates a booklist with a Book helper function with a file path
		List<Book> booksList = Book.getList("src/books/books.csv");
		
		// sorts the book
		Collections.sort(booksList);
		
		System.out.println("Sorted book list:");
		
		// prints out the size or the number of books in the list
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
	
	/**
	 * Prints sorted books in reverse order
	 */
	public static void printReversedBooks() {
		// creates a booklist with a Book helper function with a file path
		List<Book> booksList = Book.getList("src/books/books.csv");
		
		// sorts the book in reverse
		Collections.sort(booksList, Collections.reverseOrder()); 
		
		System.out.println("Reversed Order:");
		
		// prints out the size or the number of books in the list
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
}
