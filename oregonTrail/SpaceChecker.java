import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SpaceChecker extends KeyAdapter {
    Locations location;

    public SpaceChecker(Locations location){
        this.location = location;
    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Map map = new Map();
            map.display(location);
        }
    }
}
