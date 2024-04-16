import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @File TravelScreen.java
 * @Author Ethan Burch
 * @Version 1.0.0 4/14/24
 * Creates a JPanel for the traveling portion of the game
 */
public class TravelScreen extends JPanel {
    JPanel panel;
    PicPanel viewPanel;

	public TravelScreen() {
        initialize();
		this.conditions = new Conditions(inventory);
    }

    private int spaceBetween = 5;
    private int food = 200;
    private int water = 100;
    private int wagonTongue = 1;
    private int wagonWheel = 1;
    private int wagonAxle = 1;
    private int health = 100;
    private int milesTraveled = 0;
    private int daysPassed = 0;
    private boolean brokenWagon = false;

    private Locations locations = new Locations(90);

    private Player user = new Player(health, food, 0, 0);

    private Inventory inventory = new Inventory();

    private Conditions conditions;

    /**
     * constructor for TravelScreen object
     * 
     * @param inventory  - the main inventory
     * @param locations  - the location of the wagon
     * @param user       - the user
     * @param conditions - the trail conditions
     */
    public TravelScreen(Inventory inventory, Locations locations, Player user, Conditions conditions) {
        this.inventory = inventory;
        this.locations = locations;
        this.user = user;
        this.conditions = conditions;
        initialize();
    }

    /**
     * resizes all background images on the panel
     */
    public void resizeBackgroundImages() {
        viewPanel.resizeImage();
    }

    /**
     * initializes the JPanel
     */
    protected void initialize() {
        panel = new JPanel();

        panel.setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(2, 1, 0, 0));

        File image = new File("Images/Covered Wagon.jpg");

        viewPanel = new PicPanel(image);
        viewPanel.setBackground(Color.BLUE);
        panel.add(viewPanel);
        viewPanel.repaint();

        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(Color.DARK_GRAY);
        panel.add(optionPanel);
        optionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		panel.add(optionPanel); // Add this line


		JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        topPanel.setLayout(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Welcome to the Oregon Trail!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel infoLabel1 = new JLabel("Press the button below to start the game.");
        JLabel infoLabel2 = new JLabel("You'll encounter rivers, trade at stores, and travel the trail.");
        topPanel.add(titleLabel);
        topPanel.add(infoLabel1);
        topPanel.add(infoLabel2);

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setOpaque(false);
        inventoryPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
        optionPanel.add(inventoryPanel);
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        JPanel inventoryShowPanel = new JPanel();
        inventoryShowPanel.setBackground(Color.LIGHT_GRAY);
        inventoryPanel.add(inventoryShowPanel);
        inventoryShowPanel.setLayout(new BoxLayout(inventoryShowPanel, BoxLayout.Y_AXIS));

        JLabel healthLabel = new JLabel("Player Health: " + health);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(healthLabel);

        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(inventoryLabel);

        JLabel foodLabel = new JLabel("Lbs of Food: " + food);
        foodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(foodLabel);

        JLabel waterLabel = new JLabel("Lbs of Water: " + water);
        waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(waterLabel);

        JLabel wheelLabel = new JLabel("Wagon Wheels: " + wagonWheel);
        wheelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(wheelLabel);

        JLabel tongueLabel = new JLabel("Wagon Tongues: " + wagonTongue);
        tongueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(tongueLabel);

        JLabel axleLabel = new JLabel("Wagon Axles: " + wagonAxle);
        axleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(axleLabel);

        JPanel travelSpeedPanel = new JPanel();
        travelSpeedPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
        optionPanel.add(travelSpeedPanel);
        travelSpeedPanel.setLayout(new BoxLayout(travelSpeedPanel, BoxLayout.Y_AXIS));
        travelSpeedPanel.setOpaque(false);

        JPanel panel_4 = new JPanel();
        panel_4.setOpaque(false);
        travelSpeedPanel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel sliderLbl = new JLabel("Speed: ");
        sliderLbl.setForeground(Color.LIGHT_GRAY);
        sliderLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(sliderLbl);

        JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // tell user their speed
                sliderLbl.setText("Speed: " + slider.getValue());
            }
        });
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        panel_4.add(slider);
        slider.setForeground(Color.BLACK);
        slider.setMinimum(12);
        slider.setValue(15);
        slider.setMaximum(20);
        slider.setBackground(Color.DARK_GRAY);

        JLabel traveledLbl = new JLabel("Miles Traveled: " + milesTraveled);
        traveledLbl.setForeground(Color.LIGHT_GRAY);
        traveledLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(traveledLbl);

        JLabel distanceLbl = new JLabel("Distance: " + locations.getDistance());
        distanceLbl.setForeground(Color.LIGHT_GRAY);
        distanceLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(distanceLbl);

        JLabel daysLbl = new JLabel("Days Passed: " + daysPassed);
        daysLbl.setForeground(Color.LIGHT_GRAY);
        daysLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel_4.add(daysLbl);

        JPanel foodConsumptionPanel = new JPanel();
        foodConsumptionPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
        optionPanel.add(foodConsumptionPanel);
        foodConsumptionPanel.setOpaque(false);
        foodConsumptionPanel.setLayout(new GridLayout(3, 1, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        foodConsumptionPanel.add(panel_2);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        foodConsumptionPanel.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JRadioButton meagerButton = new JRadioButton("Meager");
        meagerButton.setBackground(Color.LIGHT_GRAY);
        panel.add(meagerButton);
        meagerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JRadioButton bareBonesButton = new JRadioButton("Bare-Bones");
        bareBonesButton.setBackground(Color.LIGHT_GRAY);
        bareBonesButton.setAlignmentX(0.5f);
        panel.add(bareBonesButton);

        JRadioButton fillingButton = new JRadioButton("Filling");
        fillingButton.setBackground(Color.LIGHT_GRAY);
        fillingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(fillingButton);

		JPanel buttonPanel = new JPanel();
    	buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	optionPanel.add(buttonPanel);

    	JButton travelBtn = new JButton("Travel");
		travelBtn.setBackground(Color.LIGHT_GRAY); // Set background color
		travelBtn.addActionListener(new ActionListener() {
    @Override
	public void actionPerformed(ActionEvent e) {
        if (conditions != null) { // Ensure conditions object is initialized
            conditions.setInventory(inventory);
            conditions.handleInventory();
            conditions.getInventory();

            String str = conditions.getConditionMessage();
            if (str != null && !str.isEmpty()) {
                JOptionPane.showMessageDialog(null, str);
            } else if (str != null && str.equals("Random Event: Your wagon broke down. You were unable to fix it!")) {
                brokenWagon = true;
            }

            inventory.removeItem("food", user.getConsumption());
            foodLabel.setText("Lbs of Food: " + inventory.getItemCount("food"));
            inventory.removeItem("water", 10);
            waterLabel.setText("Lbs of Water: " + inventory.getItemCount("water"));
            user.setFood(inventory.getItemCount("food"));
            wheelLabel.setText("Wagon Wheels: " + inventory.getItemCount("wheel"));
            tongueLabel.setText("Wagon Tongues:" + inventory.getItemCount("tongue"));
            axleLabel.setText("Wagon Axles: " + inventory.getItemCount("axle"));
            locations.addDistance(slider.getValue());
            distanceLbl.setText("Distance: " + locations.getDistance());
            if (milesTraveled == 90) {
                JOptionPane.showMessageDialog(null, "You have made it to Soda Springs");
            }
        } else {
            System.out.println("Conditions object is null!");
        }
    }
});

		optionPanel.add(travelBtn);
		

    	panel.add(topPanel, BorderLayout.CENTER);
    	panel.add(buttonPanel, BorderLayout.SOUTH);
		
        

        optionPanel.add(Box.createVerticalGlue());
		
		add(panel);
    }
	public JPanel getPanel() {
			return panel;
		}
}
