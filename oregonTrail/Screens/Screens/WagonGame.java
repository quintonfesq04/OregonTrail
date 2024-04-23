package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WagonGame extends AbstractScreen {
    private JFrame frame;
    private JPanel bubblesPanel;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private int time = 30;
    private int score;
    private int bubbleCount;
    private List<Bubble> bubbles;
    private Timer gameTimer;
    private PicPanel viewPanel = new PicPanel(new File("Images\\Covered Wagon.jpg"));

    public WagonGame() {
        initializeUI();
        createBubbles();
        score = 0;
        bubbleCount = 0;
        updateScoreLabel();
        startGameTimer();
    }

    private void initializeUI() {
        frame = new JFrame("Wagon Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Create and add the score and timer panel
        JPanel scoreTimerPanel = new JPanel(new GridLayout(1, 2));
    
        scoreLabel = new JLabel("Score: 0");
        scoreTimerPanel.add(scoreLabel);
    
        timerLabel = new JLabel("Time: 30");
        scoreTimerPanel.add(timerLabel);
    
        frame.add(scoreTimerPanel, BorderLayout.NORTH);
    
        // Ensure bubblesPanel is transparent
        bubblesPanel = new JPanel(null);
        bubblesPanel.setOpaque(false);
    
        // Add the bubblesPanel to the frame
        frame.add(bubblesPanel, BorderLayout.CENTER);
    
        frame.setContentPane(viewPanel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
        createBubbles(); // Create bubbles after the frame is visible
    }
    
    
    private void createBubbles() {
        bubbles = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(450);
            int y = rand.nextInt(450);
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
        gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (time > 0) {
                    time--;
                    timerLabel.setText("Time: " + time);
                } else {
                    endGame();
                }
            }
        });
        gameTimer.start();
    }

    private void endGame() {
        gameTimer.stop();
        JOptionPane.showMessageDialog(frame, "Game Over! Your Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private class BubbleClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Bubble clickedBubble = (Bubble) e.getSource();
            score++;
            bubbleCount++;
            updateScoreLabel();
            bubblesPanel.remove(clickedBubble);
            bubbles.remove(clickedBubble);
            bubblesPanel.repaint();
            bubblesPanel.revalidate();

            if (bubbleCount == 10) {
                endGame();
            }
        }
    }

    private static class Bubble extends JLabel {
        public Bubble(int x, int y) {
            setBounds(x, y, 20, 20);
            setOpaque(true);
            setBackground(Color.BLUE);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        viewPanel.resizeImage();
    }

    @Override
    public PicPanel getPanel() {
        // No implementation needed for now
        return viewPanel;
    }
}
