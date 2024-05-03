package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.Color;

public class LeaveIndependence extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
    protected PicPanel independence = new PicPanel(new File("Images/Covered Wagon.jpg"));

    private JLabel infoLbl = new JLabel("<html><center>Well then, you're ready to start. Good Luck! You have a long and difficult journey ahead of you.</html>");
    private JLabel startLbl;
    

    int instructionScreen = 0;

    private Wagon wagon;
    private Display display;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    public LeaveIndependence(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0,1.0};
        viewPanel.setLayout(gbl_viewPanel);
        viewPanel.setVisible(true);

        independence.setFocusable(true);
        GridBagLayout gbl_independence = new GridBagLayout();
        gbl_independence.columnWeights = new double[]{0.0,1.0};
        independence.setLayout(gbl_independence);
        independence.setVisible(false);

        GridBagConstraints gbc_infoLbl = new GridBagConstraints();
        gbc_infoLbl.insets = new Insets(0,100,0,100);
        gbc_infoLbl.gridx = 1;
        gbc_infoLbl.gridy = 1;
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL;
        gbc_infoLbl.insets = new Insets(0,100,0,100);
        infoLbl.setForeground(new Color(93, 199, 255));
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoLbl.setFont(smallFont);
        viewPanel.add(infoLbl, gbc_infoLbl);

        JLabel continueLbl = new JLabel("Press Space To Continue");
        GridBagConstraints gbc_continueLbl = new GridBagConstraints();
        gbc_continueLbl.insets = new Insets(50,0,5,0);
        gbc_continueLbl.gridx = 1;
        gbc_continueLbl.gridy = 4;
        continueLbl.setForeground(new Color(93, 199, 255));
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(continueLbl, gbc_continueLbl);
        continueLbl.setFont(smallFont);

        startLbl = new JLabel("<html><center>Independence\nMarch 1, 1848<html>");
        GridBagConstraints gbc_startLbl = new GridBagConstraints();
        gbc_startLbl.insets = new Insets(50,0,5,0);
        gbc_startLbl.gridx = 1;
        gbc_startLbl.gridy = 1;
        startLbl.setForeground(new Color(93, 199, 255));
        startLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(startLbl, gbc_startLbl);
        startLbl.setFont(smallFont);
        startLbl.setVisible(false);

        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    switchLabel();
                }
            }
        });
    }

    private void switchLabel() {
        switch(instructionScreen) {
            case 0:
                viewPanel.setVisible(false);
                infoLbl.setVisible(false);
                independence.setVisible(true);
                startLbl.setVisible(true);
                instructionScreen++;
                break;
            case 1:
                //display.showTravelScreen(wagon);
                instructionScreen++;
                break;
        }
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
