import javax.swing.JFrame;
import java.awt.EventQueue;
import java.io.File;

public class Map{
    Locations location;
    JFrame frame;
    PicPanel panel;

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


    Map( /*Locations location */){
        //this.location = location;
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setBounds(200,200,200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        panel = new PicPanel("oregonTrail\\Oregon-Trail-Map-Modified.jpg");
        frame.add(panel);
        panel.resizeImage();
    }
}
