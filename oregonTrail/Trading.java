public class Trading {
    private Store store;

    public Trading(Store store) {
        this.store = store;
    }

    // Method to display available items for trade
    public void displayTradeItems() {
        store.displayTradeItems();
    }

    // Method to perform trading between items
    public void tradeItems(String itemToSell, double amountToSell, String itemToBuy, int landmarkIndex) {
        // Calculate the price of the item to sell
        double sellPrice = store.calculateItemPrice(itemToSell, landmarkIndex);

        // Calculate the price of the item to buy
        double buyPrice = store.calculateItemPrice(itemToBuy, landmarkIndex);

        // Calculate the quantity of the item to buy
        double amountToBuy = (amountToSell * sellPrice) / buyPrice;

        // Display the trade details
        System.out.println("Trade details:");
        System.out.println("Selling " + amountToSell + " units of " + itemToSell + " at $" + sellPrice + " each.");
        System.out.println("Buying " + amountToBuy + " units of " + itemToBuy + " at $" + buyPrice + " each.");
    }
}
