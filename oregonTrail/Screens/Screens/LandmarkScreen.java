package Screens;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * LandmarkScreen.java -- shows the landmark that the player has arrived at
 * 
 * @author Quinton Fesq
 * @author Ethan Burch
 * @version 1.3.1 4/24/24
 */

public class LandmarkScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Landmark 1.png"));

	private Font labelFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font sliderFont = new Font("Trajan Pro", Font.PLAIN, 16);

	private Display display;
	private Wagon wagon;

	int screenBG = 0;

	/**
	 * constructor for LandmarkScreen object
	 * 
	 * @param display the display that this will be used in
	 */
	public LandmarkScreen(Wagon wagon, Display display) {
		this.display = display;
		this.wagon = wagon;
		initialize();
	}

	@Override
	protected void initialize() {
		viewPanel.setFocusable(true);
		GridBagLayout gbl_viewPanel = new GridBagLayout();
		gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
		viewPanel.setLayout(gbl_viewPanel);

		JButton storeBtn = new JButton("Store");
		GridBagConstraints gbc_storeBtn = new GridBagConstraints();
		gbc_storeBtn.insets = new Insets(50, 115, 0, 0);
		gbc_storeBtn.gridx = 0;
		gbc_storeBtn.gridy = 0;
		storeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		storeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showStoreScreen();
			}
		});
		viewPanel.add(storeBtn, gbc_storeBtn);

		JButton travelBtn = new JButton("Travel");
		GridBagConstraints gbc_travelBtn = new GridBagConstraints();
		gbc_travelBtn.insets = new Insets(25, 30, 0, 45);
		gbc_travelBtn.gridx = 1;
		gbc_travelBtn.gridy = 0;
		travelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showTravelScreen(wagon);
			}
		});
		viewPanel.add(travelBtn, gbc_travelBtn);

		JButton conversationBtn = new JButton("Conversation");
		GridBagConstraints gbc_conversationBtn = new GridBagConstraints();
		gbc_conversationBtn.insets = new Insets(105, 35, 0, 92);
		gbc_conversationBtn.gridx = 2;
		gbc_conversationBtn.gridy = 0;
		conversationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showConversationScreen(wagon);
			}
		});
		viewPanel.add(conversationBtn, gbc_conversationBtn);

		switchBG();
	}

	private void switchBG() {
		switch (screenBG) {
			case 0:
				viewPanel.setImage(new File("Images/Landmark 1.png"));
				screenBG++;
				break;
			case 1:
				viewPanel.setImage(new File("Images/Landmark 2.png"));
				screenBG++;
				break;
			case 2:
				viewPanel.setImage(new File("Images/Landmark 3.png"));
				screenBG = 0;
				break;
			default:
				viewPanel.setImage(new File("Images/Background.jpg"));
				break;
		}
		viewPanel.repaint();
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