package Stuff;
import javax.imageio.ImageIO;
import javax.swing.*;

import Hunting.*;
import Screens.*;
import Stuff.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Display extends JFrame {
    private JFrame frame;
    private JPanel currentPanel;

    private TravelScreen travelScreen;
    private StartScreen startScreen;
    private StoreScreen storeScreen;
    private RiverScreen riverScreen;
    private TradeScreen tradeScreen;
    private ControlScreen controlScreen;
    private HuntingScreen huntingScreen;
    private ConversationScreen conversationScreen;
    private ConditionsScreen conditionsScreen;
    private LandmarkScreen landmarkScreen;
    private WagonGame wagonGame;
    private DeathScreen deathScreen;

    Locations locations = new Locations(0);

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Display window = new Display();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Display() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 675);
        getContentPane().setLayout(new CardLayout());

        travelScreen = new TravelScreen(null);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        startScreen = new StartScreen(this);
        getContentPane().add(startScreen.getPanel(), "StartScreen");

        storeScreen = new StoreScreen();
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        riverScreen = new RiverScreen(locations);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        tradeScreen = new TradeScreen();
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        controlScreen = new ControlScreen();
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        huntingScreen = new HuntingScreen();
        getContentPane().add(huntingScreen.getPanel(), "HuntingScreen");

        conversationScreen = new ConversationScreen();
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        conditionsScreen = new ConditionsScreen();
        getContentPane().add(conditionsScreen.getPanel(), "ConditionsScreen");

        landmarkScreen = new LandmarkScreen();
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        wagonGame = new WagonGame();
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        deathScreen = new DeathScreen(null);
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

        showStartScreen();
    }

	public void showTravelScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "TravelScreen");
	}

	public void showStartScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "StartScreen");
	}

	public void showStoreScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "StoreScreen");
	}

	public void showRiverScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "RiverScreen");
	}

	public void showTradeScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "TradeScreen");
	}

	public void showControlScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "ControlScreen");
	}

	public void showHuntinScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "HuntingScreen");
	}

	public void showConversationScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "ConversationScreen");
	}

	public void showConditionsScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "ConditionsScreen");
	}

	public void showLandmarkScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "LandmarkScreen");
	}

	public void showWagonGame() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "WagonGame");
	}

	public void showDeathScreen() {
		CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
		cardLayout.show(getContentPane(), "DeathScreen");
	}

    public void setScreens(List<String> imageNames) {
        List<JPanel> panels = new ArrayList<>();
        for (String imageName : imageNames) {
            try {
                File file = new File(imageName);
                if (file.exists()) {
                    JLabel label = new JLabel(new ImageIcon(ImageIO.read(file)));
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.add(label);
                    panels.add(panel);
                } else {
                    System.err.println("File not found: " + imageName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        if (!panels.isEmpty()) {
            currentPanel = panels.get(0); // Show the first panel
            getContentPane().removeAll(); // Clear the content pane
            getContentPane().add(currentPanel, "StartScreen"); // Add the current panel as the StartScreen
            showStartScreen(); // Show the StartScreen
            revalidate(); // Refresh the frame
            repaint();
        }
    }
    
}