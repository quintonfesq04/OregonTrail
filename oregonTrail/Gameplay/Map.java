package Gameplay;

import java.io.File;

import javax.swing.JFrame;


/**
 * @File Map.java
 * @author Ethan Burch
 * @version 1.0.0 4/15/24
 * Creates a stand-alone JFrame that displays the map.
 */
public class Map {
    private JFrame frame;
    private PicPanel viewPanel;
    private File image;
    Locations location;

    /**
     * Updates the location of the player along the trail.
     * 
     * @return The file representing the updated location.
     */
    private File updateLocation() {
        String loc = location.getNextLandmark();

        for (int i = 0; i < Locations.LOCATIONS.length; i++) {
            if (loc.compareTo(Locations.LOCATIONS[i]) == 0) {
                // Use if on mac
                File file = new File("Images/Oregon Trail Map " + i + ".jpg");

                // Use if on windows
                // File file = new File("Images\\Oregon Trail Map " + i + ".jpg");
                return file;
            }
        }
        return null;
    }

    /**
     * Displays a JFrame with a picture representing where a player is along the trail.
     * 
     * @param location The location of the player along the trail.
     */
    public void display(Locations location) {
        this.location = location;
        image = updateLocation();

        frame = new JFrame();
        frame.setBounds(400, 200, 700, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        viewPanel = new PicPanel(image);

        frame.add(viewPanel);
        frame.setVisible(true);
        viewPanel.resizeImage();
    }

    /**
     * Displays the map without specifying a location.
     */
    public void display() {
        image = new File("Images\\Oregon Trail Map.jpg");

        frame = new JFrame();
        frame.setBounds(400, 200, 700, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        viewPanel = new PicPanel(image);

        frame.add(viewPanel);
        frame.setVisible(true);
        viewPanel.resizeImage();
    }
}