package books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book>{
	String title;
	String author;
	int year;
	
	
	public Book(String inputTitle, String inputAuthor, int inputYear) {
		title = inputTitle;
		author = inputAuthor;
		year = inputYear;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public int getYear() {
		return this.year;
	}
	
	@Override
	public String toString() {
		return this.title + " by " + this.author + " ( " + this.year + " ) " ;
	}
	
	// input file param
	@SuppressWarnings("unchecked")
	static List<Book> getList() {
		// fix this link to be in the project
		String fileName = "/Users/Henry/Documents/workspace/fall18/src/books/books.csv";
		File f = new File(fileName);
		@SuppressWarnings("rawtypes")
		List<Book> booksList = new LinkedList();
		
		try {
			Scanner bookScanner = new Scanner(f);
			
			while (bookScanner.hasNextLine()) {
				String bookLine = bookScanner.nextLine();
				String[] values = bookLine.split(",");
				
				try {
					Book b = new Book(values[0], values[1], Integer.parseInt(values[2]));

					booksList.add(b);
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
					System.out.println("Problem reading in " + bookLine + "\n");
				}
			}
			bookScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return booksList;
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.title);
	}
}
