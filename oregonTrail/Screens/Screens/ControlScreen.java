package Screens;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import Gameplay.*;

public class ControlScreen extends AbstractScreen {
    private JPanel panel;
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
    
    private Font labelFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font sliderFont = new Font("Trajan Pro", Font.PLAIN, 16);
    private JPanel sliderPanel;
    private JPanel consumptionPanel;
    private JRadioButton meagerBtn;
    private JRadioButton bareBonesBtn;
    private JRadioButton fillingBtn;
    private JSlider slider;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public ControlScreen(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    protected void initialize() {
        panel = new JPanel(new GridLayout());

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
        slider.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                wagon.getPlayer().setTravelSpeed(slider.getValue());
                panel.requestFocusInWindow();
            }
            
        });
        sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.setBorder(BorderFactory.createTitledBorder("Travel Speed"));
        sliderPanel.add(slider, BorderLayout.NORTH);
        sliderPanel.setFont(sliderFont);
        optionPanel.add(sliderPanel);

        consumptionPanel = new JPanel(new GridLayout(3, 1));
        consumptionPanel.setBorder(BorderFactory.createTitledBorder("Food Consumption"));
        bareBonesBtn = new JRadioButton("Bare-Bones");
        meagerBtn = new JRadioButton("Meager");
        fillingBtn = new JRadioButton("Filling");
        fillingBtn.setSelected(true);
        buttonGroup.add(bareBonesBtn);
        buttonGroup.add(meagerBtn);
        buttonGroup.add(fillingBtn);
        consumptionPanel.add(bareBonesBtn);
        consumptionPanel.add(meagerBtn);
        consumptionPanel.add(fillingBtn);
        meagerBtn.setFont(sliderFont);
        bareBonesBtn.setFont(sliderFont);
        fillingBtn.setFont(sliderFont);
        optionPanel.add(consumptionPanel);

        
        ActionListener radioListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.requestFocusInWindow();
                if(e.getSource() instanceof JRadioButton){
                    if(e.getSource() == bareBonesBtn){
                        wagon.getPlayer().setConsumption(Player.BARE_BONES);
                    }
                    else if (e.getSource() == fillingBtn){
                        wagon.getPlayer().setConsumption(Player.FILLING);
                    }
                    else if(e.getSource() == meagerBtn){
                        wagon.getPlayer().setConsumption(Player.MEAGER);
                    }
                }
            }
            
        };

        fillingBtn.addActionListener(radioListener);
        meagerBtn.addActionListener(radioListener);
        bareBonesBtn.addActionListener(radioListener);
        

        panel.addKeyListener(new KeyAdapter() {
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

    public void updateDisplay(){
        moneyLbl.setText("Money:" + wagon.getInventory().getMoney());
        oxenLbl.setText("Oxen:" + wagon.getInventory().getOxen());
        foodLbl.setText("Food:" + wagon.getInventory().getFood());
        clothesLbl.setText("Clothes:" + wagon.getInventory().getClothing());
        ammoLbl.setText("Ammo:" + wagon.getInventory().getBullets());
        wheelLbl.setText("Wagon Wheels:" + wagon.getInventory().getWagonWheel());
        axleLbl.setText("Wagon Axles:" + wagon.getInventory().getWagonAxle());
        tongueLbl.setText("Wagon Tongues:" + wagon.getInventory().getWagonTongue());
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
