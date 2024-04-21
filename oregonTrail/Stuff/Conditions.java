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
    Private String weather;

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
     * Generates weather based on temperature and probability of rainfall
     */
    private void generateWeather(int temperature, double avgRainfall){
        // Determine weather based on temperature
        if(temperature > 90){
            weather = "Very Hot";
        } else if (temperature >= 70 && temperature <= 90){
            weather = "Hot";
        } else if (temperature >= 50 && temperature <= 70){
            weather = "Warm";
        } else if (temperature >= 30 && temperature <= 50){
            weather = "Cool";
        } else if (temperature >= 10 && temperature <= 30){
            weather = "Cold"
        } else{
            weather = "Very Cold";
        }
    }
               // Determine probability of rainfall
               double rainProbability = avgRainfall / 100.0; // Adjust to percentage
               if (random.nextDouble() < rainProbability) {
                   // Rainy weather
                   weather += " and Rainy";
                   double todayRainfall = random.nextDouble() * 2; // Random rainfall between 0 and 2 inches
                   accumulatedRainfall += todayRainfall;
               } else {
                   // Not rainy
                   if (temperature <= 30) {
                       // Snowy weather
                       weather += " and Snowy";
                       double todaySnowfall = random.nextDouble() * 10; // Random snowfall between 0 and 10 inches
                       // Convert snowfall to equivalent rainfall
                       accumulatedRainfall += todaySnowfall / 10.0; // 1 inch of snow = 0.1 inch of rainfall
                   }
               }
           } else {
               // Repeat previous day's weather
               weather = previousWeather;
           }
       
       /**
        * Retrieves the average monthly rainfall (for demonstration purposes)
        * @return Average monthly rainfall
        */
       private double getAverageMonthlyRainfall() {
           return 50.0; // Placeholder for average rainfall
       }
   
       /**
        * Handles accumulation and management of rainfall
        */
       private void handleRainfall() {
           accumulatedRainfall *= 0.9; // 10% of accumulated rainfall disappears
           if (accumulatedRainfall < 0.2) {
               // Drought occurs (insufficient grass)
               eventInfo += "Drought: Insufficient grass";
           }
           if (accumulatedRainfall < 0.1) {
               // Severe drought occurs (inadequate water, bad water)
               eventInfo += "Severe Drought: Inadequate water, Bad water";
           }
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


