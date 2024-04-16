import java.util.Random;


public class River {

    // Class representing a river

    private String name;

    private int height;

    private int flow;

    private int width;



    public River(String name, int height, int flow, int width) {

        this.name = name;

        this.height = height;

        this.flow = flow;

        this.width = width;

    }



    public String getName() {
        return name;
    }



    public boolean crossRiver() {

        // Random chance of crossing success

        Random random = new Random();

        int crossingChance = random.nextInt(10); // Generating a random number between 0 to 9



        int successThreshold = (int) ((100 - height) * (100 - flow) * (100 - width) * 0.25); // Adjusted based on height, flow, and width



        if (crossingChance < successThreshold) {

            System.out.println("Successfully crossed the river " + name);

            return true;

        } else {

            System.out.println("Failed to cross the river " + name);

            return false;

        }

     }

}