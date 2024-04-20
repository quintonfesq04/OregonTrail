package Screens;
import java.awt.Color;

import javax.swing.JFrame;
import java.io.File;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Stuff.*;

public class DeathScreen extends AbstractScreen{
    File image = new File("Images/death screen.jpg");
    private PicPanel viewPanel = new PicPanel(image);
    private Display display;

    public DeathScreen(Display display) {
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setBackground(new Color(78, 78, 78));
        viewPanel.setLayout(null);
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
