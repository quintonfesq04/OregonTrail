package Stuff;
import javax.swing.JFrame;
import java.io.File;

/**
 * @File Map.java
 * @author Ethan Burch
 * @version 1.0.0 4/15/24
 * creates a stand alone JFrame that displays the map
 */
public class Map{
    //private Locations location;
    private JFrame frame;
    private PicPanel viewPanel;
    private File image;
    Locations location;


    /**
     * updates the location of the player along the trail
     * @return
     */
    private File updateLocation(){
        String loc = location.getNextLandmark();

        for (int i = 0; i < Locations.LOCATIONS.length;i++){
            if(loc.compareTo(Locations.LOCATIONS[i]) == 0){
                
                /* make sure to comment the other file out if you are on a different device. If you use mac comment out windows
                   if you use windows commetn out mac */

                //use if on mac
                File file = new File("Images/Oregon Trail Map " + i + ".jpg");

                //use if on windows
                //File file = new File("Images\\Oregon Trail Map " + i + ".jpg");
                return file;
            }
        }
        return null;
    }

    /**
     * displays a JFrame with a picture representing where a player is along the trail
     * @param location the location of the player along the trail
     */
    public void display(Locations location){
        this.location = location;
        image = updateLocation();
        
        frame = new JFrame();
        frame.setBounds(400,200,700,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        viewPanel = new PicPanel(image);
		
        frame.add(viewPanel);
        frame.setVisible(true);
        viewPanel.resizeImage();
    }

    public void display(){
        //this.location = location;
        image = new File("Images\\Oregon Trail Map.jpg");
        
        frame = new JFrame();
        frame.setBounds(400,200,700,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        viewPanel = new PicPanel(image);
		
        frame.add(viewPanel);
        frame.setVisible(true);
        viewPanel.resizeImage();
    }
    
}
