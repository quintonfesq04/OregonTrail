package Hunting;

public class LaneHunting {
    private int colIndex;
    private int rowIndex;
    private int direction;
    public static final int NOT_MOVING = 0;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;

    private static final char map[][]= {
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


    public int getColIndex(){
        return colIndex;
    }

    public int getRowIndex(){
        return rowIndex;
    }

    public void moveRight(){
        rowIndex++;
        direction = RIGHT;
    }

    public void moveLeft(){
        rowIndex--;
        direction = LEFT;
    }

    public void moveUp(){
        colIndex++;
        direction = UP;
    }

    public void moveDown(){
        colIndex--;
        direction = DOWN;
    }

    public int getDirection(){
        return direction;
    }
}
