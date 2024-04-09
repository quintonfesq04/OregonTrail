/**
 * @file Locations.java
 * @author Lane Kanagy
 * @version 1.0.0 4/8/24
 */
public class Locations {
    private int distance;

    public Locations(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return this.distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public int calculateDistance(int travelSpeed){
        distance -= travelSpeed;
        if (distance < 0)
            distance = 0;
        return distance;
    }
}
