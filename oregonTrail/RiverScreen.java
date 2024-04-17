import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RiverScreen extends JPanel {

    private JPanel panel = new JPanel();
    private Display display; // Add reference to Display
    private PicPanel viewPanel;

    public RiverScreen(Display display){
        this.display = display;
        initialize();
    }

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

        // Create cross river button
        JButton crossBtn = new JButton("Cross river");
        crossBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Create a river object
                River river = new River("Kansas", 10, 10, 50);
                // Attempt to cross the river
                if(river.crossRiver()){
                    JOptionPane.showMessageDialog(null, "Successfully crossed the " + river.getName() + " river");
                }
                else{
                    JOptionPane.showMessageDialog(null, "You did not cross the " + river.getName() + " river");
                }
            }
        });
        buttonPanel.add(crossBtn);
    }

    public JPanel getPanel(){
        return panel;
    }
}
