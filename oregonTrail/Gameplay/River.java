package Gameplay;
import java.util.Random;

import Gameplay.*;
import Screens.*;
import Hunting.*;
/**
 * River.java
 * @author Madison Scott
 * @version 1.2.0 4/20/24
 * This program represents a river using attributes 
 * like its name, height, flow rate, and width. The crossRiver() method 
 * simulates crossing attempts with random success chances based on the river's features.
 */
 public class River extends Locations {
     // Attributes
     private String name; // Name of the river
     private int height; // Height of the river (in meters)
     private int flow; // Flow rate of the river (in cubic meters per second)
     private int width; // Width of the river (in meters)
     private double crossingProbability; // Probability of successfully crossing the river
     
 
     /**
      * Constructor for River class.
      *
      * @param name   The name of the river.
      * @param height The height of the river (in meters).
      * @param flow   The flow rate of the river (in cubic meters per second).
      * @param width  The width of the river (in meters).
      */
     public River(String name, int height, int flow, int width) {
        super(0); // Calls the constructor of the parent class Locations with a distance of 0
        this.name = name;
        this.height = height;
        this.flow = flow;
        this.width = width;
        this.crossingProbability = 0.8;
     }


 
    
     /**
      * Get the name of the river.
      *
      * @return The name of the river.
      */
     public String getName() {
         return name;
     }
 
     /**
      * Attempt to cross the river.
      *
      * @return True if the crossing is successful, false otherwise.
      */
     public boolean crossRiver() {
        
        double random = new Random().nextDouble();
   

        // Check if the crossing is successful based on random chance and success threshold
        return random < crossingProbability;
    }
 }
