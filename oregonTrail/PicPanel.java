import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class PicPanel extends JPanel {

    private Image backgroundImage;

    PicPanel(String fileName){
        try {                
            backgroundImage = ImageIO.read(new File("image name and path"));
         } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not found! Path Attempted: " + fileName);
         }
    }

    PicPanel(File fileName){
        try{
            backgroundImage = ImageIO.read(fileName);
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Image not found! path Attempted: " + fileName.getPath());
        }
    }

    PicPanel(Image backgroundImage){
        this.backgroundImage = backgroundImage;
        resizeImage();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    public void resizeImage(){
        backgroundImage = backgroundImage.getScaledInstance(super.getWidth(), super.getHeight(), Image.SCALE_SMOOTH);
    }

    public void resizeImage(int width, int height){
        backgroundImage = backgroundImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

}
