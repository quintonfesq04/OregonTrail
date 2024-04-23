package Screens;
/*
package Screens;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Document;

import Stuff.Display;
import Stuff.PicPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class StartScreen extends AbstractScreen {
    private Map<String, List<String>> pathImageMap = new HashMap<>();
    private JTextField input;
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
    private int imageIndex = 0;

    public StartScreen(Display display) {
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        input = new JTextField(5);
        //input.setDocument((Document) new JTextFieldLimit(1, 5));

        viewPanel.add(input);

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                viewPanel.requestFocusInWindow();
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    String choice = input.getText();
                    processChoice(choice);
                }
            }
        });
    }

    private void processChoice(String choice) {
        int option = Integer.parseInt(choice);
        if(option >= 1 && option <= 5) {
            switch(option) {
                case 1:
                    navigateToPath("path1");
                    break;
                case 2:
                    navigateToPath("path2");
                    break;
                case 3:
                    navigateToPath("path3");
                    break;
                case 4:
                    navigateToPath("path4");
                    break;
                case 5:
                    navigateToPath("path5");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Choice. Please Enter A Number Between 1 & 5");
        }
    }

    private void navigateToPath(String path) {
        // Logic to navigate to the specified path
        List<String> imageNames = pathImageMap.get(path);
        if (imageNames != null && !imageNames.isEmpty()) {
            // Display the panels associated with the chosen path
            //display.setScreens(imageNames);
        } else {
            // Handle case where the path is not found
            System.out.println("Path not found: " + path);
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
*/