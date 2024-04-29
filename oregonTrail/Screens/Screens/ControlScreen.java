package Screens;
import java.io.File;

import javax.swing.JPanel;

import Gameplay.*;



/**
 * ControlScreen.java -- Shows the player their inventory, food consumption, and travel speed.
 * @author Ethan Burch
 * @version 1.1.0 4/22/24
 */
public class ControlScreen extends AbstractScreen{
    private File image = new File("Images\\start screen46.jpg");
    private PicPanel panel = new PicPanel(image);

    private Inventory inventory;
    private Player player;
    private Display display;

    /**
     * Constructor for ControlScreen object
     * @param inventory the inventory to be shown 
     * @param player    the player object used 
     * @param display   the main display that this will be shown in
     */
    public ControlScreen(Inventory inventory, Player player, Display display){
        this.inventory = inventory;
        this.player = player;
        this.display = display;
    }
    
    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }    
}
