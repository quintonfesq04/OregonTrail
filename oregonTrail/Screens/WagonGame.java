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
        // Create the bubbles panel
        bubblesPanel = new JPanel();
        bubblesPanel.setLayout(null); // Set layout to null for manual positioning
    
        // Create and add the bubbles representing wagon parts
        JLabel wheel1 = createBubble("Wheel", 50, 50);
        JLabel wheel2 = createBubble("Wheel", 150, 50);
        JLabel wheel3 = createBubble("Wheel", 50, 150);
        JLabel wheel4 = createBubble("Wheel", 150, 150);
        JLabel axle1 = createBubble("Axle", 250, 50);
        JLabel axle2 = createBubble("Axle", 250, 150);
        JLabel tongue1 = createBubble("Tongue", 50, 250);
        JLabel tongue2 = createBubble("Tongue", 150, 250);
        JLabel tongue3 = createBubble("Tongue", 250, 250);
    
        // Add bubbles to the bubbles panel
        bubblesPanel.add(wheel1);
        bubblesPanel.add(wheel2);
        bubblesPanel.add(wheel3);
        bubblesPanel.add(wheel4);
        bubblesPanel.add(axle1);
        bubblesPanel.add(axle2);
        bubblesPanel.add(tongue1);
        bubblesPanel.add(tongue2);
        bubblesPanel.add(tongue3);
    
        // Create and add timer and score labels
        timerLabel = new JLabel("Time: 60");
        scoreLabel = new JLabel("Score: 0");
        
        // Set positions for timer and score labels
        timerLabel.setBounds(10, 10, 100, 20);
        scoreLabel.setBounds(300, 10, 100, 20);
    
        // Add components to the screen
        add(bubblesPanel);
        add(timerLabel);
        add(scoreLabel);
    
        // Start the game
        createBubble();
    }
    

    // Implement all abstract methods from AbstractScreen here

    private void createBubble() {
        bubblesPanel.removeAll();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int random = rand.nextInt(10);
            JLabel bubble = new JLabel(String.valueOf(random), SwingConstants.CENTER);
            bubble.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            bubble.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel clickedBubble = (JLabel) e.getSource();
                    int hit = Integer.parseInt(hitLabel.getText().split(": ")[1]);
                    int clickedValue = Integer.parseInt(clickedBubble.getText());
                    if (hit == clickedValue) {
                        newScore += 10;
                        scoreLabel.setText("Score: " + newScore);
                        createBubble();
                    }
                }
            });
            bubblesPanel.add(bubble);
        }
        bubblesPanel.revalidate();
        bubblesPanel.repaint();
    }

    private void checkBubble() {
        Random rand = new Random();
        int hit = rand.nextInt(10);
        hitLabel.setText("Hit: " + hit);
    }

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

    private void resetGame() {
        time = 60;
        newScore = 0;
        timerLabel.setText("Time: " + time);
        scoreLabel.setText("Score: " + newScore);
        createBubble();
        checkBubble();
    }
}

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPanel'");
    }
}
