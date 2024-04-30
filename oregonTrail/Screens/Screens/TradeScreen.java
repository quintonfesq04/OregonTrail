package Screens;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Screens.*;
import Hunting.*;

public class TradeScreen {
	private JPanel panel = new JPanel();
    private JLabel tradeLabel;
    private Display display;
    private Wagon wagon;
    private String[] tradeStr;

    /**
     * Create the application.
     */
    public TradeScreen(Wagon wagon,Display display) {
    	this.display = display;
        this.wagon = wagon;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel titleLabel = new JLabel("Potential Trade");
        titleLabel.setFont(new Font("Rockwell", Font.PLAIN, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        tradeLabel = new JLabel("Trade Text");
        tradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tradeLabel.setFont(new Font("Rockwell", Font.PLAIN, 24));
        panel_3.add(tradeLabel, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_3.add(panel_1, BorderLayout.SOUTH);
        
        JButton acceptButton = new JButton("Accept");
        acceptButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, wagon.getTrade().acceptTrade(tradeStr));
                display.showTravelScreen(wagon);
        	}
        });

        acceptButton.setFont(new Font("Rockwell", Font.PLAIN, 24));
        panel_1.add(acceptButton);
        
        JButton declineButton = new JButton("Decline");
        declineButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Trade Declined!");
        		display.showTravelScreen(wagon);
        	}
        });
        declineButton.setFont(new Font("Rockwell", Font.PLAIN, 24));
        panel_1.add(declineButton);
        updateDisplay();
    }

    public void updateDisplay(){
        makeTrade();
    }

    private void makeTrade(){
        tradeStr = wagon.getTrade().createTrade();
        String sendString = "A traveler wants to trade " + tradeStr[1] + " " + tradeStr[0] + " for " + tradeStr[3] + " " + tradeStr[2] + ".";
        tradeLabel.setText(sendString);
    }
    /**
     * obtain the JPanel created by this class
     * @return a JPanel containing the TradeScreen
     */
	public JPanel getPanel() {   
		return panel;
    }
}
