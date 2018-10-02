package assignment02;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for LibraryGeneric.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBookGeneric<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("801.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))  
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    
    // Further testing for generics by Henry Doan
    PhoneNumber testNumber = new PhoneNumber("801.420.6969");
    
    ArrayList<LibraryBookGeneric<PhoneNumber>> newBooksByPhone = generateLibrary(10000);
    
	lib2.addAll(newBooksByPhone);
	for( int testBook = 0; testBook < newBooksByPhone.size(); testBook++) {
		
		if(!lib2.checkout(newBooksByPhone.get(testBook).getIsbn(), testNumber, 0, 1, 1999)) {
			System.err.println("TEST FAILED: checkout(ISBN holder)");
		}
		
		if(!newBooksByPhone.get(testBook).getDueDate().equals(new GregorianCalendar(1999, 0, 1))) {
			System.err.println("TEST FAILED: getDueDate(Holder date)");
		}
		
		if((newBooksByPhone.get(testBook).getDueDate() == null)) {
			System.err.println("TEST FAILED: getDueDate(Holder NULL)");
		}
		
		if(!lib2.lookup(newBooksByPhone.get(testBook).getIsbn()).equals(testNumber)) {
			System.err.println("TEST FAILED: lookup(ISBN)");
		}
		
		if(!lib2.lookup(newBooksByPhone.get(testBook).getIsbn()).equals(testNumber)) {
			System.err.println("TEST FAILED: lookup(ISBN)");
		}
		
		if(!lib2.checkin(newBooksByPhone.get(testBook).getIsbn())) {
			System.err.println("TEST FAILED: checkin(ISBN)");
		}

		if(!lib2.checkout(newBooksByPhone.get(testBook).getIsbn(), testNumber, 0, 1, 1999)) {
			System.err.println("TEST FAILED: checkout(ISBN, Holder Date)");
		}
		
	}
	
    System.out.println("Testing done.");

  }
  
  /**
	 * Returns a library of test books with random titles, authors and isbn 
	 * 
	 * 
	 * @param size --
	 *          size of the library to be generated
	 */
	public static <T> ArrayList<LibraryBookGeneric<T>> generateLibrary(int size) {
		
		// new array list of the results
		ArrayList<LibraryBookGeneric<T>> randomBooks = new ArrayList<LibraryBookGeneric<T>>();

		for (int i = 0; i < size; i++) {
			
			// generate random ISBN
			Random randomNumGen = new Random();
			String isbn = "";
			
			for (int isbnChar = 0; isbnChar < 13; isbnChar++) {
				isbn += randomNumGen.nextInt(10);
			}
		
			// add the book to the ending list
			randomBooks.add(new LibraryBookGeneric<T>(Long.parseLong(isbn), "test Author", "test  title"));
		}

		return randomBooks;
	}

}
