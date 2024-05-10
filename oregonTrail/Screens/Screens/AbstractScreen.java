package Screens;
import javax.swing.JPanel;

/**
 * AbstractScreen.java -- gives a blueprint for the screen objects
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public abstract class AbstractScreen {

    /**
     * create the JPanel
     */
    protected abstract void initialize();
    
    /**
     * resizes all images within the JPanel
     */
    public abstract void resizeImages();

    /**
     * recieve the JPanel created 
     * @return the JPanel
     */
    public abstract JPanel getPanel();
}