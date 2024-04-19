import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * MapChecker.java -- displays the map when M key is pressed
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public class MapChecker extends KeyAdapter {
    Locations location;
    Map map = new Map();

    public MapChecker(Locations location) {
        this.location = location;
    }

    @Override
    public void keyPressed(KeyEvent e){
        int vk = e.getKeyCode();
        if(vk == KeyEvent.VK_M){
            map.display();
        }
        else 
            System.out.println((char)vk);
    }
}
