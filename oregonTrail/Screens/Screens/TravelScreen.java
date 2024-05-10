package Screens;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JOptionPane;

import Gameplay.Cloud;
import Gameplay.Conditions;
import Gameplay.Display;
import Gameplay.Locations;
import Gameplay.Map;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * TravelScreen.java -- the screen seen when traveling
 * 
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public class TravelScreen extends AbstractScreen {
    private File imageFile = new File("Images/Normal Travel.png");

    private Cloud cloud = new Cloud(50, 25, new File("Images/Cloud4.png"));

    protected PicPanel viewPanel = new PicPanel(imageFile);

    private Display display;
    private Wagon wagon;
    private ControlScreen controlScreen;
    private Conditions conditions;
    private int distanceMoved;
    private String conditionString;

    public TravelScreen(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        this.conditions = wagon.getConditions();
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        viewPanel.setLayout(null);

        cloud.setPreferredSize(new Dimension(300, 150));
        cloud.setSize(cloud.getPreferredSize());

        viewPanel.add(cloud);

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE)
                    travel();
                else if (vk == KeyEvent.VK_I)
                    display.showControlScreen();
                else if (vk == KeyEvent.VK_M) {
                    Map map = new Map();
                    map.display();
                }
            }
        });

        endGame();
    }

    @Override
    public PicPanel getPanel() {
        return viewPanel;
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
        // cloud.resizeImage();
    }

    private void endGame() {
        if (wagon.getLocations().getDistance() >= 2051) {
            JOptionPane.showMessageDialog(null, "Congratulations You Made It To Oregon!");
            display.showTheOregonTrail(wagon);
        }
    }

    public void updateScreen(Wagon wagon) {
        this.wagon.setLocations(wagon.getLocations());
        this.wagon.setConditions(wagon.getConditions());
        // initialize();
    }

    private void arriveAtLandmark() {
        String nextLandmark = wagon.getLocations().getNextLandmark();

        wagon.getConditions().handleInventory();
        if (nextLandmark != null) {
            if (wagon.getLocations().hitRiver()) {
                display.showRiverScreen(wagon);
            } else if (wagon.getTrade().tradeTime()) {
                wagon.getTrade().createTrade();
                display.showTradeScreen();
            } else if (wagon.getConditions().getConditionMessage().contains("Your wagon broke down")) {
                display.showWagonGame();
            } else if (checkLandmark()) {
                display.showLandmarkScreen();
            }
        }

        handleConditions();
    }

    private void travel() {
        int cloudDistanceMoved = 50; // Distance the cloud moves
        if (cloud.getX() < viewPanel.getWidth()) {
            cloud.update(cloudDistanceMoved); // Update cloud position
        } else {
            cloud.setX(-100); // Reset cloud position
        }

        cloud.setLocation(cloud.getX(), cloud.getY()); // Set cloud location

        distanceMoved = wagon.getPlayer().getTravelSpeed();

        wagon.getLocations().addDistance(distanceMoved); // Update distance traveled

        System.out.println(wagon.getLocations().getDistance());

        arriveAtLandmark(); // Check if arrived at landmark
    }

    private boolean checkLandmark() {
        for (int i = 0; i < Locations.LOCATION_DISTANCE.length; i++) {
            if (Locations.LOCATION_DISTANCE[i] + distanceMoved - 1 >= wagon.getLocations().getDistance() &&
                    Locations.LOCATION_DISTANCE[i] <= wagon.getLocations().getDistance()) {
                wagon.getLocations().setDistance(Locations.LOCATION_DISTANCE[i]);
                return true;
            }
        }
        if (wagon.getLocations().getDistance() >= Locations.LOCATION_DISTANCE[Locations.LOCATION_DISTANCE.length - 1]) {
            wagon.getLocations().setDistance(Locations.LOCATION_DISTANCE[Locations.LOCATION_DISTANCE.length - 1]);
            display.showEndGame(wagon);
        }
        return false;
    }

    private void handleConditions() {
        conditionString = wagon.getConditions().getConditionMessage();

        int weatherType = wagon.getConditions().generateWeather();

        if (weatherType == Conditions.DROUGHT)
            imageFile = new File("Images/Drought Travel.png");

        else if (weatherType == Conditions.RAINING)
            imageFile = new File("Images/Normal Travel.png");

        else if (weatherType == Conditions.SNOWING)
            imageFile = new File("Images/Snow Travel.png");

        viewPanel.setImage(imageFile);

        if (wagon.getConditions().isEventOccurred()) {
            if (wagon.getConditions().isWagonGame()) {
                display.showWagonGame();
            }
            JOptionPane.showMessageDialog(null, wagon.getConditions().getConditionMessage());
        }
    }
}