package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

public class TheOregonTrail extends AbstractScreen{
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	
	private Display display;
	private Wagon wagon;

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

	/**
	 * Create the application.
	 */
	public TheOregonTrail(Wagon wagon, Display display) {
		this.wagon = wagon;
		this.display = display;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		viewPanel.setFocusable(true);
		GridBagLayout gbl_viewPanel = new GridBagLayout();
		gbl_viewPanel.rowHeights = new int[]{0, -89, 0, 0, 0};
		gbl_viewPanel.columnWidths = new int[]{98, 0, 0, 0, 0};
		viewPanel.setLayout(gbl_viewPanel);
		        
		        GridBagConstraints gbc1 = new GridBagConstraints();
		        gbc1.insets = new Insets(0, 0, 5, 5);
		        gbc1.gridx = 1;
		        gbc1.gridy = 0;
		        gbc1.anchor = GridBagConstraints.NORTH;
		        
		        JLabel theOregonTrailLbl = new JLabel("The Oregon Trail");
		        theOregonTrailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		        theOregonTrailLbl.setVerticalAlignment(SwingConstants.TOP);
		        theOregonTrailLbl.setForeground(new Color(93, 199, 255));
		        viewPanel.add(theOregonTrailLbl, gbc1);
		        theOregonTrailLbl.setFont(titleFont);
		
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.insets = new Insets(0, 0, 5, 5);
		        gbc.anchor = GridBagConstraints.WEST;
		        gbc.gridx = 0; 
		        gbc.gridy = 3; 
		        gbc.gridx = 0;
		        gbc.gridy = 2;
		        
		        JLabel youMayLbl = new JLabel("You May:");
		        youMayLbl.setForeground(new Color(93, 199, 255));
		        viewPanel.add(youMayLbl, gbc);
		        youMayLbl.setFont(smallFont);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.WEST;
		gbc2.insets = new Insets(0, 0, 5, 5);
		gbc2.gridx = 1;
		gbc2.gridy = 2;
		
		JComboBox <String> comboBox = new JComboBox();
		comboBox.addItem("1. Travel The Trail");
		comboBox.addItem("2. Learn About The Trail");
		comboBox.addItem("3. End");
		
		comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedOption = (String) combo.getSelectedItem();
                // Check which item is selected and perform action accordingly
                switch (selectedOption) {
                	case "1. Travel The Trail":
                		display.showTrailScreen(wagon);
                		break;
                	case "2. Learn About The Trail":
                		display.showLearnTrail(wagon);
                		break;
                	case "3. End":
                		display.showDeathScreen();
                		break;
                }
            }
		});
		
		viewPanel.add(comboBox, gbc2);
        viewPanel.requestFocusInWindow();
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
