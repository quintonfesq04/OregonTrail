package Gameplay;

public class Wagon {
    private Inventory inventory = new Inventory();
    private Locations locations = new Locations(0);
    private Conditions conditions = new Conditions(inventory);
    private Player player = new Player();
    private Trade trade = new Trade();
    private Store store = new Store();

    private Wagon(){

    }
    
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setLocations(Locations locations){
        this.locations = locations;
    }

    public Locations getLocations(){
        return this.locations;
    }

    public void setConditions(Conditions conditions){
        this.conditions = conditions;
    }

    public Conditions getConditions(){
        return this.conditions;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setTrade(Trade trade){
        this.trade = trade;
    }

    public Trade getTrade(){
        return this.trade;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public Store getStore(){
        return this.store;
    }
}
