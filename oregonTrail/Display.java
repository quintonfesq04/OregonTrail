package oregonTrail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Display {

	private JFrame frame;
	private int spaceBetween = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel viewPanel = new JPanel();
		viewPanel.setBackground(Color.GREEN);
		frame.getContentPane().add(viewPanel);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(Color.RED);
		frame.getContentPane().add(optionPanel);
		optionPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(inventoryPanel);
		
		JLabel lblNewLabel = new JLabel("New label");
		inventoryPanel.add(lblNewLabel);
		inventoryPanel.setOpaque(false);
		
		JPanel travelSpeedPanel = new JPanel();
		travelSpeedPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(travelSpeedPanel);
		travelSpeedPanel.setLayout(new BoxLayout(travelSpeedPanel, BoxLayout.X_AXIS));
		travelSpeedPanel.setOpaque(false);
		
		JSlider slider = new JSlider();
		travelSpeedPanel.add(slider);
		
		JPanel foodConsumptionPanel = new JPanel();
		foodConsumptionPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(foodConsumptionPanel);
		foodConsumptionPanel.setOpaque(false);
		foodConsumptionPanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		foodConsumptionPanel.add(panel_2);
		
		JPanel panel = new JPanel();
		foodConsumptionPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Meager");
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("theOtherOne");
		rdbtnNewRadioButton_2.setAlignmentX(0.5f);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Filling");
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panel_1 = new JPanel();
		foodConsumptionPanel.add(panel_1);
		
		JPanel travelPanel = new JPanel();
		travelPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(travelPanel);
		travelPanel.setLayout(new BoxLayout(travelPanel, BoxLayout.X_AXIS));
		travelPanel.setOpaque(false);
		
		JButton btnNewButton = new JButton("Travel");
		travelPanel.add(btnNewButton); 
	}
}