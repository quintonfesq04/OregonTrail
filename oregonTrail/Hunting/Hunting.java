package Hunting;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Hunting extends JFrame{
    HuntingMap huntingMap = new HuntingMap();
    HuntingScreen huntingScreen = new HuntingScreen();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Hunting window = new Hunting();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Hunting(){
        init();
    }

    private void init(){
        this.setLayout(null);
        this.add(huntingScreen);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }
}
