package Hunting;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Stuff.PicPanel;

public class HuntingMap extends JPanel{
    private static final int MAP_ROWS = 24;
    private static final int MAP_COL = 17;
    private char map[][]= {
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
        {'w','w','w','w','p','w','p','p','p','p','p','w','p','w','w','w','w'},
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
                if(map[i][j] == 'w'){
                    panels[i][j].setBackground(Color.BLUE);
                }
                else if(map[i][j] == 'p'){
                    panels[i][j].setBackground(Color.BLACK);
                }
                else if(map[i][j] == 'g'){
                    panels[i][j].setBackground(Color.GRAY);
                }
                else if(map[i][j] == 'h'){
                    panels[i][j].setBackground(Color.YELLOW);
                }
                this.add(panels[i][j]);
                
            }
        }
    }

    public char[][] getMap(){
        return map;
    }

    public void setMap(char[][] map){
        this.map = map;
    }
}
