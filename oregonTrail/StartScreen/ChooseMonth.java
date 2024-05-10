package StartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * ChooseMonth.java -- Provides the user with a combo box with the available
 * months that they can leave in
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class ChooseMonth extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
    private static final int TEXT_FIELD_MAX = 20;
    private Wagon wagon;
    private Display display;

    private JPanel panel;
    private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    /**
     * Constructor for the ChooseMonth object
     * 
     * @param wagon
     * @param display
     */
    public ChooseMonth(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    /**
     * initializes the ChooseMonth Display
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel chooseMonthLbl = new JLabel(
                "<html>It is 1848. Your jumping off place for Oregon is Independence, Missouri. You must decide which month to leave Independence.");
        GridBagConstraints gbc_chooseMonthLbl = new GridBagConstraints();
        gbc_chooseMonthLbl.anchor = GridBagConstraints.CENTER;
        gbc_chooseMonthLbl.insets = new Insets(0, 100, 25, 100);
        gbc_chooseMonthLbl.gridx = 1;
        gbc_chooseMonthLbl.gridy = 0;
        gbc_chooseMonthLbl.fill = GridBagConstraints.HORIZONTAL;
        chooseMonthLbl.setFont(titleFont);
        chooseMonthLbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(chooseMonthLbl, gbc_chooseMonthLbl);

        JComboBox<String> comboBox = new JComboBox<>();
        GridBagConstraints gbc_ComboBox = new GridBagConstraints();
        gbc_ComboBox.anchor = GridBagConstraints.CENTER;
        gbc_ComboBox.insets = new Insets(0, 0, 5, 0);
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
                        display.showBeforeLeaving(wagon);
                        break;
                    case "6. Ask For Advice":
                        display.showMonthAdvice(wagon);
                        break;
                }
            }
        });

        JLabel choiceLbl = new JLabel("What is Your Choice?");
        GridBagConstraints gbc_choiceLbl = new GridBagConstraints();
        gbc_choiceLbl.anchor = GridBagConstraints.CENTER;
        gbc_choiceLbl.insets = new Insets(15, 0, 5, 0);
        gbc_choiceLbl.gridx = 1;
        gbc_choiceLbl.gridy = 4;
        choiceLbl.setFont(smallFont);
        choiceLbl.setForeground(new Color(93, 199, 255));
        viewPanel.add(choiceLbl, gbc_choiceLbl);
    }

    /**
     * Resets the items within the screen when the user reopens the game
     */
    public void resetScreen() {
        viewPanel.removeAll();
        // add your elements
        viewPanel.revalidate();
        viewPanel.repaint();
        display.showChooseMonth(wagon);
        initialize();
    }

    /**
     * resizes all images through AbstractScreen
     */
    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    /**
     * receive the JPanel created
     * 
     * @return the viewPanel
     */
    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

}