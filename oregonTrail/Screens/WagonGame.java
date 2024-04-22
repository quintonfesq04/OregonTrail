package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WagonGame extends AbstractScreen {
    private JPanel bubblesPanel;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel hitLabel;

    private int time = 60;
    private int newScore = 0;

    public WagonGame() {
        initializeUI();
        startGameTimer();
    }

    private void initializeUI() {
        // Create the main panel to hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Create the bubbles panel
        bubblesPanel = new JPanel();
        bubblesPanel.setLayout(new CardLayout()); // Set layout to null for manual positioning
        
        // Create and add the bubbles representing wagon parts
        addBubble("Wheel", 50, 50, bubblesPanel);
        addBubble("Wheel", 150, 50, bubblesPanel);
        addBubble("Wheel", 50, 150, bubblesPanel);
        addBubble("Wheel", 150, 150, bubblesPanel);
        addBubble("Axle", 250, 50, bubblesPanel);
        addBubble("Axle", 250, 150, bubblesPanel);
        addBubble("Tongue", 50, 250, bubblesPanel);
        addBubble("Tongue", 150, 250, bubblesPanel);
        addBubble("Tongue", 250, 250, bubblesPanel);
        
        // Create and add timer, score, and hit labels
        timerLabel = new JLabel("Time: 60");
        scoreLabel = new JLabel("Score: 0");
        hitLabel = new JLabel("Hit: "); // Initialize hitLabel here
        
        // Create a panel to hold the labels
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(timerLabel);
        labelPanel.add(scoreLabel);
        labelPanel.add(hitLabel);
        
        // Add bubbles panel and label panel to the main panel
        mainPanel.add(bubblesPanel, BorderLayout.CENTER);
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        
        // Add the main panel to the frame
        frame = new JFrame();
        frame.setTitle("Wagon Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 400); // Set a custom size for the frame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible

    }
    
    // Add bubble to the specified panel at specified coordinates
    private void addBubble(String type, int x, int y, JPanel panel) {
    }

    // Create a bubble JLabel with specified type and coordinates
    private JLabel createBubble(String type, int x, int y) {
		return null;
    }

    // Create new random bubble labels and add them to the bubbles panel
    private void createBubble() {
        bubblesPanel.removeAll();
        Random rand = new Random();
        for (int i = 0; i < 9; i++) { // Change to the number of wagon parts
            int random = rand.nextInt(10);
            addBubble(String.valueOf(random), rand.nextInt(300), rand.nextInt(300), bubblesPanel);
        }
        bubblesPanel.revalidate();
        bubblesPanel.repaint();
        checkBubble();
    }

    // Set a random hit value
    private void checkBubble() {
        Random rand = new Random();
        int hit = rand.nextInt(10);
        hitLabel.setText("Hit: " + hit);
    }

    // Start the game timer
    private void startGameTimer() {
        Timer gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (time > 0) {
                    time--;
                    timerLabel.setText("Time: " + time);
                } else {
                    gameTimer.cancel();
                    timerLabel.setText("Time's up!");

                    int option = JOptionPane.showConfirmDialog(null, "Your Score: " + newScore + "\nPlay Again?", "Game Over", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        resetGame();
                    } else {
                        System.exit(0);
                    }
                }
            }
        }, 1000, 1000);
    }

    // Reset the game
    private void resetGame() {
        time = 60;
        newScore = 0;
        timerLabel.setText("Time: " + time);
        scoreLabel.setText("Score: " + newScore);
        createBubble();
        checkBubble();
    }

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WagonGame window = new WagonGame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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