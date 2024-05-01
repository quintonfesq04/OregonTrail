package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;

public class WelcomeScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Display display;
    private Wagon wagon;

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

	/**
	 * Create the application.
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

        viewPanel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_SPACE)
                    display.showTheOregonTrail(wagon);   
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
