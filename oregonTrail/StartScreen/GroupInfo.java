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
 * GroupInfo.java -- Provides the user with HTML text that tell the user what each role provides them
 * 
 * @author Quinton Fesq
 * @version 1.0.0 05/02/2024
 */
public class GroupInfo extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    JLabel infoLbl = new JLabel(
            "<html><center>Traveling to Oregon isn't easy! But if you're a doctor, you'll have a less chance of dying than a homesteader or a teacher.");

    int instructionScreen = 0;

    private Wagon wagon;
    private Display display;
    private TrailScreen trailScreen;

    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    /**
     * Constructor for the GroupInfo object
     * 
     * @param wagon
     * @param display
     * @param trailScreen
     */
    public GroupInfo(Wagon wagon, Display display, TrailScreen trailScreen) {
        this.wagon = wagon;
        this.display = display;
        this.trailScreen = trailScreen;
        initialize();
    }

    /**
     * Initializes the GroupInfo Display
     */
    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[] { 0.0, 1.0 };
        viewPanel.setLayout(gbl_viewPanel);

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
                    display.showTrailScreen(wagon);
                    trailScreen.resetScreen();
                }
            }
        });
    }

    /**
     * Resizes all images through AbstractScreen
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