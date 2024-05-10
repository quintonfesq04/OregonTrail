package Gameplay;

import javax.swing.JOptionPane;

/**
 * Player.java
 * @author: Madison Scott
 * @author: Ethan Burch
 * @version: 2.1.0 5/1/24
 * Controls the player's health, food, and sickness count.
 */

public class Player {
    private int health;
    private int food;
    private int sicknessCount;
    private int consumptionRate;
    private int travelSpeed;
    private int daysTraveled;
    public static final String FILLING = "Filling";
    public static final String BARE_BONES = "Bare-Bones";
    public static final String MEAGER = "Meager";

    private String[] partyNames;

    /**
     * Default constructor for Player class.
     * Initializes player attributes to default values.
     */
    public Player() {
        this.health = 0;
        this.food = 50;
        this.sicknessCount = 0;
        this.consumptionRate = 15;
        this.travelSpeed = 20;
        this.daysTraveled = 0;
    }

    /**
     * Parameterized constructor for Player class.
     *
     * @param health          The player's initial health.
     * @param food            The player's initial food level.
     * @param sicknessCount   The initial sickness count.
     * @param consumptionRate The rate at which food is consumed.
     * @param travelSpeed     The speed at which the player travels.
     * @param daysTraveled    The number of days the player has traveled.
     */
    public Player(int health, int food, int sicknessCount, int consumptionRate, int travelSpeed, int daysTraveled) {
        this.health = health;
        this.food = food;
        this.sicknessCount = sicknessCount;
        this.consumptionRate = consumptionRate;
        this.travelSpeed = travelSpeed;
        this.daysTraveled = daysTraveled;
    }

    /**
     * Sets the number of days the player has traveled.
     *
     * @param daysTraveled The number of days traveled to set.
     */
    public void setDaysTraveled(int daysTraveled) {
        this.daysTraveled = daysTraveled;
    }

    /**
     * Increments the number of days the player has traveled by 1.
     */
    public void incrementDaysTraveled() {
        this.daysTraveled += 1;
    }

    /**
     * Increments the number of days the player has traveled by a specified amount.
     *
     * @param daysTraveled The number of days to increment by.
     */
    public void incrementDaysTraveled(int daysTraveled) {
        this.daysTraveled += daysTraveled;
    }

    /**
     * Gets the number of days the player has traveled.
     *
     * @return The number of days traveled.
     */
    public int getDaysTraveled() {
        return daysTraveled;
    }

