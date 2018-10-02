package assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Class representation of a library (a collection of generic type library books) with generic.
 * 
 * @author  Henry Doan
 * @version January 20, 2018
 */
public class LibraryGeneric<T> {

	// An array list to hold all the library books
	private ArrayList<LibraryBookGeneric<T>> library;

	/**
	 * Constructor of the generic library. Creates a new array list for library books
	 */
	public LibraryGeneric() {
		library = new ArrayList<LibraryBookGeneric<T>>();
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
		library.add(new LibraryBookGeneric<T>(isbn, author, title));
	}

	/**
	 * Add the list of library books to the library, assume no duplicates.
	 * 
	 * @param list
	 *            -- list of library books to be added
	 */
	public void addAll(ArrayList<LibraryBookGeneric<T>> list) {
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
		ArrayList<LibraryBookGeneric<T>> toBeAdded = new ArrayList<LibraryBookGeneric<T>>();

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
					toBeAdded.add(new LibraryBookGeneric<T>(isbn, author, title));
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
	public T lookup(long isbn) {
		
		// look in the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// look at the isbn number of the book
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// return the holder of the book
				return library.get(arrListPos).getHolder();
			}
		}
		
		// no books are found return null
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
	public ArrayList<LibraryBookGeneric<T>> lookup(T holder) {

		// new array list to hold the books checked out from a holder 
		ArrayList<LibraryBookGeneric<T>> booksCheckedOutFromHolder = new ArrayList<LibraryBookGeneric<T>>();
		
		// look in the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// check to see if the holder is the one we are looking for
			if(library.get(arrListPos).getHolder() == holder) {
				
				// add the book on to the booksCheckedOutFromHolder array list
				booksCheckedOutFromHolder.add(library.get(arrListPos));
			}
		}
		
