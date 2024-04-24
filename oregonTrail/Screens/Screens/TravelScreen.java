package Screens;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.util.Arrays;
import Screens.*;
import Stuff.*;
import Hunting.*;

/**
 * TravelScreen.java -- the screen seen when traveling
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public class TravelScreen extends AbstractScreen {
    private Cloud cloud = new Cloud(50,50,new File("Images\\Cloud.png"));

    protected PicPanel viewPanel = new PicPanel(new File("Images\\Covered Wagon.jpg"));

    private Locations locations;
    private Conditions conditions;
    private Display display;
    private Trade trade;


    public TravelScreen(Locations location, Conditions conditions, Display display){
        this.locations = location;
        this.conditions = conditions;
        this.display = display;
        this.trade = trade;
        initialize();
    }

    @Override
    protected void initialize(){
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        viewPanel.setLayout(null);

        cloud.setPreferredSize(new Dimension(100,100));
        cloud.setSize(cloud.getPreferredSize());

        viewPanel.add(cloud);
        viewPanel.addKeyListener(new MapChecker(locations));
        viewPanel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_SPACE)
                    travel();
                else if (vk == KeyEvent.VK_I)
                    display.showControlScreen();
                
            }
        });
    }

    @Override
    public PicPanel getPanel(){
        return viewPanel;
    }

    @Override
    public void resizeImages(){
        viewPanel.resizeImage();
        //cloud.resizeImage();
    }

    public void updateScreen(Locations locations, Conditions conditions){
        this.locations = locations;
        this.conditions = conditions;
        initialize();
    }
    
    private void arriveAtLandmark() {
    	String nextLandmark = locations.getNextLandmark();
        int landmarkIndex = Arrays.asList(Locations.LOCATIONS).indexOf(nextLandmark);
        if (landmarkIndex != -1 && cloud.getX() >= locations.LOCATION_DISTANCE[landmarkIndex]) {
            if(locations.hitRiver()){
            	display.showRiverScreen();
            }
            else if (trade.tradeTime()) {
                    display.showTradeScreen();
            }
            else if (conditions.eventInfo.contains("Your wagon broke down")) {
            	display.showWagonGame();
            }
            else {
            		display.showLandmarkScreen();
            	}
            }
        }
    

    private void travel(){
        if(cloud.getX() < viewPanel.getWidth())
            cloud.update(50);
        else
            cloud.setX(-100);
        cloud.setLocation(cloud.getX(), cloud.getY());
    }
}
