/**
 * This class creates a panel that contains a TextField that
 * reads in filepaths for book objects, a button to allow for importing
 * of said book objects. Creates book buttons from these books, and places
 * them on a BookButtonPanel which is placed inside of a JScrollPane. As well,
 * this class contains the libraryList of book objects.
 * @author Nathan Maroko
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class LibraryPanel extends JPanel{
	
	private Library libraryList;
	private JPanel bookListPanel;
	private JScrollPane bookListScroll;
	private JPanel loadLibraryPanel;
	private JTextField fileField;
	private JButton loadButton;
	private ActionListener buttonListener;
	
	public LibraryPanel(ActionListener b) {
		
		buttonListener = b;
		
		libraryList = new Library();
		
		fileField = new JTextField(15);
		fileField.setText("etext/booklist.csv");
		fileField.addActionListener(new LoadButtonListener());
		
		loadButton = new JButton("LOAD");
		loadButton.addActionListener(new LoadButtonListener());
		
		this.setBorder(BorderFactory.createTitledBorder("Library"));
		this.setLayout(new BorderLayout());
		
		bookListPanel = new JPanel();
		bookListPanel.setLayout(new BoxLayout(bookListPanel,BoxLayout.Y_AXIS));
		
		loadLibraryPanel = new JPanel();
		loadLibraryPanel.setBorder(BorderFactory.createTitledBorder("Load Books"));
		loadLibraryPanel.add(fileField);
		loadLibraryPanel.add(loadButton);
		
		bookListScroll = new JScrollPane(bookListPanel);
		bookListScroll.setBorder(BorderFactory.createTitledBorder("Book List"));
		bookListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bookListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(bookListScroll, BorderLayout.CENTER);
		this.add(loadLibraryPanel, BorderLayout.SOUTH);
		
		
	}
	
	private class LoadButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			bookListPanel.removeAll();
			File file = new File(fileField.getText());
			
			if(!file.exists() || !file.isFile()) {
				fileField.setText("File not found");
			}
			
			libraryList.loadLibraryFromCSV(fileField.getText());
			
			for(int i = 0; i < libraryList.getBooks().size(); i++) {
				
				Book b = libraryList.getBook(i);
				BookButton button = new BookButton(b);
				button.addActionListener(buttonListener);
				JPanel centered = new JPanel();
				centered.setBackground(Color.GRAY);
				centered.add(button);
				bookListPanel.add(centered);
				bookListPanel.revalidate();
				
			}
			
			
			
		}
		
	}
}
