package books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Book object that has a title, author, year, getters, getting the books list
 * 	- includes A overrided toString and a comparator for book.
 * 
 * @author Henry Doan
 * @version September 8, 2018
 */

public class Book implements Comparable<Book>{
	// initial variables all books have
	String title;
	String author;
	int year;
	
	/**
	 * Constructor taking in a title, author and year to have the variables
	 * set to the incoming data.
	 * 
	 * @param inputTitle -- a string for the title
	 *        inputAuthor -- a string for the author of the book
	 *        year -- a integer for the year of the book
	 */
	public Book(String inputTitle, String inputAuthor, int inputYear) {
		title = inputTitle;
		author = inputAuthor;
		year = inputYear;
	}
	
	/**
	 * Getter for the title
	 * 
	 * @return this.title -- a string for the current book's title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Getter for the author
	 * 
	 * @return this.author -- a string for the current book's author
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * Getter for the year
	 * 
	 * @return this.year -- a integer for the current book's year
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * Format the the title, author and year
	 * 
	 * @return this.title + " by " + this.author + " ( " + this.year + " ) " -- a string for the current book's' attributes
	 */
	@Override
	public String toString() {
		return this.title + " by " + this.author + " ( " + this.year + " ) " ;
	}
	
	/**
	 * Takes in a file or file path and grabs the data from the file to
	 * have each line be a book and add the book to a book list.
	 * 
	 * @param file -- a string to the file name or a path to the file
	 * @return booksList -- a Linked List of books 
	 * 		   catch -- if the file is not found
	 *         catch -- if the data is in the wrong format
	 */
	static List<Book> getList(String file) {
		// have the string to a file
		String fileName = file;
		File f = new File(fileName);
		
		// create a list of books
		List<Book> booksList = new LinkedList<Book>();
		
		try {
			// scan the file
			Scanner bookScanner = new Scanner(f);
			
			while (bookScanner.hasNextLine()) {
				// book line is each line scanned
				String bookLine = bookScanner.nextLine();
				
				// the values of the book is by the commas
				String[] values = bookLine.split(",");
				
				// check to see if the book line is in the right format
				try {
					// have a new book with the values for title, author, and year
					Book b = new Book(values[0], values[1], Integer.parseInt(values[2]));

					// add book to list
					booksList.add(b);
					
				// catch if the book like is in the wrong format
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
					System.out.println("Problem reading in " + bookLine + "\n");
				}
			}
			// close scanner
			bookScanner.close();
		
		// catch if the file is not found
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return booksList;
	}

	/**
	 * Takes in a book to compare against current book and returns the natural order
	 * based off of title
	 * 
	 * @param 0 -- incoming book to compare against
	 * @return this.title.compareTo(o.title) -- natural order base on title
	 */
	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}
}
