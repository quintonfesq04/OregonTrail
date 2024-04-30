package Gameplay;

import java.util.Random;

import Gameplay.Inventory;

public class Trade {

    private Inventory inventory = new Inventory();
    private static Random random = new Random();
    
    // Method to check if it's time for a trade
    public boolean tradeTime() {
        // Adjust the probability as needed
        return random.nextInt(50) == 0; // 1 in 50 chance for trade
    } 

    // Method to create a random trade offer
    public String[] createTrade() {
        String tradeOutput[] = new String[4];
        String itemList[] = Inventory.itemNames;

        // Generate random item indices
        int itemIndex1 = random.nextInt(itemList.length);
        int itemIndex2 = random.nextInt(itemList.length);

        // Ensure that the two items are different
        while (itemIndex2 == itemIndex1) {
            itemIndex2 = random.nextInt(itemList.length);
        }

        // Assign items to trade
        tradeOutput[0] = itemList[itemIndex1];
        tradeOutput[2] = itemList[itemIndex2];

        // Generate random quantities based on item types
        int randomNumber1 = generateRandomQuantity(itemIndex1);
        int randomNumber2 = generateRandomQuantity(itemIndex2);

        // Assign quantities to trade
        tradeOutput[1] = Integer.toString(randomNumber1);
        tradeOutput[3] = Integer.toString(randomNumber2);

        return tradeOutput;
    }

    // Method to handle accepting a trade offer
    public String acceptTrade(String tradeOutput[]) {
        String receiveItem = tradeOutput[0];
        int receiveCount = Integer.parseInt(tradeOutput[1]);
        String giveItem = tradeOutput[2];
        int giveCount = Integer.parseInt(tradeOutput[3]);

        // Check if the player has enough of the item to give away
        int playerItemCount = inventory.getItemCount(giveItem);
        if (playerItemCount < giveCount) {
            return "Trade failed: Not enough items to trade.";
        }

        // Execute the trade by adding the received item and removing the given item from the inventory
        inventory.addItem(receiveItem, receiveCount);
        inventory.removeItem(giveItem, giveCount);

        return "Trade success";
    }

    // Method to generate random quantity based on item type
    private int generateRandomQuantity(int itemIndex) {
        String[] itemList = Inventory.itemNames;
        // Adjust quantity ranges as needed for different item types
        if (itemIndex == 0 || itemIndex == 2 || itemIndex == 6) {
            // Food, Money, Bullets: 1-32
            return random.nextInt(32) + 1;
        } else {
            // Other items: 1-4
            return random.nextInt(3) + 1;
        }
    }
}
