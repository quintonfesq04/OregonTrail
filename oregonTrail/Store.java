import java.util.HashMap;
import java.util.Map;

public class Store {
    // Define the base prices of items
    private Map<String, Double> basePrices;

    public Store() {
        // Initialize base prices
        basePrices = new HashMap<>();
        basePrices.put("Food", 20.0); // Example base price for food
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
            System.out.println("- " + item);
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

        // Display the trade details
        System.out.println("Trade details:");
        System.out.println("Selling " + amountToSell + " units of " + itemToSell + " at $" + sellPrice + " each.");
        System.out.println("Buying " + amountToBuy + " units of " + itemToBuy + " at $" + buyPrice + " each.");
    }
}
