import java.awt.Color;

import javax.swing.JFrame;
import java.io.File;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeathScreen extends AbstractScreen{
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();

    @Override
    protected void initialize() {
        frame = new JFrame();
		frame.setBackground(new Color(78, 78, 78));
		frame.getContentPane().setBackground(new Color(78, 78, 78));
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

        File image = new File("Images/death screen.jpg");

        viewPanel = new PicPanel(image);
        viewPanel.setBackground(Color.BLUE);
        panel.add(viewPanel);
        viewPanel.repaint();
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }
    
}
