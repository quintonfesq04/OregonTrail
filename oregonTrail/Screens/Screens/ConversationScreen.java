package Screens;
import javax.swing.JPanel;
import Screens.*;
import Stuff.*;
import Hunting.*;

import Stuff.*;

/**
 * ConversationScreen.java -- a screen that shows conversations between the player and people along the trail
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */

public class ConversationScreen extends AbstractScreen{
    private JPanel panel = new JPanel();

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
