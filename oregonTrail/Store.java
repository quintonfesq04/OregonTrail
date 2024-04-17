import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Store {
    // Define the base prices of items
    private Map<String, Double> basePrices;

    public Store() {
        // Initialize base prices
        basePrices = new HashMap<>();
        basePrices.put(Item.FOOD, .20); // Example base price for food
        basePrices.put(Item.WATER, .20);
        basePrices.put(Item.OXEN, 25.00);
        basePrices.put(Item.CLOTHES, 10.00);
        basePrices.put(Item.BULLETS, .02);
        // Add more base prices for other items if needed
    }

    // Method to calculate the price of an item based on the landmark
    public double calculateItemPrice(String itemName, int landmarkIndex) {
        // Get the base price of the item
        double basePrice = basePrices.getOrDefault(itemName, 0.0);

        // Calculate the multiplier based on the landmark index
        double multiplier = 1.0 + (landmarkIndex * 0.25); // Increase by 25% for each landmark

        // Calculate the final price
        double finalPrice = basePrice * multiplier;

        return finalPrice;
    }

    // Method to display available items for trade
    public void displayTradeItems() {
        // Iterate through the base prices map and print out each item
        System.out.println("Items available for trade:");
        for (String item : basePrices.keySet()) {
            JOptionPane.showMessageDialog(null,"- " + item);
        }
    }

    // Method to perform trading between items
    public void tradeItems(String itemToSell, double amountToSell, String itemToBuy, int landmarkIndex) {
        // Calculate the price of the item to sell
        double sellPrice = calculateItemPrice(itemToSell, landmarkIndex);

        // Calculate the price of the item to buy
        double buyPrice = calculateItemPrice(itemToBuy, landmarkIndex);

        // Calculate the quantity of the item to buy
        double amountToBuy = (amountToSell * sellPrice) / buyPrice;

        String buyString = Double.toString(buyPrice);
        String sellString = Double.toString(sellPrice);

        buyString = String.format("%.2", buyString);
        sellString = String.format("%.2", sellString);
        
        // Display the trade details
        JOptionPane.showMessageDialog(null,"Trade details:\n Selling " + amountToSell + " units of " + itemToSell + " at $" 
                                        + sellString + " each.\nBuying " + amountToBuy +
                                        " units of " + itemToBuy + " at $" + buyString + " each.");
        
        // Call the inventory class to add the bought item
        Inventory inventory = new Inventory();
        inventory.addItem(itemToBuy, (int) amountToBuy);
    }
}
