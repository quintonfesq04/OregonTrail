import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TravelScreen.java -- the screen seen when traveling
 * @author Ethan Burch
 * @version 1.0.0 4/18/24
 */
public class TravelScreen extends AbstractScreen {
    private PicPanel cloud = new PicPanel(new File("Images\\Cloud.png"));

    protected PicPanel viewPanel = new PicPanel(new File("Images\\Covered Wagon.jpg"));

    private Locations location;

    private int LocX = 50;
    private int LocY = 50; 

    public TravelScreen(Locations location){
        this.location = location;
        initialize();
    }

    @Override
    protected void initialize(){
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        viewPanel.setLayout(null);
        cloud.setPreferredSize(new Dimension(100,100));
        cloud.setSize(cloud.getPreferredSize());
        cloud.setOpaque(false);
        viewPanel.add(cloud);
        cloud.setLocation(LocX,LocY);
        viewPanel.addKeyListener(new MapChecker(location));
        viewPanel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_SPACE)
                    UpdateImages(50);
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

    public void UpdateImages(int speed){
        if(LocX < viewPanel.getWidth())
            LocX += speed;
        else
        
        cloud.setLocation(LocX, LocY);
    }
}
