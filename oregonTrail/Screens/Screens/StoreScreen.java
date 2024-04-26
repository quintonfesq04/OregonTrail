package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Gameplay.*;
import Screens.*;
import Hunting.*;

/**
 * StoreScreen.java -- a screen for when the player enters a store
 * @author Ethan Burch
 * @version 1.4.0 4/23/24
 */
public class StoreScreen extends AbstractScreen{
    private File image = new File("Images/Background.jpg");
    private PicPanel panel = new PicPanel(image);

	private Font wordFont = new Font("Rockwell", Font.PLAIN, 24);
	private JLabel foodPriceLbl;
	private JLabel oxenPriceLbl;
	private JLabel clothingPriceLbl;
	private JLabel bulletsPriceLbl;
	private JLabel axlePriceLbl;
	private JLabel wheelPriceLbl;
	private JLabel tonguePriceLbl;
	public JButton returnToLandmarkBtn;

	Inventory inventory;
	Store store;
	Display display;

	/**
	 * Constructor for StoreScreen object
	 * @param inventory the inventory to add to
	 * @param store the store used by the screen
	 * @param display the display that this will be used in
	 */
    public StoreScreen(Inventory inventory, Store store, Display display){
		this.inventory = inventory;
		this.store = store;
		this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
		panel.setBounds(100, 100, 573, 456);
		panel.setLayout(new BorderLayout(5, 0));
		
		JPanel bottomPanel = new JPanel();
		panel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel priceLbl = new JLabel("Total Cost: $");
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		bottomPanel.add(priceLbl);
        priceLbl.setFont(wordFont);

		
		JButton buyBtn = new JButton("Buy");
		buyBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(store.checkIfEnoughMoney(inventory))
					inventory = store.buyMethod(inventory);
			}
		});
		bottomPanel.add(buyBtn);
		
		JButton travelBtn = new JButton("Travel");
		travelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showTravelScreen();
			}
		});
		bottomPanel.add(travelBtn);
		
		returnToLandmarkBtn = new JButton("Return To Landmark");
		returnToLandmarkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.showLandmarkScreen();
			}
		});
		bottomPanel.add(returnToLandmarkBtn);
		returnToLandmarkBtn.setEnabled(false);
		
		JPanel textPanel = new JPanel();
		panel.add(textPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome to the General Store!");
		lblNewLabel.setFont(wordFont);
		textPanel.add(lblNewLabel);
		
		JPanel optionPanel = new JPanel();
		panel.add(optionPanel, BorderLayout.CENTER);
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Names", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		optionPanel.add(itemPanel);
		itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
		
		JLabel foodLbl = new JLabel("Food:");
		foodLbl.setFont(wordFont);
		itemPanel.add(foodLbl);
		
		JLabel oxenLbl = new JLabel("Oxen:");
		oxenLbl.setFont(wordFont);
		itemPanel.add(oxenLbl);
		
		JLabel clothingLbl = new JLabel("Clothing:");
		clothingLbl.setFont(wordFont);
		itemPanel.add(clothingLbl);
		
		JLabel bulletsLbl = new JLabel("Bullets:");
		bulletsLbl.setFont(wordFont);
		itemPanel.add(bulletsLbl);
		
		JLabel axleLbl = new JLabel("Wagon Axels:");
		axleLbl.setFont(wordFont);
		itemPanel.add(axleLbl);
		
		JLabel tongueLbl = new JLabel("Wagon Tongues:");
		tongueLbl.setFont(wordFont);
		itemPanel.add(tongueLbl);
		
		JLabel wheelLbl = new JLabel("Wagon Wheels:");
		wheelLbl.setFont(wordFont);
		itemPanel.add(wheelLbl);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Prices", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		optionPanel.add(pricePanel);
		pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));
		
		foodPriceLbl = new JLabel("$.20");
		foodPriceLbl.setFont(wordFont);
		pricePanel.add(foodPriceLbl);
		
		oxenPriceLbl = new JLabel("$40");
		oxenPriceLbl.setFont(wordFont);
		pricePanel.add(oxenPriceLbl);
		
		clothingPriceLbl = new JLabel("$10");
		clothingPriceLbl.setFont(wordFont);
		pricePanel.add(clothingPriceLbl);
		
		bulletsPriceLbl = new JLabel("$.10");
		bulletsPriceLbl.setFont(wordFont);
		pricePanel.add(bulletsPriceLbl);
		
		axlePriceLbl = new JLabel("$20");
		axlePriceLbl.setFont(wordFont);
		pricePanel.add(axlePriceLbl);
		
		tonguePriceLbl = new JLabel("$20");
		tonguePriceLbl.setFont(wordFont);
		pricePanel.add(tonguePriceLbl);
		
		wheelPriceLbl = new JLabel("$20");
		wheelPriceLbl.setFont(wordFont);
		pricePanel.add(wheelPriceLbl);

        
		pricePanel.setVisible(true);
		panel.setVisible(true);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Purchase Amount", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionPanel.add(buyPanel);
		buyPanel.setLayout(new BoxLayout(buyPanel, BoxLayout.Y_AXIS));
		buyPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 235));
        
		

		JSpinner foodSpinner = new JSpinner();
		foodSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.FOOD, (Integer) foodSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(foodSpinner);
		
		JSpinner oxenSpinner = new JSpinner();
		oxenSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.OXEN, (Integer) oxenSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(oxenSpinner);
		
		JSpinner clothingSpinner = new JSpinner();
		clothingSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.CLOTHING, (Integer) clothingSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(clothingSpinner);
		
		JSpinner bulletSpinner = new JSpinner();
		bulletSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.BULLETS, (Integer) bulletSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(bulletSpinner);
		
		JSpinner axleSpinner = new JSpinner();
		axleSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.WAGON_AXLE, (Integer) axleSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		}); 
		buyPanel.add(axleSpinner);
		
		JSpinner tongueSpinner = new JSpinner();
		tongueSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.WAGON_TONGUE, (Integer) tongueSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(tongueSpinner);
		
		JSpinner wheelSpinner = new JSpinner();
		wheelSpinner.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				store.updateCost(Inventory.WAGON_WHEEL, (Integer) wheelSpinner.getValue());
				priceLbl.setText("Total Cost: $" + store.getCost());
			}
		});
		buyPanel.add(wheelSpinner);

        panel.setVisible(true);
    }

    @Override
    public void resizeImages() {
        panel.resizeImage();
    }

	public void resetStore(){
		store.resetQuantity();
	}

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
