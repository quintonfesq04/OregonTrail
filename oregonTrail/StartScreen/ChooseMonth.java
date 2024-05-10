package StartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * ChooseMonth.java -- Provides the user with a combo box with the available
 * months that they can leave in
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class ChooseMonth extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image
    private Wagon wagon; // call to wagon class
    private Display display; // call to display class

    private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24); // set title font
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set normal font

    /**
     * Constructor for the ChooseMonth object
     * 
     * @param wagon   call to the wagon class
     * @param display call to the display class
     */
    // add a new constructor with calls to the wagon and display classes
    public ChooseMonth(Wagon wagon, Display display) {
        this.wagon = wagon; // calls to the wagon class
        this.display = display; // calls to the display class
        initialize(); // call to our initialize method
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // allow user to use our action listeners and performers
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set layout to grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set the column weights
        viewPanel.setLayout(gbl_viewPanel); // add grid bag layout to our panel

        JLabel chooseMonthLbl = new JLabel( // create lbl using HTML text
                "<html>It is 1848. Your jumping off place for Oregon is Independence, Missouri. You must decide which month to leave Independence.");
        GridBagConstraints gbc_chooseMonthLbl = new GridBagConstraints(); // give the lbl grid bag contraints
        gbc_chooseMonthLbl.anchor = GridBagConstraints.CENTER; // center the grid bag constraints
        gbc_chooseMonthLbl.insets = new Insets(0, 100, 25, 100); // determine the amount of push to the infoLbl --
                                                                 // moving the lbl up, down, left or right by x amounnt
                                                                 // of pixels
        gbc_chooseMonthLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_chooseMonthLbl.gridy = 0; // determines the lbl's y coordinate
        gbc_chooseMonthLbl.fill = GridBagConstraints.HORIZONTAL; // allow the lbl to fill out horizontally across the
                                                                 // panel
        chooseMonthLbl.setFont(titleFont); // give the lbl our set title font
        chooseMonthLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        viewPanel.add(chooseMonthLbl, gbc_chooseMonthLbl); // add the lbl with its constraints to the panel

        JComboBox<String> comboBox = new JComboBox<>(); // create a new combobox with our month options
        GridBagConstraints gbc_ComboBox = new GridBagConstraints(); // give the combobox grid bag constraints
        gbc_ComboBox.anchor = GridBagConstraints.CENTER; // center the grid bag constraints
        gbc_ComboBox.insets = new Insets(0, 0, 5, 0); // determine the amount of push to the infoLbl --
                                                      // moving the lbl up, down, left or right by x amounnt of pixels
        gbc_ComboBox.gridx = 1; // determines the lbl's x coordinate
        gbc_ComboBox.gridy = 1; // determines the lbl's y coordinate
        comboBox.addItem("1. March"); // add march
        comboBox.addItem("2. April"); // add april
        comboBox.addItem("3. May"); // add may
        comboBox.addItem("4. June"); // add june
        comboBox.addItem("5. July"); // add july
        comboBox.addItem("6. Ask For Advice"); // add ask for advice
        viewPanel.add(comboBox, gbc_ComboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                @SuppressWarnings("unchecked")
                JComboBox<String> combo = (JComboBox<String>) e.getSource();
                String selectedOption = (String) combo.getSelectedItem();
                // Check which item is selected and perform action accordingly
                switch (selectedOption) {
                    // check for any of the months
                    case "1. March":
                    case "2. April":
                    case "3. May":
                    case "4. June":
                    case "5. July":
                        display.showBeforeLeaving(wagon); // show before leaving screen
                        break; // break from case
                    case "6. Ask For Advice": // check for if ask for advice
                        display.showMonthAdvice(wagon); // show month advice screen
                        break; // break from case
                }
            }
        });

        JLabel choiceLbl = new JLabel("What is Your Choice?"); // create new lbl
        GridBagConstraints gbc_choiceLbl = new GridBagConstraints(); // give lbl grid bag constraints
        gbc_choiceLbl.anchor = GridBagConstraints.CENTER; // center grid bag constraints
        gbc_choiceLbl.insets = new Insets(15, 0, 5, 0); // determine the amount of push to the infoLbl --
                                                        // moving the lbl up, down, left or right by x amounnt of pixels
        gbc_choiceLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_choiceLbl.gridy = 4; // determines the lbl's y coordinate
        choiceLbl.setFont(smallFont); // add set text font
        choiceLbl.setForeground(new Color(93, 199, 255)); // add color to lbl text
        viewPanel.add(choiceLbl, gbc_choiceLbl); // add lbl and grid bag contraints to panel
    }

    /**
     * Resets the items within the screen when the user reopens the game
     */
    public void resetScreen() {
        // remove elements
        viewPanel.removeAll();
        // add elements
        viewPanel.revalidate();
        viewPanel.repaint();
        display.showChooseMonth(wagon);
        initialize();
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

}