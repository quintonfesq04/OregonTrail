package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.Locations;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * ConversationScreen.java -- a screen that shows conversations between the
 * player and people along the trail
 * 
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */

public class ConversationScreen extends AbstractScreen implements KeyListener {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
    private JLabel conversationLabel = new JLabel("");
    private JLabel continueLabel = new JLabel("Press Space To Continue");
    private Wagon wagon;
    private Display display;
    private Locations locations = new Locations(0);
    private int conversationCase;

    private Font labelFont = new Font("Trajan Pro", Font.PLAIN, 24);
    int distance = locations.getDistance();

    /**
     * Construtor for ConversationScreen class
     * @param wagon the wagon used by this class
     * @param display the display that is showing in this class
     */
    public ConversationScreen(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        this.locations = new Locations(0);
        initialize();
    }

    @Override
    protected void initialize() {
        // Set the layout manager of the panel to BorderLayout
        viewPanel.setLayout(new BorderLayout());

        continueLabel.setFont(labelFont);
        continueLabel.setForeground(new Color(93, 199, 255));

        // Set the text alignment of the conversationLabel to center
        conversationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        conversationLabel.setFont(labelFont);
        conversationLabel.setForeground(new Color(93, 199, 255));

        // Add the conversationLabel to the panel at the center position
        viewPanel.add(conversationLabel, BorderLayout.CENTER);

        viewPanel.add(continueLabel, BorderLayout.SOUTH);
        continueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();

        getConversation(conversationCase);
    }

    /**
     * determines which conversation is being shown
     * @param currentCase the number representing the conversation to be shown
     */
    private void getConversation(int currentCase) {
        switch (currentCase) {
            case 0:
                conversationLabel.setText(
                        "<html>Captain: What are you going to do? *The Captain gives a groan and falls to the ground.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 1:
                conversationLabel.setText("<html>Traveler 1: A man named the Captain fell off his horse.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 2:
                conversationLabel.setText(
                        "<html>Traveler 1: We did worse than alone; in a strange wilderness; without food, without fire; the darkness of night forbade the stars to shine upon me; solitary - all was solitary as death - but the same kind Providence that ever watched over me.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 3:
                conversationLabel.setText("<html>Traveler: I am looking for venison.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 4:
                conversationLabel.setText("<html>Orus convinced us to make one more effort to reach the Settlement.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 5:
                conversationLabel.setText(
                        "<html>I would like to see that Oregon Pioneer; I wonder if she is anything like what she used to be.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 6:
                conversationLabel.setText(
                        "<html>I started in an open boat up the river for Salem again; wind and tide against us; it was 13 days reaching Oregon City.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 7:
                conversationLabel.setText("<html>Winter set in; they pressed me hard to spend the winter with them.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 8:
                conversationLabel.setText("<html>We are waiting for more people to cut a road through the mountains.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 9:
                conversationLabel.setText(
                        "<html>Hey my name is Mr. Pringle, and I tried to shoot a wolf. But I couldn’t because I am weak and trembling.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 10:
                conversationLabel
                        .setText("<html>I am going to go look for some relief. I do not know when I will be back.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 11:
                conversationLabel.setText(
                        "<html>We had all retired to rest in our tents, hoping to forget our troubles until daylight.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase++;
                            viewPanel.removeKeyListener(this);
                            getConversation(conversationCase);
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            case 12:
                conversationLabel.setText("<html>Traveler 1: There is much sickness and death on the Plains.");
                viewPanel.addKeyListener(new KeyAdapter() {
                    // KeyListener methods
                    @Override
                    public void keyPressed(KeyEvent e) {
                        int vk = e.getKeyCode();
                        if (vk == KeyEvent.VK_SPACE) {
                            conversationCase = 0;
                            display.showLandmarkScreen();
                        }
                    }
                });
                break;
            default:
                conversationLabel.setText("<html>error");
                break;
        }
    }

    @Override
    public void resizeImages() {
        // Resize images if needed
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Unused
    }
}