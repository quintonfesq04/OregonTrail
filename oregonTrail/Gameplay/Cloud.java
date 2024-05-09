package Gameplay;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Cloud.java -- Creates a cloud to be shown moving across the screen.
 * 
 * This class represents a cloud object that moves horizontally across the
 * screen.
 * It extends the PicPanel class.
 * 
 * @author Ethan Burch
 * @version 1.2.1 4/21/24
 */
public class Cloud extends PicPanel {

    private int x; // X coordinate of the cloud
    private int y; // Y coordinate of the cloud
    private File image; // File representing the image for the cloud

    /**
     * Constructor for a Cloud object.
     * 
     * @param x     The initial x coordinate of the cloud.
     * @param y     The initial y coordinate of the cloud.
     * @param image The image file for the cloud.
     */
    public Cloud(int x, int y, File image) {
        this.x = x;
        this.y = y;
        this.image = image;
        init(); // Initialize the cloud
    }

    /**
     * Initializes the cloud.
     */
    private void init() {
        this.setImage(image); // Set the image for the cloud
        this.setOpaque(false); // Make the cloud transparent
    }

    /**
     * Obtain the x coordinate of the cloud.
     * 
     * @return The x coordinate of the cloud.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Set the x coordinate for the cloud.
     * 
     * @param newX The desired x coordinate for the cloud.
     */
    public void setX(int newX) {
        this.x = newX;
    }

    /**
     * Obtain the y coordinate of the cloud.
     * 
     * @return The y coordinate of the cloud.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Set the y coordinate for the cloud.
     * 
     * @param newY The desired y coordinate for the cloud.
     */
    public void setY(int newY) {
        this.y = newY;
    }

    /**
     * Update the position of the cloud by a given step.
     * 
     * @param step The amount by which to update the position of the cloud.
     */
    public void update(int step) {
        this.x += step;
    }

    /**
     * Resize the background image to the specified dimensions.
     * 
     * @param backgroundImage The background image to resize.
     * @param newW            The new width of the image.
     * @param newH            The new height of the image.
     * @return The resized image.
     */
    @Override
    protected BufferedImage resize(Image backgroundImage, int newW, int newH) {
        Image tmp = backgroundImage.getScaledInstance(newW, newH, Image.SCALE_FAST);
        BufferedImage resizedImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resizedImg;
    }

}
