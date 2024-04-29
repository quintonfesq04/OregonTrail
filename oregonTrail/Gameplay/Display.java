package Gameplay;

import javax.imageio.ImageIO;
import javax.swing.*;

import Gameplay.*;
import Hunting.*;
import Screens.*;

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

    Inventory inventory = new Inventory();
    Locations locations = new Locations(0);
    Conditions conditions = new Conditions(inventory);
    Store store = new Store();
    Player player = new Player();

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

        travelScreen = new TravelScreen(locations, conditions, new Trade(), inventory, this);
        getContentPane().add(travelScreen.getPanel(), "TravelScreen");

        // startScreen = new StartScreen(this);
        // getContentPane().add(startScreen.getPanel(), "StartScreen");

        storeScreen = new StoreScreen(inventory, store, this);
        getContentPane().add(storeScreen.getPanel(), "StoreScreen");

        riverScreen = new RiverScreen(this, locations);
        getContentPane().add(riverScreen.getPanel(), "RiverScreen");

        tradeScreen = new TradeScreen(this);
        getContentPane().add(tradeScreen.getPanel(), "TradeScreen");

        controlScreen = new ControlScreen(inventory, player, this);
        getContentPane().add(controlScreen.getPanel(), "ControlScreen");

        // huntingScreen = new HuntingScreen();
        // getContentPane().add(huntingScreen.getPanel(), "HuntingScreen");

        conversationScreen = new ConversationScreen();
        getContentPane().add(conversationScreen.getPanel(), "ConversationScreen");

        conditionsScreen = new ConditionsScreen();
        getContentPane().add(conditionsScreen.getPanel(), "ConditionsScreen");

        landmarkScreen = new LandmarkScreen(this);
        getContentPane().add(landmarkScreen.getPanel(), "LandmarkScreen");

        wagonGame = new WagonGame(this);
        getContentPane().add(wagonGame.getPanel(), "WagonGame");

        deathScreen = new DeathScreen();
        getContentPane().add(deathScreen.getPanel(), "DeathScreen");

        showConversationScreen();
    }
   
    /**
     * Switches to the Travel Screen
     */
    public void showTravelScreen() {
        travelScreen.updateScreen(locations, conditions);
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "TravelScreen");
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
        if (locations.hasLeftStartingLandmark(locations.getDistance())) {
            storeScreen.returnToLandmarkBtn.setEnabled(true);
        } else {
            storeScreen.returnToLandmarkBtn.setEnabled(false);
        }
    }

    /**
     * Switches to the River Screen
     */
    public void showRiverScreen(Locations locations) {
        riverScreen.update(locations);
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

}