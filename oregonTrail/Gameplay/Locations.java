package Gameplay;

import javax.swing.JOptionPane;

/**
 * Locations.java -- This class tracks the player's position along the trail.
 * 
 * This class manages the player's position along the trail, including landmarks reached,
 * distances traveled, and river crossings.
 * 
 * @author Ethan Burch
 * @author Madison Scott
 * @version 1.5.0 4/19/2024
 */
public class Locations {
    private Display display;
    private Wagon wagon;

    public int distance = 0; // Distance traveled along the trail

    // Constants for landmark names
    public static final String INDEPENDENCE = "Independence";
    public static final String COURTHOUSE = "Courthouse";
    public static final String CHIMNEY = "Chimney Rock";
    public static final String LARAMIE = "Fort Laramie";
    public static final String I_ROCK = "Independence Rock";
    public static final String F_BRIDGER = "Fort Bridger";
    public static final String S_SPRINGS = "Soda Springs";
    public static final String F_HALL = "Fort Hall";
    public static final String F_BOISE = "Fort Boise";
    public static final String F_BOISE_NORTH = "Fort Boise North";
    public static final String F_BOISE_SOUTH = "Fort Boise South";
    public static final String DALLES = "The Dalles";
    public static final String O_CITY_NORTH = "Oregon City North";
    public static final String O_CITY_SOUTH = "Oregon City South";
    
    // Constants for distances to landmarks
    public static final int KANSAS_DISTANCE = 102;
    public static final int BIG_BLUE_DISTANCE = 185;
    public static final int GREEN_DISTANCE = 989;
    public static final int SNAKE_DISTANCE = 1372;
       
    // Flags to track whether the player has passed certain landmarks and rivers
    private boolean pastKansas = false;
    private boolean pastBigBlue = false;
    private boolean pastGreen = false;
    private boolean pastSnake = false;
    private boolean leftStartingLandmark = false;  // Flags to track whether the player has passed certain landmarks and rivers

    private String riverName; // Name of the river reached by the player
    private String nextLandmark; // Name of the next landmark to be reached

    // Array of landmark names
    public static final String LOCATIONS[] = {  "Independence", "Courthouse", "Chimney Rock", "Fort Laramie",
                                                "Independence Rock", "Fort Bridger", "Soda Springs", "Fort Hall", 
                                                 "Fort Boise North", "Fort Boise South", "The Dalles",
                                                "Oregon City North", "Oregon City South" };

    // Array of distances to landmarks                       
    public static final int LOCATION_DISTANCE[] = { 0, 566, 587, 663, 846, 1085, 1225, 1289, 1596, 1569, 1915, 2051, 2051, 2051 };

    // Constructor for Locations object
    public Locations(int distance) {
        this.distance = distance;
    }
    
    /**
     * Moves the player along the trail by the specified distance.
     * 
     * @param travel The distance to move the player.
     * @return The new distance traveled along the trail.
     */
    public int setPlayerPostion(int travel) {
        distance = distance + travel;
        return distance;
    }

