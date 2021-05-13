/**
 * This class creates a book button object that passes
 * a book object in as a parameter. A book button
 * is a JButton with a little bit more.
 * @author Nathan Maroko
 */
import javax.swing.*;

public class BookButton extends JButton {

	private Book b;
	
	public BookButton(Book b) {
		this.b = b;
		if(b.getTitle().length() >= 20) {
			
			String shortened = b.getTitle().substring(0, 17) + "...";
			this.setText(shortened);
		} else {
			this.setText(b.getTitle());
		}
		
		this.setToolTipText(b.toString());
		
	}
	/**
	 * Returns an instance of the book object the button is attached to.
	 * @returns book
	 */
	public Book getBook() {
		return b;
	}
	
}
