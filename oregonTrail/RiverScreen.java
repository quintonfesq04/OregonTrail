import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @File RiverScreen.java
 * @author Madison Scott
 * @version 1.0.0 4/17/24
 * Creates a JPanel for river portion of the game
 * Represents the screen for crossing a river.
 * This panel displays the river image and provides controls for crossing the river.
 */
public class RiverScreen extends JPanel {

    private JPanel panel = new JPanel();
    private Display display; // Add reference to Display
    private PicPanel viewPanel;
    private Locations locations;
    private int height = 10;
    private int flow = 10;
    private int width = 50;

    /**
     * Constructs a RiverScreen object.
     * @param display The reference to the main display.
     * @param location The Locations object containing information about the river.
     */

    public RiverScreen(Display display, Locations location){
        this.locations = location;
        this.display = display;
        initialize();
    }
    
    /**
     * Initializes the RiverScreen panel.
     */

    protected void initialize(){
        panel.setLayout(new GridLayout(2,1,0,0));

        // Load river image
        File image = new File("Images/River.jpg");
        viewPanel = new PicPanel(image);
        panel.add(viewPanel);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        panel.add(buttonPanel);
        
        JLabel heightLbl = new JLabel("Height: " + height);
        heightLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(heightLbl);

        JLabel flowLbl = new JLabel("Flow: " + flow);
        flowLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(flowLbl);

        JLabel widthLbl = new JLabel("Width: " + width);
        widthLbl.setForeground(Color.LIGHT_GRAY);
        buttonPanel.add(widthLbl);

        // Create cross river button
        JButton crossBtn = new JButton("Cross river");
        crossBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Create a river object
                
                River river = new River(locations.getRiverName(), height, flow, width);
                // Attempt to cross the river
                if(river.crossRiver()){
                    JOptionPane.showMessageDialog(null, "Successfully crossed the " + river.getName() + " river");
                    display.showTravelScreen();
                }
                else{
                    JOptionPane.showMessageDialog(null, "You did not cross the " + river.getName() + " river");
                }
            }
        });
        buttonPanel.add(crossBtn);
    }

     /**
     * Returns the RiverScreen panel.
     * @return JPanel containing river image and controls for crossing the river.
     */
    public JPanel getPanel(){
        return panel;
    }
}
