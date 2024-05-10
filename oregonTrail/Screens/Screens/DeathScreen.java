package Screens;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JPanel;

import Gameplay.PicPanel;

/**
 * DeathScreen.java -- the screen that is shown when the player dies
 * 
 * @author Quinton Fesq
 * @author Ethan Burch
 * @version 1.2.0 4/23/24
 */
public class DeathScreen extends AbstractScreen {
    File image = new File("Images/death screen.jpg");
    private PicPanel viewPanel = new PicPanel(image);

    /**
     * Constructor for DeathScreen object
     */
    public DeathScreen() {
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        viewPanel.setBackground(new Color(78, 78, 78));
        viewPanel.setLayout(null);
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE)
                    System.exit(0);
            }
        });
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