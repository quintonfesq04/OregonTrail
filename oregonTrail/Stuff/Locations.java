package Stuff;

/**
 * Locations.java -- stores the location of the player along the trail
 * @author Ethan Burch
 * @author Madison Scott
 * @version 1.0.0 4/18/24
 */
public class Locations {

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

    
    public Locations(){

    }

    public String getNextLandmark(){
        return new String();
    }
}
