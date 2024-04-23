package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Stuff.Locations;
import Stuff.PicPanel;
import Stuff.River;
import Stuff.Display;

import java.awt.BorderLayout;

public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images/river screen0.jpg"));
    private Display display;    
    private Locations location;
    private int height = 10;
    private int flow = 10;
    private int width = 50;

    public RiverScreen(Locations location) {
        viewPanel.setLayout(new BorderLayout());
        JButton crossBtn = new JButton("Cross");
        crossBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the current location from the Locations object
                String currentLocation = location.getRiverName();
                // Create a river object with the current location
                River river = new River(currentLocation, height, flow, width);

                // Attempt to cross the river
                if (river.crossRiver()) {
                    JOptionPane.showMessageDialog(null, "Successfully crossed the " + river.getName() + " river");
                    display.showTravelScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "You did not cross the " + river.getName() + " river");
                    JOptionPane.showMessageDialog(null, "You Died!");
                    System.exit(0);
                }
            }
        });
        viewPanel.add(crossBtn, BorderLayout.SOUTH);
        this.location = location;
        initialize();
    }

    @Override
    protected void initialize() {
        // Implement if needed
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
}
