package Screens;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TradeScreen {
	private JPanel panel = new JPanel();
    private JLabel tradeLabel;

    /**
     * Create the application.
     */
    public TradeScreen() {
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
        acceptButton.setFont(new Font("Rockwell", Font.PLAIN, 24));
        panel_1.add(acceptButton);
        
        JButton declineButton = new JButton("Decline");
        declineButton.setFont(new Font("Rockwell", Font.PLAIN, 24));
        panel_1.add(declineButton);

    }
		public JPanel getPanel() {   
			return panel;
    }
}
