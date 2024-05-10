package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import Stuff.*;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.River;
import Gameplay.Wagon;

/**
 * RiverScreen.java -- Screen shows during river crossing
 * 
 * @author Ethan Burch
 * @author Quinton Fesq
 * @version 1.5.2 4/24/24
 */
public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images/River.jpg"));
    private JPanel panel = new JPanel();
    private Display display;
    private River river;
    private int height = 10;
    private int flow = 10;
    private int width = 50;
    private Wagon wagon;

    /**
     * constructor for RiverScreen object
     * 
     * @param display  the display that this will be used in
     * @param location the location of the player along the trail
     */
    public RiverScreen(Wagon wagon, Display display) {
        this.display = display;
        this.wagon = wagon;

        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        panel.add(buttonPanel);

        JLabel heightLbl = new JLabel("Height: " + height);
        heightLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(heightLbl);

        JLabel flowLbl = new JLabel("Flow: " + flow);
        flowLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(flowLbl);

        JLabel widthLbl = new JLabel("Width: " + width);
        widthLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(widthLbl);

        JButton btnNewButton = new JButton("Cross");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                river = new River(wagon.getLocations().getRiverName());
                boolean crossed = river.crossRiver();
                if (crossed) {
                    JOptionPane.showMessageDialog(null, "You Crossed " + river.getName());
                    display.showTravelScreen(wagon);
                } else {
                    JOptionPane.showMessageDialog(null, "You Did Not Cross " + river.getName());
                    display.showDeathScreen();
                }
            }
        });
        viewPanel.add(btnNewButton, BorderLayout.SOUTH);
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

    /**
     * updates the wagon within the class.
     * @param wagon
     */
    public void update(Wagon wagon) {
        this.wagon = wagon;
    }

}