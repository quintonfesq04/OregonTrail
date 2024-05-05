package Screens;
import javax.swing.JPanel;

import Gameplay.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import Screens.*;
import Hunting.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * LandmarkScreen.java -- shows the landmark that the player has arrived at
 * @author Quinton Fesq
 * @author Ethan Burch
 * @version 1.3.1 4/24/24
 */

public class LandmarkScreen extends AbstractScreen{
    protected PicPanel viewPanel = new PicPanel(new File("Images/Landmark 1.png"));
    private Display display;
	private Wagon wagon;
    
	/**
	 * constructor for LandmarkScreen object
	 * @param display the display that this will be used in
	 */
    public LandmarkScreen(Wagon wagon, Display display) {
    	this.display = display;
		this.wagon = wagon;
    	initialize();
    }

    @Override
    protected void initialize() {
    	viewPanel.setBounds(100, 100, 573, 456);
		viewPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.add(viewPanel);
		topPanel.setLayout(new GridLayout(0,1,0,0));

		JPanel bottomPanel = new JPanel();
		viewPanel.add(bottomPanel);
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
				display.showTravelScreen(wagon);
			}
		});
		bottomPanel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Conversation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showConversationScreen(wagon);
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
        return viewPanel;
    }
    
}
