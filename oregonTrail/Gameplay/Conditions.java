package Gameplay;

import java.util.Random;

/**
 * Conditions.java -- Controls the conditions on the trail
 * 
 * @author Madison Scott
 * @author Ethan Burch
 * @author Lane Kanagy
 * @version 1.5.0 4/21/24
 */
public class Conditions {
    private static Random random = new Random();
    private String eventInfo;

    private Wagon wagon;

    private boolean wagonGame;
    private boolean eventOccurred;

    public final static int DROUGHT = 0;
    public final static int RAINING = 1;
    public final static int SNOWING = 2;

    private int weatherCondition;

    /**
     * Constructs a Conditions object with the given wagon object.
     *
     * @param wagon the wagon to be associated with this Conditions object
     */
    public Conditions(Wagon wagon) {
        this.wagon = wagon;
        weatherCondition = 0;
    }

    /**
     * Notifies if a random event occurred.
     * 
     * @return true if a random event occurred, false otherwise.
     */
    public boolean isEventOccurred() {
        return eventOccurred;
    }

    /**
     * Randomly generates weather conditions.
     *
     * @return an integer representing the current weather conditions
     */
    public int generateWeather() {
        weatherCondition = random.nextInt(3);
        return weatherCondition;
    }

    /**
     * Gives the current weather conditions. Does not generate these conditions.
     * 
     * @return an integer representing the current weather conditions
     */
    public int getWeatherCondition() {
        return weatherCondition;
    }

    /**
     * Notifies if the wagon game should be played.
     * 
     * @return true if wagon game should be played, false otherwise
     */
    public boolean isWagonGame() {
        return wagonGame;
    }

