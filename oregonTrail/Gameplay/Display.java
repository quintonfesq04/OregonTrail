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
 * @version 2.4.1 4/24/24
 */
public class Display extends JFrame {
    private TravelScreen travelScreen;
    // private StartScreen startScreen;
    private StoreScreen storeScreen;
    private RiverScreen riverScreen;
    private TradeScreen tradeScreen;
    private ControlScreen controlScreen;        
    //private HuntingScreen huntingScreen;
    private ConversationScreen conversationScreen;
    private ConditionsScreen conditionsScreen;
    private LandmarkScreen landmarkScreen;
    private WagonGame wagonGame;
    private DeathScreen deathScreen;

    //StartScreen separator
    private WelcomeScreen welcomeScreen;
    private TheOregonTrail theOregonTrail;

    Wagon wagon = new Wagon();


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
        wagon.getInventory().setMoney(10000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 675);
        getContentPane().setLayout(new CardLayout());

        travelScreen = new TravelScreen(wagon, this);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        // startScreen = new StartScreen(this);
        // getContentPane().add(startScreen.getPanel(), "StartScreen");

        storeScreen = new StoreScreen(wagon, this);
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        riverScreen = new RiverScreen(wagon,this);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        tradeScreen = new TradeScreen(wagon, this);
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        controlScreen = new ControlScreen(wagon, this);
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        // huntingScreen = new HuntingScreen();
        // getContentPane().add(huntingScreen.getPanel(), "HuntingScreen");

        conversationScreen = new ConversationScreen(wagon, this);
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        conditionsScreen = new ConditionsScreen();
        getContentPane().add(conditionsScreen.getPanel(), "ConditionsScreen");

        landmarkScreen = new LandmarkScreen(wagon, this);
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        wagonGame = new WagonGame(wagon, this);
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        deathScreen = new DeathScreen();
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

        /*
         * Start Screen Separator
         */

        welcomeScreen = new WelcomeScreen(wagon, this);
        getContentPane().add(welcomeScreen.getPanel(), "WelcomeScreen");

        theOregonTrail = new TheOregonTrail(wagon, this);
        getContentPane().add(theOregonTrail.getPanel(), "TheOregonTrail");


        // show what screen
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
    public void showConversationScreen() {
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
    }

    /**
     * Switches to the Wagon Screen
     */
    public void showWagonGame() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "WagonGame");
    }

    /**
     * Switches to the Death Screen
     */
    public void showDeathScreen() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "DeathScreen");
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