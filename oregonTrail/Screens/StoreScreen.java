package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Stuff.*;

public class StoreScreen extends AbstractScreen{
    private File image = new File("Images\\Background.jpg");
    private PicPanel panel = new PicPanel(image);

	private Font wordFont = new Font("Rockwell", Font.PLAIN, 24);
	private JLabel foodPriceLbl;
	private JLabel oxenPriceLbl;
	private JLabel clothingPriceLbl;
	private JLabel bulletsPriceLbl;
	private JLabel axlePriceLbl;
	private JLabel wheelPriceLbl;
	private JLabel tonguePriceLbl;

    @Override
    protected void initialize() {
		panel.setBounds(100, 100, 573, 456);
		panel.setLayout(new BorderLayout(5, 0));
		
		JPanel bottomPanel = new JPanel();
		panel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Total Cost: $");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		bottomPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Buy");
		bottomPanel.add(btnNewButton);
		
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
		
		JLabel axleLbl = new JLabel("Wagon Axles:");
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
		
		foodPriceLbl = new JLabel("$.85");
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
		buyPanel.setMaximumSize(new Dimension(1000,pricePanel.getHeight()));
		
		JSpinner foodSpinner = new JSpinner();
		buyPanel.add(foodSpinner);
		
		JSpinner oxenSpinner = new JSpinner();
		buyPanel.add(oxenSpinner);
		
		JSpinner clothingSpinner = new JSpinner();
		buyPanel.add(clothingSpinner);
		
		JSpinner bulletSpinner = new JSpinner();
		buyPanel.add(bulletSpinner);
		
		JSpinner axleSpinner = new JSpinner();
		buyPanel.add(axleSpinner);
		
		JSpinner tongueSpinner = new JSpinner();
		buyPanel.add(tongueSpinner);
		
		JSpinner wheelSpinner = new JSpinner();
		buyPanel.add(wheelSpinner);

        panel.setVisible(true);
    }

    @Override
    public void resizeImages() {
        panel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