    /**
     * Handles inventory updates based on random events.
     */
    public void handleInventory() {
        eventInfo = "";
        wagonGame = false;
        eventOccurred = false;
        int num = random.nextInt(2);
        if (num == 0) {
            eventOccurred = true;
            int event = random.nextInt(18);
            switch (event) {
                case 0:
                    // Thieves event
                    eventInfo = "Random Event: Thieves attacked your wagon!\n";
                    int stolenAmount = random.nextInt(wagon.getInventory().getFood()) + 1;
                    wagon.getInventory().removeItem(Inventory.FOOD, stolenAmount);
                    eventInfo += " " + stolenAmount + " food stolen by thieves.\n";
                    break;

                case 1:
                    // Wagon breakdown event
                    eventInfo = "Random Event: Your wagon broke down.\n";
                    String[] wagonParts = { Inventory.WAGON_WHEEL, Inventory.WAGON_TONGUE, Inventory.WAGON_AXLE };
                    String part = wagonParts[random.nextInt(wagonParts.length)];
                    if (wagon.getInventory().getItemCount(part) > 0) {
                        wagon.getInventory().removeItem(part, 1);
                    } else {
                        eventInfo += " You were unable to fix it!\n";
                    }
                    wagonGame = true;
                    break;

                case 2:
                    // Disease event
                    String[] diseases = { "Exhaustion", "Typhoid", "Cholera", "Measles", "Dysentery", "Fever" };
                    String disease = diseases[random.nextInt(diseases.length)];
                    eventInfo = "Random Disease Event: " + disease + "\n";
                    String partyMember = wagon.getPlayer().getPartyNames()[random
                            .nextInt(wagon.getPlayer().getPartyNames().length)];
                    eventInfo += partyMember + " is sick with " + disease;
                    break;

                case 3:
                    // Indians help find food
                    wagon.getInventory().setFood(wagon.getInventory().getFood() + 30);
                    eventInfo = "Indians helped you find food! +30 lbs of food.\n";
                    break;

                case 4:
                    // Severe thunderstorm
                    eventInfo = "Random Event: Severe thunderstorm!\n";
                    int lostFood = random.nextInt(11); // Random amount lost (0-10)
                    wagon.getInventory().removeItem(Inventory.FOOD, lostFood);
                    eventInfo += "Lost " + lostFood + " lbs of food due to the severe thunderstorm.\n";
                    break;

                case 5:
                    // Severe blizzard
                    eventInfo = "Random Event: Severe blizzard!\n";
                    // Implement logic for consequences of severe blizzard
                    lostFood = random.nextInt(11); // Random amount lost (0-10)
                    wagon.getInventory().removeItem(Inventory.FOOD, lostFood);
                    eventInfo += "Lost " + lostFood + " lbs of food due to the severe blizzard.\n";
                    break;

                case 6:
                    // Heavy fog
                    eventInfo = "Random Event: Heavy fog!\n";
                    if (random.nextDouble() < 0.5) {
                        eventInfo += "Lost a day's travel due to heavy fog.\n";
                    }

                    break;

                case 7:
                    // Hail storm
                    eventInfo = "Random Event: Hail storm!\n";
                    lostFood = random.nextInt(6); // Random amount lost (0-5)
                    wagon.getInventory().removeItem(Inventory.FOOD, lostFood);
                    eventInfo += "Lost " + lostFood + " units of medicine due to the hail storm.\n";
                    break;

                case 8:
                    if (wagon.getInventory().getOxenHealthy()) {
                        eventInfo = "Random Event: An ox has been injured!\n";
                        wagon.getInventory().setOxenHealthy(false);
                    } else if (!wagon.getInventory().getOxenHealthy()) {
                        eventInfo = "Random Event: An ox has died!\n";
                        wagon.getInventory().setOxen(wagon.getInventory().getOxen() - 1);
                        wagon.getInventory().setOxenHealthy(true);
                    }
                    break;

                case 9:
                    // Injured party member (broken arm or leg)
                    eventInfo = "Random Event: A party member is injured!\n";
                    wagon.getPlayer().getSick();
                    break;

                case 10:
                    // Snake bite
                    eventInfo = "Random Event: Snake bite! A party member is sick!\n";
                    wagon.getPlayer().getSick();

                    break;

                case 11:
                    // Lose trail
                    eventInfo = "Random Event: Lost the trail! Lost 2 days.\n";
                    wagon.getPlayer().incrementDaysTraveled(2);

                    break;

                case 12:
                    // Wrong trail
                    eventInfo = "Random Event: Took the wrong trail! Lost 3 days\n";
                    wagon.getPlayer().incrementDaysTraveled(3);
                    break;

                case 13:
                    // Rough trail
                    eventInfo = "Random Event: Rough trail! Lost 1 day.\n";
                    wagon.getPlayer().incrementDaysTraveled();

                    break;

                case 14:
                    // Impassible trail
                    eventInfo = "Random Event: Impassible trail! Lost 2 days.\n";
                    wagon.getPlayer().incrementDaysTraveled(2);

                    break;

                case 15:
                    // Finding wild fruit
                    eventInfo = "Random Event: Found wild fruit! +20 lbs of food.\n";
                    wagon.getInventory().setFood(wagon.getInventory().getFood() + 20);
                    break;

                case 17:
                    // Lost party member
                    int daysLost = random.nextInt(6) + 1; // Lose up to 6 days
                    wagon.getPlayer().incrementDaysTraveled(daysLost);
                    eventInfo = "Random Event: Lost a party member! Lost " + daysLost + " days.\n";
                    break;

                case 18:
                    // Ox wanders off
                    daysLost = random.nextInt(4) + 1; // Lose up to 4 days.
                    wagon.getPlayer().incrementDaysTraveled(daysLost);
                    eventInfo = "Random Event: Ox wandered off! Lost " + daysLost + " days.\n";
                    break;

                default:
                    // No event occurred
                    eventInfo = "No event occurred";
                    break;
            }
        }
    }

    /**
     * Retrieves the message describing the latest condition event.
     *
     * @return the message describing the latest condition event
     */
    public String getConditionMessage() {
        return eventInfo;
    }
}
