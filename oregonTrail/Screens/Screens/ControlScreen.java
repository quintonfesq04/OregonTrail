package Screens;
import java.io.File;

import javax.swing.JPanel;

import Stuff.*;

public class ControlScreen extends AbstractScreen{
    private File image = new File("Images\\start screen46.jpg");
    private PicPanel panel = new PicPanel(image);

    private Inventory inventory;
    private Player player;
    private Display display;

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
