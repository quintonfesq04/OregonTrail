import java.awt.Color;

import javax.swing.JFrame;
import java.io.File;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeathScreen extends AbstractScreen{
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();
    private PicPanel viewPanel;
    private Display display;

    public DeathScreen(Display display) {
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        panel.setBackground(new Color(78, 78, 78));
        panel.setLayout(null);

        File image = new File("Images/Oregon Trail Map 1.jpg");
        System.out.println("Error Opening Image");


        viewPanel = new PicPanel(image);
        panel.add(viewPanel);
        viewPanel.repaint();
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
