package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class WagonLeader extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	private static final int TEXT_FIELD_MAX = 20;
    private Display display;
    private Wagon wagon;
	private WagonNames wagonNames;

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	private JTextField textField;

	private String name1;

	/**
	 * Create the application.
	 */
	public WagonLeader(Wagon wagon, Display display) {
		this.wagon = wagon;
		this.display = display;
		this.wagonNames = wagonNames;
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
	
		// JLabel "What is the first name of the Wagon Leader?"
		JLabel leaderNameLbl = new JLabel("What is the first name of the Wagon Leader?");
		leaderNameLbl.setForeground(new Color(93, 199, 255));
		leaderNameLbl.setFont(smallFont);
		gbc.gridx = 0;
		gbc.gridy = 0;
		viewPanel.add(leaderNameLbl, gbc);
	
		// JTextField
		textField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL; // Allow the text field to expand horizontally
		viewPanel.add(textField, gbc);
		textField.setColumns(10);
	
		textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textField.getText();
                name1 = str; // Set the name1 variable with the entered text
                if (wagonNames != null) { // Check if wagonNames object is not null
                    wagonNames.updateName1(name1); // Update the name1 label in WagonNames class
                }
                textField.setText("");
				display.showWagonNames(wagon);
			}
		});
		
		
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

	public String getName1() {
		return name1;
	}
}
