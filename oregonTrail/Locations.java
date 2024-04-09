/**
 * @file Locations.java
 * @Team Chimney Rock
 * @04/08/2024
 *This class calculates distance from the final destination, sets the players current 
 *location, and outputs the distance left to travel. It is used as the go-to class for
 *and calculations in relation to location.
 */
public class Locations {
    private int distance;

    /**
    *Uses a varible from the main code to manually assign the distance varible a value
    *@param int distance is the value of the range the player is from the final destination
    *@return null
    */
    public Locations(int distance){
        this.distance = distance;
    }

    /**
    *Allows the value of distance from final destination to be called
    *@param void
    *@return int distance is the value that the player is from the final destination 
    */
    public int getDistance(){
        return this.distance;
    }

    /**
    *Uses a varible from the main code to manually assign the distance varible a value
    *@param int distance is the value of the range the player is from the final destination
    *@return void
    */
    public void setDistance(int distance){
        this.distance = distance;
    }

    /**
    *Used to update the distance the player is from the target location
    *@param int travel speed is the amount of distance that can be traveled in one "turn"
    *@return int distance is the updated value that the player is from the final destination
    */
    public int calculateDistance(int travelSpeed){
        distance -= travelSpeed;
        if (distance < 0)
            distance = 0;
        return distance;
    }
}
