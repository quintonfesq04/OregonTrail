package Stuff;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import Screens.*;
import Stuff.*;
import Hunting.*;

/**
 * Cloud.java -- creates a cloud to be shows moving across the screen
 * @author Ethan Burch
 * @version 1.2.1 4/21/24
 */
public class Cloud extends PicPanel {

    private int x;
    private int y;
    private File image;

    /**
     * constructor for cloud object
     * @param x the initial x coordinate
     * @param y the initial y coordinate
     * @param image the image for the cloud
     */
    public Cloud(int x, int y, File image) {
        this.x = x;
        this.y = y;
        this.image = image;
        init();
    }

    /**
     * inializes the cloud
     */
    private void init() {
        this.setImage(image);
        this.setOpaque(false);
    }

    /**
     * obtain the x coordinate of the cloud
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * set the x coordinate for the cloud
     * @param newX the desired x coordinate
     */
    public void setX(int newX) {
        this.x = newX;
    }

    /**
     * get 
     */
    public int getY() {
        return this.y;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void update(int step) {
        this.x += step;
    }

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
