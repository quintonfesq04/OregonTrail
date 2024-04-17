import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Inventory {
    private int money = 2000;
    private int food = 1500;
    private int water = 1500;
    private int oxen = 4;
    private int bullets = 100;
    private int clothing = 30;
    private int misSupplies = 50;
    private static final int INVENTORY_CAP = 2000; // Maximum inventory capacity
    private static Map<String, Integer> items;

    public Inventory() {
        Inventory.items = new HashMap<>();
    }

    // Method to add an item to the inventory
    public void addItem(String itemName, int quantity) {
        if (items.containsKey(itemName)) {
            int currentQuantity = items.get(itemName);
            int newQuantity = currentQuantity + quantity;
            if (newQuantity <= INVENTORY_CAP) {
                items.put(itemName, newQuantity);
            } else {
                JOptionPane.showMessageDialog(null, "Inventory capacity reached for " + itemName + ".");
            }
        } else {
            items.put(itemName, Math.min(quantity, INVENTORY_CAP));
        }
    }

    // Method to remove an item from the inventory
    public void removeItem(String itemName, int quantity) {
        int currentQuantity = items.getOrDefault(itemName, 0);
        if (currentQuantity >= quantity) {
            items.put(itemName, currentQuantity - quantity);
        } else {
            JOptionPane.showMessageDialog(null,"Insufficient quantity of " + itemName + " in inventory.");
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

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }


}
