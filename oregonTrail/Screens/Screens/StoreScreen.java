package Screens;

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

import Gameplay.Display;
import Gameplay.Inventory;
import Gameplay.PicPanel;
import Gameplay.Wagon;

/**
 * StoreScreen.java -- a screen for when the player enters a store
 * 
 * @author Quinton Fesq
 * @author Ethan Burch
 * @version 1.4.0 4/23/24
 */
public class StoreScreen extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private JLabel foodPriceLbl;
    private JLabel oxenPriceLbl;
    private JLabel clothingPriceLbl;
    private JLabel bulletsPriceLbl;
    private JLabel axlePriceLbl;
    private JLabel wheelPriceLbl;
    private JLabel tonguePriceLbl;
    private JLabel remainingLbl;
    private JSpinner oxenSpinner;
    public JButton returnBtn;

    private Display display;
    private Wagon wagon;

    private double money;
    private double total = 0;

    /**
     * Constructor for StoreScreen object
     * 
     * @param inventory the inventory to add to
     * @param store     the store used by the screen
     * @param display   the display that this will be used in
     */
    public StoreScreen(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 0.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel priceLbl = new JLabel("Total Cost: $" + total);
        GridBagConstraints gbc_priceLabel = new GridBagConstraints();
        gbc_priceLabel.insets = new Insets(10, 0, 5, 0);
        gbc_priceLabel.gridx = 1;
        gbc_priceLabel.gridy = 9;
        priceLbl.setForeground(new Color(93, 199, 255));
        priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(priceLbl, gbc_priceLabel);
        priceLbl.setFont(smallFont);

        JButton buyBtn = new JButton("Buy");
        GridBagConstraints gbc_buyBtn = new GridBagConstraints();
        gbc_buyBtn.insets = new Insets(10, 0, 0, 0);
        gbc_buyBtn.gridx = 1;
        gbc_buyBtn.gridy = 11;
        buyBtn.setForeground(new Color(93, 199, 255));
        buyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (wagon.getStore().checkIfEnoughMoney(wagon.getInventory())) {
                    wagon.setInventory(wagon.getStore().buyMethod(wagon.getInventory()));
                    display.showLandmarkScreen();
                } else if ((total + wagon.getStore().getCost()) > (wagon.getInventory().getMoney())) {
                    JOptionPane.showMessageDialog(null,
                            "Okay that comes to a total of $" + (total + wagon.getStore().getCost())
                                    + ". But I see that you only have $" + wagon.getInventory().getMoney()
                                    + ". We'd better go over the list again.");
                } else if ((Integer) oxenSpinner.getValue() == 0) {
                    JOptionPane.showMessageDialog(null, "Don't forget, you'll need oxen to pull your wagon.");
                }
            }
        });
        viewPanel.add(buyBtn, gbc_buyBtn);

        returnBtn = new JButton("Return To Landmark");
        GridBagConstraints gbc_returnBtn = new GridBagConstraints();
        gbc_returnBtn.insets = new Insets(10, 0, 0, 0);
        gbc_returnBtn.gridx = 1;
        gbc_returnBtn.gridy = 12;
        returnBtn.setForeground(new Color(93, 199, 255));
        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.showLandmarkScreen();
            }
        });
        viewPanel.add(returnBtn, gbc_returnBtn);

        remainingLbl = new JLabel("Remaining Money: $" + money);
        GridBagConstraints gbc_remainingLbl = new GridBagConstraints();
        gbc_remainingLbl.insets = new Insets(0, 0, 0, 0);
        gbc_remainingLbl.gridx = 1;
        gbc_remainingLbl.gridy = 10;
        remainingLbl.setForeground(new Color(93, 199, 255));
        remainingLbl.setHorizontalAlignment(SwingConstants.CENTER);
        remainingLbl.setFont(smallFont);
        viewPanel.add(remainingLbl, gbc_remainingLbl);

        JLabel titleLbl = new JLabel("Welcome to the General Store!");
        GridBagConstraints gbc_titleLbl = new GridBagConstraints();
        gbc_titleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_titleLbl.gridx = 1;
        gbc_titleLbl.gridy = 0;
        titleLbl.setForeground(new Color(93, 199, 255));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(titleFont);
        viewPanel.add(titleLbl, gbc_titleLbl);

        JLabel foodLbl = new JLabel("Food:");
        GridBagConstraints gbc_foodLbl = new GridBagConstraints();
        gbc_foodLbl.insets = new Insets(0, 0, 0, 0);
        gbc_foodLbl.gridx = 0;
        gbc_foodLbl.gridy = 2;
        foodLbl.setForeground(new Color(93, 199, 255));
        foodLbl.setHorizontalAlignment(SwingConstants.CENTER);
        foodLbl.setFont(smallFont);
        viewPanel.add(foodLbl, gbc_foodLbl);

        JLabel oxenLbl = new JLabel("Oxen:");
        GridBagConstraints gbc_oxenLbl = new GridBagConstraints();
        gbc_oxenLbl.insets = new Insets(0, 0, 0, 0);
        gbc_oxenLbl.gridx = 0;
        gbc_oxenLbl.gridy = 3;
        oxenLbl.setForeground(new Color(93, 199, 255));
        oxenLbl.setHorizontalAlignment(SwingConstants.CENTER);
        oxenLbl.setFont(smallFont);
        viewPanel.add(oxenLbl, gbc_oxenLbl);

        JLabel clothingLbl = new JLabel("Clothing:");
        GridBagConstraints gbc_clothingLbl = new GridBagConstraints();
        gbc_clothingLbl.insets = new Insets(0, 0, 0, 0);
        gbc_clothingLbl.gridx = 0;
        gbc_clothingLbl.gridy = 4;
        clothingLbl.setForeground(new Color(93, 199, 255));
        clothingLbl.setHorizontalAlignment(SwingConstants.CENTER);
        clothingLbl.setFont(smallFont);
        viewPanel.add(clothingLbl, gbc_clothingLbl);

        JLabel bulletsLbl = new JLabel("Bullets:");
        GridBagConstraints gbc_bulletsLbl = new GridBagConstraints();
        gbc_bulletsLbl.insets = new Insets(0, 0, 0, 0);
        gbc_bulletsLbl.gridx = 0;
        gbc_bulletsLbl.gridy = 5;
        bulletsLbl.setForeground(new Color(93, 199, 255));
        bulletsLbl.setFont(smallFont);
        viewPanel.add(bulletsLbl, gbc_bulletsLbl);

        JLabel axleLbl = new JLabel("Wagon Axels:");
        GridBagConstraints gbc_axleLbl = new GridBagConstraints();
        gbc_axleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_axleLbl.gridx = 0;
        gbc_axleLbl.gridy = 6;
        axleLbl.setForeground(new Color(93, 199, 255));
        axleLbl.setFont(smallFont);
        viewPanel.add(axleLbl, gbc_axleLbl);

        JLabel tongueLbl = new JLabel("Wagon Tongues:");
        GridBagConstraints gbc_tongueLbl = new GridBagConstraints();
        gbc_tongueLbl.insets = new Insets(0, 0, 0, 0);
        gbc_tongueLbl.gridx = 0;
        gbc_tongueLbl.gridy = 7;
        tongueLbl.setForeground(new Color(93, 199, 255));
        tongueLbl.setFont(smallFont);
        viewPanel.add(tongueLbl, gbc_tongueLbl);

        JLabel wheelLbl = new JLabel("Wagon Wheels:");
        GridBagConstraints gbc_wheelLbl = new GridBagConstraints();
        gbc_wheelLbl.insets = new Insets(0, 0, 0, 0);
        gbc_wheelLbl.gridx = 0;
        gbc_wheelLbl.gridy = 8;
        wheelLbl.setForeground(new Color(93, 199, 255));
        wheelLbl.setFont(smallFont);
        viewPanel.add(wheelLbl, gbc_wheelLbl);

        foodPriceLbl = new JLabel("$.20");
        GridBagConstraints gbc_foodPriceLbl = new GridBagConstraints();
        gbc_foodPriceLbl.insets = new Insets(0, 0, 0, 0);
        gbc_foodPriceLbl.gridx = 1;
        gbc_foodPriceLbl.gridy = 2;
        foodPriceLbl.setForeground(new Color(93, 199, 255));
        foodPriceLbl.setFont(smallFont);
        viewPanel.add(foodPriceLbl, gbc_foodPriceLbl);

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
     * resets the store object within the wagon object
     */
    public void resetStore() {
        wagon.getStore().resetQuantity();
    }

    /**
     * gets money from the wagon object
     */
    private void getMoney() {
        money = wagon.getInventory().getMoney();
    }

    /**
     * updates the money label
     */
    public void updateLabel() {
        getMoney();
        remainingLbl.setText("Remaining Money: $" + money);
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        // TODO Auto-generated method stub
        return viewPanel;
    }
}