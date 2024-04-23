package Screens;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WagonGame extends AbstractScreen {
    private JPanel bubblesPanel;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel hitLabel;
    private List<Bubble> bubbles;

    private int time = 60;
    private int newScore = 0;

    Image image;

    public WagonGame() {
        initializeUI();
        startGameTimer();
        createBubbles();
    }

    private void initializeUI() {
        // Create the main panel to hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Create the bubbles panel
        bubblesPanel = new JPanel();
        bubblesPanel.setPreferredSize(new Dimension(400, 400));
        
        mainPanel.add(bubblesPanel, BorderLayout.CENTER);

        // Create and add the bubbles representing wagon parts
        addBubble("Wheel", bubblesPanel);
        addBubble("Wheel", bubblesPanel);
        addBubble("Wheel", bubblesPanel);
        addBubble("Wheel", bubblesPanel);
        addBubble("Axle", bubblesPanel);
        addBubble("Axle", bubblesPanel);
        addBubble("Tongue", bubblesPanel);
        addBubble("Tongue", bubblesPanel);
        addBubble("Tongue", bubblesPanel);
        
        // Create and add timer, score, and hit labels
        timerLabel = new JLabel("Time: 60");
        scoreLabel = new JLabel("Score: 0");
        hitLabel = new JLabel("Hit: "); // Initialize hitLabel here
        
        // Create a panel to hold the labels
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
        labelPanel.add(timerLabel);
        labelPanel.add(scoreLabel);
        labelPanel.add(hitLabel);
        
        // Create a panel to hold the wheel label
        JPanel wheelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        File file = new File("Images/Wheel0.png");
        try {
            image = ImageIO.read(file);
            image = image.getScaledInstance(350,350,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        JLabel wheelLbl = new JLabel(new ImageIcon(image)) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };
        wheelPanel.add(wheelLbl);
        
        // Add bubbles panel and label panel to the main panel
        mainPanel.add(bubblesPanel, BorderLayout.CENTER);
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(wheelPanel, BorderLayout.WEST); // Add wheel panel to the left side
        
        // Add the main panel to the frame
        frame = new JFrame();
        frame.setTitle("Wagon Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setSize(1000, 1000); // Set a custom size for the frame
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
    
    

    // Add bubble to the specified panel
    private void addBubble(String type, JPanel bubblesPanel2) {
        ImageIcon icon = new ImageIcon("Images/" + type + ".png");
        JLabel bubble = new JLabel(icon);
        bubblesPanel.add(bubble);
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

    // Create new random bubble labels and add them to the bubbles panel
    private void createBubble() {
        bubblesPanel.removeAll();
        Random rand = new Random();
        for (int i = 0; i < 9; i++) { // Change to the number of wagon parts
            int random = rand.nextInt(10);
            addBubble("Part" + random, bubblesPanel);
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

    private JFrame frame;

    /**
     * Launch the application.
     */
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

    private void createBubbles() {
        bubbles = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) { // Create 10 bubbles
            int x = rand.nextInt(bubblesPanel.getWidth());
            int y = rand.nextInt(bubblesPanel.getHeight());
            Bubble bubble = new Bubble(x, y);
            bubbles.add(bubble);
        }

        // Add bubbles to the bubbles panel
        for (Bubble bubble : bubbles) {
            bubblesPanel.add(bubble);
        }
    }

    private static class Bubble extends JLabel {
        public Bubble(int x, int y) {
            // Set bubble properties
            setBounds(x, y, 20, 20); // Set position and size
            setOpaque(true);
            setBackground(Color.BLUE); // Set color (you can change this)
            setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border (optional)
        }
    }
}
