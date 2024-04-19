import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

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

    Locations locations = new Locations();

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
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new CardLayout());

        travelScreen = new TravelScreen(locations);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        startScreen = new StartScreen();
        getContentPane().add(startScreen.getPanel(), "StartScreen");

        storeScreen = new StoreScreen();
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        riverScreen = new RiverScreen();
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

        showDeathScreen();
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
}