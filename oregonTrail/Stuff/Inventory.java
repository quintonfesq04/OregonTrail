package Stuff;

/**
 * @File Inventory.java
 * @author Quinton Fesq
 * @version 1.5.2 4/17/24
 * Creates the inventory for the journey along the oregon trail
 */
public class Inventory {
    private int food = 0;
    private int oxen = 0;
    private int money = 0;
    private int wagonWheel = 0;
    private int wagonTongue = 0; 
    private int wagonAxle = 0;
    private int bullets = 0; 
    private int clothing = 0;

    public void setFood(int number){
        this.food = number;
    }

    public void setOxen(int number){
        this.oxen = number;
    }
    
    public void setMoney(int number){
        this.money = number;
    }

    public void setWagonWheel(int number){
        this.wagonWheel = number;
    }

    public void setWagonTongue(int number){
        this.wagonTongue = number;
    }

    public void setWagonAxle(int number){
        this.wagonAxle = number;
    }

    public void setBullets(int number){
        this.bullets = number;
    }

    public void setClothing(int number){
        this.clothing = number; 
    }

    public int getFood(){
        return this.food;
    }

    public int getOxen(){
        return this.oxen;
    }

    public int getMoney(){
        return this.money;
    }

    public int getWagonWheel(){
        return this.wagonWheel;
    }

    public int getWagonTongue(){
        return this.wagonTongue;
    }

    public int getWagonAxle(){
        return this.wagonAxle;
    }

    public int getBullets(){
        return this.bullets;
    }

    public int getClothing(){
        return this.clothing;
    }

}