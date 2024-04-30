package Screens;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import Gameplay.*;

public class ControlScreen extends AbstractScreen {
    private JPanel panel;
    private Inventory inventory;
    private Player player;
    private Display display;
    private Locations locations;

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

    public ControlScreen(Inventory inventory, Player player, Display display, Locations locations) {
        this.inventory = inventory;
        this.player = player;
        this.display = display;
        this.locations = locations;
        initialize();
    }

    protected void initialize() {
        panel = new JPanel(new BorderLayout());

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBorder(BorderFactory.createTitledBorder("Inventory"));
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.PAGE_AXIS));
        panel.add(inventoryPanel, BorderLayout.WEST);

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
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        panel.add(optionPanel, BorderLayout.CENTER);

        slider = new JSlider(JSlider.HORIZONTAL, 12, 20, 20);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.setBorder(BorderFactory.createTitledBorder("Travel Speed"));
        sliderPanel.add(slider, BorderLayout.NORTH);
        optionPanel.add(sliderPanel);

        consumptionPanel = new JPanel(new GridLayout(3, 1));
        consumptionPanel.setBorder(BorderFactory.createTitledBorder("Food Consumption"));
        meagerBtn = new JRadioButton("Meager");
        bareBonesBtn = new JRadioButton("Bare-Bones");
        fillingBtn = new JRadioButton("Filling");
        fillingBtn.setSelected(true);
        buttonGroup.add(meagerBtn);
        buttonGroup.add(bareBonesBtn);
        buttonGroup.add(fillingBtn);
        consumptionPanel.add(meagerBtn);
        consumptionPanel.add(bareBonesBtn);
        consumptionPanel.add(fillingBtn);
        optionPanel.add(consumptionPanel);

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_I) {
                    display.showTravelScreen(locations);
                } else {
                    System.out.println((char) e.getKeyCode());
                }
            }
        });
    }

    @Override
    public void resizeImages() {
        // TODO: Implement resizing of images
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
