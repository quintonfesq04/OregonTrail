package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WagonGame extends AbstractScreen {
    private JFrame frame;
    private JPanel bubblesPanel;
    private JLabel scoreLabel;
    private JLabel timerLabel; // Timer label
    private int score;
    private int bubbleCount; // Keep track of clicked bubbles
    private List<Bubble> bubbles;
    private Timer gameTimer;

    public WagonGame() {
        initializeUI();
        createBubbles();
        score = 0;
        bubbleCount = 0;
        updateScoreLabel();
        startGameTimer();
    }

    private void initializeUI() {
        // Create the main panel to hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the bubbles panel
        bubblesPanel = new JPanel();
        bubblesPanel.setLayout(null); // Use null layout for absolute positioning
        bubblesPanel.setPreferredSize(new Dimension(400, 400)); // Set size

        // Add bubbles panel to the main panel
        mainPanel.add(bubblesPanel, BorderLayout.CENTER);

        // Create and add score label
        scoreLabel = new JLabel("Score: 0");
        mainPanel.add(scoreLabel, BorderLayout.NORTH);

        // Create and add timer label
        timerLabel = new JLabel("Time: 30");
        mainPanel.add(timerLabel, BorderLayout.EAST); // Add timer label to the right

        // Add the main panel to the frame
        frame = new JFrame();
        frame.setTitle("Wagon Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack(); // Pack components
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    private void createBubbles() {
        bubbles = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // Create 10 bubbles
            int x = rand.nextInt(bubblesPanel.getWidth());
            int y = rand.nextInt(bubblesPanel.getHeight());
            Bubble bubble = new Bubble(x, y);
            bubbles.add(bubble);
            bubble.addMouseListener(new BubbleClickListener());
            bubblesPanel.add(bubble);
        }
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    private void startGameTimer() {
        gameTimer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });
        gameTimer.setRepeats(false);
        gameTimer.start();
    }

    private void endGame() {
        JOptionPane.showMessageDialog(frame, "Game Over! Your Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private class BubbleClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Bubble clickedBubble = (Bubble) e.getSource();
            score++;
            bubbleCount++; // Increment bubble count
            updateScoreLabel();
            bubblesPanel.remove(clickedBubble);
            bubbles.remove(clickedBubble);
            bubblesPanel.repaint();
            bubblesPanel.revalidate();

            // Check if all bubbles are clicked
            if (bubbleCount == 10) {
                endGame(); // End game if all bubbles are clicked
            }
        }
    }

    // Bubble class representing a bubble
    private static class Bubble extends JLabel {
        public Bubble(int x, int y) {
            // Set bubble properties
            setBounds(x, y, 20, 20); // Set position and size
            setOpaque(true);
            setBackground(Color.BLUE); // Set color (you can change this)
            setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border (optional)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WagonGame::new);
    }

    @Override
    protected void initialize() {
        // No implementation needed for now
    }

    @Override
    public void resizeImages() {
        // No implementation needed for now
    }

    @Override
    public JPanel getPanel() {
        // No implementation needed for now
        return null;
    }
}
