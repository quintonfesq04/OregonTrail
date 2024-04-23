package Hunting;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Stuff.PicPanel;

public class HuntingMap extends JPanel{
    private static final int MAP_ROWS = 24;
    private static final int MAP_COL = 17;
    private static final char MAP[][]= {
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'},
        {'w','p','p','p','p','p','p','p','w','p','p','p','p','p','p','p','w'},
        {'w','p','w','w','p','w','w','p','w','p','w','w','p','w','w','p','w'},
        {'w','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','w'},
        {'w','p','w','w','p','w','p','w','w','w','p','w','p','w','w','p','w'},
        {'w','p','p','p','p','w','p','p','w','p','p','w','p','p','p','p','w'},
        {'w','w','w','w','p','w','w','p','w','p','w','w','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','p','p','p','p','w','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','w','g','w','p','w','p','w','w','w','w'},
        {'p','p','p','p','p','p','p','w','p','w','p','p','p','p','p','p','p'},
        {'w','w','w','w','p','w','p','w','w','w','p','w','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','p','h','p','p','w','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','w','w','w','p','w','p','w','w','w','w'},
        {'w','w','w','w','p','p','p','p','w','p','p','p','p','w','w','w','w'},
        {'w','w','w','w','p','w','w','p','w','p','w','w','p','w','w','w','w'},
        {'w','w','w','w','p','p','p','p','p','p','p','p','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','w','w','w','p','w','p','w','w','w','w'},
        {'w','w','w','w','p','w','p','p','w','p','p','w','p','w','w','w','w'},
        {'w','p','p','p','p','w','w','p','w','p','w','w','p','p','p','p','w'},
        {'w','p','w','w','p','w','w','p','p','p','w','w','p','w','w','p','w'},
        {'w','p','p','p','p','p','w','w','p','w','w','p','p','p','p','p','w'},
        {'w','p','w','w','w','p','w','w','p','w','w','p','w','w','w','p','w'},
        {'w','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','w'},
        {'w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w','w'}
    };

    
    public HuntingMap(){
        init();
    }

    private void init(){
        this.setLayout(new GridLayout(MAP_ROWS, MAP_COL));
        PicPanel panels[][] = new PicPanel[MAP_ROWS][MAP_COL];

        for(int i = 0; i < MAP_ROWS; i++){
            for(int j = 0; j < MAP_COL; j++){
                panels[i][j] = new PicPanel();
                if(MAP[i][j] == 'w'){
                    panels[i][j].setBackground(Color.BLUE);
                }
                else if(MAP[i][j] == 'p'){
                    panels[i][j].setBackground(Color.BLACK);
                }
                else if(MAP[i][j] == 'g'){
                    panels[i][j].setBackground(Color.GRAY);
                }
                else if(MAP[i][j] == 'h'){
                    panels[i][j].setBackground(Color.YELLOW);
                }
                this.add(panels[i][j]);
                
            }
        }
    }

}
