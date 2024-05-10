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
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

	private Display display;
	private Wagon wagon;

	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

	/**
	 * Create the application.
	 * 
	 * @param display
	 */
	public WelcomeScreen(Wagon wagon, Display display) {
		this.wagon = wagon;
		this.display = display;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		viewPanel.setFocusable(true);
		viewPanel.requestFocusInWindow();
		viewPanel.setLayout(new BorderLayout(0, 0));

		JLabel welcomeLbl = new JLabel("Welcome To The Oregon Trail");
		welcomeLbl.setForeground(new Color(93, 199, 255));
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(welcomeLbl, BorderLayout.CENTER);
		welcomeLbl.setFont(titleFont);

		JLabel continueLbl = new JLabel("Press Space To Continue");
		continueLbl.setForeground(new Color(93, 199, 255));
		continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		continueLbl.setVerticalAlignment(SwingConstants.CENTER);
		viewPanel.add(continueLbl, BorderLayout.SOUTH);
		continueLbl.setFont(smallFont);

		viewPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int vk = e.getKeyCode();
				if (vk == KeyEvent.VK_SPACE)
					display.showTheOregonTrail(wagon);
			}
		});
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