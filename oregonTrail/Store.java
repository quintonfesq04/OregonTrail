import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

public class Store {
    private double[] prices;
    private Inventory inventory;
    private Random random;

    public Store() {
       this.prices = new double[6];
       initializePrices();
    }

    private void initializePrices() {
        double basePrice = 0.20;

        for (int i = 0; i < prices.length; i++) {
            double percentageIncreases = i * 0.25;
            prices[i] = basePrice * (1 + percentageIncreases);
        }
    }

    public double getPriceAtLocation(String item, int locationIndex) {
        if(locationIndex >= 0 && locationIndex < prices.length) {
            return prices[locationIndex];
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid Location Index!");
            return -1;
        }
    }  
    
    public static void main(String[] args) {
        Store store = new Store();
    
        // Example item and location index
        String item = "food";
        int locationIndex = 0; // Ensure this is within the valid range
    
        // Get the price of the item at the specified location index
        double price = store.getPriceAtLocation(item, locationIndex);
    
        // Check if the price is valid (-1 indicates invalid price)
        if (price != -1) {
            JOptionPane.showMessageDialog(null, "Price of " + item + " at location " + locationIndex + ": $" + price);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid item or location index.");
        }
    }    

}