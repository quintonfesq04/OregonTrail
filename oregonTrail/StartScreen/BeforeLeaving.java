package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.Color;

public class BeforeLeaving extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));

    private Wagon wagon;
    private Display display;
    private TrailScreen trailScreen;
    private Inventory inventory;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    private double money;

    public BeforeLeaving(Wagon wagon, Display display, TrailScreen trailScreen, Inventory inventory) {
        this.wagon = wagon;
        this.display = display;
        this.trailScreen = trailScreen;
        getMoney();
        this.inventory = inventory;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0,1.0};
        viewPanel.setLayout(gbl_viewPanel);

        JLabel infoLbl = new JLabel("<htm><center>Before leaving Independence you should buy equipment and supplies. You have $" + (int) money + " in cash, but you don't have to spend it all now.<html>");
        GridBagConstraints gbc_infoLbl = new GridBagConstraints();
        gbc_infoLbl.insets = new Insets(0,100,0,100);
        gbc_infoLbl.gridx = 1;
        gbc_infoLbl.gridy = 1;
        gbc_infoLbl.fill = GridBagConstraints.HORIZONTAL;
        gbc_infoLbl.insets = new Insets(0,100,0,100);
        infoLbl.setForeground(new Color(93, 199, 255));
        infoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoLbl.setFont(smallFont);
        viewPanel.add(infoLbl, gbc_infoLbl);

        JLabel continueLbl = new JLabel("Press Space To Continue");
        GridBagConstraints gbc_continueLbl = new GridBagConstraints();
        gbc_continueLbl.insets = new Insets(50,0,5,0);
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
                    display.showStoreScreen();
                    trailScreen.resetScreen();
                }
            }
        });
    }

    private void getMoney(){
        String selectedOption = trailScreen.setChoice();
        if(selectedOption == "1. Be a Doctor from Dayton") {
            inventory.setMoney(1600);
            money = inventory.getMoney();
        }
        else if(selectedOption == "2. Be a Homesteader from Hamden"){
            inventory.setMoney(800);
            money = inventory.getMoney();
        }
        else if(selectedOption == "3. Be a Teacher from Toledo"){
            inventory.setMoney(300);
            money = inventory.getMoney();
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
