package Hunting;

public class Hunter {
    private int colIndex;
    private int rowIndex;
    private int direction;
    public static final int NOT_MOVING = 0;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static final int LEFT = 4;



    public Hunter(int colIndex, int rowIndex, int direction){
        this.colIndex = colIndex;
        this.rowIndex = rowIndex;
        this.direction = direction;
    }

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
