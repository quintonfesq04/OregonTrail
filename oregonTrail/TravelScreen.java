import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;


/**
 * TravelScreen.java -- the screen seen when traveling
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public class TravelScreen extends AbstractScreen {

    protected PicPanel viewPanel = new PicPanel(new File("Images\\Covered Wagon.jpg"));
    
    private Locations location;

    public TravelScreen(Locations location){
        this.location = location;
    }

    protected void initialize(){
        viewPanel.setFocusable(true);
        viewPanel.requestFocus();
        //viewPanel.addKeyListener(new MapChecker(location));
        viewPanel.addKeyListener( new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_M){
                    Map map = new Map();
                    map.display();
                }
                else 
                    System.out.println(vk);
            }
        });
    }

    public PicPanel getPanel(){
        return viewPanel;
    }
    
    public void resizeImages(){
        viewPanel.resizeImage();
    }
}
