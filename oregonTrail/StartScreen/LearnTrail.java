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
 * LearnTrail.java -- Provides the user with a series of HTML text that explain
 * the journey they are about to take in our game
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class LearnTrail extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image
    private JLabel infoLbl = new JLabel( // create new lbl with HTML text
            "<html><center>Try taking a journey by convered wagon across 2000 miles of plains, rivers, and mountains. Try! On the plains, you will slosh your oxen through mud and water-filled ruts or will you plod through dust six inches deep?</html>");

    int instructionScreen = 0; // set case counter to 0

    private Wagon wagon; // call to wagon class
    private Display display; // call to display class

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24); // set title font
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set text font

    /**
     * create application
     * 
     * @param wagon
     * @param display
     */
    public LearnTrail(Wagon wagon, Display display) {
        this.wagon = wagon; // call to wagon class
        this.display = display; // call to display class
        initialize(); // call to initialize method
    }

    protected void initialize() {
        viewPanel.setFocusable(true); // set panel focusable for usability
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // set grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 }; // set column weight
        viewPanel.setLayout(gbl_viewPanel); // add gbl to panel

        JLabel titleLbl = new JLabel("The Oregon Trail"); // create new title lbl
        GridBagConstraints gbc_titleLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_titleLbl.insets = new Insets(0, 0, 50, 0); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_titleLbl.gridx = 1; // determine lbl's x coordinate
        gbc_titleLbl.gridy = 0; // determine lbl's y coordinate
        viewPanel.add(titleLbl, gbc_titleLbl); // add lbl and gbc to panel
        titleLbl.setForeground(new Color(93, 199, 255)); // add color to lbl text
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        titleLbl.setFont(titleFont); // add set title font to lbl

        GridBagConstraints gbc_infoLbl = new GridBagConstraints(); // add gbc to the lbl
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_infoLbl.gridx = 1; // determine lbl's x coordinate
        gbc_infoLbl.gridy = 1; // determine lbl's y coordinate
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL; // fill lbl's gbc to fill the panel
        infoLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl's text
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        infoLbl.setFont(smallFont); // add font to the text
        viewPanel.add(infoLbl, gbc_infoLbl); // add lbl and gbc to the panel

        JLabel continueLbl = new JLabel("Press Space To Continue"); // create new lbl
        GridBagConstraints gbc_continueLbl = new GridBagConstraints(); // add gbc to the lbl
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0); // determine the amount of push to the infoLbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_continueLbl.gridx = 1; // determine lbl's x coordinate
        gbc_continueLbl.gridy = 4; // determine lbl's y coordinate
        continueLbl.setForeground(new Color(93, 199, 255)); // add color to the lbl
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER); // center the text
        viewPanel.add(continueLbl, gbc_continueLbl); // add lbl and gbc to the panel
        continueLbl.setFont(smallFont); // add font to the lbl

        viewPanel.setFocusable(true); // set panel focusable
        viewPanel.requestFocusInWindow(); // request focus on the panel

        // create new key listener
        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                // listen for space key
                if (vk == KeyEvent.VK_SPACE) {
                    switchLabel(); // call to switch lbl method
                }
            }
        });

    }

    /**
     * uses a key listener to switch to the next HTML text once the user wants to
     * continue
     */
    private void switchLabel() {
        // case counter is set at 0
        switch (instructionScreen) {
            case 0:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>How will you corss the river? if you have money, you might take a ferry (if there is a ferry). Or, you can ford the river and hope you and your wagon aren't swallowed alive!</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 1:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>What about supplies? Well, if you're low on food you can forage. You might get a berry... you might. And there are potatoes in the mountains.</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 2:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>At the Dalles, you can try navigating the Columbia River, but if running the rapids with a makeshift raft makes you queasy, better take the Barlow Road.</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 3:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>If for some reason you don't survive -- your wagon burns, or thieves steal your oxen, or you run out of provisions, or you die of cholera -- don't give up! Try again... and again... until your name is up with the others on the The Oregon Top Ten.</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 4:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>M Key -- You may want to see your progess on the map. By pressing M, you can view where you are on the map.</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 5:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>I Key -- You may want to check your inventory progress, change your speed, or check out how many miles you have left. By pressing I, you can view the Control Screen, that shows you the: Inventory, Speed, and Miles Remaining.</html>");
                instructionScreen++; // add to case coutner by 1
                break; // break case
            case 6:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>Esc Key -- You may want to quit in the middle of the program. If so, press the Escape (Esc) key twice whenever the computer is waiting for a response.</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 7:
                infoLbl.setText( // set text of lbl to new HTML text
                        "<html><center>The software team responsible for the creation of this product includes:<br>Ethan Burch<br>Quinton Fesq<br>Madison Scott<br>Lane Kanagy</html>");
                instructionScreen++; // add to case counter by 1
                break; // break case
            case 8:
                instructionScreen = 0; // set case counter to 0
                display.showTheOregonTrail(wagon); // display The Oregon Trail screen
                break; // break case
        }
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