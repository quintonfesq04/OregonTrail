package Hunting;
import javax.swing.JPanel;
import Screens.*;


import Stuff.*;

public class HuntingScreen extends AbstractScreen{
    private JPanel panel = new JPanel();
    HuntingMap huntingMap = new HuntingMap();
    Hunter hunter = new Hunter(12,9,Hunter.NOT_MOVING);

    @Override
    protected void initialize() {
        panel.add(huntingMap);
        hunter.moveLeft();
        
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
