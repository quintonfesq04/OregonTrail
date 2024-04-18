import java.io.File;



public class TravelScreen extends AbstractScreen {

    protected PicPanel panel = new PicPanel(new File("Images\\Covered Wagon.jpg"));
    
    private Locations location;

    public TravelScreen(Locations location){
        this.location = location;
    }

    protected void initialize(){
        
    }

    public PicPanel getPanel(){
        return panel;
    }
    
    public void resizeImages(){
        panel.resizeImage();
    }
}
