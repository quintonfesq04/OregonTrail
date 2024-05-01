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

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public WagonLeader(Wagon wagon, Display display) {
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
		
		JLabel leaderNameLbl = new JLabel("What is the first name of the Wagon Leader?");
        leaderNameLbl.setForeground(new Color(93, 199, 255));
        leaderNameLbl.setFont(smallFont);
        //gbc.gridx = 0; 
       // gbc.gridy = 0; 
		
        viewPanel.add(leaderNameLbl, gbc);
		
		textField = new JTextField();
		//gbc.gridx = 1; 
		//gbc.gridy = 0;
        viewPanel.add(textField, gbc);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				if(str.length() > TEXT_FIELD_MAX){
					str = str.substring(0, TEXT_FIELD_MAX);
					textField.setText(str);
				}
					
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
}
