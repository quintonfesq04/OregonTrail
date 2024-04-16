import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RiverScreen extends AbstractScreen {

    JPanel panel = new JPanel();
    PicPanel viewPanel;

    RiverScreen(){
        initialize();
    }

    protected void initialize(){
        panel.setLayout(new GridLayout(2,1,0,0));

        File image = new File("Images\\River.jpg");
        viewPanel = new PicPanel(image);
        panel.add(viewPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        panel.add(buttonPanel);

        JButton crossBtn = new JButton("Cross river");
        crossBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                River river = new River("Kansas", 10, 10, 50);
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

    public void resizeBackgroundImages(){
        viewPanel.resizeImage();
    }

}
