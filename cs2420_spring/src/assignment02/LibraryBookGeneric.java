package assignment02;
import java.util.GregorianCalendar;

/**
 * Class representation of a generic library book.
 * 
 * @author  Henry Doan
 * @version January 20, 2018
 */
public class LibraryBookGeneric<T> extends Book {
	
	// variables all generic type library books have
	private T libBookHolder;
	private GregorianCalendar dueDate;
	private Boolean checkedOut;
	
	/**
	 * Constructor of the generic type library books. Reset the default variables to default.
	 * 
	 * @param isbn
	 *            -- ISBN of the book to be added
	 * @param author
	 *            -- author of the book to be added
	 * @param title
	 *            -- title of the book to be added
	 *            -- the object begin compared with "this"
	 */
	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
		
		this.libBookHolder = null;
		this.dueDate = null;
		this.checkedOut = false;
	}
	
	/**
	 * @return the library book holder
	 */
	public T getHolder(){
		return libBookHolder;
	}
	
	/**
	 * @return the due date
	 */
	public GregorianCalendar getDueDate(){
		return dueDate;
	}
	
	/**
	 * @return return if the book is checked out or not
	 */
	public boolean isCheckedOut(){
		return checkedOut;
	}
	
	/**
	 * Reset the libBookHolder, dueDate, and checkedOut to default values
	 *
	 * @return the book
	 */
	public LibraryBookGeneric<T> checkingBookIn(){
		libBookHolder = null;
		dueDate = null;
		checkedOut = false;
		
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
	public LibraryBookGeneric<T> checkingBookOut(T holder, GregorianCalendar booksDueDate){
		libBookHolder =  holder;
		dueDate = booksDueDate;
		checkedOut = true;
		
		return this;
	}

}
