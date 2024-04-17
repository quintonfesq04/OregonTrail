import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JPanel panel;
    private StoreScreen storeScreen;
    private TravelScreen travelScreen;
	private RiverScreen riverScreen;
	private Inventory inventory = new Inventory();
    private TradeScreen tradeScreen;
    private Player user = new Player();
    private Locations location = new Locations(0);

    public Display() {
        initialize();
    }

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

    public void showStoreScreen() {
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "StoreScreen");
    }

    public void showTravelScreen(Inventory inventory) {
		travelScreen.setInventory(inventory);
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "TravelScreen");
    }

    public void showTravelScreen(){
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
        cardLayout.show(frame.getContentPane(), "TravelScreen");
    }

	public void showTradeScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TradeScreen");
	}

    public void showRiverScreen(){
        CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "RiverScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Display::new);
    }
}
