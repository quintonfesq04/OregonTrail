import java.util.Random;

import javax.swing.JOptionPane;

public class River extends Locations {
    private String name;
    private int height;
    private int flow;
    private int width;

    public River(String name, int height, int flow, int width) {
        super(0); // Calls the constructor of the parent class Locations with a distance of 0
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
            JOptionPane.showMessageDialog(null,"Successfully crossed the river " + name);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Failed to cross the river " + name);
            return false;
        }
    }
}