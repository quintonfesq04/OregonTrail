package Stuff;

import java.text.DecimalFormat;
import Screens.*;
import Stuff.*;
import Hunting.*;
import javax.swing.JOptionPane;

/**
 * Store.java
 * @author Madison Scott 
 * @version 1.0.0 4/22/24
 * Store class handles the functionality related to purchasing items from the store.
 */

 public class Store {
    // Prices of various items
    private double foodPricePerPound;
    private double oxenPrice;
    private double clothingPrice;
    private double bulletsPrice;
    private double wagonWheelPrice;
    private double wagonAxlePrice;
    private double wagonTonguePrice;
   
    // Total cost of the purchase
    private double totalCost;
    
    // Individual costs of items
    private double foodCost;
    private double oxenCost;
    private double clothingCost;
    private double bulletCost;
    private double wagonWheelCost;
    private double wagonAxleCost;
    private double wagonTongueCost;

    // Quantities of items
    private int foodQuantity;
    private int oxenQuantity;
    private int clothingQuantity;
    private int bulletQuantity;
    private int wagonWheelQuantity;
    private int wagonAxleQuantity;
    private int wagonTongueQuantity;

    /**
     * Constructor initializes default prices for items.
     */
    public Store(){
        foodPricePerPound = 0.20;
        oxenPrice = 40.0;
        clothingPrice = 10.0;
        bulletsPrice = 2.0;
        wagonWheelPrice = 10.0;       
        wagonAxlePrice = 10.0;
        wagonTonguePrice = 10.0;
    }

    /**
     * Resets the quantity of items to zero.
     */
    public void resetQuantity(){
        foodQuantity = 0;
        oxenQuantity = 0;
        clothingQuantity = 0;
        bulletQuantity = 0;
        wagonWheelQuantity = 0;
        wagonAxleQuantity = 0;
        wagonTongueQuantity = 0;
    }

    /**
     * Updates the cost of the item based on its quantity.
     * 
     * @param item The item to update cost for.
     * @param quantity The quantity of the item.
     */
    public void updateCost(String item,int quantity){
        switch(item){
            case Inventory.FOOD:
                foodQuantity = quantity;
                foodCost = foodPricePerPound * quantity;
                break;
            case Inventory.OXEN:
                oxenQuantity = quantity;
                oxenCost = oxenPrice * quantity;
                break;
            case Inventory.CLOTHING:
                clothingQuantity = quantity;
                clothingCost = clothingPrice * quantity;
                break;
            case Inventory.BULLETS:
                bulletQuantity = quantity;
                bulletCost = bulletsPrice * quantity;
                break;
            case Inventory.WAGON_WHEEL:
                wagonWheelQuantity = quantity;
                wagonWheelCost = wagonWheelPrice * quantity;
                break;
            case Inventory.WAGON_AXLE:
                wagonAxleQuantity = quantity;
                wagonAxleCost = wagonAxlePrice * quantity;
                break;
            case Inventory.WAGON_TONGUE:
                wagonTongueQuantity = quantity;
                wagonTongueCost  = wagonTonguePrice * quantity;
                break;
            default:
                totalCost = -1; // Indicate error
                break;
        }  
    }

    /**
     * Calculates the total cost of the purchase.
     * 
     * @return The total cost of the purchase.
     */
    public double getCost(){
        totalCost = foodCost + oxenCost + clothingCost + bulletCost + wagonAxleCost + wagonTongueCost + wagonWheelCost;
        DecimalFormat df = new DecimalFormat("####.##");
        totalCost = Double.valueOf(df.format(totalCost));
        return totalCost;
    }

    /**
     * Performs the purchase and updates the inventory accordingly.
     * 
     * @param inventory The current inventory.
     * @return The updated inventory after the purchase.
     */
    public Inventory buyMethod(Inventory inventory){
        totalCost = foodCost + oxenCost + clothingCost + bulletCost + wagonAxleCost + wagonTongueCost + wagonWheelCost;

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
  
    /**
     * Checks if the player has enough money to make the purchase.
     * 
     * @param inventory The current inventory.
     * @return True if the player has enough money, false otherwise.
     */
    public boolean checkIfEnoughMoney(Inventory inventory){
       return (totalCost <= inventory.getMoney());
    }
}