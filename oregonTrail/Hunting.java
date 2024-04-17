import javax.swing.JOptionPane;

/**
 * @File Hunting.java
 * @author Quinton Fesq
 * @version 1.0.0 4/16/24
 * Allows for hunting minigame
 */
public class Hunting {

    private Inventory inventory;

    public Hunting(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Perform hunting mini-game.
     * @return The amount of food obtained from hunting.
     */
    public int performHunting() {
        int yield = generateRandomNumber() * 10;
        JOptionPane.showMessageDialog(null, "You went hunting and caught " + yield + " pounds of food.");
        inventory.addItem(Item.FOOD, yield); // Add the obtained food to the inventory
        return yield;
    }

    /**
     * Generate a random number for hunting yield.
     * @return A random number between 0 and 10.
     */
    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
