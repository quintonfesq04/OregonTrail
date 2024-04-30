package Hunting;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;


public class HuntingScreen extends JPanel{
    HuntingMap huntingMap = new HuntingMap();
    Hunter hunter = new Hunter(12,9, Hunter.NOT_MOVING);


    public HuntingScreen(){
        initialize();
        Timer clock = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                updateDisplay(evt); 
            }
        });
        clock.start();
    }

    
    private void initialize() {
        setLayout(new BorderLayout());
        add(huntingMap);
    }    

    private void updateDisplay(ActionEvent evt){
        char[][] mapCopy = huntingMap.getMap();
        mapCopy[hunter.getColIndex()][hunter.getRowIndex()] = 'p';
        hunter.moveLeft();
        mapCopy[hunter.getColIndex()][hunter.getRowIndex()] = 'h';
        huntingMap.setMap(mapCopy);
        huntingMap.updateDisplay();
        System.out.println(hunter.getDirection());
        add(huntingMap);
    }
}
