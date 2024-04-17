// StoreScreen.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    private JPanel panel;
    private JFrame frame;
    private Display display; // Add reference to Display

    public StoreScreen(Display display) {
        this.display = display;
        initialize();
    }


    private void initialize() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Store Screen");
        panel.add(label, BorderLayout.CENTER);

        JButton travelButton = new JButton("Go to Travel Screen");
        travelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.showTravelScreen();
            }
        });
        
        panel.add(travelButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
