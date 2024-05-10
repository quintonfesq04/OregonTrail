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

        travelScreen = new TravelScreen(wagon, this);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        storeScreen = new StoreScreen(wagon, this);
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        riverScreen = new RiverScreen(wagon, this);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        tradeScreen = new TradeScreen(wagon, this);
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        controlScreen = new ControlScreen(wagon, this, foragingScreen);
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        conversationScreen = new ConversationScreen(wagon, this);
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        landmarkScreen = new LandmarkScreen(wagon, this);
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        wagonGame = new WagonGame(wagon, this);
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        foragingScreen = new ForagingScreen(wagon, this, controlScreen);
        getContentPane().add(foragingScreen.getPanel(), "ForagingScreen");

        deathScreen = new DeathScreen();
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

        endGame = new EndGame(wagon);
        getContentPane().add(endGame.getPanel(), "EndGame");

        /*
         * Start Screen Separator
         */

        welcomeScreen = new WelcomeScreen(wagon, this);
        getContentPane().add(welcomeScreen.getPanel(), "WelcomeScreen");

        theOregonTrail = new TheOregonTrail(wagon, this);
        getContentPane().add(theOregonTrail.getPanel(), "TheOregonTrail");

        trailScreen = new TrailScreen(wagon, this);
        getContentPane().add(trailScreen.getPanel(), "TrailScreen");

        learnTrail = new LearnTrail(wagon, this);
        getContentPane().add(learnTrail.getPanel(), "LearnTrail");

        groupInfo = new GroupInfo(wagon, this, trailScreen);
        getContentPane().add(groupInfo.getPanel(), "GroupInfo");

        wagonNames = new WagonNames(wagon, this);
        getContentPane().add(wagonNames.getPanel(), "WagonNames");

        chooseMonth = new ChooseMonth(wagon, this);
        getContentPane().add(chooseMonth.getPanel(), "ChooseMonth");

        monthAdvice = new MonthAdvice(wagon, this, chooseMonth);
        getContentPane().add(monthAdvice.getPanel(), "MonthAdvice");

        beforeLeaving = new BeforeLeaving(wagon, this, trailScreen);
        getContentPane().add(beforeLeaving.getPanel(), "BeforeLeaving");

        mayasStore = new MayasStore(wagon, this);
        getContentPane().add(mayasStore.getPanel(), "MayasStore");

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

    public void showTrailScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TrailScreen");
    }

    public void showLearnTrail(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LearnTrail");
        learnTrail.getPanel().requestFocusInWindow();
    }

    public void showGroupInfo(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "GroupInfo");
        groupInfo.getPanel().requestFocusInWindow();
    }

    public void showWagonNames(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WagonNames");
    }

    public void showChooseMonth(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ChooseMonth");
    }

    public void showMonthAdvice(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "MonthAdvice");
        monthAdvice.getPanel().requestFocusInWindow();
    }

    public void showBeforeLeaving(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "BeforeLeaving");
        beforeLeaving.getPanel().requestFocusInWindow();
        beforeLeaving.updateLabel();
    }

    public void showMayasStore(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "MayasStore");
        mayasStore.getPanel().requestFocusInWindow();
        mayasStore.updateLabel();
    }

    public void showLeaveIndependence(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "LeaveIndependence");
        leaveIndependence.getPanel().requestFocusInWindow();
    }

    public void showEndGame(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "EndGame");
        endGame.getPanel().requestFocusInWindow();
    }

    /*
     * Start Screen Separator - end
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