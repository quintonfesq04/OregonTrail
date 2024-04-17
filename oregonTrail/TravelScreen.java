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
    private Conditions conditions;

    public TravelScreen() {
        initialize();
        this.conditions = new Conditions(inventory); // Initialize Conditions object
    }

    // Existing constructor
    public TravelScreen(Inventory inventory, Locations locations, Player user) {
        this.inventory = inventory;
        this.locations = locations;
        this.user = user;
        initialize();
        this.conditions = new Conditions(inventory); // Initialize Conditions object
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
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        File image = new File("Images/Covered Wagon.jpg");

        viewPanel = new PicPanel(image);
        viewPanel.setBackground(Color.BLUE);
        panel.add(viewPanel);
        viewPanel.repaint();

        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(Color.DARK_GRAY);
        panel.add(optionPanel);
        optionPanel.setLayout(new GridLayout(0, 4, 0, 0));

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
        
        inventory.addItem(Item.FOOD, food);
        JLabel foodLabel = new JLabel("Lbs of Food: " + food);
        foodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(foodLabel);

        inventory.addItem(Item.WATER, water);
        JLabel waterLabel = new JLabel("Lbs of Water: " + water);
        waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(waterLabel);

        inventory.addItem(Item.WAGON_WHEEL, wagonWheel);
        JLabel wheelLabel = new JLabel("Wagon Wheels: " + wagonWheel);
        wheelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(wheelLabel);

        inventory.addItem(Item.WAGON_TONGUE, wagonTongue);
        JLabel tongueLabel = new JLabel("Wagon Tongues: " + wagonTongue);
        tongueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryShowPanel.add(tongueLabel);

        inventory.addItem(Item.WAGON_AXLE, wagonAxle);
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

        JPanel foodPanel = new JPanel();
        foodPanel.setOpaque(false);
        foodConsumptionPanel.add(foodPanel);
        foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));

        JRadioButton meagerButton = new JRadioButton("Meager");
        meagerButton.setBackground(Color.LIGHT_GRAY);
        meagerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodPanel.add(meagerButton);

        JRadioButton bareBonesButton = new JRadioButton("Bare-Bones");
        bareBonesButton.setBackground(Color.LIGHT_GRAY);
        bareBonesButton.setAlignmentX(0.5f);
        foodPanel.add(bareBonesButton);

        JRadioButton fillingButton = new JRadioButton("Filling");
        fillingButton.setBackground(Color.LIGHT_GRAY);
        fillingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodPanel.add(fillingButton);

		JPanel buttonPanel = new JPanel();
    	buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setOpaque(false);
    	optionPanel.add(buttonPanel);

    	JButton travelBtn = new JButton("Travel");
		travelBtn.setBackground(Color.LIGHT_GRAY); // Set background color
		travelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (conditions != null) {
					// Update conditions
					conditions.setInventory(inventory);
					conditions.handleInventory();
					
					// Get updated inventory
					inventory = conditions.getInventory();
			
					// Deduct food and water based on consumption rate
					int foodConsumed = user.getConsumption();

					//int waterConsumed = 10; //Adjust as needed
					inventory.removeItem(Item.FOOD, foodConsumed);
					//updatedInventory.removeItem("water", waterConsumed);
			
					// Update UI labels
					foodLabel.setText("Lbs of Food: " + inventory.getItemCount(Item.FOOD));
					waterLabel.setText("Lbs of Water: " + inventory.getItemCount(Item.WATER));
			
					// Update class variables
					food = inventory.getItemCount("food");
					water = inventory.getItemCount("water");
			
					// Update other UI elements and game state as needed
				} else {
					System.out.println("Conditions object is null!");
				}
			}
			
});

		buttonPanel.add(travelBtn);
    }
	public JPanel getPanel() {
			return panel;
		}
}
