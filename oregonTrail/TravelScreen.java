import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * @File TravelScreen.java
 * @Author Ethan Burch
 * @Version 1.0.0 4/14/24
 * Creates a JPanel for the traveling portion of the game
 */
public class TravelScreen extends AbstractScreen{
    JPanel panel;
    PicPanel viewPanel;

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
	 * @param inventory 	- the main inventory 
	 * @param locations 	- the location of the wagon
	 * @param user			- the user
	 * @param conditions	- the trail conditions
	 */
    TravelScreen(Inventory inventory, Locations locations, Player user, Conditions conditions){
        this.inventory = inventory;
        this.locations = locations;
        this.user = user;
        this.conditions = conditions;
        initialize();
        //init();
    }

	/**
	 * getPanel	- returns the JPanel for traveling
	 * @return	- Traveling JPanel
	 */
    public JPanel getPanel(){
        return panel;
    }

	/**
	 * resizes all background images on the panel
	 */
    public void resizeBackgroundImages(){
        viewPanel.resizeImage();
    }

	/**
	 * initializes the JPanel
	 */
    protected void initialize() {
		panel = new JPanel();
		
		panel.setBounds(100, 100, 500, 500);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		
		File image = new File("Images\\Covered Wagon.jpg");

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
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		inventoryPanel.add(panel_3);
		
		JPanel inventoryShowPanel = new JPanel();
		inventoryShowPanel.setBackground(Color.LIGHT_GRAY);
		inventoryPanel.add(inventoryShowPanel);
		inventoryShowPanel.setLayout(new BoxLayout(inventoryShowPanel, BoxLayout.Y_AXIS));
		
		JLabel healthLabel = new JLabel("Player Health: " + health);
		healthLabel.setBackground(Color.LIGHT_GRAY);
		healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(healthLabel);
		

		JLabel inventoryLabel = new JLabel("Inventory");
		inventoryLabel.setBackground(Color.LIGHT_GRAY);
		inventoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(inventoryLabel);

		JLabel foodLabel = new JLabel("Lbs of Food: " + food);
		foodLabel.setBackground(Color.LIGHT_GRAY);
		foodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(foodLabel);
		
		inventory.addItem("food", food);

		JLabel waterLabel = new JLabel("Lbs of Water: " + water);
		waterLabel.setBackground(Color.LIGHT_GRAY);
		waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(waterLabel);

		inventory.addItem("water", water);

		JLabel wheelLabel = new JLabel("Wagon Wheels: " + wagonWheel);
		wheelLabel.setBackground(Color.LIGHT_GRAY);
		wheelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(wheelLabel);

		inventory.addItem("wheel", wagonWheel);

		JLabel tongueLabel = new JLabel("Wagon Tongues: " + wagonTongue);
		tongueLabel.setBackground(Color.LIGHT_GRAY);
		tongueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(tongueLabel);

		inventory.addItem("tongue", wagonTongue);

		JLabel axleLabel = new JLabel("Wagon Axles: " + wagonAxle);
		axleLabel.setBackground(Color.LIGHT_GRAY);
		axleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(axleLabel);

		inventory.addItem("axle", wagonAxle);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		inventoryPanel.add(panel_5);
		
		JPanel travelSpeedPanel = new JPanel();
		travelSpeedPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(travelSpeedPanel);
		travelSpeedPanel.setLayout(new BoxLayout(travelSpeedPanel, BoxLayout.Y_AXIS));
		travelSpeedPanel.setOpaque(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		travelSpeedPanel.add(panel_6);
		
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
				sliderLbl.setText( "Speed: " + slider.getValue() );
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
		
		JLabel traveledLbl = new JLabel("Miles Traveled: " + milesTraveled );
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

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		travelSpeedPanel.add(panel_7);
		
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

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(fillingButton);
		btnGroup.add(meagerButton);
		btnGroup.add(bareBonesButton);
		fillingButton.setSelected(true);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		foodConsumptionPanel.add(panel_1);
		
		JPanel travelPanel = new JPanel();
		travelPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(travelPanel);
		travelPanel.setLayout(new BoxLayout(travelPanel, BoxLayout.X_AXIS));
		travelPanel.setOpaque(false);
		
		conditions = new Conditions(inventory);

		JOptionPane.showMessageDialog(null, "You are starting the trail in Fort Bridger and are traveling 90 miles away to Soda Springs.");

		JButton travelBtn = new JButton("Travel");
		travelBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		travelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(milesTraveled != 90 && !brokenWagon){ //if there is still trail to travel on
					if(locations.getDistance() != 0){
						daysPassed++;
						milesTraveled += slider.getValue();
					}
					// reset all vairables
					traveledLbl.setText("Miles Traveled: "+ milesTraveled);
					daysLbl.setText("Days Passed: " + daysPassed);
					if (fillingButton.isSelected()) 
						user.setConsumption(fillingButton.getText());
					else if(meagerButton.isSelected())
						user.setConsumption(meagerButton.getText());
					else 
						user.setConsumption(bareBonesButton.getText());
					
					// determine random events
					conditions.setInventory(inventory);
					conditions.handleInventory();
					conditions.getInventory();
					
					String str = conditions.getConditionMessage(); 
					if(str.compareTo("") != 0) // make sure there is a string to display
						JOptionPane.showMessageDialog(null, str);
					else if(str.compareTo("Random Event: Your wagon broke down." + " You were unable to fix it!") == 0)
						brokenWagon = true;
					inventory.removeItem("food", user.getConsumption());
					foodLabel.setText("Lbs of Food: " + inventory.getItemCount("food"));
					inventory.removeItem("water", 10);
					waterLabel.setText("Lbs of Water: " + inventory.getItemCount("water"));
					user.setFood(inventory.getItemCount("food"));
					wheelLabel.setText("Wagon Wheels: " + inventory.getItemCount("wheel"));
					tongueLabel.setText("Wagon Tongues:" + inventory.getItemCount("tongue"));
					axleLabel.setText("Wagon Axles: " + inventory.getItemCount("axle"));
				
					distanceLbl.setText("Distance: " + locations.calculateDistance(slider.getValue()));
					if(milesTraveled == 90){
						JOptionPane.showMessageDialog(null, "You have made it to Soda Springs");
					}
				}
			}
		});
		travelBtn.setBackground(Color.LIGHT_GRAY);
		travelPanel.add(travelBtn); 
		panel.setVisible(true);
	}
}
