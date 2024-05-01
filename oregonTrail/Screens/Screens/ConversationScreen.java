package Screens;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Gameplay.*;

/**
 * ConversationScreen.java -- a screen that shows conversations between the
 * player and people along the trail
 * 
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */

public class ConversationScreen extends AbstractScreen implements KeyListener {
    private JPanel panel = new JPanel();
    private JLabel conversationLabel = new JLabel();
    private Wagon wagon;
    private Display display;
    private Conversations conversations = new Conversations();
    private int conversationCase = 0;

    public ConversationScreen(Wagon wagon, Display display){
        this.wagon = wagon;
        this.display = display;
    }
    @Override
    protected void initialize() {
        // Set the layout manager of the panel to BorderLayout
        panel.setLayout(new BorderLayout());

        // Set the text alignment of the conversationLabel to center
        conversationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the conversationLabel to the panel at the center position
        panel.add(conversationLabel, BorderLayout.CENTER);

        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
    }

    private String getConversation() {
        switch(conversationCase){
            case 0 :
                conversationLabel.setText("<html>Captain: What are you going to do? *The Captain gives a groan and falls to the ground.*");
                conversationCase++;
                break;
            case 1 :
                conversationLabel.setText("<html>Traveler 1: A man named the Captain fell off his horse.");
                break;
            case 2 :
                conversationLabel.setText("<html>Traveler 1: We did worse than alone; in a strange wilderness; without food, without fire; the darkness of night forbade the stars to shine upon me; solitary - all was solitary as death - but the same kind Providence that ever watched over me.");
                break;
            case 3 :
                conversationLabel.setText("<html>Traveler: I am looking for venison.");
                break;
            case 4 :
                conversationLabel.setText("<html>Orus convinced us to make one more effort to reach the Settlement.");
                break;
            case 5 :
                conversationLabel.setText("<html>I would like to see that Oregon Pioneer; I wonder if she is anything like what she used to be.");
                break;
            case 6 :
                conversationLabel.setText("<html>I started in an open boat up the river for Salem again; wind and tide against us; it was 13 days reaching Oregon City.");
                break;
            case 7 :
                conversationLabel.setText("<html>Winter set in; they pressed me hard to spend the winter with them.");
                break;
            case 8 :
                conversationLabel.setText("<html>We are waiting for more people to cut a road through the mountains.");
                break;
            case 9 :
                conversationLabel.setText("<html>Hey my name is Mr. Pringle, and I tried to shoot a wolf. But I couldn’t because I am weak and trembling.");
                break;
            case 10 :
                conversationLabel.setText("<html>I am going to go look for some relief. I do not know when I will be back.");
                break;  
            case 11 :
                conversationLabel.setText("<html>We had all retired to rest in our tents, hoping to forget our troubles until daylight.");
                break;  
            case 12 :
                conversationLabel.setText("<html>Traveler 1: There is much sickness and death on the Plains.");
                break;
            default :
                conversationLabel.setText("<html>error");
                break;
        }
        return line;
    }
    }

    @Override
    public void resizeImages() {
        // Resize images if needed
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

   

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            display.showLandmarkScreen();
        }

     
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }
}
