import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.File;


public class Map{
    //private Locations location;
    private JFrame frame;
    private PicPanel viewPanel;
    private File image = new File("Images\\Oregon Trail Map.jpg");
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

    

    public void update(Locations location){
        
    }

    public void display(){
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
