/**
 * This class establishes an Array of book objects
 * called a library.
 * @author Nathan Maroko
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library implements LibraryInterface{
	
	private ArrayList<Book> bookList;
	
	public Library() {
		this.bookList = new ArrayList<Book>();
	}

	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> newList = new ArrayList<Book>();
		for(int i = 0; i < bookList.size(); i++) {
			newList.add(bookList.get(i));
		}
		return newList;
	}

	
	public void addBook(Book newBook) {
		this.bookList.add(newBook);
		
	}

	
	public void removeBook(int index) {
		if(index < bookList.size() && index >= 0) {
		this.bookList.remove(index);
		}
	}

	
	public Book getBook(int index) {
		if(index < bookList.size() && index >= 0) {
		return this.bookList.get(index);
		}
		return null;
	}
	
	public String toString() {
		String output = "";
		for(int i = 0; i < bookList.size(); i++) {
			output += "Index " + i + ":" + bookList.get(i) + "\n";
		}
		return output;
	}


	
	public void loadLibraryFromCSV(String csvFilename) {
		
		File file = new File(csvFilename);
		if(file.exists() && file.isFile()) {
			try {
				bookList.clear();
				Scanner fileScan = new Scanner(file);
				while(fileScan.hasNext()) {
					String line = fileScan.nextLine();
					Scanner lineScan = new Scanner(line);
					lineScan.useDelimiter(",");
					String title = lineScan.next();
					String author = lineScan.next();
					String genre = lineScan.next();
					String filepath = lineScan.next();
					Book b = new Book(title,author);
					b.setGenre(genre);
					b.setFilename(filepath);
					bookList.add(b);
				}
				fileScan.close();
			} catch (FileNotFoundException e) {
				
			}
			
		}
		
		
	}
	
}