		// return the array list, if no books are found return empty array list
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
	public boolean checkout(long isbn, T holder, int month, int day, int year) {
		
		// look through the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// if the book has the isbn that we are looking for
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// makes sure the book isn't checked out
				if(!library.get(arrListPos).isCheckedOut()) {
					
					// check out the book with the holder and duedate
					library.get(arrListPos).checkingBookOut(holder, new GregorianCalendar(year, month, day));
					
					// return the book is checked out
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
		
		// look through the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// if the book has the isbn that we are looking for
			if(library.get(arrListPos).getIsbn() == isbn) {
				
				// makes sure the book is checked out
				if(library.get(arrListPos).isCheckedOut()) {
					
					// check the book in
					library.get(arrListPos).checkingBookIn();
					
					// return true
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
	public boolean checkin(T holder) {
		
		// new array list to hold the books checked in from a holder 
		ArrayList<LibraryBookGeneric<T>> booksCheckedInFromHolder = new ArrayList<LibraryBookGeneric<T>>();
		
		// look through the library at each book
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// check to see if the book is checked out and to see if the holder is the one we are looking for
			if(library.get(arrListPos).isCheckedOut() && library.get(arrListPos).getHolder() == holder) {
				
				// add the book to the array list
				booksCheckedInFromHolder.add(library.get(arrListPos));
				
				// check the book in
				booksCheckedInFromHolder.add(library.get(arrListPos).checkingBookIn());
			}
		}
		
		// if the list is empty, return false
		if(booksCheckedInFromHolder.size() == 0) {
			return false;
		}
		
		// the list is full of books, return true
		return true;
	}
	
	/**
	 * Returns the list of library books, sorted by ISBN (smallest ISBN first).
	 */
	public ArrayList<LibraryBookGeneric<T>> getInventoryList() {
		ArrayList<LibraryBookGeneric<T>> libraryCopy = new ArrayList<LibraryBookGeneric<T>>();
		libraryCopy.addAll(library);

		OrderByIsbn comparator = new OrderByIsbn();

		sort(libraryCopy, comparator);

		return libraryCopy;
	}

	/**
	 * Returns the list of library books, sorted by author
	 */
	public ArrayList<LibraryBookGeneric<T>> getOrderedByAuthor() {
		
		// Make a new library to store sorted books by author
		ArrayList<LibraryBookGeneric<T>> orderedLibraryByAuthor = new ArrayList<LibraryBookGeneric<T>>();
		
		// add all the books from library
		orderedLibraryByAuthor.addAll(library);

		// a new comparator 
		OrderByAuthor comparator = new OrderByAuthor();

		// pass the comparator to be sorted
		sort(orderedLibraryByAuthor, comparator);

		// return the sorted by author library
		return orderedLibraryByAuthor;
	}

	/**
	 * Returns the list of library books whose due date is older than the input
	 * date. The list is sorted by date (oldest first).
	 *
	 * If no library books are overdue, returns an empty list.
	 */
	public ArrayList<LibraryBookGeneric<T>> getOverdueList(int month, int day, int year) {
		
		// Make a new library to store sorted books by date
		ArrayList<LibraryBookGeneric<T>> orderedLibraryByDate = new ArrayList<LibraryBookGeneric<T>>();
		
		// Get the current date 
		GregorianCalendar currentDate = new GregorianCalendar(year,month,day);
		
		// Loop through library
		for(int arrListPos = 0; arrListPos < library.size(); arrListPos++) {
			
			// if the book is checked out
			if(library.get(arrListPos).isCheckedOut()) {
				
				/**
				 * if the date is before the current date meaning it is over due
				 * by using .before "Returns whether this Calendar represents a time 
				 * before the time represented by the specified Object." or compares
				 * the time to see if the left hand side is before the current time.
				 */
				if(library.get(arrListPos).getDueDate().before(currentDate)) {
					
					// add the book to the sorted library
					orderedLibraryByDate.add(library.get(arrListPos));
				}
			}
		}
		
		// a new comparator 
		OrderByDueDate comparator = new OrderByDueDate();
		
		// pass the comparator to be sorted
		sort(orderedLibraryByDate, comparator);
		
		// return the sorted by date library
		return orderedLibraryByDate;
	}



	/**
	 * Performs a SELECTION SORT on the input ArrayList. 
	 *    1. Find the smallest item in the list. 
	 *    2. Swap the smallest item with the first item in the list. 
	 *    3. Now let the list be the remaining unsorted portion 
	 *       (second item to Nth item) and repeat steps 1, 2, and 3.
	 */
	private static <ListType> void sort(ArrayList<ListType> list, Comparator<ListType> c) {
		for (int i = 0; i < list.size() - 1; i++) {
			int j, minIndex;
			for (j = i + 1, minIndex = i; j < list.size(); j++)
				if (c.compare(list.get(j), list.get(minIndex)) < 0)
					minIndex = j;
			ListType temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}

	/**
	 * Comparator that defines an ordering among library books using the ISBN.
	 */
	protected class OrderByIsbn implements Comparator<LibraryBookGeneric<T>> {

		/**
		 * Returns a negative value if lhs is smaller than rhs. Returns a positive
		 * value if lhs is larger than rhs. Returns 0 if lhs and rhs are equal.
		 */
		public int compare(LibraryBookGeneric<T> lhs, LibraryBookGeneric<T> rhs) {
			return (int) (lhs.getIsbn() - rhs.getIsbn());
		}
	}

	/**
	 * Comparator that defines an ordering among library books using the author,  and book title as a tie-breaker.
	 */
	protected class OrderByAuthor implements Comparator<LibraryBookGeneric<T>> {
		
		// Override the original compare function then Compares the lhs and rhs books author then compares the books by title
		@Override
		public int compare(LibraryBookGeneric<T> lhs, LibraryBookGeneric<T> rhs) {
			
			// compares the authors
			int compared = lhs.getAuthor().compareTo(rhs.getAuthor());
			
			// if authors are same
			if(compared == 0) {
				// compares the titles
				compared = lhs.getTitle().compareTo(rhs.getTitle());
			}
			
			// return the compared
			return compared;
		}
	}

	/**
	 * Comparator that defines an ordering among library books using the due date.
	 */
	protected class OrderByDueDate implements Comparator<LibraryBookGeneric<T>> {
		
		 // Compares the due dates of the lhs and the rhs books using the gregorian calendar
		@Override
		public int compare(LibraryBookGeneric<T> lhs, LibraryBookGeneric<T> rhs) {
			
			// returns the compared
			return lhs.getDueDate().compareTo(rhs.getDueDate());
		}
	}

}
