import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    private JPanel panel;
    private Display display; // Add reference to Display

    public StoreScreen(Display display) {
        this.display = display;
        initialize();
    }

    private void initialize() {
        // Initialize the panel and set layout
        panel = new JPanel();
        panel.setLayout(null);

        // Add components to the panel
        JLabel lblNewLabel = new JLabel("Do You Want To Buy Items For Your Trip?");
        lblNewLabel.setBackground(new Color(105, 105, 107));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBounds(26, 17, 265, 16);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("No I Do Not Want To Travel To Oregon");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBackground(new Color(251, 252, 255));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBounds(6, 45, 311, 55);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Buy");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.showTravelScreen();
                Inventory.removeItem("money", 1000);
            }
        });
        btnNewButton_1.setBackground(new Color(251, 252, 255));
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBounds(329, 45, 117, 55);
        panel.add(btnNewButton_1);

        // Set the content pane of StoreScreen to the panel
        setContentPane(panel);

        // Set frame properties
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(480, 150);
        //setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
