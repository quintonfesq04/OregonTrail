/**
 * A class that keeps track of damage done to the wagon as well as the wagon's weight.
 * It connects to other classes by providing functionality to track wagon status.
 * @File Wagon.java
 * @author Ethan Burch
 * @version 1.0 4/3/2024
 */
public class Wagon {

    private int weight;
    private boolean broken;

    /**
     * Default constructor for Wagon class.
     */
    public Wagon() {
        // Initialize the wagon with default values
        this.weight = 0;
        this.broken = false;
    }

    /**
     * Check if the wagon is broken.
     * 
     * @return true if wagon is broken, false otherwise
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Set the status of the wagon (broken or not).
     * 
     * @param broken a boolean determining if the wagon is broken
     */
    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    /**
     * Get the weight of the wagon.
     * 
     * @return the weight of the wagon
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Set the weight of the wagon. If the weight provided is negative, take the absolute value.
     * 
     * @param weight the desired weight of the wagon
     */
    public void setWeight(int weight) {
        this.weight = Math.abs(weight);
    }
}
