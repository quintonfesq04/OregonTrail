/**
 * @File Item.java
 * @author Ethan Burch
 * @version 1.0.1 4/17/24
 * Storing class for different item types
 */
public interface Item {
    // constant Names for different item types
    public final String MONEY           = "money";
    public final String FOOD            = "food";
    public final String OXEN            = "oxen";
    public final String WAGON_TONGUE    = "tongue";
    public final String WAGON_WHEEL     = "wheel";
    public final String WAGON_AXLE      = "axle";
    public final String CLOTHES         = "clothes";
    public final String BULLETS         = "bullets";
    public final String WATER           = "water";
    public void removeItem(String money2, int quantity);
}
