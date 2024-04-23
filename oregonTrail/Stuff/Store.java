package Stuff;

import javax.swing.JOptionPane;

public class Store {
    private double foodPricePerPound;
    private double oxenPrice;
    private double clothingPrice;
    private double bulletsPrice;
    private double wagonWheelPrice;
    private double wagonAxlePrice;
    private double wagonTonguePrice;
    private double totalCost;
    private int maxFood;
    private int maxOxen;
    private int maxClothing;
    private int maxBullets;
    private int maxWagonWheels;
    private int maxWagonAxles;
    private int maxWagonTongues;

   private int foodQuantity;
   private int oxenQuantity;
   private int clothingQuantity;
   private int bulletQuantity;
   private int wagonWheelQuantity;
   private int wagonAxleQuantity;
   private int wagonTongueQuantity;

    
    public Store(){
        foodPricePerPound = 0.20;
        oxenPrice = 40.0;
        clothingPrice = 10.0;
        bulletsPrice = 2.0;
        wagonWheelPrice = 10.0;       
        wagonAxlePrice = 10.0;
        wagonTonguePrice = 10.0;

        maxFood = 2000;
        maxOxen = 20;
        maxClothing = 99;
        maxBullets = 99;
        maxWagonWheels = 3;
        maxWagonAxles = 3;
        maxWagonTongues = 3;

       
    }

    public void resetQuantity(){
        foodQuantity = 0;
        oxenQuantity = 0;
        clothingQuantity = 0;
        bulletQuantity = 0;
        wagonWheelQuantity = 0;
        wagonAxleQuantity = 0;
        wagonTongueQuantity = 0;
    }

    public void updateCost(String item,int quantity){
        switch(item){
        case Inventory.FOOD:
            foodQuantity = quantity;
            totalCost += foodPricePerPound * quantity;
            break;
        case Inventory.OXEN:
            oxenQuantity = quantity;
            totalCost += oxenPrice;
            break;
        case Inventory.CLOTHING:
            clothingQuantity = quantity;
            totalCost += clothingPrice;
            break;
        case Inventory.BULLETS:
            bulletQuantity = quantity;
            totalCost += bulletsPrice;
            break;
        case Inventory.WAGON_WHEEL:
            wagonWheelQuantity = quantity;
            totalCost += wagonWheelPrice;
            break;
        case Inventory.WAGON_AXLE:
            wagonAxleQuantity = quantity;
            totalCost += wagonAxlePrice;
            break;
        case Inventory.WAGON_TONGUE:
            wagonTongueQuantity = quantity;
            totalCost  += wagonTonguePrice;
            break;
        default:
            totalCost = -1;
            break;
        }
      
    }

    /**
     * @param inventory
     * @param quantity
     */
    public Inventory buyMethod(Inventory inventory){
        inventory.setMoney((int)(inventory.getMoney() - totalCost));
        inventory.setFood(inventory.getFood() + foodQuantity);
        inventory.setOxen(inventory.getOxen() + oxenQuantity);
        inventory.setClothing(inventory.getClothing() + clothingQuantity);
        inventory.setBullets(inventory.getBullets() + bulletQuantity);
        inventory.setWagonWheel(inventory.getWagonWheel() + wagonWheelQuantity);
        inventory.setWagonAxle(inventory.getWagonAxle() + wagonAxleQuantity);
        inventory.setWagonTongue(inventory.getWagonTongue() + wagonTongueQuantity);

        return inventory;
    }
  
    public boolean checkIfEnoughMoney(Inventory inventory){
       return (totalCost<= inventory.getMoney());
    }
    

    public double getCost(){
        return totalCost;
    }
}


