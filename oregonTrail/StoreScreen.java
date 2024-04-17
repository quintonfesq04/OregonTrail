import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreScreen extends JFrame {
    private JPanel panel;
    private Display display; // Add reference to Display
    private Inventory inventory; // Add reference to Inventory

    public StoreScreen(Display display, Inventory inventory) {
        this.display = display;
        this.inventory = inventory;
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

        JButton btnNewButton_1 = new JButton("Buy");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.setMoney(inventory.getMoney() - 1000); // Subtract money from the inventory
                inventory.setFood(inventory.getFood() + 1500);
                inventory.setOxen(inventory.getOxen() + 4);
                inventory.setClothing(inventory.getClothing() + 30);
                inventory.setBullets(inventory.getBullets() + 100);
                display.showTravelScreen(inventory);
            }
        });
        btnNewButton_1.setBackground(new Color(251, 252, 255));
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBounds(155, 111, 117, 55);
        panel.add(btnNewButton_1);

        // Set the content pane of StoreScreen to the panel
        setContentPane(panel);
        
        JSpinner spinner = new JSpinner();
        spinner.setBounds(99, 73, 34, 26);
        panel.add(spinner);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setBounds(99, 111, 34, 26);
        panel.add(spinner_1);
        
        JSpinner spinner_2 = new JSpinner();
        spinner_2.setBounds(99, 149, 34, 26);
        panel.add(spinner_2);
        
        JSpinner spinner_3 = new JSpinner();
        spinner_3.setBounds(99, 187, 34, 26);
        panel.add(spinner_3);
        
        JSpinner spinner_4 = new JSpinner();
        spinner_4.setBounds(99, 227, 34, 26);
        panel.add(spinner_4);
        
        JLabel lblNewLabel_1 = new JLabel("Food:");
        lblNewLabel_1.setBounds(26, 78, 61, 16);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Water:");
        lblNewLabel_2.setBounds(26, 116, 61, 16);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Oxen:");
        lblNewLabel_3.setBounds(26, 154, 61, 16);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Clothing:");
        lblNewLabel_4.setBounds(26, 192, 61, 16);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Bullets:");
        lblNewLabel_5.setBounds(26, 232, 61, 16);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Total Weight:");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_6.setBounds(145, 78, 92, 16);
        panel.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Items:");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_7.setBounds(26, 45, 117, 16);
        panel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("0");
        lblNewLabel_8.setBounds(249, 78, 61, 16);
        panel.add(lblNewLabel_8);

        // Set frame properties
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(480, 150);
        //setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
