import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

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

    // Method to edit the amount of weight carried of a certain item
    public void editItemWeight(String item, int newWeight) {
        Integer currentWeight = items.get(item);
        if (currentWeight != null) {
            items.put(item, newWeight);
        } else {
            JOptionPane.showMessageDialog(null, "Item not found in inventory.");
        }
    }

    // Method to add items called from the store class
    public void addItemsFromStore(String item, int count) {
        addItem(item, count);
        JOptionPane.showMessageDialog(null, count + " " + item + " added to inventory from the store.");
    }

    // Method to add/remove items called from the trading class
    public void tradeItems(String item, int count) {
        if (count >= 0) {
            addItem(item, count);
            JOptionPane.showMessageDialog(null, count + " " + item + " added to inventory through trading.");
        } else {
            count *= -1; // Convert negative count to positive for removal
            removeItem(item, count);
            JOptionPane.showMessageDialog(null, count + " " + item + " removed from inventory through trading.");
        }
    }

    // Method to add items called from the hunting class
    public void addItemsFromHunting(String item, int count) {
        addItem(item, count);
        JOptionPane.showMessageDialog(null, count + " " + item + " added to inventory from hunting.");
    }

    // Method to remove bullets
    public void removeBullets(int count) {
        removeItem(Item.BULLETS, count);
        JOptionPane.showMessageDialog(null, count + " bullets removed from inventory.");
    }

    // Method to create a unified way of grabbing the necessary items from the HashMap
    public String[] getItemsArray() {
        return items.keySet().toArray(new String[0]);
    }

    // Main method for the Inventory class
    public static void main(String[] args) {
        // Create an instance of the Inventory class
        Inventory inventory = new Inventory();

        // Test for the methods
        inventory.addItem("Food", 10);
        inventory.addItem("Water", 20);

        JOptionPane.showMessageDialog(null, "Item count of Food: " + inventory.getItemCount("Food"));
        JOptionPane.showMessageDialog(null, "Item count of Water: " + inventory.getItemCount("Water"));

        inventory.removeItem("Food", 5);
        JOptionPane.showMessageDialog(null, "Item count of Food after removal: " + inventory.getItemCount("Food"));

        JOptionPane.showMessageDialog(null, "Inventory summary: " + inventory.getInventorySummary());
    }
}
