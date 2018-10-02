package assignment02;
import java.util.GregorianCalendar;

/**
 * Class representation of a library book.
 * 
 * @author  Henry Doan
 * @version January 20, 2018
 */
public class LibraryBook extends Book {
	
	// Variables all library books have
	private String libBookHolder;
	private GregorianCalendar dueDate;
	private Boolean checkedOut;
	
	/**
	 * Constructor of the library books. Reset the default variables to default.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be added
	 * @param author
	 *            -- author of the book to be added
	 * @param title
	 *            -- title of the book to be added
	 *            -- the object begin compared with "this"
	 */
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
		
		this.libBookHolder = null;
		this.dueDate = null;
		this.checkedOut = false;
	}

	/**
	 * @return the library book holder
	 */
	public String getHolder() {
		return libBookHolder;
	}
	
	/**
	 * @return the due date
	 */
	public GregorianCalendar getDueDate() {
		return dueDate;
	}
	
	/**
	 * @return return if the book is checked out or not
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	/**
	 * Reset the libBookHolder, dueDate, and checkedOut to default values
	 *
	 * @return the book
	 */
	public LibraryBook checkingBookIn() {
		this.libBookHolder = null;
		this.dueDate = null;
		this.checkedOut = false;
		
		return this;
	}
	
	/**
	 * Checks the books in with the holder and booksDuedate set to the library books
	 * holder and duedate and sets checked out to true
	 * 
	 * @param holder
	 *            -- a string of the holder for the book
	 * @param booksDueDate
	 *            -- is a date represented with the Gregorian calendar
	 *            -- the object begin compared with "this"
	 */
	public void checkingBookOut(String holder, GregorianCalendar booksDueDate) {
		this.libBookHolder =  holder;
		this.dueDate = booksDueDate;
		this.checkedOut = true;
	}
}
