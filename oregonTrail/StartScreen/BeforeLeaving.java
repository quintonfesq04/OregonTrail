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

// import Packages
import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * BeforeLeaving.java -- Display screen that advices the user about their travel
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class BeforeLeaving extends AbstractScreen {
    // Attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

    private Wagon wagon; // call to wagon class
    private Display display; // call to display class
    private TrailScreen trailScreen; // call to trailScreen

    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set font

    private double money; // Amount of money
    private int instructionScreen = 0; // used to change the case in switchLabel method

    private JLabel infoLbl; // instance variable of our infoLbl

    /**
     * Constructor for the BeforeLeaving object
     * 
     * @param wagon call to the wagon class
     * @param display call to the display class
     * @param trailScreen call to the trail screen
     */
    // add a new constructor with calls to the wagon, display, and trailScreen classes
    public BeforeLeaving(Wagon wagon, Display display, TrailScreen trailScreen) {
        this.wagon = wagon; // calls to the wagon class
        this.display = display; // calls to the display class
        this.trailScreen = trailScreen; // calls to the trialScreen class
        initialize(); // call to our initialize method
    }

    /**
     * initializes the BeforeLeaving Display
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // allow user to use our action listeners and performers
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set layout to grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set the column weights
        viewPanel.setLayout(gbl_viewPanel); // add grid bag layout to our panel

        infoLbl = new JLabel( // create our infoLbl using HTML text
                "<html><center>Before leaving Independence you should buy equipment and supplies. You have $"
                        + (int) money + " in cash, but you don't have to spend it all now.<html>");
        GridBagConstraints gbc_infoLbl = new GridBagConstraints(); // give the infoLbl grid bag constraints
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the lbl up, down, left or right by x amounnt of pixels
        gbc_infoLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_infoLbl.gridy = 1; // determines the lbl's y coordinate
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL; // allow the lbl to fill out horizontally across the panel
        infoLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text on our panel
        infoLbl.setFont(smallFont); // give the lbl our set font
        viewPanel.add(infoLbl, gbc_infoLbl); // add the lbl with its constraints to the panel

        JLabel continueLbl = new JLabel("Press Space To Continue"); // create a new label
        GridBagConstraints gbc_continueLbl = new GridBagConstraints(); // give the infoLbl grid bag constraints
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the lbl up, down, left or right by x amounnt of pixels
        gbc_continueLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_continueLbl.gridy = 4; // determines the lbl's y coordinate
        continueLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text on our panel
        viewPanel.add(continueLbl, gbc_continueLbl); // add the lbl with its constraints to the panel
        continueLbl.setFont(smallFont); // give the lbl our set font

        viewPanel.setFocusable(true); // make sure our panel is usable for the user
        viewPanel.requestFocusInWindow(); // request the panel to give the user access to use the panel

        // create a key listener
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                // listen for the space key
                if (vk == KeyEvent.VK_SPACE) {
                    switchLabel(); // when space key is pressed the HTML text will change
                }
            }
        });

    }

    /**
     * Get Method to tell the display how much money the user the awarded for their
     * chosen role
     */
    private void getMoney() {
        // takes in the choice from the trailScreen to set the amount of given money to the user
        String selectedOption = trailScreen.setChoice();
        // option 1: doctor from dayton
        if (selectedOption == "1. Be a Doctor from Dayton") {
            // give the user $1600 for being a doctor from dayton
            wagon.getInventory().setMoney(1600);
            // add the money to the user's inventory
            money = wagon.getInventory().getMoney();
        } 
        // option 2: homesteader from hamden
        else if (selectedOption == "2. Be a Homesteader from Hamden") {
            // give the user $800 for being a homesteader from hamden
            wagon.getInventory().setMoney(800);
            // add the momey to the user's inventory
            money = wagon.getInventory().getMoney();
        } 
        // optiom 3: teacher from toledo
        else if (selectedOption == "3. Be a Teacher from Toledo") {
            // give the user $400 for being a teacher from toledo
            wagon.getInventory().setMoney(400);
            // add the money to the user's inventory
            money = wagon.getInventory().getMoney();
        }
    }

    /**
     * Updates the display to show the given money
     */
    public void updateLabel() {
        // get the money set for the selected role
        getMoney();
        // set the text to show the amount of money given to the user
        infoLbl.setText("<html><center>Before leaving Independence you should buy equipment and supplies. You have $"
                + (int) money + " in cash, but you don't have to spend it all now.<html>");
    }

    /**
     * switches the information labels text
     */
    /**
     * uses a key listener to switch to the next HTML text once the user wants to
     * continue
     */
    private void switchLabel() {
        // switch case starts at 0 as instructionScreen is initially set at 0
        switch (instructionScreen) {
            // case 0 is ran after the first space click
            case 0:
                // set the infoLbl text to a new set of HTML text
                infoLbl.setText("<html><center>You can buy whatever you need at Maya's General Store.</html>");
                instructionScreen++; // increase the counter by 1
                break; // break from the case
            // case 1 is ran after the second space click
            case 1:
                // set the infoLbl text to a new set of HTML text
                infoLbl.setText(
                        "<html><center>Hello, I'm Maya. So you're going to Oregon? I can fix you up with what you need<br><br>- a team of oxen to pull your wagon<br>- clothing for both summer and winter<html>");
                instructionScreen++; // increase the counter by 1
                break; // break from the case
            // case 2 is ran after the third space click
            case 2:
                // set the infoLbl text to a new set of HTML text
                infoLbl.setText(
                        "<html><center>Hello, I'm Maya. So you're going to Oregon? I can fix you up with what you need<br><br>- plenty of food for the trip<br>- ammunition for your rifles<br>- spare parts for your wagon<html>");
                instructionScreen++; // increase the counter by 1
                break; // break from the case
            // case 3 is ran after the fourth space click
            case 3:
                display.showMayasStore(wagon); // go to Maya's store after the last space click
                break; // break from the case
        }
    }

    /**
     * resizes all images through PicPanel
     */
    @Override
    public void resizeImages() {
        viewPanel.resizeImage(); // use PicPanel's resizeImages method

    }

    @Override
    public JPanel getPanel() {
        return viewPanel; // return the viewPanel -- our background
    }
}