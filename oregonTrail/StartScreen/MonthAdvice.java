package StartScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Gameplay.Display;
import Gameplay.PicPanel;
import Gameplay.Wagon;
import Screens.AbstractScreen;

/**
 * MonthAdvice.java -- Provides the user with an HTML text that informs the user which money they should select
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class MonthAdvice extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Wagon wagon;
    private Display display;
    private ChooseMonth chooseMonth;
    
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    /**
     * Constructor for the MonthAdvice object
     * 
     * @param wagon
     * @param display
     * @param chooseMonth
     */
    public MonthAdvice(Wagon wagon, Display display, ChooseMonth chooseMonth) {
        this.wagon = wagon;
        this.display = display;
        this.chooseMonth = chooseMonth;
        initialize();
    }

    /**
     * Initializes the MonthAdvice constructor
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);

        JLabel infoLbl = new JLabel(
                "<html><center>You attend a public meeting held for 'women - with the California - Oregon fever.' You're told:<br><br>If you leave too early, there won't be any grass for your oxen to eat. If you leave too late, you may not get to Oregon before winter comes. If you leave at just the right time, there will be green grass and the weather will still be cool.");
        GridBagConstraints gbc_infoLbl = new GridBagConstraints();
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100);
        gbc_infoLbl.gridx = 1;
        gbc_infoLbl.gridy = 1;
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL;
        gbc_infoLbl.insets = new Insets(0, 100, 0, 100);
        infoLbl.setForeground(new Color(93, 199, 255));
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoLbl.setFont(smallFont);
        viewPanel.add(infoLbl, gbc_infoLbl);

        JLabel continueLbl = new JLabel("Press Space To Continue");
        GridBagConstraints gbc_continueLbl = new GridBagConstraints();
        gbc_continueLbl.insets = new Insets(50, 0, 5, 0);
        gbc_continueLbl.gridx = 1;
        gbc_continueLbl.gridy = 4;
        continueLbl.setForeground(new Color(93, 199, 255));
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(continueLbl, gbc_continueLbl);
        continueLbl.setFont(smallFont);

        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    display.showChooseMonth(wagon);
                    chooseMonth.resetScreen();
                }
            }
        });
    }

    /**
     * resizes all images through AbstractScreen
     */
    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        viewPanel.resizeImage();

    }

    /**
     * receive the JPanel created
     * 
     * @return the viewPanel
     */
    @Override
    public JPanel getPanel() {
        // TODO Auto-generated method stub
        return viewPanel;
    }
}