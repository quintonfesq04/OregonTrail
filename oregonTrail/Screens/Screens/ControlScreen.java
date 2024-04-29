package Screens;

import java.io.File;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import Gameplay.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



/**
 * ControlScreen.java -- Shows the player their inventory, food consumption, and travel speed.
 * @author Ethan Burch
 * @version 1.1.0 4/22/24
 */
public class ControlScreen extends AbstractScreen{
    private File image = new File("Images\\start screen46.jpg");
    private PicPanel panel = new PicPanel(image);

    private Inventory inventory;
    private Player player;
    private Display display;

	private JLabel moneyLbl;
	private JLabel oxenLbl;
	private JLabel clothesLbl;
	private JLabel wheelLbl;
	private JLabel axleLbl;
	private JLabel tongueLbl;
	private JLabel ammoLbl;
	private Font labelFont = new Font("Trajan Pro", Font.PLAIN, 24);
	private Font sliderFont = new Font("Trajan Pro", Font.PLAIN, 16);
	private JLabel foodLbl;
	private JPanel sliderPanel;
	private JPanel consumptionPanel;
	private JRadioButton meagerBtn;
	private JRadioButton bareBonesBtn;
	private JRadioButton fillingBtn;
	private JSlider slider;
	private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Constructor for ControlScreen object
     * @param inventory the inventory to be shown 
     * @param player    the player object used 
     * @param display   the main display that this will be shown in
     */
    public ControlScreen(Inventory inventory, Player player, Display display){
        this.inventory = inventory;
        this.player = player;
        this.display = display;
    }
    
    @Override
    protected void initialize() {
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel inventoryPanel = new JPanel();
		inventoryPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(inventoryPanel);
		inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.PAGE_AXIS));
		
		moneyLbl = new JLabel("Money: ");
		moneyLbl.setFont(labelFont);
		inventoryPanel.add(moneyLbl);
		
		foodLbl = new JLabel("Food: ");
		foodLbl.setFont(labelFont);
		inventoryPanel.add(foodLbl);
		
		oxenLbl = new JLabel("Oxen: ");
		oxenLbl.setFont(labelFont);
		inventoryPanel.add(oxenLbl);
		
		clothesLbl = new JLabel("Clothes: ");
		clothesLbl.setFont(labelFont);
		inventoryPanel.add(clothesLbl);
		
		ammoLbl = new JLabel("Ammunition: ");
		ammoLbl.setFont(labelFont);
		inventoryPanel.add(ammoLbl);
		
		wheelLbl = new JLabel("Wagon Wheel: ");
		wheelLbl.setFont(labelFont);
		inventoryPanel.add(wheelLbl);
		
		axleLbl = new JLabel("Wagon Axle: ");
		axleLbl.setFont(labelFont);
		inventoryPanel.add(axleLbl);
		
		tongueLbl = new JLabel("Wagon Tongue: ");
		tongueLbl.setFont(labelFont);
		inventoryPanel.add(tongueLbl);
		
		
		JPanel optionPanel = new JPanel();
		panel.add(optionPanel);
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
		
		slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setValue(20);
		slider.setMaximum(20);
		slider.setMinimum(12);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setFont(sliderFont);
		
		sliderPanel = new JPanel();
		sliderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Travel Speed", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionPanel.add(sliderPanel);
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));
		
		sliderPanel.add(slider);
		
		consumptionPanel = new JPanel();
		consumptionPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Food Consumption", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionPanel.add(consumptionPanel);
		consumptionPanel.setLayout(new BoxLayout(consumptionPanel, BoxLayout.X_AXIS));
		
		meagerBtn = new JRadioButton("Meager");
		buttonGroup.add(meagerBtn);
		meagerBtn.setFont(sliderFont);
		consumptionPanel.add(meagerBtn);
		
		bareBonesBtn = new JRadioButton("Bare-Bones");
		buttonGroup.add(bareBonesBtn);
		bareBonesBtn.setFont(sliderFont);
		consumptionPanel.add(bareBonesBtn);
		
		fillingBtn = new JRadioButton("Filling");
		fillingBtn.setSelected(true);
		buttonGroup.add(fillingBtn);
		fillingBtn.setFont(sliderFont);
		consumptionPanel.add(fillingBtn);
    }

    public void keyPressed(KeyEvent e){
        int vk = e.getKeyCode();
        if(vk == KeyEvent.VK_I){
            this.map.display();
        }
        else 
            System.out.println((char)vk);
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }    
}
