public class Hunting {
    public int performHunting() {
        // Perform hunting mini-game
        int yield = generateRandomNumber() * 10;
        System.out.println("You went hunting and caught " + yield + " pounds of food.");
        return yield;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10); // Generate a random number for hunting yield
    }
}
