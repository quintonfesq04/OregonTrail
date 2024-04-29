package Screens;
import javax.swing.JPanel;

import Gameplay.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import Screens.*;
import Hunting.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * LandmarkScreen.java -- shows the landmark that the player has arrived at
 * @author Quinton Fesq
 * @version 1.3.1 4/24/24
 */

public class LandmarkScreen extends AbstractScreen{
    private JPanel panel = new JPanel();
    private Display display;
    
	/**
	 * constructor for LandmarkScreen object
	 * @param display the display that this will be used in
	 */
    public LandmarkScreen(Display display) {
    	this.display = display;
    	initialize();
    }

    @Override
    protected void initialize() {
    	panel.setBounds(100, 100, 573, 456);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel bottomPanel = new JPanel();
		panel.add(bottomPanel);
		bottomPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Store");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showStoreScreen();
			}
		});
		bottomPanel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Travel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showTravelScreen();
			}
		});
		bottomPanel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Conversation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showConversationScreen();
			}
		});
		bottomPanel.add(btnNewButton);
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
