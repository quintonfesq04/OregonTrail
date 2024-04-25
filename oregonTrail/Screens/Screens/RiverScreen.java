package Screens;

import java.io.File;
import javax.swing.JPanel;
//import Stuff.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Screens.*;
import Stuff.*;
import Hunting.*;


/**
 * RiverScreen.java -- Screen shows during river crossing
 * @author Ethan Burch
 * @author Quinton Fesq
 * @version 1.5.2 4/24/24
 */
public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images/river screen0.jpg"));
    private JPanel panel = new JPanel();
    private Locations location;
    private Display display;
    private River river;
    private int height = 10;
    private int flow = 10;
    private int width = 50;

    /**
     * constructor for RiverScreen object
     * @param display the display that this will be used in
     * @param location the location of the player along the trail
     */
    public RiverScreen(Display display, Locations location){
        this.display = display;
        this.location = location;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setLayout(new BorderLayout());
    	
    	JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        panel.add(buttonPanel);
    	
    	 JLabel heightLbl = new JLabel("Height: " + height);
         heightLbl.setForeground(Color.LIGHT_GRAY);
         buttonPanel.add(heightLbl);

         JLabel flowLbl = new JLabel("Flow: " + flow);
         flowLbl.setForeground(Color.LIGHT_GRAY);
         buttonPanel.add(flowLbl);

         JLabel widthLbl = new JLabel("Width: " + width);
         widthLbl.setForeground(Color.LIGHT_GRAY);
         buttonPanel.add(widthLbl);
    	
    	JButton btnNewButton = new JButton("Cross");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			river = new River(location.getRiverName(), height, flow, width);
    			if(river.crossRiver()) {
    				JOptionPane.showMessageDialog(null, "You Crossed " + river.getName());
    				display.showTravelScreen();
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "You Did Not Cross " + river.getName());
    				display.showDeathScreen();
    			}
    		}
    	});
    	viewPanel.add(btnNewButton, BorderLayout.SOUTH);
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

    public void update(Locations location){
        this.location = location;
    }
    
}
