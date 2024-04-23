package Stuff;

import java.util.Random;

public class Trade {

    private Inventory inventory = new Inventory();

    public String[] createTrade(){
        String tradeOutput[] = {"receive", "R_number", "lose", "L_number"};
        
        String itemList[] = Inventory.itemNames;


        return tradeOutput;
    }
}
