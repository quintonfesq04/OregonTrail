

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Display {

	private JFrame frame;
	private int spaceBetween = 5;
	
	private Image backgroundImage;
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
		viewPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(viewPanel);
		
		try {
			//get image and scale it nice
			backgroundImage = javax.imageio.ImageIO.read(new File("Covered Wagon.JPG"));
			backgroundImage = backgroundImage.getScaledInstance(490, 250, Image.SCALE_SMOOTH);
			viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
			JLabel pic = new JLabel(new javax.swing.ImageIcon(backgroundImage));
			viewPanel.add(pic);
			
		            
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "Error, image not found!");
		}
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(optionPanel);
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
		
		JLabel foodLabel = new JLabel("Lbs of Food: ");
		foodLabel.setBackground(Color.LIGHT_GRAY);
		foodLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(foodLabel);
		
		JLabel waterLabel = new JLabel("Lbs of Water: ");
		waterLabel.setBackground(Color.LIGHT_GRAY);
		waterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryShowPanel.add(waterLabel);
		
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Meager");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("theOtherOne");
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_2.setAlignmentX(0.5f);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Filling");
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		foodConsumptionPanel.add(panel_1);
		
		JPanel travelPanel = new JPanel();
		travelPanel.setBorder(new EmptyBorder(0, spaceBetween, 0, spaceBetween));
		optionPanel.add(travelPanel);
		travelPanel.setLayout(new BoxLayout(travelPanel, BoxLayout.X_AXIS));
		travelPanel.setOpaque(false);
		
		JButton btnNewButton = new JButton("Travel");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		travelPanel.add(btnNewButton); 
		
	
	}
}