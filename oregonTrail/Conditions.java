import java.util.Random;

public class Conditions {
    public static void main(String[] args) {
        Random random = new Random(); 
        int milesTraveled = 0; 
        int supplies = 1000; // Initial supplies
        int daysPassed = 0; 
        boolean wagonBroken = false; 
        int consumptionRate; 

        System.out.println("Welcome to the Oregon Trail!");

        // Set consumption rate based on travel condition: 0 - Meager, 1 - Bare bones, 2 - Filling
        int travelCondition = random.nextInt(3);
        switch (travelCondition) {
            case 0:
                consumptionRate = 25; // Meager consumption rate
                System.out.println("You're traveling in meager conditions. Supplies will be consumed quickly.");
                break;
            case 1:
                consumptionRate = 15; // Bare bones consumption rate
                System.out.println("You're traveling in bare bones conditions. Supplies will be consumed moderately.");
                break;
            case 2:
                consumptionRate = 10; // Filling consumption rate
                System.out.println("You're traveling in filling conditions. Supplies will be consumed slowly.");
                break;
            default:
                consumptionRate = 20; // Default consumption rate
                break;
        }

        while (milesTraveled < 2000 && supplies > 0) {
            daysPassed++;
            int event = random.nextInt(4); // Random event: 0 - Weather, 1 - Thieves, 2 - Broken Wagon, 3 - Normal Day

            switch (event) {
                case 0:
                    int weather = random.nextInt(3); // Random weather: 0 - Sunny, 1 - Rainy, 2 - Snowy
                    switch (weather) {
                        case 0:
                            System.out.println("It's sunny today, making your journey easier.");
                            break;
                        case 1:
                            System.out.println("It's raining today, slowing down your progress.");
                            milesTraveled -= 10; // Rain slows down progress
                            break;
                        case 2:
                            System.out.println("It's snowy today, making travel difficult.");
                            milesTraveled -= 20; // Snow makes travel very difficult
                            break;
                    }
                    break;
                case 1:
                    System.out.println("Thieves attacked your wagon! They stole some supplies.");
                    int stolenSupplies = random.nextInt(200) + 50; // Random amount of supplies stolen by thieves
                    supplies -= stolenSupplies;
                    break;
                case 2:
                    if (!wagonBroken) {
                        System.out.println("Your wagon broke down.");
                        int fixChoice = random.nextInt(3); // Random choice for fixing the wagon: 0 - Axle, 1 - Wheel, 2 - Tongue
                        switch (fixChoice) {
                            case 0:
                                System.out.println("You used a wagon axle to fix the wagon.");
                                break;
                            case 1:
                                System.out.println("You used a wagon wheel to fix the wagon.");
                                break;
                            case 2:
                                System.out.println("You used a wagon tongue to fix the wagon.");
                                break;
                        }
                        wagonBroken = false;
                    } else {
                        System.out.println("Your wagon is still broken. You cannot travel until it's fixed.");
                    }
                    break;
                case 3:
                    System.out.println("It's a normal day. You make progress on your journey.");
                    break;
            }

            supplies -= consumptionRate; // Update supplies based on consumption rate
            milesTraveled += random.nextInt(50) + 50; // Random miles traveled each day

            System.out.println("Day " + daysPassed + ": Traveled " + milesTraveled + " miles. Supplies: " + supplies);

            try {
                Thread.sleep(5000); // Pause for a second to simulate a day passing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (milesTraveled >= 2000) {
            System.out.println("Congratulations! You've reached Oregon.");
        } else {
            System.out.println("Game over! You've run out of supplies or encountered too many obstacles.");
        }
    }
}

