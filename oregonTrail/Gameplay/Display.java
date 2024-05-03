package Gameplay;

import javax.imageio.ImageIO;
import javax.swing.*;

import Gameplay.*;
import Hunting.*;
import Screens.*;
import StartScreen.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Display.java -- The main display of the game
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
    private ConditionsScreen conditionsScreen;
    private LandmarkScreen landmarkScreen;
    private WagonGame wagonGame;
    private DeathScreen deathScreen;

    //StartScreen separator
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

    private CardLayout cardLayout;

    /**
     * the main gateway into the program
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

        riverScreen = new RiverScreen(wagon,this);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        tradeScreen = new TradeScreen(wagon, this);
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        controlScreen = new ControlScreen(wagon, this);
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        conversationScreen = new ConversationScreen(wagon, this);
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        conditionsScreen = new ConditionsScreen();
        getContentPane().add(conditionsScreen.getPanel(), "ConditionsScreen");

        landmarkScreen = new LandmarkScreen(wagon, this);
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        wagonGame = new WagonGame(wagon, this);
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        foragingScreen = new ForagingScreen(wagon, this);        
        getContentPane().add(foragingScreen.getPanel(), "ForagingScreen");

        deathScreen = new DeathScreen();
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

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

        groupInfo = new GroupInfo(wagon,this, trailScreen);
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

        leaveIndependence = new LeaveIndependence(wagon, this);
        getContentPane().add(leaveIndependence.getPanel(), "LeaveIndependence");

        showWelcomeScreen(wagon);
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

    public void showForagingScreen(Wagon wagon){
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
        if (wagon.getLocations().hasLeftStartingLandmark(wagon.getLocations().getDistance())) {
            storeScreen.returnToLandmarkBtn.setEnabled(true);
        } else {
            storeScreen.returnToLandmarkBtn.setEnabled(false);
        }
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
    }

    /**
     * Switches to the Conditions Screen
     */
    public void showConditionsScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "ConditionsScreen");
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
        wagonGame.startGame();
    }

    /**
     * Switches to the Death Screen
     */
    public void showDeathScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "DeathScreen");
        deathScreen.getPanel().requestFocusInWindow();
    }

    /*
     * Start Screen Separator
     * Switches to the Start Screen
     */
    public void showWelcomeScreen(Wagon wagon) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WelcomeScreen");
    }

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

    /*
     * Start Screen Separator - end
     */

    public boolean showingLandmarkScreen() {
        Component[] components = getContentPane().getComponents();
        for(Component component : components) {
            if(component.isVisible() && component.getName().equals("LandmarkScreen")) {
                return true;
            }
        }
        return false;
    }

}