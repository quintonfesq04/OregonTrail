import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 * @file Display.java
 * @author Ethan Burch
 * @version 1.2.0 4/14/24
 * Controls the display of the Wagon
 */
public class Display {

	private JFrame frame;
	private int food = 200;
	private int health = 100;

	private boolean riverPresent = true;

	private Locations locations = new Locations(90);

	private Player user = new Player(health, food, 0, 0);

	private Inventory inventory = new Inventory();

	private Conditions conditions;

	TravelScreen travelScreen = new TravelScreen(inventory, locations, user, conditions);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(!riverPresent){
			frame.add(travelScreen.getPanel());
			frame.setVisible(true);
			travelScreen.resizeBackgroundImages();
		}
		else if (riverPresent){
			RiverScreen riverScreen = new RiverScreen();
			frame.add(riverScreen.getPanel());
			frame.setVisible(true);
			riverScreen.resizeBackgroundImages();
		}		
	}
}
