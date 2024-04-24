package Hunting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import Screens.*;
import Stuff.*;
import Hunting.*;

import javax.swing.JPanel;
import Screens.*;


import Stuff.*;

public class HuntingScreen extends JPanel{
    HuntingMap huntingMap = new HuntingMap();
    Hunter hunter = new Hunter(12,9,Hunter.NOT_MOVING);
    private Timer clock;


    public HuntingScreen(){
        initialize();
        clock = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                updateDisplay(evt); 
            }
        });
    }

    
    private void initialize() {
        
        add(huntingMap);
    }    

    private void updateDisplay(ActionEvent evt){
        char[][] mapCopy = huntingMap.getMap();
        mapCopy[hunter.getColIndex()][hunter.getRowIndex()] = 'p';
        //hunter.moveLeft();
        mapCopy[hunter.getColIndex()][hunter.getRowIndex()] = 'h';
        huntingMap.setMap(mapCopy);
        huntingMap.updateDisplay();
        add(huntingMap);
    }
}
