import javax.swing.JPanel;

public abstract class AbstractScreen {
    JPanel panel;


    protected abstract void initialize();

    public abstract JPanel getPanel();

    public abstract void resizeBackgroundImages();
    
}
