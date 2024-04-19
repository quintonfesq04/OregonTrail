import java.io.File;
import javax.swing.JPanel;

public class RiverScreen extends AbstractScreen {
    private PicPanel viewPanel = new PicPanel(new File("Images\\River.jpg"));

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override
    public void resizeImages() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeImages'");
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
    
}
