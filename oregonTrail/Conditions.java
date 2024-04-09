import java.util.Random;

public class Conditions {
    private static Random random = new Random ();
    private Inventory inventory;
    private String eventInfo;

    public Conditions(Inventory inventory){
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    // Method to check if a random event occurred
    public static boolean isEventOccurred() {
        int eventChance = random.nextInt(10); // Generate a random number between 0 and 9
        if(eventChance == 0)
            return true;
        return false;
    }

    // Method to handle inventory changes based on random events and return updated inventory
    public Inventory handleInventory() {
        eventInfo = "";
        int num;
        if (isEventOccurred()) {
            int event = random.nextInt(3); // Random event: 0 - Weather, 1 - Thieves, 2 - Wagon breakdown
            switch (event) {
                case 0:
                    // Weather event
                    String[] weathers = {"Sunny", "Rainy", "Snowy"};
                    String weather = weathers[random.nextInt(weathers.length)];
                    // Handle weather effects on inventory here if needed
                    eventInfo = "Random Weather Event: " + weather;  
                    break;

                case 1:
                    // Thieves event
                    eventInfo = "Random Event: Thieves attacked your wagon!";   

                    String[] itemNames = {"food", "water"};

                    num = random.nextInt(2);

                    String item = itemNames[num];


                    // Handle thieves stealing supplies from inventory             

                    int stolenAmount = random.nextInt(inventory.getItemCount(item) + 1);
                    inventory.removeItem(item, stolenAmount);
                    eventInfo += " " + stolenAmount + " " + item + " stolen by thieves.";
                    break;

                case 2:
                    // Wagon breakdown event
                    eventInfo = "Random Event: Your wagon broke down.";
                    // Handle wagon breakdown effects on inventory here if needed
                    String[] wagonParts = {"wheel", "tongue", "axle"};

                    num = random.nextInt(3);

                    String part = wagonParts[num];

                    if(inventory.getItemCount(part) > 0){
                        inventory.removeItem(part, 1);
                    }
                    else{
                        eventInfo += " You were unable to fix it!";
                    }
                    break;
            }
        }
        return this.inventory;
    }

    public String getConditionMessage(){
        return eventInfo;
    }
}