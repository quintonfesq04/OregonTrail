package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
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

public class LearnTrail extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	
	private Display display;
	private Wagon wagon;
	
	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	

	/**
	 * Create the application.
	 */
	public LearnTrail(Wagon wagon, Display display) {
		this.wagon = wagon;
		this.display = display;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		viewPanel.setFocusable(true);
		viewPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("The Oregon Trail");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Press Space To Continue");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(lblNewLabel_2, BorderLayout.SOUTH);
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