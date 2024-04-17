import java.util.Random;

import javax.swing.JOptionPane;

public class Trading {
    private Store store;

    public Trading(Store store) {
        this.store = store;
    }

    // Method to display available items for trade
    public void displayTradeItems() {
        store.displayTradeItems();
    }

    public boolean tradeTime(){
        Random rand = new Random();
        int randNum = rand.nextInt(8);
        if(randNum==5){
            return true;
        }
        else 
            return false;
    } 

    // Method to perform trading between items
    public void tradeItems(String itemToSell, double amountToSell, String itemToBuy, int landmarkIndex) {
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
        Inventory inventory = new Inventory();
        inventory.addItem(itemToBuy, (int) amountToBuy);
        // Call the inventory class to remove the sold item
        inventory.removeItem(itemToSell, (int) amountToSell);
    }
}
