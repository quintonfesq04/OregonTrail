import javax.swing.*;
import java.awt.*;

/**
 * @File Display.java
 * @author Ethan Burch & Quinton Fesq
 * @version 2.0.4 4/17/24
 * Main gateway into Oregon Trail game. Controls which screen is being shown to the player.
 */
public class Display {
    private JFrame frame;
    private StoreScreen storeScreen;
    private TravelScreen travelScreen;
	private RiverScreen riverScreen;
	private Inventory inventory = new Inventory();
    private TradeScreen tradeScreen;
    private Player user = new Player();
    private Locations location = new Locations(0);

    // constuctor for Display object
    public Display() {
        initialize();
    }

    // initializes the display
    protected void initialize() {
        frame = new JFrame("Oregon Trail");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

		

        
        storeScreen = new StoreScreen(this, inventory);
        travelScreen = new TravelScreen(this, inventory, location, user);
		tradeScreen = new TradeScreen(this, inventory, location);
		riverScreen = new RiverScreen(this, location);

        frame.add(storeScreen.getPanel(), "StoreScreen");
        frame.add(travelScreen.getPanel(), "TravelScreen");
		frame.add(tradeScreen.getPanel(), "TradeScreen");	
        frame.add(riverScreen.getPanel(), "RiverScreen");

        showStoreScreen(); // Show the initial screen

        frame.pack(); // Adjust frame size based on the content
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    /**
     * Forces the display to switch to the Store Screen
     */
    public void showStoreScreen() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "StoreScreen");
    }

    /**
     * Forces the display to switch to the Travel Screen
     * @param inventory the inventory that Travel Screen should use
     */
    public void showTravelScreen(Inventory inventory) {
		travelScreen.setInventory(inventory);
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "TravelScreen");
    }

    /**
     * Forces the display to switch to the Travel Screen
     */
    public void showTravelScreen(){
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "TravelScreen");
    }

    /**
     * Forces the display to switch to the Trade Screen
     * @param inventory the inventory that Trade Screen should edit
     */
	public void showTradeScreen(Inventory inventory) {
        tradeScreen.setInventory(inventory);
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TradeScreen");
	}

    /**
     * Forces the display to switch to the River Screen
     */
    public void showRiverScreen(){
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "RiverScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Display::new);
    }
}
