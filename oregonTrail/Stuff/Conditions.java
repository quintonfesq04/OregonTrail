package Stuff;

import java.util.Random;

/**
 * Conditions.java  --  Controls the conditions on the trail
 * @author Madison Scott
 * @author Ethan Burch
 * @version 1.5.0 4/21/24
 */
public class Conditions {
    private static Random random = new Random();
    private Inventory inventory;
    private String eventInfo;
    private String weather;
    private double accumulatedRainfall;
    private String previousWeather;

    public Conditions(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private boolean isEventOccurred() {
        int eventChance = random.nextInt(100);
        return eventChance == 0;
    }

    public void generateWeather(int temperature, double avgRainfall) {
        if (temperature > 90) {
            weather = "Very Hot";
        } else if (temperature >= 70 && temperature <= 90) {
            weather = "Hot";
        } else if (temperature >= 50 && temperature <= 70) {
            weather = "Warm";
        } else if (temperature >= 30 && temperature <= 50) {
            weather = "Cool";
        } else if (temperature >= 10 && temperature <= 30) {
            weather = "Cold";
        } else {
            weather = "Very Cold";
        }

        double rainProbability = avgRainfall / 100.0;
        if (random.nextDouble() < rainProbability) {
            weather += " and Rainy";
            double todayRainfall = random.nextDouble() * 2;
            accumulatedRainfall += todayRainfall;
        } else {
            if (temperature <= 30) {
                weather += " and Snowy";
                double todaySnowfall = random.nextDouble() * 10;
                accumulatedRainfall += todaySnowfall / 10.0;
            } else {
                weather = previousWeather;
            }
        }
    }

    private double getAverageMonthlyPrecipitation() {
        return 50.0; // Placeholder for average monthly precipitation
    }

    private double calculateThunderstormProbability(double avgPrecipitation) {
        // Implement logic to calculate thunderstorm probability based on average precipitation
        return avgPrecipitation * 0.01; // Placeholder logic
    }

    private boolean isAfterFortHall() {
        // Implement logic to check if after Fort Hall
        return true; // Placeholder logic
    }

    private boolean isVeryHot() {
        // Implement logic to check if temperature is very hot
        return true; // Placeholder logic
    }

    private boolean isMountain() {
        // Implement logic to check if currently in mountains
        return true; // Placeholder logic
    }

    private boolean isMayToSeptember() {
        // Implement logic to check if current month is May to September
        return true; // Placeholder logic
    }

    public Inventory handleInventory() {
        eventInfo = "";
        if (isEventOccurred()) {
            int event = random.nextInt(50);
            switch (event) {
                case 0:
                    // Weather event
                    String[] weathers = { "Sunny", "Rainy", "Snowy" };
                    String weather = weathers[random.nextInt(weathers.length)];
                    eventInfo = "Random Weather Event: " + weather + "\n";
                    break;

                case 1:
                    // Thieves event
                    eventInfo = "Random Event: Thieves attacked your wagon!\n";
                    String[] itemNames = { "food", "water"};
                    String item = itemNames[random.nextInt(itemNames.length)];
                    int stolenAmount = random.nextInt(inventory.getItemCount(item) + 1);
                    inventory.removeItem(item, stolenAmount);
                    eventInfo += " " + stolenAmount + " " + item + " stolen by thieves.\n";
                    break;

                case 2:
                    // Wagon breakdown event
                    eventInfo = "Random Event: Your wagon broke down.\n";
                    String[] wagonParts = { "wagon wheel", "wagon tongue", "wagon axle"};
                    String part = wagonParts[random.nextInt(wagonParts.length)];
                    if (inventory.getItemCount(part) > 0) {
                        inventory.removeItem(part, 1);
                    } else {
                        eventInfo += " You were unable to fix it!\n";
                    }
                
                    break;
                    
                case 3:
                    // Disease event
                    String[] diseases = {"Exhaustion", "Typhoid", "Cholera", "Measles", "Dysentery", "Fever"};
                    String disease = diseases[random.nextInt(diseases.length)];
                    eventInfo = "Random Disease Event: " + disease + "\n";
                    int affectedAmount = random.nextInt(11); // Random amount affected (0-10)
                    inventory.removeItem("medicine", affectedAmount); // Remove medicine as treatment
                    eventInfo += " " + affectedAmount + " units of medicine used for treatment.\n";
                    break;

                case 4:
                    // Indians help find food
                    if (inventory.getItemCount("food") == 0) {
                        if (random.nextDouble() < 0.05) {
                            inventory.setFood(inventory.getFood()+30);
                            eventInfo = "Indians helped you find food! +30 lbs of food.\n";
                        }
                    }
                    break;

                case 5:
                    // Severe thunderstorm
                    double avgPrecipitation = getAverageMonthlyPrecipitation();
                    double probability = calculateThunderstormProbability(avgPrecipitation);
                    if (random.nextDouble() < probability) {
                        eventInfo = "Random Event: Severe thunderstorm!\n";
                        // Implement logic for consequences of severe thunderstorm, such as lost supplies or damaged wagon
                        int lostFood = random.nextInt(11); // Random amount lost (0-10)
                        inventory.removeItem("food", lostFood);
                        eventInfo += "Lost " + lostFood + " lbs of food due to the severe thunderstorm.\n";
                    }
                    break;

                case 6:
                    // Severe blizzard
                    if (random.nextDouble() < 0.15) {
                        eventInfo = "Random Event: Severe blizzard!\n";
                        // Implement logic for consequences of severe blizzard
                        int lostWater = random.nextInt(11); // Random amount lost (0-10)
                        inventory.removeItem("water", lostWater);
                        eventInfo += "Lost " + lostWater + " gallons of water due to the severe blizzard.\n";
                    }
                    break;

                case 7:
                    // Heavy fog
                    if (isAfterFortHall() && !isVeryHot()) {
                        if (random.nextDouble() < 0.06) {
                            eventInfo = "Random Event: Heavy fog!\n";
                            if (random.nextDouble() < 0.5) {
                                eventInfo += "Lost a day's travel due to heavy fog.\n";
                            }
                        }
                    }
                    break;

                case 8:
                    // Hail storm
                    if (!isAfterFortHall() && isVeryHot()) {
                        if (random.nextDouble() < 0.06) {
                            eventInfo = "Random Event: Hail storm!\n";
                            int lostMedicine = random.nextInt(6); // Random amount lost (0-5)
                            inventory.removeItem("medicine", lostMedicine);
                            eventInfo += "Lost " + lostMedicine + " units of medicine due to the hail storm.\n";
                        }
                    }
                    break;

                case 9:
                    // Injured or dead ox
                    double oxInjuryProbability = isMountain() ? 0.035 : 0.02;
                    if (inventory.getAllOxenHealthy() && random.nextDouble() < oxInjuryProbability) {
                        eventInfo = "Random Event: An ox has been injured!\n";
                        inventory.setRandomOxInjured();
                    } else if (!inventory.getAllOxenHealthy() && random.nextDouble() < 0.02) {
                        eventInfo = "Random Event: An ox has died!\n";
                        inventory.removeRandomSickOx();
                    }
                    break;

                case 10:
                    // Injured party member (broken arm or leg)
                    double injuryProbability = isMountain() ? 0.035 : 0.02;
                    if (random.nextDouble() < injuryProbability) {
                        eventInfo = "Random Event: A party member is injured!\n";
                        inventory.setRandomPartyMemberInjured();
                    }
                    break;

                case 11:
                    // Snake bite
                    if (random.nextDouble() < 0.007) {
                        eventInfo = "Random Event: Snake bite!\n";
                    }
                    break;

                case 12:
                    // Lose trail
                    if (random.nextDouble() < 0.02) {
                        eventInfo = "Random Event: Lost the trail!\n";
                    }
                    break;

                case 13:
                    // Wrong trail
                    if (random.nextDouble() < 0.01) {
                        eventInfo = "Random Event: Took the wrong trail!\n";
                    }
                    break;

                case 14:
                    // Rough trail
                    if (isMountain() && random.nextDouble() < 0.025) {
                        eventInfo = "Random Event: Rough trail!\n";
                    }
                    break;

                case 15:
                    // Impassible trail
                    if (isMountain() && random.nextDouble() < 0.025) {
                        eventInfo = "Random Event: Impassible trail!\n";
                    }
                    break;

                case 16:
                    // Finding wild fruit
                    if (isMayToSeptember() && random.nextDouble() < 0.04) {
                        eventInfo = "Random Event: Found wild fruit! +20 lbs of food.\n";
                        inventory.setFood(inventory.getFood()+20);
                    }
                    break;

                case 17:
                    // Fire in the wagon
                    if (random.nextDouble() < 0.02) {
                        eventInfo = "Random Event: Fire in the wagon!\n";
                    }
                    break;

                case 18:
                    // Lost party member
                    if (random.nextDouble() < 0.01) {
                        int daysLost = random.nextInt(6) + 1; // Lose up to 5 days
                        eventInfo = "Random Event: Lost a party member! Lost " + daysLost + " days.\n";
                    }
                    break;

                case 19:
                    // Ox wanders off
                    if (random.nextDouble() < 0.01) {
                        int daysLost = random.nextInt(4) + 1; // Lose up to 3 days
                        eventInfo = "Random Event: Ox wandered off! Lost " + daysLost + " days.\n";
                    }
                    break;

                case 20:
                    // Finding an abandoned wagon
                    if (random.nextDouble() < 0.02) {
                        eventInfo = "Random Event: Found an abandoned wagon!\n";
                    }
                    break;

                case 21:
                    // Thief comes during the night
                    if (random.nextDouble() < 0.02) {
                        eventInfo = "Random Event: Thief came during the night!\n";
                    }
                    break;

                case 22:
                    // Bad water
                    if (random.nextDouble() < 0.1 && accumulatedRainfall < 0.1) {
                        eventInfo = "Random Event: Bad water! Insufficient rainfall.\n";
                    }
                    break;

                case 23:
                    // Very little water
                    if (random.nextDouble() < 0.2 && accumulatedRainfall < 0.1) {
                        eventInfo = "Random Event: Very little water! Insufficient rainfall.\n";
                    }
                    break;

                case 24:
                    // Inadequate grass
                    if (random.nextDouble() < 0.2 && accumulatedRainfall < 0.1) {
                        eventInfo = "Random Event: Inadequate grass! Insufficient rainfall.\n";
                    }
                    break;

                default:
                    // No event occurred
                    break;
            }
        }
        return inventory;
    }

    public String getConditionMessage() {
        return eventInfo;
    }
}
