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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;

public class EndGame extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Oregon.jpg"));

    private Wagon wagon;
    private Display display;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private Color desiredColor = new Color(93, 199, 255);

    /**
     * Constructor for EndGame class
     * 
     * @param wagon wagon used by this class
     */
    public EndGame(Wagon wagon) {
        this.wagon = wagon;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 0.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel welcomeLbl = new JLabel("Welcome To Oregon!");
        GridBagConstraints gbc_welcomeLbl = new GridBagConstraints();
        gbc_welcomeLbl.insets = new Insets(0, 0, 0, 0);
        gbc_welcomeLbl.gridx = 0;
        gbc_welcomeLbl.gridy = 0;
        welcomeLbl.setFont(titleFont);
        welcomeLbl.setForeground(desiredColor);
        welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(welcomeLbl, gbc_welcomeLbl);

        JButton newGameBtn = new JButton("Start New Game");
        GridBagConstraints gbc_newGameBtn = new GridBagConstraints();
        gbc_newGameBtn.insets = new Insets(10, 0, 0, 0);
        gbc_newGameBtn.gridx = 0;
        gbc_newGameBtn.gridy = 1;
        newGameBtn.setFont(smallFont);
        newGameBtn.setForeground(desiredColor);
        newGameBtn.setHorizontalAlignment(SwingConstants.CENTER);
        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.showWelcomeScreen(wagon);
            }
        });
        viewPanel.add(newGameBtn, gbc_newGameBtn);

        JButton endGameBtn = new JButton("End Game");
        GridBagConstraints gbc_endGameBtn = new GridBagConstraints();
        gbc_endGameBtn.insets = new Insets(100, 0, 10, 0);
        gbc_endGameBtn.gridx = 0;
        gbc_endGameBtn.gridy = 1;
        endGameBtn.setFont(smallFont);
        endGameBtn.setForeground(desiredColor);
        endGameBtn.setHorizontalAlignment(SwingConstants.CENTER);
        endGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        viewPanel.add(endGameBtn, gbc_endGameBtn);
    }

    @Override
    public void resizeImages() {
        // TODO: Implement resizing of images
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
}