import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TradeScreen extends AbstractScreen{
    private JPanel panel;
    private Trading trading = new Trading(new Store());
    private Display display;
    private Inventory inventory;

    public TradeScreen(Display display, Inventory inventory){
        this.display = display;
        initialize();
    }
    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        panel = new JPanel();
        //panel.setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(3, 1));

        JLabel tradeLabel = new JLabel("Trade 100 Food for 2 Oxen");
        panel.add(tradeLabel);

        JButton acceptButton = new JButton("Accept");
        JButton rejectButton = new JButton("Reject");

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the trade
                trading.tradeItems("Food", 100, "Oxen", 0);
                JOptionPane.showMessageDialog(null, "Trade accepted!");
                display.showTravelScreen(inventory);
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Trade rejected!");
                display.showTravelScreen(inventory);
            }
        });

        panel.add(acceptButton);
        panel.add(rejectButton);
    }

    public JPanel getPanel(){
        return panel;
    }

	@Override
	public void resizeBackgroundImages() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'resizeBackgroundImages'");
	}
    

}
