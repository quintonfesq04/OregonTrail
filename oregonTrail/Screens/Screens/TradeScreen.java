package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * TradeScreen.java --
 * 
 * @author Madison Scott
 * @author Ethan Burch
 * @author Quinton Fesq
 * @version 1.1.0 4/26/24
 */
public class TradeScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private Color desiredColor = new Color(93, 199, 255);

    private JLabel tradeLabel;
    private Display display;
    private Wagon wagon;
    private String[] tradeStr;

    /**
     * Create the application.
     */
    public TradeScreen(Wagon wagon, Display display) {
        this.display = display;
        this.wagon = wagon;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel titleLabel = new JLabel("Potential Trade");
        GridBagConstraints gbc_titleLable = new GridBagConstraints();
        gbc_titleLable.insets = new Insets(0, 0, 100, 0);
        gbc_titleLable.gridx = 0;
        gbc_titleLable.gridy = 0;
        titleLabel.setForeground(desiredColor);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(titleLabel, gbc_titleLable);

        tradeLabel = new JLabel("Trade Text");
        GridBagConstraints gbc_tradeLabel = new GridBagConstraints();
        gbc_tradeLabel.insets = new Insets(50, 0, 50, 0);
        gbc_tradeLabel.gridx = 0;
        gbc_tradeLabel.gridy = 1;
        tradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tradeLabel.setForeground(desiredColor);
        tradeLabel.setFont(smallFont);
        viewPanel.add(tradeLabel, gbc_tradeLabel);

        JButton acceptButton = new JButton("Accept");
        GridBagConstraints gbc_acceptButton = new GridBagConstraints();
        gbc_acceptButton.insets = new Insets(50, 0, 0, 150);
        gbc_acceptButton.gridx = 0;
        gbc_acceptButton.gridy = 2;
        acceptButton.setFont(smallFont);
        acceptButton.setForeground(desiredColor);
        acceptButton.setHorizontalAlignment(SwingConstants.CENTER);
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, wagon.getTrade().acceptTrade(tradeStr));
                display.showTravelScreen(wagon);
            }
        });
        viewPanel.add(acceptButton, gbc_acceptButton);

        JButton declineButton = new JButton("Decline");
        GridBagConstraints gbc_declineButton = new GridBagConstraints();
        gbc_declineButton.insets = new Insets(50, 150, 0, 0);
        gbc_declineButton.gridx = 0;
        gbc_declineButton.gridy = 2;
        declineButton.setFont(smallFont);
        declineButton.setForeground(desiredColor);
        declineButton.setHorizontalAlignment(SwingConstants.CENTER);
        declineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Trade Declined!");
                display.showTravelScreen(wagon);
            }
        });
        viewPanel.add(declineButton, gbc_declineButton);
        updateDisplay();
    }

    public void updateDisplay() {
        makeTrade();
    }

    private void makeTrade() {
        tradeStr = wagon.getTrade().createTrade();
        String sendString = "A traveler wants to trade " + tradeStr[1] + " " + tradeStr[0] + " for " + tradeStr[3] + " "
                + tradeStr[2] + ".";
        tradeLabel.setText(sendString);
    }

    /**
     * obtain the JPanel created by this class
     * 
     * @return a JPanel containing the TradeScreen
     */
    public JPanel getPanel() {
        return viewPanel;
    }
}