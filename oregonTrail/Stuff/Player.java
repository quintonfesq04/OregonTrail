package Stuff;
import javax.swing.JOptionPane;

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

    /**
     * Constructs a Player object with default values for health, food, sickness count, and consumption rate.
     */
    public Player() {
        this.health = 100; // Starting health
        this.food = 50;    // Starting food
        this.sicknessCount = 0; 
        this.consumptionRate = 15;
    }

    /**
     * Constructs a Player object with specified values for health, food, sickness count, and consumption rate.
     *
     * @param health the initial health of the player
     * @param food the initial food level of the player
     * @param sicknessCount the initial sickness count of the player
     * @param consumptionRate the initial consumption rate of the player
     */
    public Player(int health, int food, int sicknessCount, int consumptionRate) {
    	this.health = health;
    	this.food = food;
    	this.sicknessCount = sicknessCount;
    	this.consumptionRate = consumptionRate;
    }

    /**
     * Sets the consumption rate of the player based on the provided string.
     *
     * @param str the string representing the consumption rate ("Filling", "Bare-Bones", "Meager", or any other string)
     */
    public void setConsumption(String str) {
    	if(str.compareTo("Filling")== 0) 
    		this.consumptionRate = 25;
    	else if (str.compareTo("Bare-Bones")== 0) 
    		this.consumptionRate = 20;
    	else if (str.compareTo("Meager")== 0) 
    		this.consumptionRate = 15;
    	else 
    		this.consumptionRate = 0;
    }
    
    /**
     * Returns the current consumption rate of the player.
     *
     * @return the current consumption rate of the player
     */
    public int getConsumption() {
    	return this.consumptionRate;
    }

    /**
     * Returns the current health of the player.
     *
     * @return the current health of the player
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the player.
     *
     * @param health the new health value for the player
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the current food level of the player.
     *
     * @return the current food level of the player
     */
    public int getFood() {
        return food;
    }

    /**
     * Sets the food level of the player.
     *
     * @param food the new food level for the player
     */
    public void setFood(int food) {
        this.food = food;
    }
    
    /**
     * Decreases the food level of the player by the consumption rate.
     *
     * @return the updated food level of the player after decrementing
     */
    public int decrementFood() {
    	food = food - consumptionRate;
    	return food;
    }
   
    /**
     * Increases the sickness count of the player and prints a message if the player becomes sick.
     */
    public void getSick() {
        this.sicknessCount++;
        System.out.println("Player got sick. Sickness count: " + this.sicknessCount);
        if (this.sicknessCount >= 2) {
            this.health = 0; // Simulate immediate death
            System.out.println("Player's health decreased to zero due to sickness!");
        }
    }

    /**
     * Simulates the player's health deteriorating by a specified amount.
     *
     * @param healthDecrease the amount by which the player's health will decrease
     * @return the player's updated health after the decrease
     */
    public int deteriorateHealth(int healthDecrease) {
        this.health -= healthDecrease;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("Health decreased by " + healthDecrease + ". Current health: " + this.health);
        return this.health;
    }

    /**
     * The main method to demonstrate the functionality of the Player class.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        Player player = new Player();

        JOptionPane.showMessageDialog(null,"Player's initial health: " + player.getHealth());
        JOptionPane.showMessageDialog(null,"Player's initial food: " + player.getFood());

        player.deteriorateHealth(10); // Simulating health deterioration
        JOptionPane.showMessageDialog(null,"Player's current health: " + player.getHealth());
    }
}

