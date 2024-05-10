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
 * LeaveIndependence.java -- A series of HTML text that alerts the user that the
 * game is about the begin
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class LeaveIndependence extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

    private JLabel infoLbl = new JLabel( // create infolbl using HTML text
            "<html><center>Well then, you're ready to start. Good Luck! You have a long and difficult journey ahead of you.</html>");
    private JLabel startLbl; // create startlbl

    int instructionScreen = 0; // used to change the case in switchLbl method

    private Wagon wagon; // call to the wagon class
    private Display display; // call to the display class
    private TravelScreen travelScreen; // call to the travelScreen class

    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set font

    /**
     * Constructor for the LeaveIndependence objecct
     * 
     * @param wagon        call to the wagon class
     * @param display      call to the display class
     * @param travelScreen call to the travelScreen class
     */
    public LeaveIndependence(Wagon wagon, Display display, TravelScreen travelScreen) {
        this.wagon = wagon; // call to the wagon class
        this.display = display; // call to the display class
        this.travelScreen = travelScreen; // call to the travelScreen class
        initialize(); // call to the initialize method
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // allow user to use our action listeners and performers
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set layout to grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set the column weights
        viewPanel.setLayout(gbl_viewPanel); // add grid bag layout to our panel
        viewPanel.setVisible(true); // make the panel visible

        GridBagConstraints gbc_infoLbl = new GridBagConstraints(); // give the infolbl grid bag constraints
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_infoLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_infoLbl.gridy = 1; // determines the lbl's y coordinate
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL; // centers the grid bag constraints
        infoLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        infoLbl.setFont(smallFont); // add set font to the lbl
        viewPanel.add(infoLbl, gbc_infoLbl); // add the lbl and grid bag constraints to the panel

        JLabel continueLbl = new JLabel("Press Space To Continue"); // create new lbl
        GridBagConstraints gbc_continueLbl = new GridBagConstraints(); // add grid bag constraints to lbl
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_continueLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_continueLbl.gridy = 4; // determines the lbl's y coordinate
        continueLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl's text
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the lbl
        viewPanel.add(continueLbl, gbc_continueLbl); // add lbl and grid bag constraints to the panel
        continueLbl.setFont(smallFont); // add the set font to the lbl

        startLbl = new JLabel("<html><center>Independence\nMarch 1, 1848<html>"); // create a new lbl with HTML text
        GridBagConstraints gbc_startLbl = new GridBagConstraints(); // add grid bag constraints to the lbl
        gbc_startLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_startLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_startLbl.gridy = 1; // determines the lbl's y coordinate
        startLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        startLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the lbl
        viewPanel.add(startLbl, gbc_startLbl); // add the lbl and grid bag constraints to the panel
        startLbl.setFont(smallFont); // add set font to the lbl
        startLbl.setVisible(false); // make the lbl not visible

        viewPanel.setFocusable(true); // make the panel usable for the user
        viewPanel.requestFocusInWindow(); // make the panel focusable

        // add key listener
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                // listen for space key
                if (vk == KeyEvent.VK_SPACE) {
                    switchLabel(); // if space is pressed then call to switch lbl
                }
            }
        });
    }

    /**
     * switches to the next group of text before starting the game
     */
    private void switchLabel() {
        // case instructionScreen = 0
        switch (instructionScreen) {
            // case 0 is called after first space press
            case 0:
                infoLbl.setVisible(false); // disable infolbl visibility
                startLbl.setVisible(true); // enable startlbl visibility
                instructionScreen++; // increase case by 1
                break; // break case
            // case 1 is called after second space press
            case 1:
                display.showTravelScreen(wagon); // display travel screen
                travelScreen.getPanel().requestFocusInWindow(); // set travel screen focusable
                instructionScreen++; // increase case by 1
                break; // break case
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