public class Locations {
    private int distance;
    private static int tot_Distance = 2051; 
    public int player_Distance = 0;

    // Array of landmark names
    public static final String[] LOCATIONS = {"Independence", "Courthouse", "Chimney Rock", "Fort Laramie", "Independence Rock", 
                                              "Fort Bridger", "Soda Springs", "Fort Hall", "Fort Boise", "Fort Boise North",
                                              "Fort Boise South", "The Dalles", "Oregon City North", "Oregon City South"};

    private String nextLandmark;

    // Constructor with distance parameter
    public Locations(int distance) {
        this.distance = distance;
    }

    // Method to add distance
    public void addDistance(int distance) {
        this.distance += distance;
    }

    // Method to get next landmark
    public String getNextLandmark() {
        nextLandmark = LOCATIONS[0]; // Just an example, you can implement logic to determine the next landmark
        return nextLandmark;
    }

    // Method to get current distance
    public int getDistance() {
        return this.distance;
    }

    // Method to set distance
    public void setDistance(int distance) {
        this.distance = distance;
    }
}