package StartScreen;

import javax.imageio.ImageIO;
import javax.swing.*;

import Gameplay.*;
import Hunting.*;
import Screens.*;
import StartScreen.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WagonNames extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	private static final int TEXT_FIELD_MAX = 20;
    private Display display;
    private Wagon wagon;
    private WagonLeader wagonLeader;

	private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);
	private JTextField textField;
	private JTextField name2TextField;
	private JTextField name3TextField;
	private JTextField name4TextField;
    private JTextField name5TextField;
    private JLabel num1Lbl;
    private JLabel name1Lbl;

    public WagonNames(Wagon wagon, Display display, WagonLeader wagonLeader) {
        this.wagon = wagon;
        this.display = display;
        this.wagonLeader = wagonLeader;
        initialize();
    }

    /**
     * @wbp.parser.entryPoint
     */
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0, 1.0};
        viewPanel.setLayout(gbl_viewPanel);
        
        JLabel titleLbl = new JLabel("<html>What are the first names of the four other members in your party?");
        GridBagConstraints gbc_titleLbl = new GridBagConstraints();
        gbc_titleLbl.insets = new Insets(0, 0, 5, 0);
        gbc_titleLbl.gridx = 1;
        gbc_titleLbl.gridy = 0;
        viewPanel.add(titleLbl, gbc_titleLbl);
        
        num1Lbl = new JLabel("1. ");
        GridBagConstraints gbc_num1Lbl = new GridBagConstraints();
        gbc_num1Lbl.anchor = GridBagConstraints.EAST;
        gbc_num1Lbl.insets = new Insets(0, 0, 5, 5);
        gbc_num1Lbl.gridx = 0;
        gbc_num1Lbl.gridy = 1;
        viewPanel.add(num1Lbl, gbc_num1Lbl);

        name1Lbl = new JLabel("");
        GridBagConstraints gbc_name1Lbl = new GridBagConstraints();
        gbc_name1Lbl.anchor = GridBagConstraints.EAST;
        gbc_name1Lbl.insets = new Insets(0, 0, 5, 5);
        gbc_name1Lbl.gridx = 1;
        gbc_name1Lbl.gridy = 1;
        viewPanel.add(name1Lbl, gbc_name1Lbl);
        
        JLabel name2Lbl = new JLabel("2. ");
        GridBagConstraints gbc_name2Lbl = new GridBagConstraints();
        gbc_name2Lbl.anchor = GridBagConstraints.EAST;
        gbc_name2Lbl.insets = new Insets(0, 0, 5, 5);
        gbc_name2Lbl.gridx = 0;
        gbc_name2Lbl.gridy = 2;
        viewPanel.add(name2Lbl, gbc_name2Lbl);
        
        name2TextField = new JTextField();
        GridBagConstraints gbc_name2TextField = new GridBagConstraints();
        gbc_name2TextField.insets = new Insets(0, 0, 5, 0);
        gbc_name2TextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_name2TextField.gridx = 1;
        gbc_name2TextField.gridy = 2;
        viewPanel.add(name2TextField, gbc_name2TextField);
        name2TextField.setColumns(10);
        
        name2TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name2TextField.getText();
                if (!name.isEmpty()) {
                    // Remove the JTextField
                    viewPanel.remove(name2TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints();
                    gbc_nameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 2;
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name3TextField
        JLabel name3Lbl = new JLabel("3. ");
        GridBagConstraints gbc_name3Lbl = new GridBagConstraints();
        gbc_name3Lbl.anchor = GridBagConstraints.EAST;
        gbc_name3Lbl.insets = new Insets(0, 0, 5, 5);
        gbc_name3Lbl.gridx = 0;
        gbc_name3Lbl.gridy = 3;
        viewPanel.add(name3Lbl, gbc_name3Lbl);
        
        name3TextField = new JTextField();
        GridBagConstraints gbc_name3TextField = new GridBagConstraints();
        gbc_name3TextField.insets = new Insets(0, 0, 5, 0);
        gbc_name3TextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_name3TextField.gridx = 1;
        gbc_name3TextField.gridy = 3;
        viewPanel.add(name3TextField, gbc_name3TextField);
        name3TextField.setColumns(10);
        
        name3TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name3TextField.getText();
                if (!name.isEmpty()) {
                    // Remove the JTextField
                    viewPanel.remove(name3TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints();
                    gbc_nameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 3;
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name4TextField
        JLabel name4Lbl = new JLabel(wagonLeader.getName1());
        GridBagConstraints gbc_name4Lbl = new GridBagConstraints();
        gbc_name4Lbl.anchor = GridBagConstraints.EAST;
        gbc_name4Lbl.insets = new Insets(0, 0, 0, 5);
        gbc_name4Lbl.gridx = 0;
        gbc_name4Lbl.gridy = 4;
        viewPanel.add(name4Lbl, gbc_name4Lbl);
        
        name4TextField = new JTextField();
        GridBagConstraints gbc_name4TextField = new GridBagConstraints();
        gbc_name4TextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_name4TextField.gridx = 1;
        gbc_name4TextField.gridy = 4;
        viewPanel.add(name4TextField, gbc_name4TextField);
        name4TextField.setColumns(10);

        name4TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name4TextField.getText();
                if (!name.isEmpty()) {
                    // Remove the JTextField
                    viewPanel.remove(name4TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints();
                    gbc_nameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nameLabel.insets = new Insets(0, 0, 0, 5);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 4;
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        // Repeat the same process for name5TextField
        JLabel name5Lbl = new JLabel("5. ");
        GridBagConstraints gbc_name5Lbl = new GridBagConstraints();
        gbc_name5Lbl.anchor = GridBagConstraints.EAST;
        gbc_name5Lbl.insets = new Insets(0, 0, 0, 5);
        gbc_name5Lbl.gridx = 0;
        gbc_name5Lbl.gridy = 5;
        viewPanel.add(name5Lbl, gbc_name5Lbl);
        
        name5TextField = new JTextField();
        GridBagConstraints gbc_name5TextField = new GridBagConstraints();
        gbc_name5TextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_name5TextField.gridx = 1;
        gbc_name5TextField.gridy = 5;
        viewPanel.add(name5TextField, gbc_name5TextField);
        name5TextField.setColumns(10);

        name5TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name5TextField.getText();
                if (!name.isEmpty()) {
                    // Remove the JTextField
                    viewPanel.remove(name5TextField);
                    // Create a JLabel with the entered name
                    JLabel nameLabel = new JLabel("" + name);
                    GridBagConstraints gbc_nameLabel = new GridBagConstraints();
                    gbc_nameLabel.anchor = GridBagConstraints.WEST;
                    gbc_nameLabel.insets = new Insets(0, 0, 0, 5);
                    gbc_nameLabel.gridx = 1;
                    gbc_nameLabel.gridy = 5;
                    viewPanel.add(nameLabel, gbc_nameLabel); // Add the JLabel
                    // Revalidate and repaint the panel
                    viewPanel.revalidate();
                    viewPanel.repaint();
                }
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
    }

    public void updateName1(String name) {
        if (name != null && !name.isEmpty()) {
            name1Lbl.setText(name);
        }
    }

    @Override
	public void resizeImages() {
		// TODO Auto-generated method stub
        viewPanel.resizeImage();
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return viewPanel;
	}
}
