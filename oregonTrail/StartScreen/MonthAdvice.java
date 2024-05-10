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
 * MonthAdvice.java -- Provides the user with an HTML text that informs the user
 * which money they should select
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class MonthAdvice extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

    private Wagon wagon; // call to wagon class
    private Display display; // call to display class
    private ChooseMonth chooseMonth; // call to chooseMonth

    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set font

    /**
     * Constructor for the MonthAdvice object
     * 
     * @param wagon       call to wagon class
     * @param display     call to display class
     * @param chooseMonth call to chooseMonth
     */
    public MonthAdvice(Wagon wagon, Display display, ChooseMonth chooseMonth) {
        this.wagon = wagon; // calls to the wagon class
        this.display = display; // calls to the display class
        this.chooseMonth = chooseMonth; // calls to the chooseMonth class
        initialize(); // call to our initialize method
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // allow user to use our action listeners and performers
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set layout to grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set the column weights
        viewPanel.setLayout(gbl_viewPanel); // add grid bag layout to our panel

        JLabel infoLbl = new JLabel( // create our infoLbl using HTML text
                "<html><center>You attend a public meeting held for 'women - with the California - Oregon fever.' You're told:<br><br>If you leave too early, there won't be any grass for your oxen to eat. If you leave too late, you may not get to Oregon before winter comes. If you leave at just the right time, there will be green grass and the weather will still be cool.");
        GridBagConstraints gbc_infoLbl = new GridBagConstraints(); // give the infoLbl grid bag contraints
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the
                                                         // lbl up, down, left or right by x amounnt of pixels
        gbc_infoLbl.gridx = 1; // determines the lbl's x coordinate
        gbc_infoLbl.gridy = 1; // determines the lbl's y coordinate
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL; // allow the lbl to fill out horizontally across the panel
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the
                                                         // lbl up, down, left or right by x amounnt of pixels
        infoLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl text
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text on our panel
        infoLbl.setFont(smallFont); // give the lbl our set font
        viewPanel.add(infoLbl, gbc_infoLbl); // add the lbl with its constraints to the panel

        JLabel continueLbl = new JLabel("Press Space To Continue"); // create new lbl
        GridBagConstraints gbc_continueLbl = new GridBagConstraints(); // give the lbl grid bag constraints
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the
                                                          // lbl up, down, left or right by x amounnt of pixels
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
                    display.showChooseMonth(wagon);
                    chooseMonth.resetScreen(); // when the space key is pressed it will reset the chooseMonth screen
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