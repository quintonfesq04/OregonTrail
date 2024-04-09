/*
 * File: Conditions.java
 * Author: Madison Scott
 * Date: 4/8/2024
 * Description: This program controls random events that can happen 
 * along your journey and travel conditions
 */

import java.util.Random;

public class Conditions {
    private static Random random = new Random ();
    private Inventory inventory;
    private String eventInfo;

    /**
     * Constructs a Conditions object with the given inventory.
     * @param inventory The inventory to be associated with this Conditions object.
     */
    public Conditions(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Retrieves the inventory associated with this Conditions object.
     * @return The inventory associated with this Conditions object.
     */
    public Inventory getInventory(){
        return inventory;
    }

    /**
     * Sets the inventory associated with this Conditions object.
     * @param inventory The inventory to be associated with this Conditions object.
     */
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Checks if a random event has occurred.
     * @return true if a random event has occurred, false otherwise.
     */
    public static boolean isEventOccurred() {
        int eventChance = random.nextInt(10); // Generate a random number between 0 and 9
        return eventChance == 0;
    }

    /**
     * Handles inventory changes based on random events and returns the updated inventory.
     * @return The updated inventory after handling random events.
     */
    public Inventory handleInventory() {
        eventInfo = "";
        int num;
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
                    String[] itemNames = {"food", "water"};
                    num = random.nextInt(2);
                    String item = itemNames[num];
                    // Handle thieves stealing supplies from inventory             
                    int stolenAmount = random.nextInt(inventory.getItemCount(item) + 1);
                    inventory.removeItem(item, stolenAmount);
                    eventInfo += " " + stolenAmount + " " + item + " stolen by thieves.";
                    break;

                case 2:
                    // Wagon breakdown event
                    eventInfo = "Random Event: Your wagon broke down.";
                    // Handle wagon breakdown effects on inventory here if needed
                    String[] wagonParts = {"wheel", "tongue", "axle"};
                    num = random.nextInt(3);
                    String part = wagonParts[num];
                    if(inventory.getItemCount(part) > 0){
                        inventory.removeItem(part, 1);
                    }
                    else{
                        eventInfo += " You were unable to fix it!";
                    }
                    break;
            }
        }
        return this.inventory;
    }

    /**
     * Retrieves the message associated with the latest event.
     * @return The message associated with the latest event.
     */
    public String getConditionMessage(){
        return eventInfo;
    }
}
