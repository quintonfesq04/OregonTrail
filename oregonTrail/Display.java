import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JPanel panel;
    private TravelScreen travelScreen;

    public Display() {
        initialize();
    }

    protected void initialize() {
        frame = new JFrame("Oregon Trail");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout());

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(1, 1));

        frame.getContentPane().add(panel, "MainPanel");
        frame.setVisible(true);

        // Start the game with the travel screen
        travelScreen = new TravelScreen();
        panel.add(travelScreen.getPanel());
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Display();
            }
        });
    }
}
