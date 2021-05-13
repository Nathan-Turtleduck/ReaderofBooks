/**
 * This class creates a book object which holds data 
 * for a title, author, genre, and filepath for
 * an etext book.
 * 
 * @author Nathan Maroko
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Book implements BookInterface{
	private String title;
	private String author;
	private String genre;
	private String filename;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.genre = null;
		this.filename = null;
	}
	/**
	 * Returns the current book title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the book title
	 */
	public void setTitle(String title) {
		this.title = title;
		
	}
	/**
	 * Returns the current author file
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Sets the book's author
	 */
	public void setAuthor(String author) {
		this.author = author;
		
	}
	/**
	 * Returns the current book genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Sets the book's genre 
	 */
	public void setGenre(String genre) {
		this.genre = genre;
		
	}
	/**
	 * Returns the current book filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * Sets the book's filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
		
	}
	
	public boolean isValid() {
		boolean condition = false;
		if ((this.genre != null) && (this.author != null) && (this.title != null) && (this.filename != null)){
			File file = new File(this.filename);
			if(file.exists() && file.isFile()) {
				condition = true;
			}
		}
		return condition;
	}
	
	public String toString() {
		String output = "";
		output = this.title + " by " + this.author + " (" + this.genre +")";
		return output;
	}
	
	public String getText() {
		String output = "";
		StringBuilder fullText = new StringBuilder();
		if(!(filename == null)) {
		File file = new File(this.filename);
		if(file.exists()) {
		try {
			Scanner scan1 = new Scanner(file);
			while (scan1.hasNextLine()) {
				fullText.append(scan1.nextLine() + "\n");
				}
			output = fullText.toString();
			scan1.close();
		} catch (FileNotFoundException e) {
			output = "File cannot be opened.";	
		}
		}else {
			output = "File cannot be opened.";
		}
		}else {
			output = "File cannot be opened.";
		}
		return output;
		
	}
}
