package Gameplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Screens.AbstractScreen;

public class ForagingScreen extends AbstractScreen {
    PicPanel viewPanel = new PicPanel(new File("Images\\Background.jpg"));
    JLabel text = new JLabel();

    Wagon wagon;
    Display display;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private Color desiredColor = new Color(93,199,255);

    public ForagingScreen(Wagon wagon, Display display){
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Forage for Food");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(desiredColor);
        viewPanel.add(title, BorderLayout.NORTH);

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(smallFont);
        text.setForeground(desiredColor);
        viewPanel.add(text, BorderLayout.CENTER);

        JLabel spacePrompt = new JLabel("Press Space to Continue");
        spacePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        spacePrompt.setFont(smallFont);
        spacePrompt.setForeground(desiredColor);
        viewPanel.add(spacePrompt, BorderLayout.SOUTH);

        viewPanel.requestFocusInWindow();

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    display.showTravelScreen(wagon);
                }
            }
        });
    }

    public void updatePanel(Wagon wagon){
        boolean chance = new Random().nextBoolean();
        if(chance){
            int foodAmount = new Random().nextInt(90) + 10; // generate between 10 amd 100;
            text.setText("You found " + foodAmount + " food!");
            wagon.getInventory().addItem(Inventory.FOOD, foodAmount);
            return;
        }
        text.setText("You did not find any food. Sorry...");
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
