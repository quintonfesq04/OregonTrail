package Gameplay;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Screens.ControlScreen;
import Screens.ConversationScreen;
import Screens.DeathScreen;
import Screens.EndGame;
import Screens.ForagingScreen;
import Screens.LandmarkScreen;
import Screens.RiverScreen;
import Screens.StoreScreen;
import Screens.TradeScreen;
import Screens.TravelScreen;
import Screens.WagonGame;
import StartScreen.BeforeLeaving;
import StartScreen.ChooseMonth;
import StartScreen.GroupInfo;
import StartScreen.LearnTrail;
import StartScreen.LeaveIndependence;
import StartScreen.MayasStore;
import StartScreen.MonthAdvice;
import StartScreen.TheOregonTrail;
import StartScreen.TrailScreen;
import StartScreen.WagonNames;
import StartScreen.WelcomeScreen;

/**
 * Display.java -- The main display of the game
 * 
 * @author Ethan Burch
 * @author Quinton Fesq
 * @author Madison Scott
 * @version 2.4.4 4/24/24
 */
public class Display extends JFrame {
    private TravelScreen travelScreen;
    private ForagingScreen foragingScreen;
    private StoreScreen storeScreen;
    private RiverScreen riverScreen;
    private TradeScreen tradeScreen;
    private ControlScreen controlScreen;
    private ConversationScreen conversationScreen;
    private LandmarkScreen landmarkScreen;
    private WagonGame wagonGame;
    private DeathScreen deathScreen;
    private EndGame endGame;

    // StartScreen separator
    private WelcomeScreen welcomeScreen;
    private TheOregonTrail theOregonTrail;
    private TrailScreen trailScreen;
    private LearnTrail learnTrail;
    private GroupInfo groupInfo;
    private WagonNames wagonNames;
    private ChooseMonth chooseMonth;
    private MonthAdvice monthAdvice;
    private BeforeLeaving beforeLeaving;
    private MayasStore mayasStore;
    private LeaveIndependence leaveIndependence;

    Wagon wagon = new Wagon();

    /**
     * the main gateway into the program
     * 
     * @param args
     */
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

    /**
     * Constructor for Display object
     */
    public Display() {
        initialize();
    }

