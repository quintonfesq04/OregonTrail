package StartScreen;

import javax.imageio.ImageIO;
import javax.swing.*;

import Gameplay.*;
import Hunting.*;
import Screens.*;
import StartScreen.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMonth extends AbstractScreen {
    protected PicPanel viewPanel = new PicPanel(new File("Images/Background.jpg"));
	private static final int TEXT_FIELD_MAX = 20;
    private Wagon wagon;
    private Display display;

    private JPanel panel;
	private Font titleFont = new Font("Trajan Pro", Font.BOLD, 24);
	private Font smallFont = new Font("Trajan Pro", Font.PLAIN, 16);

    public ChooseMonth(Wagon wagon, Display display) {
        this.wagon = wagon;
        this.display = display;
        initialize();
    }

    @Override
    protected void initialize() {
        viewPanel.setFocusable(true);
        GridBagLayout gbl_viewPanel = new GridBagLayout();
        gbl_viewPanel.columnWeights = new double[]{0.0, 1.0};
        viewPanel.setLayout(gbl_viewPanel);
    }

    @Override
    public void resizeImages() {
        viewPanel.resizeImage(); 
    }

    @Override
    public JPanel getPanel() {
        return viewPanel;
    }
    
}
