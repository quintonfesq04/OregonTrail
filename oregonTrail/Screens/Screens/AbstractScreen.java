package Screens;
import javax.swing.JPanel;

/**
 * AbstractScreen.java -- gives a blueprint for the screen objects
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public abstract class AbstractScreen {

    protected abstract void initialize();
    
    public abstract void resizeImages();

    public abstract JPanel getPanel();
}
