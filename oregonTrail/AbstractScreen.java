import javax.swing.JPanel;

public abstract class AbstractScreen {

    protected abstract void initialize();
    
    public abstract void resizeImages();

    public abstract JPanel getPanel();
}
