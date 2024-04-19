import java.io.File;
import javax.swing.JPanel;

public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images\\River.jpg"));

    private Locations location;

    public RiverScreen(Locations location){
        this.location = location;
        initialize();
    }

    @Override
    protected void initialize() {
        
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
    
}
