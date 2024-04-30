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
    private Conversations conversations;
    private Display display;

    public ConversationScreen(Conversations conversations, Display display){
        this.conversations = conversations;
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

    @Override
    public void resizeImages() {
        // Resize images if needed
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    // Method to update the conversation label text
    private void updateConversation() {

        String nextConversation = conversations.getConversation();
        conversationLabel.setText(nextConversation);
    }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            updateConversation();
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
