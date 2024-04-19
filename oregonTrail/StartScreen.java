import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;


public class StartScreen extends AbstractScreen{
    protected PicPanel viewPanel = new PicPanel(new File("Images/start screen0.jpg"));
    protected PicPanel viewPanel1 = new PicPanel(new File("Images/Intro prompt0.jpg"));
    private Display display;
    private Timer timer;
    private int alpha;

    private int imageIndex = 0;

    public StartScreen(Display display) {
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        viewPanel.requestFocusInWindow();
        //viewPanel.addKeyListener(new MapChecker(location));
        viewPanel.addKeyListener( new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                viewPanel.requestFocusInWindow();
                int vk = e.getKeyCode();
                if(vk == KeyEvent.VK_M){
                    Map map = new Map();
                    map.display();
                }
                else 
                    System.out.println(vk);
            }
        });

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(300, 500, 200, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start(); // Start fading out the current screen
            }
        });
        viewPanel.add(startButton);
    }

    private void switchToNextImage() {
        // Increment the image index
        imageIndex++;
        if (imageIndex == 1) {
            viewPanel.setImage(image1); // Switch to the second image
        } else {
            // If there are no more images, do something (like start the game)
            // For now, just reset the image index
            imageIndex = 0;
            viewPanel.setImage(image); // Switch back to the first image
        }
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage();
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            timer.start(); // Start fading out the current screen
        }
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
