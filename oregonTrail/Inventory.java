import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    // Method to remove an item from the inventory
    public void removeItem(String itemName, int quantity) {
        int currentQuantity = items.getOrDefault(itemName, 0);
        if (currentQuantity >= quantity) {
            items.put(itemName, currentQuantity - quantity);
        } else {
            // Handle insufficient quantity error
            System.out.println("Insufficient quantity of " + itemName + " in inventory.");
        }
    }

    // Method to get the quantity of an item in the inventory
    public int getItemCount(String itemName) {
        return items.getOrDefault(itemName, 0);
    }

    // Method to check if an item is in the inventory
    public boolean containsItem(String itemName) {
        return items.containsKey(itemName);
    }

    // Method to get all items in the inventory
    public Map<String, Integer> getAllItems() {
        return new HashMap<>(items);
    }
}