    /**
     * initializes the Display
     */
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 675);
        getContentPane().setLayout(new CardLayout());

        // construct travelScreen and add to frame
        travelScreen = new TravelScreen(wagon, this);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        // construct storeScreen and add to frame
        storeScreen = new StoreScreen(wagon, this);
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        // construct riverScreen and add to frame
        riverScreen = new RiverScreen(wagon, this);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        // construct tradeScreen and add to frame
        tradeScreen = new TradeScreen(wagon, this);
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        // construct controlScreen and add to frame
        controlScreen = new ControlScreen(wagon, this);
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        // construct conversationScreen and add to frame
        conversationScreen = new ConversationScreen(this);
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        // construct landmarkScreen and add to frame
        landmarkScreen = new LandmarkScreen(wagon, this);
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        // construct wagonGame and add to frame
        wagonGame = new WagonGame(wagon, this);
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        // construct foragingScreen and add to frame
        foragingScreen = new ForagingScreen(wagon, this, controlScreen);
        getContentPane().add(foragingScreen.getPanel(), "ForagingScreen");

        // construct deathScreen and add to frame
        deathScreen = new DeathScreen();
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

        // construct endGame and add to frame
        endGame = new EndGame(wagon);
        getContentPane().add(endGame.getPanel(), "EndGame");

        //Start Screen Separator

        // construct welcomeScreen and add to frame
        welcomeScreen = new WelcomeScreen(wagon, this);
        getContentPane().add(welcomeScreen.getPanel(), "WelcomeScreen");

        // construct theOregonTrail and add to frame
        theOregonTrail = new TheOregonTrail(wagon, this);
        getContentPane().add(theOregonTrail.getPanel(), "TheOregonTrail");

        // construct trailScreen and add to frame
        trailScreen = new TrailScreen(wagon, this);
        getContentPane().add(trailScreen.getPanel(), "TrailScreen");

        // construct learnScreen and add to frame
        learnTrail = new LearnTrail(wagon, this);
        getContentPane().add(learnTrail.getPanel(), "LearnTrail");

        // construct groupInfo and add to frame
        groupInfo = new GroupInfo(wagon, this, trailScreen);
        getContentPane().add(groupInfo.getPanel(), "GroupInfo");

        // construct wagonNames and add to frame
        wagonNames = new WagonNames(wagon, this);
        getContentPane().add(wagonNames.getPanel(), "WagonNames");

        // construct chooseMonth and add to frame
        chooseMonth = new ChooseMonth(wagon, this);
        getContentPane().add(chooseMonth.getPanel(), "ChooseMonth");

        // construct monthAdvice and add to frame
        monthAdvice = new MonthAdvice(wagon, this, chooseMonth);
        getContentPane().add(monthAdvice.getPanel(), "MonthAdvice");

        // construct beforeLeaving and add to frame
        beforeLeaving = new BeforeLeaving(wagon, this, trailScreen);
        getContentPane().add(beforeLeaving.getPanel(), "BeforeLeaving");

        // construct mayasStore and add to frame
        mayasStore = new MayasStore(wagon, this);
        getContentPane().add(mayasStore.getPanel(), "MayasStore");

        // construct leaveIndependence and add to frame
        leaveIndependence = new LeaveIndependence(wagon, this, travelScreen);
        getContentPane().add(leaveIndependence.getPanel(), "LeaveIndependence");

        showEndGame(wagon);
    }

    /**
     * Switches to the Travel Screen
     */
    public void showTravelScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TravelScreen");
        travelScreen.updateScreen(wagon);
        travelScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Start Screen
     */
    public void showStartScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "StartScreen");
    }

    /**
     * Switches to the Foraging Screen
     * 
     * @param wagon the wagon object to add food into
     */
    public void showForagingScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ForagingScreen");
        foragingScreen.updatePanel(wagon);
        foragingScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Store Screen
     */
    public void showStoreScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "StoreScreen");
    }

    /**
     * Switches to the River Screen
     */
    public void showRiverScreen(Wagon wagon) {
        riverScreen.update(wagon);
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "RiverScreen");
    }

    /**
     * Switches to the Trade Screen
     */
    public void showTradeScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TradeScreen");
        tradeScreen.updateDisplay();
    }

    /**
     * Switches to the Control Screen
     */
    public void showControlScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ControlScreen");
        controlScreen.getPanel().setVisible(true);
        controlScreen.updateDisplay();
        controlScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Hunting Screen
     */
    public void showHuntingScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "HuntingScreen");
    }

    /**
     * Switches to the Conversations Screen
     */
    public void showConversationScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ConversationScreen");
        conversationScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Landmark Screen
     */
    public void showLandmarkScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LandmarkScreen");
        conversationScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Wagon Screen
     */
    public void showWagonGame() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WagonGame");
        wagonGame.resetGame();
    }

    /**
     * Switches to the Death Screen
     */
    public void showDeathScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "DeathScreen");
        deathScreen.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Start Screen
     * 
     * @param wagon the wagon to pass information to and from
     */
    public void showWelcomeScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WelcomeScreen");
    }

    /**
     * Switches to Thr Oregon Trail Screen
     * 
     * @param wagon the wagon to pass information to and from
     */
    public void showTheOregonTrail(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TheOregonTrail");
    }

    /**
     * Switches to the Trail Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showTrailScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TrailScreen");
    }

    /**
     * Switches to the Learn Trail Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showLearnTrail(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LearnTrail");
        learnTrail.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Group Info Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showGroupInfo(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "GroupInfo");
        groupInfo.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Wagon Names Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showWagonNames(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WagonNames");
    }

    /**
     * Switches to the Choose Month Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showChooseMonth(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ChooseMonth");
    }

    /**
     * Switches to the Month Advice Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showMonthAdvice(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "MonthAdvice");
        monthAdvice.getPanel().requestFocusInWindow();
    }

    /**
     * Switches to the Before Leaving Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showBeforeLeaving(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "BeforeLeaving");
        beforeLeaving.getPanel().requestFocusInWindow();
        beforeLeaving.updateLabel();
    }

    /**
     * Switches to the Mayas Store Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showMayasStore(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "MayasStore");
        mayasStore.getPanel().requestFocusInWindow();
        mayasStore.updateLabel();
    }
     /**
     * Switches to the Leave Independence Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showLeaveIndependence(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LeaveIndependence");
        leaveIndependence.getPanel().requestFocusInWindow();
    }
     /**
     * Switches to the End Game Screen
     * 
     * @param wagon the desired wagon to be used
     */
    public void showEndGame(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "EndGame");
        endGame.getPanel().requestFocusInWindow();
    }

    /**
     * Checks if currently showing the landmark screen
     * @return true if showing the landmark screen, false otherwise
     */
    public boolean showingLandmarkScreen() {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component.isVisible() && component.getName().equals("LandmarkScreen")) {
                return true;
            }
        }
        return false;
    }

}