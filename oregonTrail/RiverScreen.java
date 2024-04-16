import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RiverScreen extends AbstractScreen {

    JPanel panel = new JPanel();
    PicPanel viewPanel;

    protected void initialize(){
        panel.setLayout(new GridLayout(2,1,0,0));

        File image = new File("Images\\River.jpg");
        viewPanel = new PicPanel(image);
        panel.add(viewPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        panel.add(buttonPanel);

        JButton button = new JButton("Cross river");
        buttonPanel.add(button);


    }

    public JPanel getPanel(){
        return panel;
    }

    public void resizeBackgroundImages(){
        viewPanel.resizeImage();
    }

}
