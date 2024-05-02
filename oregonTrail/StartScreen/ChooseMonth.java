package StartScreen;

import javax.imageio.ImageIO;
import javax.swing.*;

import Gameplay.*;
import Hunting.*;
import Screens.*;
import StartScreen.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMonth extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	private static final int TEXT_FIELD_MAX = 20;
    private Wagon wagon;
    private Display display;

    private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    public ChooseMonth(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0, 1.0};
        viewPanel.setLayout(gbl_viewPanel);

        JLabel chooseMonthLbl = new JLabel("<html>It is 1848. Your jumping off place for Oregon is Independence, Missouri. You must decide which month to leave Independence.");
        GridBagConstraints gbc_chooseMonthLbl = new GridBagConstraints();
        gbc_chooseMonthLbl.anchor = GridBagConstraints.CENTER;
        gbc_chooseMonthLbl.insets = new Insets(0,100,0,100);
        gbc_chooseMonthLbl.gridx = 1;
        gbc_chooseMonthLbl.gridy = 0;
        gbc_chooseMonthLbl.fill = GridBagConstraints.HORIZONTAL;
        chooseMonthLbl.setFont(titleFont);
        chooseMonthLbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(chooseMonthLbl, gbc_chooseMonthLbl);


        JComboBox<String> comboBox = new JComboBox<>();
        GridBagConstraints gbc_ComboBox = new GridBagConstraints();
        gbc_ComboBox.anchor = GridBagConstraints.CENTER;
        gbc_ComboBox.insets = new Insets(0,0,5,0);
        gbc_ComboBox.gridx = 1;
        gbc_ComboBox.gridy = 1;
        comboBox.addItem("1. March");
        comboBox.addItem("2. April");
        comboBox.addItem("3. May");
        comboBox.addItem("4. June");
        comboBox.addItem("5. July");
        comboBox.addItem("6. Ask For Advice");
        viewPanel.add(comboBox, gbc_ComboBox);

        comboBox.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
        	JComboBox<String> combo = (JComboBox<String>) e.getSource();
        	String selectedOption = (String) combo.getSelectedItem();
        	// Check which item is selected and perform action accordingly
        		switch (selectedOption) {
            		case "1. March":
                    case "2. April":
                    case "3. May":
                    case "4. June":
                    case "5. July":
                		display.showStoreScreen();
                		break;
            		case "6. Ask For Advice":
               			display.showLearnTrail(wagon);
                		break;
        		}
    		}
		});

        JLabel choiceLbl = new JLabel("What is Your Choice?");
        GridBagConstraints gbc_choiceLbl = new GridBagConstraints();
        gbc_choiceLbl.anchor = GridBagConstraints.CENTER;
        gbc_choiceLbl.insets = new Insets(0,0,5,0);
        gbc_choiceLbl.gridx = 1;
        gbc_choiceLbl.gridy = 4;
        choiceLbl.setFont(smallFont);
        choiceLbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(choiceLbl, gbc_choiceLbl);
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
