package StartScreen;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Gameplay.*;
import Screens.*;

import java.awt.BorderLayout;
import java.awt.Color;

public class LearnTrail extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
    private JLabel infoLbl = new JLabel(
            "<html>Try taking a journey by convered wagon across 2000 miles of plains, rivers, and mountains. Try! On the plains, you will slosh your oxen through mud and water-filled ruts or will you plod through dust six inches deep?");

    int instructionScreen = 0;

    private Wagon wagon;
    private Display display;

    private Font titleFont = new Font("Trajan Pro", Font.PLAIN, 24);
    private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    /**
     * Create the application.
     */
    public LearnTrail(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        viewPanel.setLayout(new BorderLayout(0, 0));

        JLabel titleLbl = new JLabel("The Oregon Trail");
        titleLbl.setForeground(new Color(93, 199, 255));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(titleLbl, BorderLayout.NORTH);
        titleLbl.setFont(titleFont);

        infoLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(infoLbl, BorderLayout.CENTER);
        infoLbl.setForeground(new Color(93, 199, 255));
        infoLbl.setFont(smallFont);

        JLabel continueLbl = new JLabel("Press Space To Continue");
        continueLbl.setForeground(new Color(93, 199, 255));
        continueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        viewPanel.add(continueLbl, BorderLayout.SOUTH);
        continueLbl.setFont(smallFont);

        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();

        System.out.println("Init ran");
        System.out.println(viewPanel.isFocusOwner());

        viewPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int vk = e.getKeyCode();
                if (vk == KeyEvent.VK_SPACE) {
                    System.out.println("key event made");
                    switchLabel();
                }
            }
        });
        
    }

    private void switchLabel() {
        switch (instructionScreen) {
            case 0:
                infoLbl.setText("<html>How will you corss the river? if you have money, you might take a ferry (if there is a ferry). Or, you can ford the river and hope you and your wagon aren't swallowed alive!");
                instructionScreen++;
                break;
            case 1:
                infoLbl.setText("<html>What about supplies? Well, if you're low on food you can forage. You might get a berry... you might. And there are potatoes in the mountains.");
                instructionScreen++;
                break;
            case 2:
                infoLbl.setText("<html>At the Dalles, you can try navigating the Columbia River, but if running the rapids with a makeshift raft makes you queasy, better take the Barlow Road.");
                instructionScreen++;
                break;
            case 3:
                infoLbl.setText("<html>If for some reason you don't survive -- your wagon burns, or thieves steal your oxen, or you run out of provisions, or you die of cholera -- don't give up! Try again... and again... until your name is up with the others on the The Oregon Top Ten.");
                instructionScreen++;
                break;
            case 4:
                infoLbl.setText("<html>M Key -- You may want to see your progess on the map. By pressing M, you can view where you are on the map.");
                instructionScreen++;
                break;
            case 5:
                infoLbl.setText("<html>I Key -- You may want to check your inventory progress, change your speed, or check out how many miles you have left. By pressing I, you can view the Control Screen, that shows you the: Inventory, Speed, and Miles Remaining");
                instructionScreen++;
                break;
            case 6:
                infoLbl.setText("<html>Esc Key -- You may want to quit in the middle of the program. If so, press the Escape (Esc) key twice whenever the computer is waiting for a response.");
                instructionScreen++;
                break;
            case 7:
                infoLbl.setText("<html><center>The software team responsible for the creation of this product includes:<br>Ethan Burch<br>Quinton Fesq<br>Madison Scott<br>Lane Kanagy</html>");
                instructionScreen++;
                break;
            case 8:
                instructionScreen = 0;
                display.showTheOregonTrail(wagon);
                break;
        }
        System.out.println(instructionScreen);
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