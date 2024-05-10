package StartScreen;

// imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// import packages
import Gameplay.Display;
import Gameplay.Inventory;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * MayasStore.java -- Provides the user with the first general store of the game before they leave independence
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class MayasStore extends AbstractScreen {
    // attributes
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg")); // add background image

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24); // set title font
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16); // set text font
    private JLabel foodPriceLbl; // create lbl
    private JLabel oxenPriceLbl; // create lbl
    private JLabel clothingPriceLbl; // create lbl
    private JLabel bulletsPriceLbl; // create lbl
    private JLabel axlePriceLbl; // create lbl
    private JLabel wheelPriceLbl; // create lbl
    private JLabel tonguePriceLbl; // create lbl
    private JLabel remainingLbl; // create lbl
    private JSpinner oxenSpinner; // create lbl

    private Display display; // call to display class
    private Wagon wagon; // call to wagon class

    private double money; // create money variable
    private double total = 0; // create total variable


    /**
     * Constructor for the MayasStore object
     * 
     * @param wagon call to wagon class
     * @param display call to display class
     */
    public MayasStore(Wagon wagon, Display display) {
        this.wagon = wagon; // call to wagon class
        this.display = display; // call to display class
        initialize(); // call to initialize method
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true); // set focusable to true
        GridBagLayout gbl_viewPanel = new GridBagLayout(); // create grid bag layout
        gbl_viewPanel.columnWeights = new double[] { 0.0, 0.0 }; // create column weights
        viewPanel.setLayout(gbl_viewPanel); // add to panel

        JLabel priceLbl = new JLabel("Total Cost: $" + total); // create new lbl
        GridBagConstraints gbc_priceLabel = new GridBagConstraints(); // add gbc to lbl
        gbc_priceLabel.insets = new Insets(10, 0, 5, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_priceLabel.gridx = 1; // determine lbl's x coordinate
        gbc_priceLabel.gridy = 9; // determine lbl's y coordinate
        priceLbl.setForeground(new Color(93, 199, 255)); // add color to text 
        priceLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        viewPanel.add(priceLbl, gbc_priceLabel); // add lbl and gbc to panel
        priceLbl.setFont(smallFont); // add font to lbl 

        JButton buyBtn = new JButton("Buy"); // create new btn
        GridBagConstraints gbc_buyBtn = new GridBagConstraints(); // add gbc to btn
        gbc_buyBtn.insets = new Insets(10, 0, 0, 0); // determine the amount of push to the btn -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_buyBtn.gridx = 1; // determine lbl's x coordinate
        gbc_buyBtn.gridy = 11; // determine lbl's y coordinate
        buyBtn.setForeground(new Color(93, 199, 255)); // add color to lbl
        // create action listener
        buyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if the user has enough money
                if (wagon.getStore().checkIfEnoughMoney(wagon.getInventory())) {
                    wagon.setInventory(wagon.getStore().buyMethod(wagon.getInventory())); // set inventory
                    display.showLeaveIndependence(wagon); // show leave independence screen
                    // if the cost is more than what the user has
                } else if ((total + wagon.getStore().getCost()) > (wagon.getInventory().getMoney())) {
                    JOptionPane.showMessageDialog(null, // display JOptionPane error message
                            "Okay that comes to a total of $" + (total + wagon.getStore().getCost())
                                    + ". But I see that you only have $" + wagon.getInventory().getMoney()
                                    + ". We'd better go over the list again.");
                    // if the oxenSpinner is 0
                } else if ((Integer) oxenSpinner.getValue() == 0) {
                    JOptionPane.showMessageDialog(null, "Don't forget, you'll need oxen to pull your wagon."); 
                    // display error message
                }
            }
        });
        viewPanel.add(buyBtn, gbc_buyBtn); // add btn and gbc to panel

        remainingLbl = new JLabel("Remaining Money: $" + money); // create new lbl
        GridBagConstraints gbc_remainingLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_remainingLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_remainingLbl.gridx = 1; // determine lbl's x coordinate
        gbc_remainingLbl.gridy = 10; // determine lbl's y coordinate
        remainingLbl.setForeground(new Color(93, 199, 255)); // add color to text
        remainingLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        remainingLbl.setFont(smallFont); // add font to text
        viewPanel.add(remainingLbl, gbc_remainingLbl); // add lbl and gbc to panel

        JLabel titleLbl = new JLabel("Welcome to the General Store!"); // create new lbl
        GridBagConstraints gbc_titleLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_titleLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_titleLbl.gridx = 1; // determine lbl's x coordinate
        gbc_titleLbl.gridy = 0; // determine lbl's y coordinate
        titleLbl.setForeground(new Color(93, 199, 255)); // add color to text
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        titleLbl.setFont(titleFont); // add font
        viewPanel.add(titleLbl, gbc_titleLbl); // add lbl and gbc to panel

        JLabel foodLbl = new JLabel("Food:"); // create new lbl
        GridBagConstraints gbc_foodLbl = new GridBagConstraints(); // add gbc to label
        gbc_foodLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_foodLbl.gridx = 0; // determine lbl's coordinate
        gbc_foodLbl.gridy = 2; // determine lbl's coordinate
        foodLbl.setForeground(new Color(93, 199, 255)); // add color to text
        foodLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        foodLbl.setFont(smallFont); // add font
        viewPanel.add(foodLbl, gbc_foodLbl); // add lbl and gbc to panel

        JLabel oxenLbl = new JLabel("Oxen:"); // create new lbl
        GridBagConstraints gbc_oxenLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_oxenLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_oxenLbl.gridx = 0; // determine x coordinate
        gbc_oxenLbl.gridy = 3; // determine y coordinate
        oxenLbl.setForeground(new Color(93, 199, 255)); // add color to text
        oxenLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        oxenLbl.setFont(smallFont); // add font to lbl
        viewPanel.add(oxenLbl, gbc_oxenLbl); // add lbl and gbc to panel

        JLabel clothingLbl = new JLabel("Clothing:"); // create new lbl
        GridBagConstraints gbc_clothingLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_clothingLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_clothingLbl.gridx = 0; // determine x coordinate
        gbc_clothingLbl.gridy = 4; // determine y coordinate
        clothingLbl.setForeground(new Color(93, 199, 255)); // add color to text
        clothingLbl.setHorizontalAlignment(SwingConstants.CENTER); // center text
        clothingLbl.setFont(smallFont); // add font
        viewPanel.add(clothingLbl, gbc_clothingLbl); // add lbl to gbc to panel

        JLabel bulletsLbl = new JLabel("Bullets:"); // create new lbl
        GridBagConstraints gbc_bulletsLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_bulletsLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_bulletsLbl.gridx = 0; // determine x coordinate
        gbc_bulletsLbl.gridy = 5; // determine y coordinate
        bulletsLbl.setForeground(new Color(93, 199, 255)); // add color to text
        bulletsLbl.setFont(smallFont); // add font
        viewPanel.add(bulletsLbl, gbc_bulletsLbl); // add lbl to gbc to panel

        JLabel axleLbl = new JLabel("Wagon Axels:"); // create new lbl
        GridBagConstraints gbc_axleLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_axleLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_axleLbl.gridx = 0; // determine x coordinate
        gbc_axleLbl.gridy = 6; // determine y coordinate
        axleLbl.setForeground(new Color(93, 199, 255)); // add add color to text
        axleLbl.setFont(smallFont); // add font
        viewPanel.add(axleLbl, gbc_axleLbl); // add lbl to gbc to panel

        JLabel tongueLbl = new JLabel("Wagon Tongues:"); // create new lbl
        GridBagConstraints gbc_tongueLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_tongueLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_tongueLbl.gridx = 0; // determine x coordinate
        gbc_tongueLbl.gridy = 7; // determien y coordinate
        tongueLbl.setForeground(new Color(93, 199, 255)); // add color to lbl
        tongueLbl.setFont(smallFont); // add font
        viewPanel.add(tongueLbl, gbc_tongueLbl); // add lbl and gbc to panel

        JLabel wheelLbl = new JLabel("Wagon Wheels:"); // create new lbl
        GridBagConstraints gbc_wheelLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_wheelLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_wheelLbl.gridx = 0; // determine x coordinate
        gbc_wheelLbl.gridy = 8; // determine y coordintae
        wheelLbl.setForeground(new Color(93, 199, 255)); // add color
        wheelLbl.setFont(smallFont); // add font
        viewPanel.add(wheelLbl, gbc_wheelLbl); // add lbl and gbc to panel

        foodPriceLbl = new JLabel("$.20"); // create new lbl
        GridBagConstraints gbc_foodPriceLbl = new GridBagConstraints(); // add gbc to lbl
        gbc_foodPriceLbl.insets = new Insets(0, 0, 0, 0); // determine the amount of push to the lbl -- moving the
        // lbl up, down, left or right by x amounnt of pixels
        gbc_foodPriceLbl.gridx = 1; // determine x coordinate
        gbc_foodPriceLbl.gridy = 2; // determine y coordinate
        foodPriceLbl.setForeground(new Color(93, 199, 255)); // add color
        foodPriceLbl.setFont(smallFont); // add font
        viewPanel.add(foodPriceLbl, gbc_foodPriceLbl); // add lbl and gbc to panel

        oxenPriceLbl = new JLabel("$40");
        GridBagConstraints gbc_oxenPriceLbl = new GridBagConstraints();
        gbc_oxenPriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_oxenPriceLbl.gridx = 1;
        gbc_oxenPriceLbl.gridy = 3;
        oxenPriceLbl.setForeground(new Color(93, 199, 255));
        oxenPriceLbl.setFont(smallFont);
        viewPanel.add(oxenPriceLbl, gbc_oxenPriceLbl);

        clothingPriceLbl = new JLabel("$10");
        GridBagConstraints gbc_clothingPriceLbl = new GridBagConstraints();
        gbc_clothingPriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_clothingPriceLbl.gridx = 1;
        gbc_clothingPriceLbl.gridy = 4;
        clothingPriceLbl.setForeground(new Color(93, 199, 255));
        clothingPriceLbl.setFont(smallFont);
        viewPanel.add(clothingPriceLbl, gbc_clothingPriceLbl);

        bulletsPriceLbl = new JLabel("$2");
        GridBagConstraints gbc_bulletsPriceLbl = new GridBagConstraints();
        gbc_bulletsPriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_bulletsPriceLbl.gridx = 1;
        gbc_bulletsPriceLbl.gridy = 5;
        bulletsPriceLbl.setForeground(new Color(93, 199, 255));
        bulletsPriceLbl.setFont(smallFont);
        viewPanel.add(bulletsPriceLbl, gbc_bulletsPriceLbl);

        axlePriceLbl = new JLabel("$10");
        GridBagConstraints gbc_axlePriceLbl = new GridBagConstraints();
        gbc_axlePriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_axlePriceLbl.gridx = 1;
        gbc_axlePriceLbl.gridy = 6;
        axlePriceLbl.setForeground(new Color(93, 199, 255));
        axlePriceLbl.setFont(smallFont);
        viewPanel.add(axlePriceLbl, gbc_axlePriceLbl);

        tonguePriceLbl = new JLabel("$10");
        GridBagConstraints gbc_tonguePriceLbl = new GridBagConstraints();
        gbc_tonguePriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_tonguePriceLbl.gridx = 1;
        gbc_tonguePriceLbl.gridy = 7;
        tonguePriceLbl.setForeground(new Color(93, 199, 255));
        tonguePriceLbl.setFont(smallFont);
        viewPanel.add(tonguePriceLbl, gbc_tonguePriceLbl);

        wheelPriceLbl = new JLabel("$10");
        GridBagConstraints gbc_wheelPriceLbl = new GridBagConstraints();
        gbc_wheelPriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_wheelPriceLbl.gridx = 1;
        gbc_wheelPriceLbl.gridy = 8;
        wheelPriceLbl.setForeground(new Color(93, 199, 255));
        wheelPriceLbl.setFont(smallFont);
        viewPanel.add(wheelPriceLbl, gbc_wheelPriceLbl);

        SpinnerNumberModel foodLimit = new SpinnerNumberModel(0, 0, 2000, 25);
        JSpinner foodSpinner = new JSpinner(foodLimit);
        GridBagConstraints gbc_foodSpinner = new GridBagConstraints();
        gbc_foodSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_foodSpinner.gridx = 2;
        gbc_foodSpinner.gridy = 2;
        foodSpinner.setPreferredSize(new Dimension(80, 20));
        foodSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.FOOD, (Integer) foodSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(foodSpinner, gbc_foodSpinner);

        SpinnerNumberModel oxenLimit = new SpinnerNumberModel(0, 0, 9, 1);
        oxenSpinner = new JSpinner(oxenLimit);
        GridBagConstraints gbc_oxenSpinner = new GridBagConstraints();
        gbc_oxenSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_oxenSpinner.gridx = 2;
        gbc_oxenSpinner.gridy = 3;
        oxenSpinner.setPreferredSize(new Dimension(80, 20));
        oxenSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.OXEN, (Integer) oxenSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(oxenSpinner, gbc_oxenSpinner);

        SpinnerNumberModel clothingLimit = new SpinnerNumberModel(0, 0, 99, 5);
        JSpinner clothingSpinner = new JSpinner(clothingLimit);
        GridBagConstraints gbc_clothingSpinner = new GridBagConstraints();
        gbc_clothingSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_clothingSpinner.gridx = 2;
        gbc_clothingSpinner.gridy = 4;
        clothingSpinner.setPreferredSize(new Dimension(80, 20));
        clothingSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.CLOTHING, (Integer) clothingSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(clothingSpinner, gbc_clothingSpinner);

        SpinnerNumberModel bulletLimit = new SpinnerNumberModel(0, 0, 99, 5);
        JSpinner bulletSpinner = new JSpinner(bulletLimit);
        GridBagConstraints gbc_bulletSpinner = new GridBagConstraints();
        gbc_bulletSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_bulletSpinner.gridx = 2;
        gbc_bulletSpinner.gridy = 5;
        bulletSpinner.setPreferredSize(new Dimension(80, 20));
        bulletSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.BULLETS, (Integer) bulletSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(bulletSpinner, gbc_bulletSpinner);

        SpinnerNumberModel axleLimit = new SpinnerNumberModel(0, 0, 3, 1);
        JSpinner axleSpinner = new JSpinner(axleLimit);
        GridBagConstraints gbc_axleSpinner = new GridBagConstraints();
        gbc_axleSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_axleSpinner.gridx = 2;
        gbc_axleSpinner.gridy = 6;
        axleSpinner.setPreferredSize(new Dimension(80, 20));
        axleSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.WAGON_AXLE, (Integer) axleSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(axleSpinner, gbc_axleSpinner);

        SpinnerNumberModel tongueLimit = new SpinnerNumberModel(0, 0, 3, 1);
        JSpinner tongueSpinner = new JSpinner(tongueLimit);
        GridBagConstraints gbc_tongueSpinner = new GridBagConstraints();
        gbc_tongueSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_tongueSpinner.gridx = 2;
        gbc_tongueSpinner.gridy = 7;
        tongueSpinner.setPreferredSize(new Dimension(80, 20));
        tongueSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.WAGON_TONGUE, (Integer) tongueSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(tongueSpinner, gbc_tongueSpinner);

        SpinnerNumberModel wheelLimit = new SpinnerNumberModel(0, 0, 3, 1);
        JSpinner wheelSpinner = new JSpinner(wheelLimit);
        GridBagConstraints gbc_wheelSpinner = new GridBagConstraints();
        gbc_wheelSpinner.insets = new Insets(0, 0, 0, 0);
        gbc_wheelSpinner.gridx = 2;
        gbc_wheelSpinner.gridy = 8;
        wheelSpinner.setPreferredSize(new Dimension(80, 20));
        wheelSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getStore().updateCost(Inventory.WAGON_WHEEL, (Integer) wheelSpinner.getValue());
                priceLbl.setText("Total Cost: $" + (total + wagon.getStore().getCost()));
                remainingLbl.setText("Remaining Money: $" + (money - wagon.getStore().getCost()));
            }
        });
        viewPanel.add(wheelSpinner, gbc_wheelSpinner);

        JLabel foodTitleLbl = new JLabel("Names");
        GridBagConstraints gbc_foodTitleLbl = new GridBagConstraints();
        gbc_foodTitleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_foodTitleLbl.gridx = 0;
        gbc_foodTitleLbl.gridy = 1;
        foodTitleLbl.setForeground(new Color(93, 199, 255));
        foodTitleLbl.setFont(smallFont);
        viewPanel.add(foodTitleLbl, gbc_foodTitleLbl);

        JLabel priceTitleLbl = new JLabel("Prices");
        GridBagConstraints gbc_priceTitleLbl = new GridBagConstraints();
        gbc_priceTitleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_priceTitleLbl.gridx = 1;
        gbc_priceTitleLbl.gridy = 1;
        priceTitleLbl.setForeground(new Color(93, 199, 255));
        priceTitleLbl.setFont(smallFont);
        viewPanel.add(priceTitleLbl, gbc_priceTitleLbl);

        JLabel amountTitleLbl = new JLabel("Purchase Amount");
        GridBagConstraints gbc_amountTitleLbl = new GridBagConstraints();
        gbc_amountTitleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_amountTitleLbl.gridx = 2;
        gbc_amountTitleLbl.gridy = 1;
        amountTitleLbl.setForeground(new Color(93, 199, 255));
        amountTitleLbl.setFont(smallFont);
        viewPanel.add(amountTitleLbl, gbc_amountTitleLbl);

        viewPanel.setVisible(true);
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
    }

    /**
     * Resets the quantity of items to zero through the store class
     */
    public void resetStore() {
        wagon.getStore().resetQuantity();
    }

    /**
     * Receives the amount of money given to the user to start the game
     */
    private void getMoney() {
        money = wagon.getInventory().getMoney();
    }

    /**
     * Sets the label with the amount of money given to the user
     */
    public void updateLabel() {
        getMoney();
        remainingLbl.setText("Remaining Money: $" + money);
    }

    /**
     * resizes all images through AbstractScreen
     */
    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
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