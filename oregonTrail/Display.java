import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

	private boolean riverPresent = false;

	private Locations locations = new Locations(90);

	private Player user = new Player(health, food, 0, 0);

	private Inventory inventory = new Inventory();

	private Conditions conditions;

	TravelScreen travelScreen = new TravelScreen(inventory, locations, user, conditions);

	static boolean changed = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);

					 while(true){
						if(changed == true){
							
						}
					 }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// Runnable r = new Controller(window);
		// Thread t = new Thread(r);
		// t.start();
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
		JPanel panel = new JPanel();
		frame.add(panel);
		
		

		while(true){
		if(!riverPresent && changed ){
			panel.add(travelScreen.getPanel());
			panel.setVisible(true);
			travelScreen.resizeBackgroundImages();
		}
		else if (riverPresent){
			RiverScreen riverScreen = new RiverScreen();
			panel.remove(travelScreen.getPanel());
			panel.add(riverScreen.getPanel());
			panel.setVisible(true);
			riverScreen.resizeBackgroundImages();
		}		
		changed = false;
	}
	}

	public void updateDisplay(boolean riverPresent){
		boolean changed= false;
		if(this.riverPresent != riverPresent){
			changed = true;
			this.riverPresent = riverPresent;
		}

		if(changed)
			initialize();
	}
	public void setRiverPresent(boolean riverPresent){
		this.riverPresent = riverPresent;
	}
}
