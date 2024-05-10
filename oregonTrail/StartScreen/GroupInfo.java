package StartScreen;

// imports
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

// import packages
import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * GroupInfo.java -- Provides the user with HTML text that tell the user what
 * each role provides them
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class GroupInfo extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

    // create new lbl with HTML text
    JLabel infoLbl = new JLabel(
            "<html><center>Traveling to Oregon isn't easy! But if you're a doctor, you'll have a less chance of dying than a homesteader or a teacher.");

    // set case counter to 0
    int instructionScreen = 0;

    private Wagon wagon; // call to wagon class
    private Display display; // call to display class
    private TrailScreen trailScreen; // call to trailScreen class

    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // create a set font

    /**
     * Constructor for the GroupInfo object
     * 
     * @param wagon       call to wagon class
     * @param display     call to display class
     * @param trailScreen call to trailScreen class
     */
    // add a new constructor with calls to the wagon, display, and trailScreen
    // classes
    public GroupInfo(Wagon wagon, Display display, TrailScreen trailScreen) {
        this.wagon = wagon; // call to wagon class
        this.display = display; // call to display class
        this.trailScreen = trailScreen; // call to trailScreen class
        initialize(); // call to initialize method
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // enable the ability to use the group info class's key listers and action
                                      // performers
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set the layout to grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set the column weights
        viewPanel.setLayout(gbl_viewPanel); // add grid bag layout to the panel

        GridBagConstraints gbc_infoLbl = new GridBagConstraints(); // add grid bag contraints to the info lbl
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_infoLbl.gridx = 1; // determine the lbl's x coordinate
        gbc_infoLbl.gridy = 1; // determine the lbl's y coordinate
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL; // fill out the infolbl to fill the panel
        infoLbl.setForeground(new Color(93, 199, 255)); // add color to the info lbl text
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        infoLbl.setFont(smallFont); // add set font to text
        viewPanel.add(infoLbl, gbc_infoLbl); // add lbl and grid bag contraints to panel

        JLabel continueLbl = new JLabel("Press Space To Continue"); // create new lbl
        GridBagConstraints gbc_continueLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_continueLbl.gridx = 1; // determine the lbl's x coordinate
        gbc_continueLbl.gridy = 4; // determine the lbl's y coordinate
        continueLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        viewPanel.add(continueLbl, gbc_continueLbl); // add the lbl and gbc to the panel
        continueLbl.setFont(smallFont); // add the set font to the text

        viewPanel.setFocusable(true); // set the panel focusable
        viewPanel.requestFocusInWindow(); // request the panel to be focusable

        // create new key listener
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                // listen for space key
                if (vk == KeyEvent.VK_SPACE) {
                    display.showTrailScreen(wagon); // show trail screen
                    trailScreen.resetScreen(); // reset trail screen
                }
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