import java.util.HashMap;
import java.util.Map;

/**
 * Calculates and tracks the items in the inventory, as well as items added or removed from inventory. Allows user to search
 * for the count of a specific item count.
 * 
 * @author Quinton Fesq
 * @version 1.0  4/3/2024
 */

public class Inventory {
    private Map<String, Integer> items;

    // Constructor to initialize the inventory
    public Inventory() {
        items = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(String item, int count) {
        // Add item to inventory or update count if item already exists
        Integer currentCount = items.get(item);
        if (currentCount != null) {
            items.put(item, currentCount + count);
        }
        else {
            int newCount = Math.max(0, count);
            items.put(item, newCount);
        }
    }

    // Method to remove an item from the inventory
    public void removeItem(String item, int count) {
        Integer currentCount = items.get(item);
        if (currentCount != null && currentCount > 0) {
            int newCount = Math.max(0, currentCount - count);
            items.put(item, newCount);
        }
    }

    // Method to check the count of a specific item in the inventory
    public int getItemCount(String item) {
        Integer count = items.get(item);
        if (count != null) {
            return count;
        }
        else {
            return 0;
        }
    }

    // Method to get a summary of all items in the inventory
    public Map<String, Integer> getInventorySummary() {
        return new HashMap<>(items);
    }

    // Method to clear the inventory
    public void clearInventory() {
        items.clear();
    }

    // Main method for the Inventory class
    public static void main(String[] args) {
        // Create an instance of the Inventory class
        Inventory inventory = new Inventory();

        // Test for the methods
        inventory.addItem("Food", 10);
        inventory.addItem("Water", 20);

        System.out.println("Item count of Food: " + inventory.getItemCount("Food"));
        System.out.println("Item count of Water: " + inventory.getItemCount("Water"));

        inventory.removeItem("Food", 5);
        System.out.println("Item count of Food after removal: " + inventory.getItemCount("Food"));

        System.out.println("Inventory summary: " + inventory.getInventorySummary());
    }
}