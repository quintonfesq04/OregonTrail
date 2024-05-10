package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.Inventory;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * ForagingScreen.java -- allows the user to get food by foraging along their journey
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/06/2024
 */
public class ForagingScreen extends AbstractScreen {
    PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
    JLabel text = new JLabel("");
    private JLabel spacePrompt;

    Wagon wagon;
    Display display;
    ControlScreen controlScreen;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private Color desiredColor = new Color(93, 199, 255);

    public ForagingScreen(Wagon wagon, Display display, ControlScreen controlScreen) {
        this.wagon = wagon;
        this.display = display;
        this.controlScreen = controlScreen;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 0.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel title = new JLabel("Forage For Food");
        GridBagConstraints gbc_title = new GridBagConstraints();
        gbc_title.insets = new Insets(0, 0, 100, 0);
        gbc_title.gridx = 0;
        gbc_title.gridy = 0;
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(titleFont);
        title.setForeground(desiredColor);
        viewPanel.add(title, gbc_title);

        GridBagConstraints gbc_text = new GridBagConstraints();
        gbc_text.insets = new Insets(0, 0, 0, 0);
        gbc_text.gridx = 0;
        gbc_text.gridy = 1;
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(smallFont);
        text.setForeground(desiredColor);
        viewPanel.add(text, gbc_text);

        spacePrompt = new JLabel("Press Space to Forage");
        GridBagConstraints gbc_spacePrompt = new GridBagConstraints();
        gbc_spacePrompt.insets = new Insets(100, 0, 0, 0);
        gbc_spacePrompt.gridx = 0;
        gbc_spacePrompt.gridy = 2;
        spacePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        spacePrompt.setFont(smallFont);
        spacePrompt.setForeground(desiredColor);
        viewPanel.add(spacePrompt, gbc_spacePrompt);

        viewPanel.requestFocusInWindow();

        updatePanel(wagon);
    }

    public void updatePanel(Wagon wagon) {
        boolean chance = new Random().nextBoolean();
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    if (chance) {
                        int foodAmount = new Random().nextInt(90) + 10; // generate between 10 amd 100;
                        text.setText("You found " + foodAmount + " food!");
                        wagon.getInventory().addItem(Inventory.FOOD, foodAmount);
                        spacePrompt.setText("Press Space To Continue");
                        viewPanel.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                int vk = e.getKeyCode();
                                if (vk == KeyEvent.VK_SPACE) {
                                    display.showTravelScreen(wagon);
                                    resetScreen();
                                }
                            }
                        });
                    } else if (!chance) {
                        text.setText("You did not find any food. Sorry...");
                        spacePrompt.setText("Press Space To Continue");
                        viewPanel.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                int vk = e.getKeyCode();
                                if (vk == KeyEvent.VK_SPACE) {
                                    display.showControlScreen();
                                    resetScreen();
                                }
                            }
                        });
                    }

                }
            }
        });
    }

    public void resetScreen() {
        viewPanel.removeAll();
        viewPanel.revalidate();
        viewPanel.repaint();
        display.showControlScreen();
        initialize();
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