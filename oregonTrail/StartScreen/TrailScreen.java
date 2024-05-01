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

public class TrailScreen extends AbstractScreen {
	protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	
	private Display display;
	private Wagon wagon;
	
	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	
	/**
	 * Create the application.
	 */
	public TrailScreen(Wagon wagon, Display display) {
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
		
		JLabel titleLbl = new JLabel("Many kinds of women made the trip to Oregon.");
        titleLbl.setForeground(new Color(93, 199, 255));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(titleLbl, BorderLayout.NORTH);
        titleLbl.setFont(titleFont);
		
		JLabel youMayLbl = new JLabel("You May:");
        youMayLbl.setForeground(new Color(93, 199, 255));
		viewPanel.add(youMayLbl, BorderLayout.WEST);
        youMayLbl.setFont(smallFont);
		
		JComboBox comboBox = new JComboBox();
        comboBox.addItem("1. Be a Doctor from Dayton");
        comboBox.addItem("2. Be a Homesteader from Hamden");
        comboBox.addItem("3. Be a Teacher from Toledo");
        comboBox.addItem("4. Find out the differences between these choices");

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedOption = (String) combo.getSelectedItem();
                // Check which item is selected and perform action accordingly
                switch (selectedOption) {
                	case "1. Be a Doctor from Dayton":
                		display.showWagonLeader(wagon);
                		break;
                	case "2. Be a Homesteader from Hamden":
                		display.showWagonLeader(wagon);
                		break;
                	case "3. Be a Teacher from Toledo":
                		display.showWagonLeader(wagon);
                		break;
                	case "4. Find out the differences between these choices":
                		display.showGroupInfo(wagon);
                		break;
                }
            }
		});

		viewPanel.add(comboBox, BorderLayout.CENTER);
		viewPanel.requestFocusInWindow();

		JLabel choiceLbl = new JLabel("What is your choice?");
        choiceLbl.setForeground(new Color(93, 199, 255));
		choiceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(choiceLbl, BorderLayout.SOUTH);
        choiceLbl.setFont(smallFont);
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
