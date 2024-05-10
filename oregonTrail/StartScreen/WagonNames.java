package StartScreen;

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
import javax.swing.JTextField;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * WagonNames.java -- Provides the user with a prompt to enter the names of the
 * players who will be traveling the trail
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class WagonNames extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Display display;
    private Wagon wagon;

    private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private JTextField name1TextField; // new text field
    private JTextField name2TextField; // new text field
    private JTextField name3TextField;// new text field
    private JTextField name4TextField;// new text field
    private JTextField name5TextField;// new text field

    private JLabel name1Lbl; // new lbl

    private boolean firstNameEntered = false; // boolean set false
    private String[] partyNames = { "", "", "", "", "" }; // party names

    /**
     * Constructor for the WagonNames object
     * 
     * @param wagon   call to wagon class
     * @param display call to display class
     */
    public WagonNames(Wagon wagon, Display display) {
        this.wagon = wagon; // call to wagon class
        this.display = display; // call to display class
        initialize(); // call to initialize method
    }

    /**
     * Initializes the WagonNames Display
     * 
     * @wbp.parser.entryPoint
     */
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel titleLbl = new JLabel("<html>What is the first name of your Wagon Leader?"); // new lbl
        GridBagConstraints gbc_titleLbl = new GridBagConstraints(); // add gbc
        gbc_titleLbl.insets = new Insets(0, 0, 5, 0);
        gbc_titleLbl.gridx = 1;
        gbc_titleLbl.gridy = 0;
        titleLbl.setFont(titleFont);
        titleLbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(titleLbl, gbc_titleLbl);

        name1Lbl = new JLabel("1. "); // new lbl
        GridBagConstraints gbc_name1Lbl = new GridBagConstraints(); // add gbc
        gbc_name1Lbl.anchor = GridBagConstraints.CENTER;
        gbc_name1Lbl.insets = new Insets(0, 0, 5, 175);
        gbc_name1Lbl.gridx = 1;
        gbc_name1Lbl.gridy = 1;
        name1Lbl.setFont(smallFont);
        name1Lbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(name1Lbl, gbc_name1Lbl);

        name1TextField = new JTextField(); // new text field
        GridBagConstraints gbc_name1TextField = new GridBagConstraints(); // add gbc
        gbc_name1TextField.insets = new Insets(0, 0, 5, 0);
        gbc_name1TextField.gridx = 1;
        gbc_name1TextField.gridy = 1;
        viewPanel.add(name1TextField, gbc_name1TextField);
        name1TextField.setColumns(10);

        name1TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name1TextField.getText();
                if (!name.isEmpty()) {
                    partyNames[0] = name;
                    wagon.getPlayer().setPartyNames(partyNames);
                    // Remove the JTextField
                    viewPanel.remove(name1TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints(); // add gbc
                    gbc_nameLabel.anchor = GridBagConstraints.CENTER;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 1;
                    nameLabel.setFont(smallFont);
                    nameLabel.setForeground(new Color(93, 199, 255));
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();

                    if (!firstNameEntered) { // Check if the first name is entered
                        // Update the title label
                        titleLbl.setText("<html>What are the first names of the other four members in your party?");
                        firstNameEntered = true; // Set the flag to true
                    }
                }
            }
        });

        JLabel name2Lbl = new JLabel("2. "); // new lbl
        GridBagConstraints gbc_name2Lbl = new GridBagConstraints(); // add gbc
        gbc_name2Lbl.anchor = GridBagConstraints.CENTER;
        gbc_name2Lbl.insets = new Insets(0, 0, 5, 175);
        gbc_name2Lbl.gridx = 1;
        gbc_name2Lbl.gridy = 2;
        name2Lbl.setFont(smallFont);
        name2Lbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(name2Lbl, gbc_name2Lbl);

        name2TextField = new JTextField(); // new text field
        GridBagConstraints gbc_name2TextField = new GridBagConstraints(); // add gbc
        gbc_name2TextField.insets = new Insets(0, 0, 5, 0);
        gbc_name2TextField.gridx = 1;
        gbc_name2TextField.gridy = 2;
        viewPanel.add(name2TextField, gbc_name2TextField);
        name2TextField.setColumns(10);

        name2TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name2TextField.getText();
                if (!name.isEmpty()) {
                    partyNames[1] = name;
                    wagon.getPlayer().setPartyNames(partyNames);
                    // Remove the JTextField
                    viewPanel.remove(name2TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints(); // add gbc
                    gbc_nameLabel.anchor = GridBagConstraints.CENTER;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 2;
                    nameLabel.setFont(smallFont);
                    nameLabel.setForeground(new Color(93, 199, 255));
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name3TextField
        JLabel name3Lbl = new JLabel("3. "); // new lbl
        GridBagConstraints gbc_name3Lbl = new GridBagConstraints(); // add gbc
        gbc_name3Lbl.anchor = GridBagConstraints.CENTER;
        gbc_name3Lbl.insets = new Insets(0, 0, 5, 175);
        gbc_name3Lbl.gridx = 1;
        gbc_name3Lbl.gridy = 3;
        name3Lbl.setFont(smallFont);
        name3Lbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(name3Lbl, gbc_name3Lbl);

        name3TextField = new JTextField(); // new text field
        GridBagConstraints gbc_name3TextField = new GridBagConstraints(); // add gbc
        gbc_name3TextField.insets = new Insets(0, 0, 5, 0);
        gbc_name3TextField.gridx = 1;
        gbc_name3TextField.gridy = 3;
        viewPanel.add(name3TextField, gbc_name3TextField);
        name3TextField.setColumns(10);

        name3TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name3TextField.getText();
                if (!name.isEmpty()) {
                    partyNames[2] = name;
                    wagon.getPlayer().setPartyNames(partyNames);
                    // Remove the JTextField
                    viewPanel.remove(name3TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints(); // add gbc
                    gbc_nameLabel.anchor = GridBagConstraints.CENTER;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 3;
                    nameLabel.setFont(smallFont);
                    nameLabel.setForeground(new Color(93, 199, 255));
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name4TextField
        JLabel name4Lbl = new JLabel("4. "); // new lbl
        GridBagConstraints gbc_name4Lbl = new GridBagConstraints(); // add gbc
        gbc_name4Lbl.anchor = GridBagConstraints.CENTER;
        gbc_name4Lbl.insets = new Insets(0, 0, 5, 175);
        gbc_name4Lbl.gridx = 1;
        gbc_name4Lbl.gridy = 4;
        name4Lbl.setFont(smallFont);
        name4Lbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(name4Lbl, gbc_name4Lbl);

        name4TextField = new JTextField(); // new text field
        GridBagConstraints gbc_name4TextField = new GridBagConstraints(); // add gbc
        gbc_name4TextField.gridx = 1;
        gbc_name4TextField.gridy = 4;
        viewPanel.add(name4TextField, gbc_name4TextField);
        name4TextField.setColumns(10);

        name4TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name4TextField.getText();
                if (!name.isEmpty()) {
                    partyNames[3] = name;
                    wagon.getPlayer().setPartyNames(partyNames);
                    // Remove the JTextField
                    viewPanel.remove(name4TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints(); // add gbc
                    gbc_nameLabel.anchor = GridBagConstraints.CENTER;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 4;
                    nameLabel.setFont(smallFont);
                    nameLabel.setForeground(new Color(93, 199, 255));
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name5TextField
        JLabel name5Lbl = new JLabel("5. "); // new lbl
        GridBagConstraints gbc_name5Lbl = new GridBagConstraints(); // add gbc
        gbc_name5Lbl.anchor = GridBagConstraints.CENTER;
        gbc_name5Lbl.insets = new Insets(0, 0, 5, 175);
        gbc_name5Lbl.gridx = 1;
        gbc_name5Lbl.gridy = 5;
        name5Lbl.setFont(smallFont);
        name5Lbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(name5Lbl, gbc_name5Lbl);

        name5TextField = new JTextField(); // new text field
        GridBagConstraints gbc_name5TextField = new GridBagConstraints(); // add gbc
        gbc_name5TextField.gridx = 1;
        gbc_name5TextField.gridy = 5;
        viewPanel.add(name5TextField, gbc_name5TextField);
        name5TextField.setColumns(10);

        name5TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name5TextField.getText();
                if (!name.isEmpty()) {
                    partyNames[4] = name;
                    wagon.getPlayer().setPartyNames(partyNames);
                    // Remove the JTextField
                    viewPanel.remove(name5TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints(); // add gbc
                    gbc_nameLabel.anchor = GridBagConstraints.CENTER;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 5;
                    nameLabel.setFont(smallFont);
                    nameLabel.setForeground(new Color(93, 199, 255));
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }

                JLabel correctNamesLbl = new JLabel("Are These Names Correct?"); // new lbl
                GridBagConstraints gbc_correctNamesLbl = new GridBagConstraints(); // add gbc
                gbc_correctNamesLbl.anchor = GridBagConstraints.CENTER;
                gbc_correctNamesLbl.insets = new Insets(10, 0, 5, 0);
                gbc_correctNamesLbl.gridx = 1;
                gbc_correctNamesLbl.gridy = 7;
                correctNamesLbl.setFont(titleFont);
                correctNamesLbl.setForeground(new Color(93, 199, 255));
                viewPanel.add(correctNamesLbl, gbc_correctNamesLbl);
                viewPanel.revalidate();
                viewPanel.repaint();

                JButton correctNameBtn = new JButton("Yes");
                GridBagConstraints gbc_correctNameBtn = new GridBagConstraints(); // add gbc
                gbc_correctNameBtn.anchor = GridBagConstraints.CENTER;
                gbc_correctNameBtn.insets = new Insets(10, 100, 5, 0);
                gbc_correctNameBtn.gridx = 1;
                gbc_correctNameBtn.gridy = 8;
                correctNameBtn.setFont(smallFont);
                correctNameBtn.setForeground(new Color(93, 199, 255));
                viewPanel.add(correctNameBtn, gbc_correctNameBtn);
                viewPanel.revalidate();
                viewPanel.repaint();

                correctNameBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        display.showChooseMonth(wagon);
                    }
                });

                JButton incorrectNameBtn = new JButton("No");
                GridBagConstraints gbc_incorrectNameBtn = new GridBagConstraints(); // add gbc
                gbc_incorrectNameBtn.anchor = GridBagConstraints.CENTER;
                gbc_incorrectNameBtn.insets = new Insets(10, 0, 5, 100);
                gbc_incorrectNameBtn.gridx = 1;
                gbc_incorrectNameBtn.gridy = 8;
                incorrectNameBtn.setFont(smallFont);
                incorrectNameBtn.setForeground(new Color(93, 199, 255));
                viewPanel.add(incorrectNameBtn, gbc_incorrectNameBtn);
                viewPanel.revalidate();
                viewPanel.repaint();

                incorrectNameBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        resetScreen();
                    }
                });
            }
        });
    }

    /**
     * Resets the screen to allow the user to change the names if the no button is
     * pressed
     */
    private void resetScreen() {
        viewPanel.removeAll();
        // add your elements
        viewPanel.revalidate();
        viewPanel.repaint();
        display.showWagonNames(wagon);
        initialize();
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