import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JPanel panel;
    private StoreScreen storeScreen;
    private TravelScreen travelScreen;
	private TradeScreen tradeScreen;
	private Inventory inventory = new Inventory();

    public Display() {
        initialize();
    }

    protected void initialize() {
        frame = new JFrame("Oregon Trail");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

		

        storeScreen = new StoreScreen(this, null);
        travelScreen = new TravelScreen();
		tradeScreen = new TradeScreen(null);

        frame.add(storeScreen.getPanel(), "StoreScreen");
        frame.add(travelScreen.getPanel(), "TravelScreen");
		frame.add(tradeScreen.getPanel(), "TradeScreen");	

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

	public void showTradeScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TradeScreen");
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Display::new);
    }
}
