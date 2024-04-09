
/**
 * Calculates and tracks the speed and miles traveled
 * @File Travel.java
 * @author Ethan Burch
 * @version 1.0  4/3/2024
 */

public class Travel {
    private int speed;
    
    private int milesTraveled;
    
    private int distanceToLandmark;
    
    /**
     * Constructor for Travel object
     */
    public Travel(){
        this.speed = 30;
        this.milesTraveled = 0;
        this.distanceToLandmark = 100;
    }
    
    /**
     * Constructor for Travel object
     * @param speed the speed the wagon is traveling at
     * @param distanceToLandmark the distance from the wagon to the next landmark
     */
    public Travel(int speed, int distanceToLandmark){
        this.speed = speed;
        this.milesTraveled = 0;
        this.distanceToLandmark = distanceToLandmark;
    }
    
    /**
     * Constructor for Travel object
     * @param speed the speed the wagon is traveling at
     * @param milesTraveled the miles currently traveled by the wagon
     * @param distanceToLandmark the distance from the wagon to the next landmark
     */
    public Travel(int speed, int milesTraveled, int distanceToLandmark){
        this.speed = speed;
        this.milesTraveled = milesTraveled;
        this.distanceToLandmark = distanceToLandmark;
    }
    
    /**
     * get the speed that the wagon is traveling at 
     * @return the speed of the wagon
     */
    public int getSpeed(){
        return this.speed;
    }
    
    /**
     * get the miles traveled by the wagon
     * @return the miles traveled
     */
    public int getMilesTraveled(){
        return this.milesTraveled;
    }
    
    /**
     * get the distance to the nearest landmark
     * @return the distance to the landmark
     */
    public int distanceToLandmark(){
        return this.distanceToLandmark;
    }
    
    /**
     * sets the speed of the wagon
     * @param speed the desired speed
     */
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    /**
     * sets the miles traveled by the wagon
     * @param milesTraveled the desired miles traveled
     */
    public void setMilesTraveled(int milesTraveled){
        this.milesTraveled = milesTraveled;
    }

    /**
     * sets the distance to the nearest landmark
     * @param distanceToLandmark the desired distance to the landmark
     */
    public void setDistanceToLandmark(int distanceToLandmark){
        this.distanceToLandmark = distanceToLandmark;
    }
    
}
