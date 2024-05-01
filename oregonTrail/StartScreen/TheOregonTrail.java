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

public class TheOregonTrail extends AbstractScreen{
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	
	private Display display;
	private Wagon wagon;

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

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
		viewPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel theOregonTrailLbl = new JLabel("The Oregon Trail");
        theOregonTrailLbl.setForeground(new Color(93, 199, 255));
		theOregonTrailLbl.setVerticalAlignment(SwingConstants.BOTTOM);
		theOregonTrailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(theOregonTrailLbl, BorderLayout.NORTH);
        theOregonTrailLbl.setFont(titleFont);
		
		JLabel youMayLbl = new JLabel("You May:");
        youMayLbl.setForeground(new Color(93, 199, 255));
		youMayLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		viewPanel.add(youMayLbl, BorderLayout.WEST);
        youMayLbl.setFont(smallFont);
		
		JComboBox <String> comboBox = new JComboBox();
		comboBox.addItem("1. Travel The Trail");
		comboBox.addItem("2. Learn About The Trail");
		comboBox.addItem("3. See The Oregon Top Ten");
		comboBox.addItem("4. Turn Sound Off");
		comboBox.addItem("5. End");
		
		comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedOption = (String) combo.getSelectedItem();
                // Check which item is selected and perform action accordingly
                switch (selectedOption) {
                	case "1. Travel The Trail":
                		display.showTrailScreen(wagon);
                		break;
                	case "2. Learn About The Trail":
                		display.showLearnTrail(wagon);
                		break;
                	case "3. See The Oregon Top Ten":
                		display.showOregonTopTen(wagon);
                		break;
                	case "4. Turn Sound Off":
                		display.showSoundOff(wagon);
                		break;
                	case "5. End":
                		display.showDeathScreen();
                		break;
                }
            }
		});
		
		viewPanel.add(comboBox, BorderLayout.CENTER);
        viewPanel.requestFocusInWindow();
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
