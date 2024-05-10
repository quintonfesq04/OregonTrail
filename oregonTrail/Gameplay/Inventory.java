package Gameplay;

public class Inventory {

    // Initial quantities of different items
    private int food = 0;
    private int oxen = 0;
    private double money;
    private int wagonWheel = 0;
    private int wagonTongue = 0;
    private int wagonAxle = 0;
    private int bullets = 0;
    private int clothing = 0;

    // Constants representing item names
    public static final String FOOD = "food";
    public static final String OXEN = "oxen";
    public static final String MONEY = "money";
    public static final String WAGON_WHEEL = "wagon wheel";
    public static final String WAGON_TONGUE = "wagon tongue";
    public static final String WAGON_AXLE = "wagon axle";
    public static final String BULLETS = "bullets";
    public static final String CLOTHING = "clothing";

    // Array of item names for convenience
    public static final String itemNames[] = { "food", "oxen", "money", "wagon wheel",
            "wagon tongue", "wagon axle", "bullets", "clothing" };

    private boolean oxenHealthy = true;

    /**
     * Set the quantity of food in the inventory.
     * 
     * @param number The quantity of food to set.
     */
    public void setFood(int number) {
        this.food = number;
    }

    /**
     * Set the quantity of oxen in the inventory.
     * 
     * @param number The quantity of oxen to set.
     */
    public void setOxen(int number) {
        this.oxen = number;
    }

    /**
     * Set the amount of money in the inventory.
     * 
     * @param number The amount of money to set.
     */
    public void setMoney(int number) {
        this.money = number;
    }

    /**
     * Set the quantitiy of wagon wheels in the inventory
     * 
     * @param number The quantity of wagon wheels to set.
     */
    public void setWagonWheel(int number) {
        this.wagonWheel = number;
    }

    /**
     * Set the quantity of wagon tongues in the inventory
     * 
     * @param number The quantity of wagon tongues to set.
     */
    public void setWagonTongue(int number) {
        this.wagonTongue = number;
    }

    /**
     * Set the quantity of wagon axles in the inventory
     * 
     * @param number The quantity of wagon axles to set.
     */
    public void setWagonAxle(int number) {
        this.wagonAxle = number;
    }

    /**
     * Set the quantity of bullets in the inventory
     * 
     * @param number The quantity of bullets to set.
     */
    public void setBullets(int number) {
        this.bullets = number;
    }

    /**
     * Set the quantity of clothing in the inventory
     * 
     * @param number The quantity of clothing to set.
     */
    public void setClothing(int number) {
        this.clothing = number;
    }

    /**
     * Get the quantity of food in the inventory.
     * 
     * @return The quantity of food.
     */
    public int getFood() {
        return this.food;
    }

    /**
     * Get the quantity of oxen in the inventory.
     * 
     * @return The quantity of oxen.
     */
    public int getOxen() {
        return this.oxen;
    }

    /**
     * Get the amount of money in the inventory.
     * 
     * @return The amount of money.
     */
    public double getMoney() {
        return this.money;
    }

    /**
     * Get the quantity of wagon wheels in the inventory.
     * 
     * @return The quantity of wagon wheels.
     */
    public int getWagonWheel() {
        return this.wagonWheel;
    }

    /**
     * Get the quantity of wagon tongues in the inventory.
     * 
     * @return The quantity of wagon tongues.
     */
    public int getWagonTongue() {
        return this.wagonTongue;
    }

    /**
     * Get the quantity of wagon axles in the inventory.
     * 
     * @return The quantity of wagon axles.
     */
    public int getWagonAxle() {
        return this.wagonAxle;
    }

    /**
     * Get the quantity of bullets in the inventory.
     * 
     * @return The quantity of bullets.
     */
    public int getBullets() {
        return this.bullets;
    }

    /**
     * Get the quantity of clothing in the inventory.
     * 
     * @return The quantity of clothing.
     */
    public int getClothing() {
        return this.clothing;
    }

    /**
     * Get the health status of oxen.
     * 
     * @return True if oxen are healthy, false otherwise.
     */
    public boolean getOxenHealthy() {
        return oxenHealthy;
    }

    /**
     * Set the health status of oxen.
     * 
     * @param oxenHealthy True if oxen are healthy, false otherwise.
     */
    public void setOxenHealthy(boolean oxenHealthy) {
        this.oxenHealthy = oxenHealthy;
    }

    /**
     * Get the quantity of a specific item in the inventory.
     * 
     * @param item The name of the item.
     * @return The quantity of the item, or -1 if the item is not found.
     */
    public int getItemCount(String item) {
        if (item == FOOD) {
            return getFood();
        } else if (item == OXEN) {
            return getOxen();
        } else if (item == WAGON_AXLE) {
            return getWagonAxle();
        } else if (item == WAGON_TONGUE) {
            return getWagonTongue();
        } else if (item == WAGON_WHEEL) {
            return getWagonWheel();
        } else if (item == BULLETS) {
            return getBullets();
        } else if (item == CLOTHING) {
            return getClothing();
        } else
            return -1;

    }

    /**
     * Remove a quantity of a specific item from the inventory.
     * 
     * @param item   The name of the item to remove.
     * @param number The quantity of the item to remove.
     */
    public void removeItem(String item, int number) {
        if (item == FOOD) {
            setFood(getFood() - number);
        } else if (item == OXEN) {
            setOxen(getOxen() - number);
        } else if (item == WAGON_AXLE) {
            setWagonAxle(getWagonAxle() - number);
        } else if (item == WAGON_TONGUE) {
            setWagonTongue(getWagonTongue() - number);
        } else if (item == WAGON_WHEEL) {
            setWagonWheel(getWagonWheel() - number);
        } else if (item == BULLETS) {
            setBullets(getBullets() - number);
        } else if (item == CLOTHING) {
            setClothing(getClothing() - number);
        }

    }

    /**
     * Add a quantity of a specific item to the inventory.
     * 
     * @param item   The name of the item to add.
     * @param number The quantity of the item to add.
     */
    public void addItem(String item, int number) {
        if (item == FOOD) {
            setFood(getFood() + number);
        } else if (item == OXEN) {
            setOxen(getOxen() + number);
        } else if (item == WAGON_AXLE) {
            setWagonAxle(getWagonAxle() + number);
        } else if (item == WAGON_TONGUE) {
            setWagonTongue(getWagonTongue() + number);
        } else if (item == WAGON_WHEEL) {
            setWagonWheel(getWagonWheel() + number);
        } else if (item == BULLETS) {
            setBullets(getBullets() + number);
        } else if (item == CLOTHING) {
            setClothing(getClothing() + number);
        }

    }

}