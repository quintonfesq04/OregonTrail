package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;

public class TrailScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	
	private Display display;
	private Wagon wagon;
	
	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	
	private String selectedOption;

	private String choice;

	/**
	 * Create the application.
	 */
	public TrailScreen(Wagon wagon, Display display) {
		this.wagon = wagon;
		this.display = display;
		initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		viewPanel.setFocusable(true);
		viewPanel.setLayout(new GridBagLayout());
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
	
		// JLabel "Many kinds of women made the trip to Oregon."
		JLabel titleLbl = new JLabel("Many kinds of women made the trip to Oregon.");
		titleLbl.setForeground(new Color(93, 199, 255));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2; // Set gridwidth to 2 to span across two columns
		viewPanel.add(titleLbl, gbc);
		titleLbl.setFont(titleFont);
	
		// JLabel "You May:"
		JLabel youMayLbl = new JLabel("You May:");
		youMayLbl.setForeground(new Color(93, 199, 255));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1; // Reset gridwidth
		viewPanel.add(youMayLbl, gbc);
		youMayLbl.setFont(smallFont);
	
		// JComboBox
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("1. Be a Doctor from Dayton");
		comboBox.addItem("2. Be a Homesteader from Hamden");
		comboBox.addItem("3. Be a Teacher from Toledo");
		comboBox.addItem("4. Find out the differences between these choices");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Allow the combo box to expand horizontally
		viewPanel.add(comboBox, gbc);
	
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				selectedOption = (String) combo.getSelectedItem();
				// Check which item is selected and perform action accordingly
				switch (selectedOption) {
					case "1. Be a Doctor from Dayton":
					case "2. Be a Homesteader from Hamden":
					case "3. Be a Teacher from Toledo":
						display.showWagonNames(wagon);
						break;
					case "4. Find out the differences between these choices":
						display.showGroupInfo(wagon);
						break;
				}
			}
		});
	
		// JLabel "What is your choice?"
		JLabel choiceLbl = new JLabel("What is your choice?");
		choiceLbl.setForeground(new Color(93, 199, 255));
		choiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2; // Set gridwidth to 2 to span across two columns
		viewPanel.add(choiceLbl, gbc);
		choiceLbl.setFont(smallFont);
	}

	public void resetScreen() {
        viewPanel.removeAll();
        //add your elements
        viewPanel.revalidate();
        viewPanel.repaint();
        display.showTrailScreen(wagon);
        initialize();
    }
	
	public String setChoice(){
		String choice;
		return this.choice = selectedOption;
	}

    @Override
	public void resizeImages() {
		// TODO Auto-generated method stub
        viewPanel.resizeImage();
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return viewPanel;
	}

}
