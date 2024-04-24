package Stuff;
import javax.swing.JOptionPane;
import Screens.*;
import Stuff.*;
import Hunting.*;

/**
 * @File: Player.java
 * @author: Madison Scott
 * @version: 2.0.0 4/16/24
 * @Description: controls the players health and sickness count
 */

public class Player {
    private int health;
    private int food;
    private int sicknessCount;
    private int consumptionRate;
    private double freezeStarveFactor;

    public Player() {
        this.health = 0;
        this.food = 50;
        this.sicknessCount = 0;
        this.consumptionRate = 15;
        this.freezeStarveFactor = 0;
    }

    public Player(int health, int food, int sicknessCount, int consumptionRate) {
        this.health = health;
        this.food = food;
        this.sicknessCount = sicknessCount;
        this.consumptionRate = consumptionRate;
        this.freezeStarveFactor = 0;
    }

    public void setConsumption(String str) {
        if(str.equals("Filling")) 
            this.consumptionRate = 25;
        else if (str.equals("Bare-Bones")) 
            this.consumptionRate = 20;
        else if (str.equals("Meager")) 
            this.consumptionRate = 15;
        else 
            this.consumptionRate = 0;
    }

    public int getConsumption() {
        return this.consumptionRate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int decrementFood() {
        food -= consumptionRate;
        return food;
    }

    public void getSick() {
        sicknessCount++;
        System.out.println("Player got sick. Sickness count: " + sicknessCount);
        if (sicknessCount >= 2) {
            health = 0; // Simulate immediate death
            System.out.println("Player's health decreased to zero due to sickness!");
        }
    }

    public int deteriorateHealth(int healthDecrease) {
        health -= healthDecrease;
        if (health < 0) {
            health = 0;
        }
        System.out.println("Health decreased by " + healthDecrease + ". Current health: " + health);
        return health;
    }

    // Method to simulate the effects of weather on health
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

    // Method to calculate the health effect of cold weather
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

    // Method to calculate the health effect of very cold weather
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

    // Method to apply the effect of food rations on health
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

    // Method to update the freeze/starve factor
    private void updateFreezeStarveFactor(boolean isFreezing, boolean isStarving) {
        if (isFreezing || isStarving) {
            freezeStarveFactor += 0.8;
        } else {
            freezeStarveFactor /= 2;
        }
    }

    // Method to apply the pace effect on health
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

    // Method to handle random events affecting health
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

    // Method to simulate the chance of contracting a disease

    public void simulateDisease() {
        int chance = (int) (Math.random() * 41); // Random number between 0 and 40
        if (chance > 0 && chance <= 40) { // There's a 0% to 40% chance of contracting a disease
            // Simulate disease strike
            // Choose a party member randomly and set sickness count to 10 days
            // Assuming partyMembers array holds all party members
            int partyMemberIndex = (int) (Math.random() * partyMembers.length); 
            partyMembers[partyMemberIndex].setSicknessCount(10);
        }
    }

    public static void main(String[] args) {
        Player player = new Player();

        JOptionPane.showMessageDialog(null,"Player's initial health: " + player.getHealth());
        JOptionPane.showMessageDialog(null,"Player's initial food: " + player.getFood());

        player.deteriorateHealth(10); // Simulating health deterioration
        JOptionPane.showMessageDialog(null,"Player's current health: " + player.getHealth());
    }
}
