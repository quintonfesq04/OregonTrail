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
    private Cloud cloud = new Cloud(50,50,new File("Images\\Cloud.png"));
    private Cloud cloud2 = new Cloud(200,80, new File("Images\\Cloud.png"));

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

        cloud2.setPreferredSize(new Dimension(75,50));
        cloud2.setSize(cloud2.getPreferredSize());

        viewPanel.add(cloud);
        viewPanel.add(cloud2);
        viewPanel.addKeyListener(new MapChecker(location));
        viewPanel.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_SPACE)
                    travel();
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

    private void travel(){
        if(cloud.getX() < viewPanel.getWidth())
            cloud.update(50);
        else
            cloud.setX(-100);

        if(cloud2.getX() < viewPanel.getWidth())
            cloud2.update(100);
        else
            cloud2.setX(-100);
        cloud.setLocation(cloud.getX(), cloud.getY());
        cloud2.setLocation(cloud.getX(), cloud.getY());
        
    }
}
