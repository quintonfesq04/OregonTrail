package Gameplay;

/**
 * Controls the different options of the wagon.
 * 
 * This class manages various aspects related to the wagon, including inventory,
 * locations, conditions, conversations,
 * player information, trade, and the store.
 * 
 * @author Ethan Burch
 * @author Madison Scott
 * @version 1.0.0, 4/30/24
 */
public class Wagon {
    private Inventory inventory = new Inventory();
    private Locations locations = new Locations(0);
    private Conditions conditions = new Conditions(this);
    private Conversations conversations = new Conversations();
    private Player player = new Player();
    private Trade trade = new Trade();
    private Store store = new Store();

    /**
     * Default constructor for the Wagon class.
     */
    public Wagon() {
        // Default Constructor
    }

    /**
     * Sets the inventory of the wagon.
     * 
     * @param inventory The inventory to be set.
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets the inventory of the wagon.
     * 
     * @return The inventory of the wagon.
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Sets the locations of the wagon.
     * 
     * @param locations The locations to be set.
     */
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    /**
     * Gets the locations of the wagon.
     * 
     * @return The locations of the wagon.
     */
    public Locations getLocations() {
        return this.locations;
    }

    /**
     * Sets the conditions of the wagon.
     * 
     * @param conditions The conditions to be set.
     */
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    /**
     * Gets the conditions of the wagon.
     * 
     * @return The conditions of the wagon.
     */
    public Conditions getConditions() {
        return this.conditions;
    }

    /**
     * Sets the conversations of the wagon.
     * 
     * @param conversations The conversations to be set.
     */
    public void setConversations(Conversations conversations) {
        this.conversations = conversations;
    }

    /**
     * Gets the conversations of the wagon.
     * 
     * @return The conversations of the wagon.
     */
    public Conversations getConversations() {
        return this.conversations;
    }

    /**
     * Sets the player of the wagon.
     * 
     * @param player The player to be set.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the player of the wagon.
     * 
     * @return The player of the wagon.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the trade of the wagon.
     * 
     * @param trade The trade to be set.
     */
    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    /**
     * Gets the trade of the wagon.
     * 
     * @return The trade of the wagon.
     */
    public Trade getTrade() {
        return this.trade;
    }

    /**
     * Sets the store of the wagon.
     * 
     * @param store The store to be set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets the store of the wagon.
     * 
     * @return The store of the wagon.
     */
    public Store getStore() {
        return this.store;
    }
}