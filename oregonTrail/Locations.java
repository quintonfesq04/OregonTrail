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
    private static int tot_Distance = 2051; 
    public int player_Distance = 0;

    public final String Independace = "Independace";
    public final String Courthouse = "Courthouse";
    public final String Chimney = "Chimney Rock";
    public final String Laramie = "Fort Laramie";
    public final String iRock = "Independace Rock";
    
    public final String LOCATIONS[] = {"Independace","Courthouse","Chimney Rock","Fort Laramie", "Independace Rock"};

    private String nextLandmark;

    public int setPlayerPostion(int travel){
        player_Distance = player_Distance + travel;
        return player_Distance;
    }

    /**
     * moves along the trail
     * @param distance the number to move along by
     */
    public void addDistance(int distance){
        this.distance += distance;
    }

    /**
     * obtain next landmark
     * @return String for next landmark
     */
    public String getNextLandmark(){
        return nextLandmark;
    }

    /*public String getPlayerPostion(){
        if(player_Distance == 0){
            return "At Independace";
        }
        else if(player_Distance<566){
            return Integer.toString(566-player_Distance)+" From Courthouse Rock";
        }
        else if(player_Distance == 566){
            return "At Courthouse Rock";
        }
        else if(player_Distance<(566+21)){
            return Integer.toString(566+21-player_Distance)+" From Courthouse Rock";
        }
        else 
            return "huh";
    }*/

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
}
    /**
    *Used to update the distance the player is from the target location
    *@param int travel speed is the amount of distance that can be traveled in one "turn"
    *@return int distance is the updated value that the player is from the final destination
    */
    /*public int calculateDistance(int travelSpeed){
        distance -= travelSpeed;
        if (distance < 0)
            distance = 0;
        return distance;
    }

}
*/
