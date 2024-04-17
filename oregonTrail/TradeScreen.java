import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @File TradeScreen.java
 * @author Quinton Fesq
 * @version 1.0.1 4/17/24
 * Creates a TradeScreen panel to display
 */
public class TradeScreen extends JPanel{
    private JPanel panel;
    private Trading trading = new Trading(new Store());
    private Display display;
    private Inventory inventory;
    private Locations location;

    /**
     * Constructor for TradeScreen 
     * @param display the display to push updates to 
     * @param inventory the inventory to make changes to
     * @param location the location of the player along the oregon trail
     */
    public TradeScreen(Display display, Inventory inventory, Locations location){
        this.display = display;
        this.inventory = inventory;
        this.location = location;
        initialize();
    }
    
    /**
     * initialize the JPanel
     */
    private void initialize() {
        // TODO Auto-generated method stub
        panel = new JPanel();
        //panel.setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(3, 1));

        JLabel tradeLabel = new JLabel("Trade 100 Food for 100 Water");
        panel.add(tradeLabel);

        JButton acceptButton = new JButton("Accept");
        JButton rejectButton = new JButton("Reject");

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the trade
                inventory = trading.tradeItems(Item.FOOD, 100, Item.WATER, location.getDistance(), inventory);
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

    /**
     * get the panel 
     * @return
     */
    public JPanel getPanel(){
        return panel;
    }

    /**
     * sets the inventory 
     * @param inventory the desired inventory
     */
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
}
