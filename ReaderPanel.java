/**
 * This classes takes in data from a book button and displays
 * the book in a JTextArea. In addition, using JLabels
 * the page count, current page, author, and title are displayed
 * You have the option to scroll through the text using a JScrollPane
 * or PageUp and PageDown buttons.
 * @author Nathan Maroko
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;

public class ReaderPanel extends JPanel {

	private JLabel title,author,page;
	private JScrollPane navigationBar;
	private JTextArea bookText;
	private JButton pageUp,pageDown;
	private JPanel infoPanel,navigationPanel;
	private int pageNum,numPages;
	
	public ReaderPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Reader"));
		
		pageNum = 0;
		numPages = 0;
		
		bookText = new JTextArea();
		bookText.setEditable(false);
		bookText.setAlignmentY(CENTER_ALIGNMENT);
		
		title = new JLabel("Title: ");
		title.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		author = new JLabel("Author: ");
		author.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		page = new JLabel("Page: " + pageNum + "/" + numPages);
		page.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		
		pageUp = new JButton("Page Up");
		pageUp.addActionListener(new PageUpListener());
		pageDown = new JButton("Page Down");
		pageDown.addActionListener(new PageDownListener());
		
		
		infoPanel = new JPanel();
		infoPanel.setBorder(BorderFactory.createTitledBorder("Book Info"));
		infoPanel.add(title);
		infoPanel.add(author);
		infoPanel.add(page);
		
		navigationPanel = new JPanel();
		navigationPanel.setBorder(BorderFactory.createTitledBorder("Navigation"));
		navigationPanel.add(pageUp);
		navigationPanel.add(pageDown);
		
		navigationBar = new JScrollPane(bookText);
		navigationBar.setBorder(BorderFactory.createTitledBorder("Book Content"));
		navigationBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		navigationBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		navigationBar.getVerticalScrollBar().addAdjustmentListener(new ScrollBarListener());
		
		if(pageNum == 0) {
			pageUp.setEnabled(false);
		}else {
			pageUp.setEnabled(true);
		}
		
		if(pageNum == numPages) {
			pageDown.setEnabled(false);
		}else {
			pageDown.setEnabled(true);
		}
		
		
		this.add(navigationPanel, BorderLayout.SOUTH);
		this.add(navigationBar, BorderLayout.CENTER);
		this.add(infoPanel, BorderLayout.NORTH);
	}
	
	public void loadBook(Book b) {
		
		title.setText("Title: " + b.getTitle() + "~~");
		author.setText("Author: " + b.getAuthor() + "~~");
		numPages = navigationBar.getVerticalScrollBar().getMaximum() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
		pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
		page.setText("Page: " + pageNum + "/" + numPages);
		
		bookText.setText(b.getText());
		
	}
	
	private class PageUpListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			numPages = navigationBar.getVerticalScrollBar().getMaximum() / navigationBar.getVerticalScrollBar().getBlockIncrement(1) - 1;
			pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
			

			navigationBar.getVerticalScrollBar().setValue(navigationBar.getVerticalScrollBar().getValue() 
					- navigationBar.getVerticalScrollBar().getBlockIncrement(1));
			
			pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
			page.setText("Page: " + pageNum + "/" + numPages);
		}
		
	}
	
	private class PageDownListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			numPages = navigationBar.getVerticalScrollBar().getMaximum() / navigationBar.getVerticalScrollBar().getBlockIncrement(1) - 1;
			pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
			

			navigationBar.getVerticalScrollBar().setValue(navigationBar.getVerticalScrollBar().getValue() 
					+ navigationBar.getVerticalScrollBar().getBlockIncrement(1));
			
			pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
			page.setText("Page: " + pageNum + "/" + numPages);
		}
		
	}
	
	private class ScrollBarListener implements AdjustmentListener{

		
		public void adjustmentValueChanged(AdjustmentEvent e) {
			
			numPages = navigationBar.getVerticalScrollBar().getMaximum() / navigationBar.getVerticalScrollBar().getBlockIncrement(1) - 1;
			pageNum = navigationBar.getVerticalScrollBar().getValue() / navigationBar.getVerticalScrollBar().getBlockIncrement(1);
			
			if(pageNum == 0) {
				pageUp.setEnabled(false);
			}else {
				pageUp.setEnabled(true);
			}
			
			if(pageNum == numPages) {
				pageDown.setEnabled(false);
			}else {
				pageDown.setEnabled(true);
			}
			
			
			page.setText("Page: " + pageNum + "/" + numPages);
		}
		
	}
}
