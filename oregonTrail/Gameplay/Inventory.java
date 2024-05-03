package Gameplay;

/**
 * @File Inventory.java -- Creates the inventory for the journey along the oregon trail
 * @author Quinton Fesq
 * @author Ethan Burch
 * @version 1.5.2 4/17/24
 */

import Screens.*;
import Gameplay.*;
import Hunting.*;
import StartScreen.*;

public class Inventory {
    private BeforeLeaving beforeLeaving;

    private int food = 0;
    private int oxen = 0;
    private double money;
    private int wagonWheel = 0;
    private int wagonTongue = 0;
    private int wagonAxle = 0;
    private int bullets = 0;
    private int clothing = 0;

    public static final String FOOD = "food";
    public static final String OXEN = "oxen";
    public static final String MONEY = "money";
    public static final String WAGON_WHEEL = "wagon wheel";
    public static final String WAGON_TONGUE = "wagon tongue";
    public static final String WAGON_AXLE = "wagon axle";
    public static final String BULLETS = "bullets";
    public static final String CLOTHING = "clothing";

    public static final String itemNames[] = { "food", "oxen", "money", "wagon wheel",
                                            "wagon tongue", "wagon axle", "bullets", "clothing"}; 

    private boolean oxenHealthy = true;

    public void setFood(int number) {
        this.food = number;
    }

    public void setOxen(int number) {
        this.oxen = number;
    }

    public void setMoney(int number) {
        this.money = number;
    }

    public void setWagonWheel(int number) {
        this.wagonWheel = number;
    }

    public void setWagonTongue(int number) {
        this.wagonTongue = number;
    }

    public void setWagonAxle(int number) {
        this.wagonAxle = number;
    }

    public void setBullets(int number) {
        this.bullets = number;
    }

    public void setClothing(int number) {
        this.clothing = number;
    }

    public int getFood() {
        return this.food;
    }

    public int getOxen() {
        return this.oxen;
    }

    public double getMoney() {
        return this.money;
    }

    public int getWagonWheel() {
        return this.wagonWheel;
    }

    public int getWagonTongue() {
        return this.wagonTongue;
    }

    public int getWagonAxle() {
        return this.wagonAxle;
    }

    public int getBullets() {
        return this.bullets;
    }

    public int getClothing() {
        return this.clothing;
    }

    public boolean getOxenHealthy(){
        return oxenHealthy;
    }

    public void setOxenHealthy(boolean oxenHealthy){
        this.oxenHealthy = oxenHealthy;
    }

    public int getItemCount(String item) {
        if (item == FOOD) {
            return getFood();
        } else if (item == OXEN) {
            return getOxen();
        } else if (item == WAGON_AXLE) {
            return getWagonAxle();
        } else if (item == WAGON_TONGUE) {
            return getWagonTongue();
        } else if (item == WAGON_WHEEL) {
            return getWagonWheel();
        } else if (item == BULLETS) {
            return getBullets();
        } else if (item == CLOTHING) {
            return getClothing();
        } else
            return -1;

    }

    public void removeItem(String item, int number) {
        if (item == FOOD) {
            setFood(getFood() - number);
        } else if (item == OXEN) {
            setOxen(getOxen() - number);
        } else if (item == WAGON_AXLE) {
            setWagonAxle(getWagonAxle() - number);
        } else if (item == WAGON_TONGUE) {
            setWagonTongue(getWagonTongue() - number);
        } else if (item == WAGON_WHEEL) {
            setWagonWheel(getWagonWheel() - number);
        } else if (item == BULLETS) {
            setBullets(getBullets() - number);
        } else if (item == CLOTHING) {
            setClothing(getClothing() - number);
        }

    }

    public void addItem(String item, int number) {
        if (item == FOOD) {
            setFood(getFood() + number);
        } else if (item == OXEN) {
            setOxen(getOxen() + number);
        } else if (item == WAGON_AXLE) {
            setWagonAxle(getWagonAxle() + number);
        } else if (item == WAGON_TONGUE) {
            setWagonTongue(getWagonTongue() + number);
        } else if (item == WAGON_WHEEL) {
            setWagonWheel(getWagonWheel() + number);
        } else if (item == BULLETS) {
            setBullets(getBullets() + number);
        } else if (item == CLOTHING) {
            setClothing(getClothing() + number);
        }

    }

}