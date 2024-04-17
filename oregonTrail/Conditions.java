import java.util.Random;

/**
 * @File Conditions.java
 * @author Madison Scott
 * @version 1.0.4 4/17/24
 * Changes for different conditions along the trail
 */
public class Conditions {
    private static Random random = new Random();
    private Inventory inventory;
    private String eventInfo;

    //constuctor for conditions object
    public Conditions(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * gives the inventory
     * @return the edited inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * sets the inventory for Conditions
     * @param inventory the desired inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * determines if an event has occurred
     * @return true if an event has occured, false otherwise
     */
    private boolean isEventOccurred() {
        int eventChance = random.nextInt(10);
        return eventChance == 0;
    }

    /**
     * makes changes to an inventory based off an event that has occurred
     * @return An updated inventory
     */
    public Inventory handleInventory() {
        eventInfo = "";
        if (isEventOccurred()) {
            int event = random.nextInt(3);
            switch (event) {
                case 0:
                    // Weather event
                    String[] weathers = {"Sunny", "Rainy", "Snowy"};
                    String weather = weathers[random.nextInt(weathers.length)];
                    eventInfo = "Random Weather Event: " + weather;
                    break;
    
                case 1:
                    // Thieves event
                    eventInfo = "Random Event: Thieves attacked your wagon!";
                    String[] itemNames = {Item.FOOD, Item.WATER};
                    String item = itemNames[random.nextInt(itemNames.length)];
                    int stolenAmount = random.nextInt(inventory.getItemCount(item) + 1);
                    inventory.removeItem(item, stolenAmount);
                    eventInfo += " " + stolenAmount + " " + item + " stolen by thieves.";
                    break;
    
                case 2:
                    // Wagon breakdown event
                    eventInfo = "Random Event: Your wagon broke down.";
                    String[] wagonParts = {Item.WAGON_WHEEL, Item.WAGON_TONGUE, Item.WAGON_AXLE};
                    String part = wagonParts[random.nextInt(wagonParts.length)];
                    if (inventory.getItemCount(part) > 0) {
                        inventory.removeItem(part, 1);
                    } else {
                        eventInfo += " You were unable to fix it!";
                    }
                    break;
            }
        }
        // Ensure water consumption occurs during travel
        return inventory;
    }
    
    
    /**
     * gives a string containg the information on what happened during handleInventory
     * @return the string containing the message
     */
    public String getConditionMessage() {
        return eventInfo;
    }
}
