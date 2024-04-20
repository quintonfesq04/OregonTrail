package Screens;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import Stuff.*;

import java.io.File;

public class StartScreen extends AbstractScreen {
    private File[] images = {
        new File("Images/start screen0.jpg"),
        new File("Images/start screen1.jpg"),
        new File("Images/start screen2.jpg")
    };
    private PicPanel viewPanel = new PicPanel(images[0]);
    private Display display;
    private Timer timer;
    private int alpha;
    private int imageIndex = 0;

    public StartScreen(Display display) {
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                viewPanel.requestFocusInWindow();
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    timer.start(); // Start fading out the current screen
                }
            }
        });

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 5;
                if (alpha <= 0) {
                    timer.stop();
                    switchToNextImage(); // Switch to next image
                }
                viewPanel.repaint();
            }
        });

        // JButton startButton = new JButton("Start Game");
        // startButton.setBounds(300, 500, 200, 50);
        // startButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         timer.start(); // Start fading out the current screen
        //     }
        // });
        // viewPanel.add(startButton);
    }

    private void switchToNextImage() {
        imageIndex++;
        if (imageIndex < images.length) {
            viewPanel.setImage(images[imageIndex]); // Switch to the next image
        } else {
            System.exit(0); // If there are no more images, exit the application
        }
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
