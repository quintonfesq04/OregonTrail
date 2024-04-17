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
    public int player_Distance = 0;

    public static final String INDEPENDENCE     =   "Independence";
    public static final String COURTHOUSE       =   "Courthouse";
    public static final String CHIMNEY          =   "Chimney Rock";
    public static final String LARAMIE          =   "Fort Laramie";
    public static final String I_ROCK           =   "Independence Rock";
    public static final String F_BRIDGER        =   "Fort Bridger";
    public static final String S_SPRINGS        =   "Soda Springs";
    public static final String F_HALL           =   "Fort Hall";
    public static final String F_BOISE          =   "Fort Boise";
    public static final String F_BOISE_NORTH    =   "Fort Boise North";
    public static final String F_BOISE_SOUTH    =   "Fort Boise South";
    public static final String DALLES           =   "The Dalles";
    public static final String O_CITY_NORTH     =   "Oregon City North";
    public static final String O_CITY_SOUTH     =   "Oregon City South";

<<<<<<< Updated upstream
    public static final int KANSAS_DISTANCE = 102;
    public static final int BIG_BLUE_DISTANCE = 185;
    public static final int GREEN_DISTANCE = 989;
    public static final int SNAKE_DISTANCE = 1372;
=======
    public static final int KANSAS_RIVER_DISTANCE = 102;
    public static final int RIVER_TWO_DISTANCE = 184;
>>>>>>> Stashed changes

    public static final String LOCATIONS[] = {"Independence","Courthouse","Chimney Rock","Fort Laramie", "Independence Rock", 
                                                "Fort Bridger", "Soda Springs", "Fort Hall", "Fort Boise", "Fort Boise North",
                                                 "Fort Boise South", "The Dalles", "Oregon City North", "Oregon City South"};
      
    public static final int LOCATION_DISTANCE[] = {0, 566, 587, 663, 846, 1085, 1225, 1289, 1569, 1569, 1915, 2051, 2051};
     
    private String nextLandmark;

    public int setPlayerPostion(int travel){
        player_Distance = player_Distance + travel;
        return player_Distance;
    }

    public boolean hitRiver(){
        
    }

    public String whatNextLoc(int currentLoc){
        int test1 = 0, test2 = 0;

        for(int i = 0; i<13; i++){
            test1=LOCATION_DISTANCE[i];
            test2=LOCATION_DISTANCE[i+1];
            if((test1<currentLoc)&&(currentLoc<test2)){
                return LOCATIONS[i+1];
            }
            if((test1==currentLoc)&&(currentLoc==test2)){
                return LOCATIONS[i+1]+" and "+LOCATIONS[i];
            }
        }
        return "At Final Location";
    }

    /*
     * uses current loaction as a String to check distance from next location
     */
    public int distanceFrom(String currentLoc, String nextLoc){
        int currentLocInt = 0;
        int nextLocInt = 0;

        for(int i =0; i<13; i++){
            if(currentLoc.compareTo(LOCATIONS[i])==0){
                currentLocInt = LOCATION_DISTANCE[i];
                break;
            }
        }

        for(int i =0; i<13; i++){
            if(nextLoc.compareTo(LOCATIONS[i])==0){
                nextLocInt = LOCATION_DISTANCE[i];
                break;
            }
        }

        return currentLocInt - nextLocInt;
    }


    /*
     * uses current loaction as an int to check distance from next location
     */
    public int distanceFrom(int currentLoc, String nextLoc){
        int nextLocInt = 0;

        for(int i =0; i<13; i++){
            if(nextLoc.compareTo(LOCATIONS[i])==0){
                nextLocInt = LOCATION_DISTANCE[i];
                break;
            }
        }

        return currentLoc - nextLocInt;
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
        nextLandmark = O_CITY_NORTH;
        return nextLandmark;
    }

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
