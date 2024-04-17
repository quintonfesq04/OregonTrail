import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @File Trading.java
 * @version 1.0.0 4/17/24
 * @author Quinton Fesq
 * allowes for trade of items for other items.
 */
public class Trading {
    private Store store;

    // constructor for Trading object
    public Trading(Store store) {
        this.store = store;
    }

    // Method to display available items for trade
    public void displayTradeItems() {
        store.displayTradeItems();
    }

    /**
     * determines if it is time for a player to trade
     * @return true if time for a trade, false otherwise
     */
    public boolean tradeTime(){
        Random rand = new Random();
        int randNum = rand.nextInt(50);
        if(randNum==0){
            return true;
        }
        else 
            return false;
    } 

    // Method to perform trading between items
    public Inventory tradeItems(String itemToSell, double amountToSell, String itemToBuy, int landmarkIndex, Inventory inventory) {
        // Calculate the price of the item to sell
        double sellPrice = store.calculateItemPrice(itemToSell, landmarkIndex);

        // Calculate the price of the item to buy
        double buyPrice = store.calculateItemPrice(itemToBuy, landmarkIndex);

        // Calculate the quantity of the item to buy
        int amountToBuy = (int) ((amountToSell * sellPrice) / buyPrice);

        String sellString = String.format("%.2f", sellPrice);
        String buyString = String.format("%.2f", buyPrice);

        // Display the trade details
        JOptionPane.showMessageDialog(null," Trade details:\n Selling " + amountToSell + 
                                                            " units of " + itemToSell + " at $" + sellString + " each.\nBuying "
                                                                + amountToBuy + " units of " + itemToBuy + " at $" + buyString + " each.");
    
        // Call the inventory class to add the bought item
        
        inventory.setFood((int) (inventory.getFood() - amountToSell));
        // Call the inventory class to remove the sold item
        inventory.setWater((int) (inventory.getWater() + amountToBuy));
        return inventory;
    }
}
