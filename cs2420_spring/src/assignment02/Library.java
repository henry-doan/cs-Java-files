package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of library books).
 * 
 * @author  Henry Doan
 * @version January 20, 2018
 */
public class Library {

	// An array list to hold all the library books
	private ArrayList<LibraryBook> library;

	/**
	 * Constructor of the library. Creates a new array list for library books
	 */
	public Library() {
		library = new ArrayList<LibraryBook>();
	}

	/**
	 * Add the specified book to the library, assume no duplicates.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be added
	 * @param author
	 *            -- author of the book to be added
	 * @param title
	 *            -- title of the book to be added
	 */
	public void add(long isbn, String author, String title) {
		library.add(new LibraryBook(isbn, author, title));
	}

	/**
	 * Add the list of library books to the library, assume no duplicates.
	 * 
	 * @param list
	 *            -- list of library books to be added
	 */
	public void addAll(ArrayList<LibraryBook> list) {
		library.addAll(list);
	}

	/**
	 * Add books specified by the input file. One book per line with ISBN,
	 * author, and title separated by tabs.
	 * 
	 * If file does not exist or format is violated, do nothing.
	 * 
	 * @param filename
	 */
	public void addAll(String filename) {
		ArrayList<LibraryBook> toBeAdded = new ArrayList<LibraryBook>();

		try (Scanner fileIn = new Scanner(new File(filename))) {

			int lineNum = 1;

			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();

				try (Scanner lineIn = new Scanner(line)) {
					lineIn.useDelimiter("\\t");

					if (!lineIn.hasNextLong()) {
						throw new ParseException("ISBN", lineNum);
					}
					long isbn = lineIn.nextLong();

					if (!lineIn.hasNext()) {
						throw new ParseException("Author", lineNum);
					}
					String author = lineIn.next();

					if (!lineIn.hasNext()) {
						throw new ParseException("Title", lineNum);
					}
					String title = lineIn.next();
					toBeAdded.add(new LibraryBook(isbn, author, title));
				}
				lineNum++;
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage() + " Nothing added to the library.");
			return;
		} catch (ParseException e) {
			System.err.println(e.getLocalizedMessage() + " formatted incorrectly at line " + e.getErrorOffset()
					+ ". Nothing added to the library.");
			return;
		}

		library.addAll(toBeAdded);
	}

	/**
	 * Returns the holder of the library book with the specified ISBN.
	 * 
	 * If no book with the specified ISBN is in the library, returns null.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be looked up
	 */
	public String lookup(long isbn) {
		
		// look in the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// then look at the isbn number of the book
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// if match return the holder of the book
				return library.get(arrListPos).getHolder();
			}
		}
		
		// if no books are found return null
		return null;
	}

	/**
	 * Returns the list of library books checked out to the specified holder.
	 * 
	 * If the specified holder has no books checked out, returns an empty list.
	 * 
	 * @param holder
	 *            -- holder whose checked out books are returned
	 */
	public ArrayList<LibraryBook> lookup(String holder) {
		
		// new array list to hold the books checked out from a holder   
		ArrayList<LibraryBook> booksCheckedOutFromHolder = new ArrayList<LibraryBook>();
		
		// look in the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// see if the holder is the one we are looking for
			if(library.get(arrListPos).getHolder() == holder) {
				
				// add on to the array list
				booksCheckedOutFromHolder.add(library.get(arrListPos));
			}
		}
		
		// if no books are found return empty array list or the list with the books
		return booksCheckedOutFromHolder;
	}

	/**
	 * Sets the holder and due date of the library book with the specified ISBN.
	 * 
	 * If no book with the specified ISBN is in the library, returns false.
	 * 
	 * If the book with the specified ISBN is already checked out, returns
	 * false.
	 * 
	 * Otherwise, returns true.
	 * 
	 * @param isbn
	 *            -- ISBN of the library book to be checked out
	 * @param holder
	 *            -- new holder of the library book
	 * @param month
	 *            -- month of the new due date of the library book
	 * @param day
	 *            -- day of the new due date of the library book
	 * @param year
	 *            -- year of the new due date of the library book
	 * 
	 */
	public boolean checkout(long isbn, String holder, int month, int day, int year) {
		
		// look through the library
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// check if the book we are checking has the isbn we are looking for
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// make sure the book is not checked out
				if(!library.get(arrListPos).isCheckedOut()) {
					// set the book checked out with the holder and the due date
					library.get(arrListPos).checkingBookOut(holder, new GregorianCalendar(year, month, day));
					
					// return true
					return true;
				}
			}
		}
		
		// else return false
		return false;
	}

	/**
	 * Unsets the holder and due date of the library book.
	 * 
	 * If no book with the specified ISBN is in the library, returns false.
	 * 
	 * If the book with the specified ISBN is already checked in, returns false.
	 * 
	 * Otherwise, returns true.
	 * 
	 * @param isbn
	 *            -- ISBN of the library book to be checked in
	 */
	public boolean checkin(long isbn) {
		
		// look through the library
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// check if the book we are checking has the isbn we are looking for
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// make sure the book is checked out
				if(library.get(arrListPos).isCheckedOut()) {
					
					// check the book in
					library.get(arrListPos).checkingBookIn();
					
					// return true for check in in the book
					return true;
				}
			}
		}	
		
		// else return false
		return false;
	}

	/**
	 * Unsets the holder and due date for all library books checked out be the
	 * specified holder.
	 * 
	 * If no books with the specified holder are in the library, returns false;
	 * 
	 * Otherwise, return counts s true.
	 * 
	 * @param holder
	 *            -- holder of the library books to be checked in
	 */
	public boolean checkin(String holder) {
		
		// new array list to hold the books checked in from a holder   
		ArrayList<LibraryBook> booksCheckedInFromHolder = new ArrayList<LibraryBook>();
		
		// look through the library
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// see if the book is checked out and check if the holder is the holder we are looking for
			if(library.get(arrListPos).isCheckedOut() && library.get(arrListPos).getHolder() == holder) {
				// add the book to the checked in from holder list
				booksCheckedInFromHolder.add(library.get(arrListPos));
				// check in the book
				booksCheckedInFromHolder.add(library.get(arrListPos).checkingBookIn());
			}
		}
		
		// if the list is empty with no books return false
		if(booksCheckedInFromHolder.size() == 0) {
			return false;
		}
		
		// else there are books so return true
		return true;
	}
}
