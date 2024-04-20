package Stuff;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import Screens.AbstractScreen;

import java.io.File;

public class StartScreen extends AbstractScreen {
    private File[] images = {
        new File("Images/start screen0.jpg"),
        new File("Images/start screen1.jpg"),
        new File("Images/start screen2.jpg"),
        new File("Images/start screen3.jpg"),
        new File("Images/start screen4.jpg"),
        new File("Images/start screen5.jpg"),
        new File("Images/start screen6.jpg"),
        new File("Images/start screen7.jpg"),
        new File("Images/start screen8.jpg"),
        new File("Images/start screen9.jpg"),
        new File("Images/start screen10.jpg"),
        new File("Images/start screen11.jpg"),
        new File("Images/start screen12.jpg"),
        new File("Images/start screen13.jpg"),
        new File("Images/start screen14.jpg"),
        new File("Images/start screen15.jpg"),
        new File("Images/start screen16.jpg"),
        new File("Images/start screen17.jpg"),
        new File("Images/start screen18.jpg"),
        new File("Images/start screen19.jpg"),
        new File("Images/start screen20.jpg"),
        new File("Images/start screen21.jpg"),
        new File("Images/start screen22.jpg"),
        new File("Images/start screen23.jpg"),
        new File("Images/start screen24.jpg"),
        new File("Images/start screen25.jpg"),
        new File("Images/start screen26.jpg"),
        new File("Images/start screen27.jpg"),
        new File("Images/start screen28.jpg"),
        new File("Images/start screen29.jpg"),
        new File("Images/start screen30.jpg"),
        new File("Images/start screen31.jpg"),
        new File("Images/start screen32.jpg"),
        new File("Images/start screen33.jpg"),
        new File("Images/start screen34.jpg"),
        new File("Images/start screen35.jpg"),
        new File("Images/start screen36.jpg"),
        new File("Images/start screen37.jpg"),
        new File("Images/start screen38.jpg"),
        new File("Images/start screen39.jpg"),
        new File("Images/start screen40.jpg"),
        new File("Images/start screen41.jpg"),
        new File("Images/start screen42.jpg"),
        new File("Images/start screen43.jpg"),
        new File("Images/start screen44.jpg"),
        new File("Images/start screen45.jpg"),
        new File("Images/start screen46.jpg"),
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
