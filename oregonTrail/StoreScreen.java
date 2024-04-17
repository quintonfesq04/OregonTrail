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

       

        // Set the content pane of StoreScreen to the panel
        setContentPane(panel);
        
        SpinnerNumberModel model1 = new SpinnerNumberModel(0,0,2000,20);
        JSpinner foodSpinner = new JSpinner(model1);
        foodSpinner.setBounds(99, 73, 50, 26);
        panel.add(foodSpinner);
        
        SpinnerNumberModel model2 = new SpinnerNumberModel(0,0,2000,20);
        JSpinner waterSpinner = new JSpinner(model2);
        waterSpinner.setBounds(99, 111, 50, 26);
        panel.add(waterSpinner);
        
        SpinnerNumberModel model3 = new SpinnerNumberModel(0,0,4,1);
        JSpinner oxenSpinner = new JSpinner(model3);
        oxenSpinner.setBounds(99, 149, 50, 26);
        panel.add(oxenSpinner);
        
        SpinnerNumberModel model4 = new SpinnerNumberModel(0,0,50,2);
        JSpinner clothesSpinner = new JSpinner(model4);
        clothesSpinner.setBounds(99, 187, 50, 26);
        panel.add(clothesSpinner);
        
        SpinnerNumberModel model5 = new SpinnerNumberModel(0,0,1000,10);
        JSpinner bulletsSpinner = new JSpinner(model5);
        bulletsSpinner.setBounds(99, 227, 50, 26);
        panel.add(bulletsSpinner);
        
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
        JButton btnNewButton_1 = new JButton("Buy");
            btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.setMoney(inventory.getMoney() - 1000); // Subtract money from the inventory
                inventory.setFood((int) foodSpinner.getValue());
                inventory.setOxen((int) oxenSpinner.getValue());
                inventory.setWater((int) waterSpinner.getValue());
                inventory.setClothing((int) clothesSpinner.getValue());
                inventory.setBullets((int) bulletsSpinner.getValue());
                display.showTravelScreen(inventory);
            }
        });
        btnNewButton_1.setBackground(new Color(251, 252, 255));
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBounds(155, 111, 117, 55);
        panel.add(btnNewButton_1);
    }

    public JPanel getPanel() {
        return panel;
    }
}
