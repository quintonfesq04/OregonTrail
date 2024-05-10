package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * WagonGame.java --
 * 
 * @author Quinton Fesq
 * @author Ethan Burch
 * @author Madison Scott
 * @version 1.7.1 5/1/24
 */
public class WagonGame extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/WagonGame.jpg"));

    private JPanel panel;
    private JPanel bubblesPanel;
    private JLabel scoreLabel;
    private JLabel timerLabel; // Timer label
    private int score;
    private int bubbleCount; // Keep track of clicked bubbles
    private List<Bubble> bubbles;
    private Timer gameTimer;
    private int time;
    private Display display;
    private Wagon wagon;

    public WagonGame(Wagon wagon, Display display) {
        this.display = display;
        this.wagon = wagon;
        initializeUI();
        createBubbles();
        score = 0;
        bubbleCount = 0;
    }

    private void initializeUI() {
        // Create the main panel to hold all components
        viewPanel.setLayout(new BorderLayout());

        // Create a panel for score and timer labels
        JPanel scoreTimerPanel = new JPanel(new GridLayout(1, 2));

        // Create and add score label
        scoreLabel = new JLabel("Score: 0");
        scoreTimerPanel.add(scoreLabel);

        // Create and add timer label
        timerLabel = new JLabel("Time: 15");
        scoreTimerPanel.add(timerLabel);

        // Add scoreTimerPanel to the main panel
        viewPanel.add(scoreTimerPanel, BorderLayout.NORTH);

        // Create the bubbles panel
        bubblesPanel = new JPanel();
        bubblesPanel.setLayout(null); // Use null layout for absolute positioning
        bubblesPanel.setPreferredSize(new Dimension(704, 396)); // Set size
        bubblesPanel.setOpaque(false);

        // Add bubbles panel to the main panel
        viewPanel.add(bubblesPanel, BorderLayout.CENTER);

        // Add the main panel
        panel = new JPanel(new BorderLayout());
        panel.add(viewPanel);

        // No need to pack or set visible when using JPanel
    }

    private void createBubbles() {
        bubbles = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // Create 10 bubbles
            int x = rand.nextInt(674);
            int y = rand.nextInt(366);
            Bubble bubble = new Bubble(x, y);
            bubbles.add(bubble);
            bubble.addMouseListener(new BubbleClickListener());
            bubblesPanel.add(bubble);
        }
    }

    public void resetGame() {
        score = 0;
        bubbleCount = 0;
        scoreLabel.setText("Score: " + score);

        time = 15;
        timerLabel.setText("Time: " + time);

        bubblesPanel.removeAll();

        createBubbles();
        startGame();
    }

    public void startGame() {
        gameTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time > 0) {
                    time--;
                    timerLabel.setText("Time: " + time);
                    if (time == 0) {
                        endWagonGame();
                    }
                }
            }
        });
        gameTimer.start();
    }

    public void endWagonGame() {
        if (gameTimer.isRunning()) {
            gameTimer.stop();
            JOptionPane.showMessageDialog(panel, "Game Over! Your Score: " + score, "Game Over",
                    JOptionPane.INFORMATION_MESSAGE);
            display.showTravelScreen(wagon);
        }
    }

    private class BubbleClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Bubble clickedBubble = (Bubble) e.getSource();
            score++;
            bubbleCount++; // Increment bubble count

            bubblesPanel.remove(clickedBubble);
            bubbles.remove(clickedBubble);
            bubblesPanel.repaint();
            bubblesPanel.revalidate();

            // Check if all bubbles are clicked
            if (bubbleCount == 10) {
                endWagonGame(); // End game if all bubbles are clicked
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
        return panel;
    }
}