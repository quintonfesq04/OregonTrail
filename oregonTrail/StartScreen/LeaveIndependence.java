package StartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import Screens.TravelScreen;

/**
 * LeaveIndependence.java -- A series of HTML text that alerts the user that the game is about the begin
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class LeaveIndependence extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private JLabel infoLbl = new JLabel(
            "<html><center>Well then, you're ready to start. Good Luck! You have a long and difficult journey ahead of you.</html>");
    private JLabel startLbl;

    int instructionScreen = 0;

    private Wagon wagon;
    private Display display;
    private TravelScreen travelScreen;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    /**
     * Constructor for the LeaveIndependence objecct
     * 
     * @param wagon
     * @param display
     * @param travelScreen
     */
    public LeaveIndependence(Wagon wagon, Display display, TravelScreen travelScreen) {
        this.wagon = wagon;
        this.display = display;
        this.travelScreen = travelScreen;
        initialize();
    }

    /**
     * Initialize the LeaveIndependence Display
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);
        viewPanel.setVisible(true);

        GridBagConstraints gbc_infoLbl = new GridBagConstraints();
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100);
        gbc_infoLbl.gridx = 1;
        gbc_infoLbl.gridy = 1;
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL;
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100);
        infoLbl.setForeground(new Color(93, 199, 255));
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoLbl.setFont(smallFont);
        viewPanel.add(infoLbl, gbc_infoLbl);

        JLabel continueLbl = new JLabel("Press Space To Continue");
        GridBagConstraints gbc_continueLbl = new GridBagConstraints();
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0);
        gbc_continueLbl.gridx = 1;
        gbc_continueLbl.gridy = 4;
        continueLbl.setForeground(new Color(93, 199, 255));
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(continueLbl, gbc_continueLbl);
        continueLbl.setFont(smallFont);

        startLbl = new JLabel("<html><center>Independence\nMarch 1, 1848<html>");
        GridBagConstraints gbc_startLbl = new GridBagConstraints();
        gbc_startLbl.insets = new Insets(50, 0, 5, 0);
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

    /**
     * switches to the next group of text before starting the game
     */
    private void switchLabel() {
        switch (instructionScreen) {
            case 0:
                infoLbl.setVisible(false);
                startLbl.setVisible(true);
                instructionScreen++;
                break;
            case 1:
                display.showTravelScreen(wagon);
                travelScreen.getPanel().requestFocusInWindow();
                instructionScreen++;
                break;
        }
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