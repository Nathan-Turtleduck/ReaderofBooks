/**
 * This panel creates two new LibraryPanel and ReaderPanel
 * objects. As well this class contains the BookButtonListener
 * allowing for data to be shared between panels.
 * @author Nathan Maroko
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReaderOfBooksPanel extends JPanel{
	
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;
	
	public ReaderOfBooksPanel() {
		
		libraryPanel = new LibraryPanel(new BookButtonListener());
		readerPanel = new ReaderPanel();
		
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(650, 500));
		
		add(libraryPanel, BorderLayout.WEST);
		add(readerPanel, BorderLayout.CENTER);
	}
	
	private class BookButtonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			BookButton button = (BookButton)e.getSource();
			Book b = button.getBook();
			readerPanel.loadBook(b);
			
		}
		
	}
}
