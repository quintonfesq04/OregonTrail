package oregonTrail;

public class Travel {
    private int speed;
    
    private int milesTraveled;
    
    private int distanceToLandmark;
    
    public Travel(){
        this.speed = 30;
        this.milesTraveled = 0;
        this.distanceToLandmark = 100;
    }
    
    public Travel(int speed, int distanceToLandmark){
        this.speed = speed;
        this.milesTraveled = 0;
        this.distanceToLandmark = distanceToLandmark;
    }
    
    public Travel(int speed, int milesTraveled, int distanceToLandmark){
        this.speed = speed;
        this.milesTraveled = milesTraveled;
        this.distanceToLandmark = distanceToLandmark;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public int getMilesTraveled(){
        return this.milesTraveled;
    }
    
    public int distanceToLandmark(){
        return this.distanceToLandmark;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void setMilesTraveled(int milesTraveled){
        this.milesTraveled = milesTraveled;
    }

    public void setDistanceToLandmark(int distanceToLandmark){
        this.distanceToLandmark = distanceToLandmark;
    }
    
}