    /**
     * Sets the travel speed of the player.
     *
     * @param travelSpeed The travel speed to set.
     */
    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }

    /**
     * Gets the travel speed of the player.
     *
     * @return The travel speed.
     */
    public int getTravelSpeed() {
        return travelSpeed;
    }

    /**
     * Sets the food consumption rate based on the selected ration option.
     *
     * @param str The selected food ration option.
     */
    public void setConsumption(String str) {
        if (str.equals("Filling"))
            this.consumptionRate = 25;
        else if (str.equals("Bare-Bones"))
            this.consumptionRate = 20;
        else if (str.equals("Meager"))
            this.consumptionRate = 15;
        else
            this.consumptionRate = 0;
    }

    /**
     * Gets the food consumption rate.
     *
     * @return The food consumption rate.
     */
    public int getConsumption() {
        return this.consumptionRate;
    }

    /**
     * Gets the player's current health.
     *
     * @return The player's health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the player's health.
     *
     * @param health The health value to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the player's current food level.
     *
     * @return The player's food level.
     */
    public int getFood() {
        return food;
    }

    /**
     * Sets the player's food level.
     *
     * @param food The food level to set.
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Decrements the player's food level based on consumption rate.
     *
     * @return The updated food level after decrementing.
     */
    public int decrementFood() {
        food -= consumptionRate;
        return food;
    }

    /**
     * Simulates the player getting sick.
     */
    public void getSick() {
        sicknessCount++;
        System.out.println("Player got sick. Sickness count: " + sicknessCount);
        if (sicknessCount >= 2) {
            health = 0; // Simulate immediate death
            System.out.println("Player's health decreased to zero due to sickness!");
        }
    }

    /**
     * Simulates the player's health decreasing.
     *
     * @param healthDecrease The amount by which health should decrease.
     * @return The updated health level after decreasing.
     */
    public int deteriorateHealth(int healthDecrease) {
        health -= healthDecrease;
        if (health < 0) {
            health = 0;
        }
        System.out.println("Health decreased by " + healthDecrease + ". Current health: " + health);
        return health;
    }

    /**
     * Method to simulate the effects of weather on health.
     *
     * @param weather The weather condition affecting the player.
     */
    public void applyWeatherEffect(String weather) {
        switch (weather) {
            case "Very hot":
                health += 2;
                break;
            case "Hot":
                health += 1;
                break;
            case "Cool":
            case "Warm":
                // No effect
                break;
            case "Cold":
                health += calculateColdEffect();
                break;
            case "Very cold":
                health += calculateVeryColdEffect();
                break;
        }
    }

    /**
     * Method to calculate the health effect of cold weather.
     *
     * @return The health effect of cold weather.
     */
    private int calculateColdEffect() {
        int clothingSets = 2; // Assuming initial clothing sets
        int coldEffect = 0;
        // Logic to determine the cold effect based on clothing sets
        if (clothingSets == 0) {
            coldEffect = 2;
        } else if (clothingSets < 2) {
            // Apply sliding scale
        }
        return coldEffect;
    }

    /**
     * Method to calculate the health effect of very cold weather.
     *
     * @return The health effect of very cold weather.
     */
    private int calculateVeryColdEffect() {
        int clothingSets = 4; // Assuming initial clothing sets
        int veryColdEffect = 0;
        // Logic to determine the very cold effect based on clothing sets
        if (clothingSets == 0) {
            veryColdEffect = 4;
        } else if (clothingSets < 4) {
            // Apply sliding scale
        }
        return veryColdEffect;
    }

    /**
     * Method to apply the effect of food rations on health.
     *
     * @param foodRation The selected food ration option.
     */
    public void applyFoodRationEffect(String foodRation) {
        switch (foodRation) {
            case "Filling":
                // No effect
                break;
            case "Meager":
                health += 2;
                break;
            case "Bare-Bones":
                health += 4;
                break;
            case "Out of food":
                health += 6;
                break;
        }
    }

    /**
     * Method to apply the pace effect on health.
     *
     * @param pace The selected pace option.
     */
    public void applyPaceEffect(String pace) {
        switch (pace) {
            case "Resting":
                // No effect
                break;
            case "Steady":
                health += 2;
                break;
            case "Strenuous":
                health += 4;
                break;
            case "Grueling":
                health += 6;
                break;
        }
    }

    /**
     * Method to handle random events affecting health.
     *
     * @param event The random event affecting the player.
     */
    public void handleRandomEvent(String event) {
        switch (event) {
            case "Bad water":
                health += 20;
                break;
            case "Very little water":
                health += 10;
                break;
            case "Diseased party member":
                sicknessCount++; // Increment sickness count for a diseased party member
                break;
            case "Rough trail":
                health += 10;
                break;
        }
    }

    /**
     * Gets the party member names.
     *
     * @return The array of party member names.
     */
    public String[] getPartyNames() {
        return partyNames;
    }

    /**
     * Sets the party member names.
     *
     * @param partyNames The array of party member names to set.
     */
    public void setPartyNames(String[] partyNames) {
        this.partyNames = partyNames;
    }

    /**
     * Entry point for testing Player class functionality.
     * Initializes a player, displays initial health and food, then simulates health deterioration.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Player player = new Player();

        JOptionPane.showMessageDialog(null, "Player's initial health: " + player.getHealth());
        JOptionPane.showMessageDialog(null, "Player's initial food: " + player.getFood());

        player.deteriorateHealth(10); // Simulating health deterioration
        JOptionPane.showMessageDialog(null, "Player's current health: " + player.getHealth());
    }
}
