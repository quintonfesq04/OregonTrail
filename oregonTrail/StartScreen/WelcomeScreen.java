package StartScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * WelcomeScreen.java -- the first screen when the application is opened
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/24
 */
public class WelcomeScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

	private Display display; // call to display
	private Wagon wagon; // call to wagon

	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24); // set font for title
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set font for text

	/**
	 * Create the application.
	 * 
	 * @param display call to display
	 * @param wagon   call to wagon
	 */
	public WelcomeScreen(Wagon wagon, Display display) {
		this.wagon = wagon; // call to wagon
		this.display = display; // call to display
		initialize(); // call to initialize method
	}

	protected void initialize() {
		viewPanel.setFocusable(true);
		viewPanel.requestFocusInWindow();
		viewPanel.setLayout(new BorderLayout(0, 0));

		JLabel welcomeLbl = new JLabel("Welcome To The Oregon Trail"); // new lbl
		welcomeLbl.setForeground(new Color(93, 199, 255)); // add color
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(welcomeLbl, BorderLayout.CENTER);
		welcomeLbl.setFont(titleFont);

		JLabel continueLbl = new JLabel("Press Space To Continue"); // new lbl
		continueLbl.setForeground(new Color(93, 199, 255)); // add color
		continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		continueLbl.setVerticalAlignment(SwingConstants.CENTER);
		viewPanel.add(continueLbl, BorderLayout.SOUTH);
		continueLbl.setFont(smallFont); // set font

		viewPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int vk = e.getKeyCode();
				if (vk == KeyEvent.VK_SPACE)
					display.showTheOregonTrail(wagon); // display the oregon trial screen
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