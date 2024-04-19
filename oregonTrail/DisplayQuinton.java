import javax.swing.*;
import java.awt.*;

public class DisplayQuinton extends JFrame{
	private TravelScreen travelScreen;

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
	public DisplayQuinton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setLayout(new CardLayout());

		travelScreen = new TravelScreen(locations) // needs the constructors (i think)
		frame.add(travelScreen.getPanel(), "TravelScreeen");
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.requestFocusInWindow();
        TravelScreen travelScreen = new TravelScreen(locations);
		
		this.getContentPane().add(travelScreen.getPanel(), "travelScreen");
		System.out.println(this.getFocusOwner());
		
	}

	public void showTravelScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TravelScreen");
	}
}


/*
 * Card Layout stuff:
 * private StoreScreen storeScreen;
 * frame.setLayout(new CardLayout());
 * storeScreen = new StoreScreen(this, inventory);
 * frame.add(storeScreen.getPanel(), "StoreScreen");
 * showStoreScreen(); -> only used if showing as the initial screen
 * 
 * public void showStoreScreen() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "StoreScreen");
    }
 */