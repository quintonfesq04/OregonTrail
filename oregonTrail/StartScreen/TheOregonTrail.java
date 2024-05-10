package StartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * TheOregonTrail.java -- Provides the user with a combobox list of choices that determine what the user does
 * the user has the option to start the game, learn the game, or end the game
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class TheOregonTrail extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

	private Display display;
	private Wagon wagon;

	private JComboBox<String> comboBox;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	private Color desiredColor = new Color(93, 199, 255);

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
		gbl_viewPanel.rowHeights = new int[] { 0, -89, 0, 0, 0 };
		gbl_viewPanel.columnWidths = new int[] { 98, 0, 0, 0, 0 };
		viewPanel.setLayout(gbl_viewPanel);

		// JLabel "The Oregon Trail"
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(0, 0, 50, 5);
		gbc1.gridx = 0; // Adjusted gridx to position at the left
		gbc1.gridy = 0; // Adjusted gridy to position at the top
		gbc1.gridwidth = 2; // Set gridwidth to 2 to span across two columns
		gbc1.anchor = GridBagConstraints.CENTER; // Center the component horizontally
		JLabel theOregonTrailLbl = new JLabel("The Oregon Trail");
		theOregonTrailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		theOregonTrailLbl.setVerticalAlignment(SwingConstants.TOP);
		theOregonTrailLbl.setForeground(new Color(93, 199, 255));
		viewPanel.add(theOregonTrailLbl, gbc1);
		theOregonTrailLbl.setFont(titleFont);

		// JLabel "You May:"
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1; // Adjusted gridy to position below the title
		JLabel youMayLbl = new JLabel("You May:");
		youMayLbl.setForeground(new Color(93, 199, 255));
		viewPanel.add(youMayLbl, gbc);
		youMayLbl.setFont(smallFont);

		// JComboBox
		comboBox = new JComboBox<>();
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor = GridBagConstraints.WEST;
		gbc2.insets = new Insets(0, 0, 5, 5);
		gbc2.gridx = 1;
		gbc2.gridy = 1; // Adjusted gridy to position next to the JLabel
		comboBox.addItem("1. Travel The Trail");
		comboBox.addItem("2. Learn About The Trail");
		comboBox.addItem("3. End");

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedOption = (String) combo.getSelectedItem();
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

	/**
	 * resizes all images through AbstractScreen
	 */
	@Override
	public void resizeImages() {
		// TODO Auto-generated method stub
		viewPanel.resizeImage();

	}

	/**
	 * receive the JPanel created
	 * 
	 * @return the viewPanel
	 */
	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return viewPanel;
	}

}