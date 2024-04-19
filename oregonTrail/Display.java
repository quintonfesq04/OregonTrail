import javax.swing.*;
import java.awt.*;

/**
 * Display.java - Generates the JFrame for the Oregon Trail video game
 * @author Ethan Burch
 * @version 1.0 4/18/2024
 */
public class Display extends JFrame{
	private JPanel panel;
	private JFrame frame;

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
		frame = new JFrame();
		initialize();
	}

	/**
	 * Initialize the contents e of the frame.
	 */
	private void initialize() {
		frame.setLayout(new CardLayout());

		travelScreen = new TravelScreen(locations); // needs the constructors (i think)
		frame.add(travelScreen.getPanel(), "TravelScreeen");

		startScreen = new StartScreen();
		frame.add(startScreen.getPanel(), "StartScreen");

		storeScreen = new StoreScreen();
		frame.add(storeScreen.getPanel(), "StoreScreen");

		riverScreen = new RiverScreen();
		frame.add(riverScreen.getPanel(), "RiverScreen");

		tradeScreen = new TradeScreen();
		frame.add(tradeScreen.getPanel(), "TradeScreen");

		controlScreen = new ControlScreen();
		frame.add(controlScreen.getPanel(), "ControlScreen");

		huntingScreen = new HuntingScreen();
		frame.add(huntingScreen.getPanel(), "HuntingScreen");

		conversationScreen = new ConversationScreen();
		frame.add(conversationScreen.getPanel(), "ConversationScreen");

		conditionsScreen = new ConditionsScreen();
		frame.add(conditionsScreen.getPanel(), "ConditionsScreen");

		landmarkScreen = new LandmarkScreen();
		frame.add(landmarkScreen.getPanel(), "LandmarkScreen");

		wagonGame = new WagonGame();
		frame.add(wagonGame.getPanel(), "WagonGame");

		deathScreen = new DeathScreen(null);
		frame.add(deathScreen.getPanel(), "DeathScreen");
		
		showDeathScreen();

		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new CardLayout(0, 0));
		this.setVisible(true);
        TravelScreen travelScreen = new TravelScreen(locations);
		
		this.getContentPane().add(travelScreen.getPanel(), "TravelScreen");
		this.getContentPane().add(startScreen.getPanel(), "StartScreen");
		this.getContentPane().add(storeScreen.getPanel(), "StoreScreen");
		this.getContentPane().add(riverScreen.getPanel(), "RiverScreen");
		this.getContentPane().add(tradeScreen.getPanel(), "TradeScreen");
		this.getContentPane().add(controlScreen.getPanel(), "ControlScreen");
		this.getContentPane().add(huntingScreen.getPanel(), "HuntingScreen");
		this.getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");
		this.getContentPane().add(conditionsScreen.getPanel(), "ConditionsScreen");
		this.getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");
		this.getContentPane().add(wagonGame.getPanel(), "WagonGame");
		this.getContentPane().add(deathScreen.getPanel(), "DeathScreen");
		
		System.out.println(this.getFocusOwner());
		
	}

	public void showTravelScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TravelScreen");
	}

	public void showStartScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "StartScreen");
	}

	public void showStoreScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "StoreScreen");
	}

	public void showRiverScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "RiverScreen");
	}

	public void showTradeScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "TradeScreen");
	}

	public void showControlScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ControlScreen");
	}

	public void showHuntinScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "HuntingScreen");
	}

	public void showConversationScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ConversationScreen");
	}

	public void showConditionsScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "ConditionsScreen");
	}

	public void showLandmarkScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "LandmarkScreen");
	}

	public void showWagonGame() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "WagonGame");
	}

	public void showDeathScreen() {
		CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
		cardLayout.show(frame.getContentPane(), "DeathScreen");
	}
}