package Gameplay;

import java.util.Random;

/**
 * Trade.java -- Handles trading events in the game.
 * 
 * This class manages trading events that occur during the game.
 * It determines when trading occurs, generates random trade offers, and handles
 * accepting trade offers.
 * 
 * @author Lane Kanagy
 * @author Quinton Fesq
 * @version 1.2.0
 */
public class Trade {

    private Inventory inventory = new Inventory(); // Inventory object to manage player's items
    private static Random random = new Random(); // Random object for generating random numbers

    /**
     * Checks if it's time for a trade event to occur.
     * 
     * @return True if it's time for a trade, false otherwise.
     */
    public boolean tradeTime() {
        // Adjust the probability as needed
        return random.nextInt(50) == 0; // 1 in 50 chance for trade
    }

    /**
     * Generates a random trade offer.
     * 
     * @return An array representing the trade offer, containing the names and
     *         quantities of items involved.
     */
    public String[] createTrade() {
        String tradeOutput[] = new String[4]; // Array to store trade offer
        String itemList[] = Inventory.itemNames; // Array of item names

        // Generate random item indices
        int itemIndex1 = random.nextInt(itemList.length);
        int itemIndex2 = random.nextInt(itemList.length);

        // Ensure that the two items are different
        while (itemIndex2 == itemIndex1) {
            itemIndex2 = random.nextInt(itemList.length);
        }

        // Assign items to trade
        tradeOutput[0] = itemList[itemIndex1]; // Item to receive
        tradeOutput[2] = itemList[itemIndex2]; // Item to give

        // Generate random quantities based on item types
        int randomNumber1 = generateRandomQuantity(itemIndex1);
        int randomNumber2 = generateRandomQuantity(itemIndex2);

        // Assign quantities to trade
        tradeOutput[1] = Integer.toString(randomNumber1); // Quantity of item to receive
        tradeOutput[3] = Integer.toString(randomNumber2); // Quantity of item to give

        return tradeOutput; // Return the trade offer
    }

    /**
     * Handles accepting a trade offer.
     * 
     * @param tradeOutput An array representing the trade offer, containing the
     *                    names and quantities of items involved.
     * @return A message indicating the outcome of the trade.
     */
    public String acceptTrade(String tradeOutput[]) {
        String receiveItem = tradeOutput[0]; // Item to receive
        int receiveCount = Integer.parseInt(tradeOutput[1]); // Quantity of item to receive
        String giveItem = tradeOutput[2]; // Item to give
        int giveCount = Integer.parseInt(tradeOutput[3]); // Quantity of item to give

        // Check if the player has enough of the item to give away
        int playerItemCount = inventory.getItemCount(giveItem);
        if (playerItemCount < giveCount) {
            return "Trade failed: Not enough items to trade."; // Trade failed if not enough items
        }

        // Execute the trade by adding the received item and removing the given item
        // from the inventory
        inventory.addItem(receiveItem, receiveCount); // Add received item
        inventory.removeItem(giveItem, giveCount); // Remove given item

        return "Trade success"; // Trade successful
    }

    /**
     * Generates a random quantity based on item type.
     * 
     * @param itemIndex The index of the item in the itemNames array.
     * @return The randomly generated quantity.
     */
    private int generateRandomQuantity(int itemIndex) {
        String[] itemList = Inventory.itemNames; // Array of item names
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