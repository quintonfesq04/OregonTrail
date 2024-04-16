import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.File;


public class Map{
    //private Locations location;
    private JFrame frame;
    private PicPanel viewPanel;
    private File image;
    Locations location;

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map window = new Map();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    private File updateLocation(){
        
        //////
    }

    public void display(Locations location){
        image = updateLocation();

        frame = new JFrame();
        frame.setBounds(200,200,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        
        viewPanel = new PicPanel(image);
		
        frame.add(viewPanel);
        frame.setVisible(true);
        viewPanel.resizeImage();
    }
}