    /**
     * Checks if the player has reached a river and displays a message if so.
     * 
     * @return True if the player has reached a river, otherwise false.
     */
    public boolean hitRiver() {
        // Check if the player has reached any of the rivers
        if (distance >= KANSAS_DISTANCE && !pastKansas) { 
            riverName = "Kansas River";
            pastKansas = true;
            JOptionPane.showMessageDialog(null, "You have reached Kansas River!", "River Crossing",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (distance >= BIG_BLUE_DISTANCE && !pastBigBlue) {
            riverName = "Big Blue River";
            pastBigBlue = true;
            JOptionPane.showMessageDialog(null, "You have reached Big Blue River!", "River Crossing",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (distance >= GREEN_DISTANCE && !pastGreen) {
            riverName = "Green River";
            pastGreen = true;
            JOptionPane.showMessageDialog(null, "You have reached Green River!", "River Crossing",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (distance >= SNAKE_DISTANCE && !pastSnake) {
            riverName = "Snake River";
            pastSnake = true;
            JOptionPane.showMessageDialog(null, "You have reached Snake River!", "River Crossing",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        return false;
    }

     /**
     * Returns the name of the river that the player has reached.
     * 
     * @return The name of the river.
     */
    public String getRiverName() {
        return riverName;
    }
    

    /**
     * Returns the name of the next landmark to be reached based on the current location.
     * 
     * @param currentLoc The current location of the player.
     * @return The name of the next landmark.
     */
    public String nextLocation(int currentLoc) {
        for (int i = 0; i < LOCATION_DISTANCE.length - 1; i++) {
            if (currentLoc >= LOCATION_DISTANCE[i] && currentLoc < LOCATION_DISTANCE[i + 1]) {
                if (currentLoc >= 2051) { // Modified condition here
                    // Display end game screen or message
                    display.showEndGame(wagon);
                    return "End of the Trail";
                } else {
                    return LOCATIONS[i];
                }
            }
        }
        return "Unknown Location"; 
    }
    /**
     * Returns the name of the current location based on the distance traveled.
     * 
     * @param distance The distance traveled by the player.
     * @return The name of the current location.
     */
    public String getLocation(int currentLoc) {
        int test1 = 0, test2 = 0;
    
        for (int i = 0; i < 13; i++) {
            test1 = LOCATION_DISTANCE[i];
            test2 = LOCATION_DISTANCE[i + 1];
            if ((test1 < currentLoc) && (currentLoc < test2)) {
                return LOCATIONS[i];
            }
            if ((test1 == currentLoc) && (currentLoc == test2)) {
                return LOCATIONS[i + 1] + " and " + LOCATIONS[i];
            }
        }
        return "At Final Location";
    }

    /**
     * Calculates the distance from the current location to the next location.
     * 
     * @param currentLoc The current location of the player.
     * @param nextLoc The name of the next location.
     * @return The distance to the next location.
     */
    public int distanceTo(int currentLoc, String nextLoc) {
        int nextLocInt = 0;
        for (int i = 0; i < 13; i++) {
            if (nextLoc.compareTo(LOCATIONS[i]) == 0) {
                nextLocInt = LOCATION_DISTANCE[i];
                break;
            }
        }
        return nextLocInt - currentLoc;
    }

   /**
     * Adds distance traveled along the trail.
     * 
     * @param distance The distance to be added.
     */
    public void addDistance(int distance) {
        this.distance += distance;
    }

    /**
     * Obtains the name of the next landmark.
     * 
     * @return The name of the next landmark.
     */
    public String getNextLandmark() {
        nextLandmark = nextLocation(distance);
        return nextLandmark;
    }

    /**
     * Returns the name of the current location based on distance traveled.
     * 
     * @param distance The distance traveled by the player.
     * @return The name of the current location.
     */
    public String getCurrentLocation(int distance) {
        for (int i = 0; i < LOCATION_DISTANCE.length - 1; i++) {
            if (distance >= LOCATION_DISTANCE[i] && distance < LOCATION_DISTANCE[i + 1]) {
                return LOCATIONS[i];
            }
        }
        // If the distance is beyond the last known location, return the final location
        return LOCATIONS[LOCATIONS.length - 1];
    }

    public Locations(Conversations conversations) {
        //TODO Auto-generated constructor stub
    }

    /**
     * Allows the value of distance from final destination to be called
     * 
     * @param void
     * @return int distance is the value that the player is from the final
     *         destination
     */
    public int getDistance() {
        return this.distance;
    }

    /**
    * Sets the distance traveled along the trail to a specified value.
    * 
    * @param distance The new distance traveled along the trail.
    */
    public void setDistance(int distance) {
        this.distance = distance;
    }
    

    /**
     * Checks if the player has left the starting landmark.
     * 
     * @param currentLocation The current location of the player.
     * @return True if the player has left the starting landmark, otherwise false.
     */
    public boolean hasLeftStartingLandmark(int currentLocation) {
    	if(currentLocation > 0) {
    		leftStartingLandmark = true;
    	}
    	else {
    		leftStartingLandmark = false;
    	}
		return leftStartingLandmark;
    }
}