package Screens;

import java.awt.Component;

import javax.swing.*;

public class WagonGameFrame extends JFrame {
    public WagonGameFrame() {
        setTitle("Wagon Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance of WagonGame
        WagonGame wagonGame = new WagonGame();
        
        // Add WagonGame to the frame
        setContentPane(wagonGame);

        
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void setContentPane(WagonGame wagonGame) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContentPane'");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WagonGameFrame();
        });
    }
}