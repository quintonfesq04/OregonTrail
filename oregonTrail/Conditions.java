import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Conditions {
    private static Random random = new Random ();
private Inventory inv;

    public Conditions(Inventory inventory){
        inv = inventory;
    }
// Method to check if a random event occurred
public static boolean isEventOccurred() {
    int eventChance = random.nextInt(10); // Generate a random number between 0 and 9
}
// Method to handle inventory changes based on random events and return updated inventory
public Inventory handleInventory() {
    if (isEventOccurred()) {
        int event = random.nextInt(3); // Random event: 0 - Weather, 1 - Thieves, 2 - Wagon breakdown

        switch (event) {
            case 0:
                // Weather event
                String[] weathers = {"Sunny", "Rainy", "Snowy"};
                String weather = weathers[random.nextInt(weathers.length)];
                // Handle weather effects on inventory here if needed
                eventInfo = "Random Weather Event: " + weather;  
                break;
            case 1:
                // Thieves event
                eventInfo = "Random Event: Thieves attacked your wagon!";   
                // Handle thieves stealing supplies from inventory             
                String item = getRandomItem(inventory);
                int stolenAmount = random.nextInt(inventory.get(item));
                inventory.put(item, inventory.get(item) - stolenAmount);
                eventInfo += " " + stolenAmount + " " + item + " stolen by thieves.";
                break;
            case 2:
                // Wagon breakdown event
                eventInfo = "Random Event: Your wagon broke down.";
                // Handle wagon breakdown effects on inventory here if needed
                break;
        }
    }
    return inventory;
}
