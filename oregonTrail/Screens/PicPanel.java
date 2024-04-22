import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @File PicPanel.java
 * @author Ethan Burch
 * @version 1.0.0 4/14/24
 * Creates a JPanel whose background can be set to an image
 */
public class PicPanel extends JPanel {
    private Image backgroundImage;

    /**
     * Constructor for PicPanel object
     * @param imageFile the image for the background
     */
    public PicPanel(File imageFile) {
        try {
            backgroundImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }

    // paintComponent override to create background
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * resizes the background image
     */
    public void resizeImage() {
        if (backgroundImage != null) { // Check if backgroundImage is not null
            int w = getWidth();
            int h = getHeight();
            if (w > 0 && h > 0) {
                backgroundImage = resize(backgroundImage, w, h);
            }
        }
    }

    // Method to resize a BufferedImage
    private BufferedImage resize(Image backgroundImage2, int newW, int newH) {
        Image tmp = backgroundImage2.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage resizedImg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resizedImg;
    }
}
