/**
 * This class is the driver for the ReaderOfBooks GUI
 * It creates a frame, establishes a new ReaderOfBooksPanel
 * and runs the GUI.
 * @author Nathan Maroko
 */
import javax.swing.JFrame;

public class ReaderOfBooks extends JFrame{

	public static void main(String[] args) {
		
		JFrame frame = new JFrame ("Reader of Books");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ReaderOfBooksPanel());
		frame.pack();
		frame.setVisible(true);

	}

}
