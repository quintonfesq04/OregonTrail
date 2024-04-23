package Screens;
import java.io.File;
import javax.swing.JPanel;
import Stuff.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

//import Stuff.*;

public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images/river screen0.jpg"));

    private Locations location;

    public RiverScreen(Locations location){
    	viewPanel.setLayout(new BorderLayout());
    	JButton btnNewButton = new JButton("Cross");
    	viewPanel.add(btnNewButton, BorderLayout.SOUTH);
        this.location = location;
        initialize();
    }

    @Override
    protected void initialize() {
        
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
    
}
