import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Display.java - Generates the JFrame for the Oregon Trail video game
 * @author Ethan Burch
 * @version 1.0 4/18/2024
 */
public class Display extends JFrame{
    Locations locations = new Locations();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.getContentPane().requestFocus();
        TravelScreen travelScreen = new TravelScreen(locations);
		
		this.getContentPane().add(travelScreen.getPanel(), "travelScreen");
		this.getContentPane().addKeyListener(new MapChecker(locations));
		System.out.println(this.getFocusOwner());
		
	}
}