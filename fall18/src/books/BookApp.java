package books;

import java.util.Collections;
import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		printBookList();
		numberOfBooks();
		printSortedBooks();
		printReversedBooks();
	}
	
	public static void printBookList() {
		List<Book> booksList = Book.getList();
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
	
	public static void numberOfBooks() {
		List<Book> booksList = Book.getList();
		
		System.out.println("Number of books read in: " + booksList.size());
	}
	
	public static void printSortedBooks() {
		List<Book> booksList = Book.getList();
		Collections.sort(booksList);
		System.out.println("Sorted book list:");
		
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
	
	public static void printReversedBooks() {
		List<Book> booksList = Book.getList();
		Collections.sort(booksList, Collections.reverseOrder()); 
		System.out.println("Reversed Order:");
		
		for (Book b: booksList) {
			System.out.println(b);
		}
	}
	
	

}
