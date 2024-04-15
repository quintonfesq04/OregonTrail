import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * @File PicPanel.java 
 * @Author Ethan Burch
 * @version 1.0.3 4/15/24
 * a class that allows a JPanel with a background image
 */
public class PicPanel extends JPanel {

    private Image backgroundImage;

    /**
     * Constructor for PicPanel object
     * @param fileName the path to the desired background image
     */
    PicPanel(String fileName){
        try {                
            backgroundImage = ImageIO.read(new File("image name and path"));
         } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not found! Path Attempted: " + fileName);
         }
    }

    /**
     * Constructor for PicPanel object
     * @param fileName a File object containing the path to the desired backgorund image
     */
    PicPanel(File fileName){
        try{
            backgroundImage = ImageIO.read(fileName);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Image not found! path Attempted: " + fileName.getPath());
        }
    }

    /**
     * Constructor for PicPanel object
     * @param backgroundImage an Image object for the desired background image
     */
    PicPanel(Image backgroundImage){
        this.backgroundImage = backgroundImage;
    }

    /**
     * Override paintComponent method to allow for background images
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    /**
     * resizeImage - sizes the image to the width and height of the JPanel
     */
    public void resizeImage(){
        backgroundImage = backgroundImage.getScaledInstance(super.getWidth(), super.getHeight(), Image.SCALE_SMOOTH);
    }

    /**
     * resizeImage   - resizes the image to the desired width and height
     * @param width  - desired width
     * @param height - desired height
     */
    public void resizeImage(int width, int height){
        backgroundImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    /**
     * setImage                 - sets the backgorund image to a new image object
     * @param backgroundImage   - desired image
     */
    public void setImage(Image backgroundImage){
        this.backgroundImage = backgroundImage;
    }

    /**
     * setImage         - sets the background image from a file path
     * @param fileName  - the path where the desired image is located
     */
    public void setImage(String fileName){
        try {                
            backgroundImage = ImageIO.read(new File("image name and path"));
         } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not found! Path Attempted: " + fileName);
         }
    }

    /**
     * setImage         - sets the backgorund image from a File object
     * @param fileName  - a File object containing the desired image path
     */
    public void setImage(File fileName){
        try{
            backgroundImage = ImageIO.read(fileName);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Image not found! path Attempted: " + fileName.getPath());
        }
    }

}
