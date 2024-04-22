package Stuff;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

public class Cloud extends PicPanel {

    private int x;
    private int y;
    private File image;

    public Cloud(int x, int y, File image) {
        this.x = x;
        this.y = y;
        this.image = image;
        init();
    }

    private void init() {
        this.setImage(image);
        this.setOpaque(false);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

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
