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

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    private double money;
    private int instructionScreen = 0;

    private JLabel infoLbl;

    public BeforeLeaving(Wagon wagon, Display display, TrailScreen trailScreen) {
        this.wagon = wagon;
        this.display = display;
        this.trailScreen = trailScreen;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0,1.0};
        viewPanel.setLayout(gbl_viewPanel);

        infoLbl = new JLabel("<html><center>Before leaving Independence you should buy equipment and supplies. You have $" + (int) money + " in cash, but you don't have to spend it all now.<html>");
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
                    switchLabel();
                }
            }
        });
        
    }

    private void getMoney(){
        String selectedOption = trailScreen.setChoice();
        if(selectedOption == "1. Be a Doctor from Dayton") {
            wagon.getInventory().setMoney(1600);
            money = wagon.getInventory().getMoney();
        }
        else if(selectedOption == "2. Be a Homesteader from Hamden"){
            wagon.getInventory().setMoney(800);
            money = wagon.getInventory().getMoney();
        }
        else if(selectedOption == "3. Be a Teacher from Toledo"){
            wagon.getInventory().setMoney(400);
            money = wagon.getInventory().getMoney();
        }
    }

    public void updateLabel(){
        getMoney();
        infoLbl.setText("<html><center>Before leaving Independence you should buy equipment and supplies. You have $" + (int) money + " in cash, but you don't have to spend it all now.<html>");
    }

    private void switchLabel() {
        switch (instructionScreen) {
            case 0:
                infoLbl.setText("<html><center>You can buy whatever you need at Matt's General Store.</html>");
                instructionScreen++;
                break;
            case 1:
                infoLbl.setText("<html><center>Hello, I'm Mat. So you're going to Oregon? I can fix you up with what you need<bk><bk>- a team of oxen to pull your wagon<bk>- clothing for both summer and winter<html>");
                instructionScreen++;
                break;
            case 2:
                infoLbl.setText("<html><center>Hello, I'm Mat. So you're going to Oregon? I can fix you up with what you need<bk><bk>- plenty of food for the trip<bk>- ammunition for your rifles<bk>- spare parts for your wagon<html>");
                instructionScreen++;
                break;
            case 3:
                display.showMattsStore(wagon);
                break;
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
