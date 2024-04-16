import java.util.Random;

public class Conditions {
    private static Random random = new Random();
    private Inventory inventory;
    private String eventInfo;

    public Conditions(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public static boolean isEventOccurred() {
        int eventChance = random.nextInt(10);
        return eventChance == 0;
    }

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
                    String[] itemNames = {"food", "water"};
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
        int waterConsumption = 10; // Adjust as needed
        inventory.removeItem(Item.WATER, waterConsumption);
    
        return inventory;
    }
    
    

    public String getConditionMessage() {
        return eventInfo;
    }
}
