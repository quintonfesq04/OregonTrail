import javax.swing.JOptionPane;

/**
 * @File Locations.java
 * @author Lane Kanagy
 * @version 1.0.0 4/16/2024
 *This class calculates distance from the final destination, sets the players current 
 *location, and outputs the distance left to travel. It is used as the go-to class for
 *and calculations in relation to location.
 */
public class Locations {
    private int distance = 0;

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

    public static final int KANSAS_DISTANCE = 102;
    public static final int BIG_BLUE_DISTANCE = 185;
    public static final int GREEN_DISTANCE = 989;
    public static final int SNAKE_DISTANCE = 1372;

    private boolean pastKansas = false;
    private boolean pastBigBlue = false;
    private boolean pastGreen = false;
    private boolean pastSnake = false;

    private String riverName;

    public static final String LOCATIONS[] = {"Independence","Courthouse","Chimney Rock","Fort Laramie", "Independence Rock", 
                                                "Fort Bridger", "Soda Springs", "Fort Hall", "Fort Boise", "Fort Boise North",
                                                 "Fort Boise South", "The Dalles", "Oregon City North", "Oregon City South"};
      
    public static final int LOCATION_DISTANCE[] = {0, 566, 587, 663, 846, 1085, 1225, 1289, 1569, 1569, 1915, 2051, 2051};
     
    private String nextLandmark;

    // Constructor for Locations object
    public Locations(int distance){
        this.distance = distance;
    }

    /**
     * moves the player along the trail
     * @param travel the distance to be added
     * @return the new distance
     */
    public int setPlayerPostion(int travel){
        distance = distance + travel;
        return distance;
    }

    /**
     * determines if the player has reached a river
     * @return true if the player has made it to a river, false otherwise
     */
    public boolean hitRiver(){
     // Check if the player has reached any of the rivers
    if (distance >= KANSAS_DISTANCE && !pastKansas) { // if we are at or slightly past kansas river but have not seen it before
        riverName = "Kansas River";
        pastKansas = true;
        JOptionPane.showMessageDialog(null, "You have reached Kansas River!", "River Crossing", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } else if (distance >= BIG_BLUE_DISTANCE && !pastBigBlue) {
        riverName = "Big Blue River";
        pastBigBlue = true;
        JOptionPane.showMessageDialog(null, "You have reached Big Blue River!", "River Crossing", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } else if (distance >= GREEN_DISTANCE && !pastGreen) {
        riverName = "Green River";
        pastGreen = true;
        JOptionPane.showMessageDialog(null, "You have reached Green River!", "River Crossing", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } else if (distance >= SNAKE_DISTANCE && !pastSnake) {
        riverName = "Snake River";
        pastSnake = true;
        JOptionPane.showMessageDialog(null, "You have reached Snake River!", "River Crossing", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    return false;
}
    /**
     * Returns the name of the river that the player has reached
     * @return the name of the river
     */
    public String getRiverName(){
        return riverName;
    }
    
    /**
     * Returns the name of the next landmark to be reached
     * @param currentLoc the location of the player
     * @return the name of the next landmark
     */
    public String nextLocation(int currentLoc){
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
     * uses current loaction as an int to check distance from next location
     */
    public int distanceTo(int currentLoc, String nextLoc){
        int nextLocInt = 0;

        for(int i =0; i<13; i++){
            if(nextLoc.compareTo(LOCATIONS[i]) == 0){
                nextLocInt = LOCATION_DISTANCE[i];
                break;
            }
        }

        return nextLocInt - currentLoc;
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
        nextLandmark = nextLocation(distance);
        return nextLandmark;
    }

    /** 
    *Uses a varible from the main code to manually assign the distance varible a value
    *@param int distance is the value of the range the player is from the final destination
    *@return null
    */
    public Locations(int distance, int location){
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

