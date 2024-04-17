// Display.java
import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JPanel panel;
    private StoreScreen store;
    private TravelScreen travelScreen;

    public Display() {
        initialize();
    }

    protected void initialize() {
        frame = new JFrame("Oregon Trail");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use a JPanel with CardLayout for managing multiple screens
        panel = new JPanel(new CardLayout());
        frame.getContentPane().add(panel);

        store = new StoreScreen(this);
        travelScreen = new TravelScreen();

        // Add StoreScreen and TravelScreen panels to the CardLayout
        panel.add(store.getPanel(), "StoreScreen");
        panel.add(travelScreen.getPanel(), "TravelScreen");

        // Show the initial screen (StoreScreen)
        showStoreScreen();

        frame.setVisible(true);
    }

    // Method to switch to the StoreScreen
    public void showStoreScreen() {
        CardLayout cardLayout = (CardLayout) panel.getLayout();
        cardLayout.show(panel, "StoreScreen");
    }

    // Method to switch to the TravelScreen
    public void showTravelScreen() {
        CardLayout cardLayout = (CardLayout) panel.getLayout();
        cardLayout.show(panel, "TravelScreen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Display::new);
    }
}
