public class Player {
    private int health;
    private int food;
    private int sicknessCount;

    public Player() {
        this.health = 100; // Starting health
        this.food = 50;    // Starting food
        this.sicknessCount = 0; 

    }
    public Player(int health, int food, int sicknessCount) {
    	this.health = health;
    	this.food = food;
    	this.sicknessCount = sicknessCount;
    }

    // Getter and setter methods for health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and setter methods for food
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

   
    public void getSick() {
        this.sicknessCount++;
        System.out.println("Player got sick. Sickness count: " + this.sicknessCount);
        if (this.sicknessCount >= 2) {
            this.health = 0; // Simulate immediate death
            System.out.println("Player's health decreased to zero due to sickness!");

        }
    }

    // Method to simulate player's health deteriorating
    public void deteriorateHealth(int healthDecrease) {
        this.health -= healthDecrease;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("Health decreased by " + healthDecrease + ". Current health: " + this.health);
    }

    public static void main(String[] args) {
        Player player = new Player();

        System.out.println("Player's initial health: " + player.getHealth());
        System.out.println("Player's initial food: " + player.getFood());

       
        player.deteriorateHealth(10); // Simulating health deterioration
        System.out.println("Player's current health: " + player.getHealth());
    }
}

