package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;

import javax.swing.*;

import Gameplay.*;
import Gameplay.PicPanel;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;

public class WelcomeScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		panel = new JPanel();
		panel.setBounds(100, 100, 450, 300);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel welcomeLbl = new JLabel("Welcome To The Oregon Trail");
		welcomeLbl.setForeground(new Color(93, 199, 255));
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(welcomeLbl, BorderLayout.CENTER);
		welcomeLbl.setFont(titleFont);
		
		JLabel continueLbl = new JLabel("Press Space To Continue");
		continueLbl.setForeground(new Color(93, 199, 255));
		continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(continueLbl, BorderLayout.SOUTH);
		continueLbl.setFont(smallFont);
	}

	@Override
	public void resizeImages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
