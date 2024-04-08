

/**
 * a class that keeps track of damage done to wagon as well as the wagons weight
 * 
 * @author Ethan Burch
 * @version 1.0  4/3/2024
 */
public class Wagon {

	private int weight;
	
	private boolean broken;
	
	public Wagon() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * tells you if the wagon is broken
	 * @return true if wagon is broken, false otherwise
	 */
	public boolean isBroken() {
		return broken;
	}
	
	/**
	 * sets if the wagon is broken
	 * @param broken a boolean determining if the wagon is broken
	 */
	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	
	/**
	 * receive the weight of the wagon
	 * @return the weight of the wagon
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Set the weight of the wagon. 
	 * @param Weight the desired weight of the wagon. If negative will take the absolute value.
	 */
	public void setWeight(int weight) {
		if (weight < 0) {
			weight *= -1;
		}
		this.weight = weight;
	}
}