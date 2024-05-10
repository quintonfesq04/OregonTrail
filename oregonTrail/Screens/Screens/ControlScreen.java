package Screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Player;
import Gameplay.Wagon;

/**
 * ControlScreen.java -- pulls up a screen that allows to player to see their
 * inventory and make edits to how they traverse the trail
 * 
 * @author Ethan Burch
 * @author Quinton Fesq
 * @version 1.4.2 5/1/24
 */
public class ControlScreen extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Wagon wagon;
    private Display display;

    private JLabel foodLbl;
    private JLabel moneyLbl;
    private JLabel oxenLbl;
    private JLabel clothesLbl;
    private JLabel wheelLbl;
    private JLabel axleLbl;
    private JLabel tongueLbl;
    private JLabel ammoLbl;
    private JButton forageBtn;

    private Font labelFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font sliderFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private JRadioButton meagerBtn;
    private JRadioButton bareBonesBtn;
    private JRadioButton fillingBtn;
    private JSlider slider;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Constructor of a ControlScreen Object
     * @param wagon the wagon used by this class
     * @param display the display that is showing this class
     */
    public ControlScreen(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    /**
     * Initializes the JPanel returned by this class
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 0.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel inventory = new JLabel("Inventory");
        GridBagConstraints gbc_inventory = new GridBagConstraints();
        gbc_inventory.insets = new Insets(0, 0, 0, 0);
        gbc_inventory.gridx = 0;
        gbc_inventory.gridy = 0;
        inventory.setForeground(new Color(93, 199, 255));
        inventory.setHorizontalAlignment(SwingConstants.CENTER);
        inventory.setFont(labelFont);
        viewPanel.add(inventory, gbc_inventory);

        moneyLbl = new JLabel("Money: ");
        GridBagConstraints gbc_moneyLbl = new GridBagConstraints();
        gbc_moneyLbl.insets = new Insets(0, 0, 0, 0);
        gbc_moneyLbl.gridx = 0;
        gbc_moneyLbl.gridy = 1;
        moneyLbl.setForeground(new Color(93, 199, 255));
        moneyLbl.setHorizontalAlignment(SwingConstants.CENTER);
        moneyLbl.setFont(labelFont);
        viewPanel.add(moneyLbl, gbc_moneyLbl);

        foodLbl = new JLabel("Food: ");
        GridBagConstraints gbc_foodLbl = new GridBagConstraints();
        gbc_foodLbl.insets = new Insets(0, 0, 0, 0);
        gbc_foodLbl.gridx = 0;
        gbc_foodLbl.gridy = 2;
        foodLbl.setForeground(new Color(93, 199, 255));
        foodLbl.setHorizontalAlignment(SwingConstants.CENTER);
        foodLbl.setFont(labelFont);
        viewPanel.add(foodLbl, gbc_foodLbl);

        oxenLbl = new JLabel("Oxen: ");
        GridBagConstraints gbc_oxenLbl = new GridBagConstraints();
        gbc_oxenLbl.insets = new Insets(0, 0, 0, 0);
        gbc_oxenLbl.gridx = 0;
        gbc_oxenLbl.gridy = 3;
        oxenLbl.setForeground(new Color(93, 199, 255));
        oxenLbl.setHorizontalAlignment(SwingConstants.CENTER);
        oxenLbl.setFont(labelFont);
        viewPanel.add(oxenLbl, gbc_oxenLbl);

        clothesLbl = new JLabel("Clothes: ");
        GridBagConstraints gbc_clothesLbl = new GridBagConstraints();
        gbc_clothesLbl.insets = new Insets(0, 0, 0, 0);
        gbc_clothesLbl.gridx = 0;
        gbc_clothesLbl.gridy = 4;
        clothesLbl.setFont(labelFont);
        viewPanel.add(clothesLbl, gbc_clothesLbl);

        ammoLbl = new JLabel("Ammunition: ");
        GridBagConstraints gbc_ammoLbl = new GridBagConstraints();
        gbc_ammoLbl.insets = new Insets(0, 0, 0, 0);
        gbc_ammoLbl.gridx = 0;
        gbc_ammoLbl.gridy = 5;
        ammoLbl.setFont(labelFont);
        viewPanel.add(ammoLbl, gbc_ammoLbl);

        wheelLbl = new JLabel("Wagon Wheel: ");
        GridBagConstraints gbc_wheelLbl = new GridBagConstraints();
        gbc_wheelLbl.insets = new Insets(0, 0, 0, 0);
        gbc_wheelLbl.gridx = 0;
        gbc_wheelLbl.gridy = 6;
        wheelLbl.setFont(labelFont);
        viewPanel.add(wheelLbl, gbc_wheelLbl);

        axleLbl = new JLabel("Wagon Axle: ");
        GridBagConstraints gbc_axleLbl = new GridBagConstraints();
        gbc_axleLbl.insets = new Insets(0, 0, 0, 0);
        gbc_axleLbl.gridx = 0;
        gbc_axleLbl.gridy = 7;
        axleLbl.setFont(labelFont);
        viewPanel.add(axleLbl, gbc_axleLbl);

        tongueLbl = new JLabel("Wagon Tongue: ");
        GridBagConstraints gbc_tongueLbl = new GridBagConstraints();
        gbc_tongueLbl.insets = new Insets(0, 0, 0, 0);
        gbc_tongueLbl.gridx = 0;
        gbc_tongueLbl.gridy = 8;
        tongueLbl.setFont(labelFont);
        viewPanel.add(tongueLbl, gbc_tongueLbl);

        JLabel sliderLbl = new JLabel("Travel Speed");
        GridBagConstraints gbc_sliderLbl = new GridBagConstraints();
        gbc_sliderLbl.insets = new Insets(0, 100, 0, 0);
        gbc_sliderLbl.gridx = 2;
        gbc_sliderLbl.gridy = 0;
        inventory.setForeground(new Color(93, 199, 255));
        inventory.setHorizontalAlignment(SwingConstants.CENTER);
        inventory.setFont(labelFont);
        viewPanel.add(sliderLbl, gbc_sliderLbl);

        slider = new JSlider(JSlider.HORIZONTAL, 12, 20, 20);
        GridBagConstraints gbc_slider = new GridBagConstraints();
        gbc_slider.insets = new Insets(0, 100, 0, 0);
        gbc_slider.gridx = 2;
        gbc_slider.gridy = 1;
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        viewPanel.add(slider, gbc_slider);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getPlayer().setTravelSpeed(slider.getValue());
                viewPanel.requestFocusInWindow();
            }

        });

        JLabel consumptionLbl = new JLabel("Food Consumption");
        GridBagConstraints gbc_consumptionLbl = new GridBagConstraints();
        gbc_consumptionLbl.insets = new Insets(0, 100, 0, 0);
        gbc_consumptionLbl.gridx = 2;
        gbc_consumptionLbl.gridy = 2;
        consumptionLbl.setForeground(new Color(93, 199, 255));
        consumptionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        consumptionLbl.setFont(labelFont);
        viewPanel.add(consumptionLbl, gbc_consumptionLbl);

        bareBonesBtn = new JRadioButton("Bare-Bones");
        GridBagConstraints gbc_bareBones = new GridBagConstraints();
        gbc_bareBones.insets = new Insets(0, 100, 0, 0);
        gbc_bareBones.gridx = 2;
        gbc_bareBones.gridy = 3;
        meagerBtn = new JRadioButton("Meager");
        GridBagConstraints gbc_meager = new GridBagConstraints();
        gbc_meager.insets = new Insets(0, 100, 0, 0);
        gbc_meager.gridx = 2;
        gbc_meager.gridy = 4;
        fillingBtn = new JRadioButton("Filling");
        GridBagConstraints gbc_filling = new GridBagConstraints();
        gbc_filling.insets = new Insets(0, 100, 0, 0);
        gbc_filling.gridx = 2;
        gbc_filling.gridy = 5;
        fillingBtn.setSelected(true);
        buttonGroup.add(bareBonesBtn);
        buttonGroup.add(meagerBtn);
        buttonGroup.add(fillingBtn);
        viewPanel.add(bareBonesBtn, gbc_bareBones);
        viewPanel.add(meagerBtn, gbc_meager);
        viewPanel.add(fillingBtn, gbc_filling);
        meagerBtn.setFont(sliderFont);
        bareBonesBtn.setFont(sliderFont);
        fillingBtn.setFont(sliderFont);

        forageBtn = new JButton("Forage For Food");
        GridBagConstraints gbc_forageBtn = new GridBagConstraints();
        gbc_forageBtn.insets = new Insets(0, 100, 0, 0);
        gbc_forageBtn.gridx = 2;
        gbc_forageBtn.gridy = 8;
        forageBtn.setPreferredSize(new Dimension(125, 25));
        forageBtn.setForeground(new Color(93, 199, 255));
        forageBtn.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(forageBtn, gbc_forageBtn);
        forageBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.showForagingScreen(wagon);
            }
        });

        ActionListener radioListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                viewPanel.requestFocusInWindow();
                if (e.getSource() instanceof JRadioButton) {
                    if (e.getSource() == bareBonesBtn) {
                        wagon.getPlayer().setConsumption(Player.BARE_BONES);
                    } else if (e.getSource() == fillingBtn) {
                        wagon.getPlayer().setConsumption(Player.FILLING);
                    } else if (e.getSource() == meagerBtn) {
                        wagon.getPlayer().setConsumption(Player.MEAGER);
                    }
                }
            }

        };

        fillingBtn.addActionListener(radioListener);
        meagerBtn.addActionListener(radioListener);
        bareBonesBtn.addActionListener(radioListener);

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_I) {
                    display.showTravelScreen(wagon);
                } else {
                    System.out.println((char) e.getKeyCode());
                }
            }
        });
    }

    /**
     * Updates the display with new information
     */
    public void updateDisplay() {
        moneyLbl.setText("Money:" + wagon.getInventory().getMoney());
        oxenLbl.setText("Oxen:" + wagon.getInventory().getOxen());
        foodLbl.setText("Food:" + wagon.getInventory().getFood());
        clothesLbl.setText("Clothes:" + wagon.getInventory().getClothing());
        ammoLbl.setText("Ammo:" + wagon.getInventory().getBullets());
        wheelLbl.setText("Wagon Wheels:" + wagon.getInventory().getWagonWheel());
        axleLbl.setText("Wagon Axles:" + wagon.getInventory().getWagonAxle());
        tongueLbl.setText("Wagon Tongues:" + wagon.getInventory().getWagonTongue());
    }

    /**
     * resizes the images contained within the JPanel
     */
    @Override
    public void resizeImages() {
        // TODO: Implement resizing of images
    }

    /**
     * Returns the JPanel from this class
     * 
     * @return the JPanel created by this class
     */
    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
}