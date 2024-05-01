package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.io.File;
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
		
		JLabel leaderNameLbl = new JLabel("What is the first name of the Wagon Leader?");
        leaderNameLbl.setForeground(new Color(93, 199, 255));
		viewPanel.add(leaderNameLbl, BorderLayout.WEST);
        leaderNameLbl.setFont(smallFont);
		
		textField = new JTextField();
		viewPanel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setBounds(100,100,100,100);
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
