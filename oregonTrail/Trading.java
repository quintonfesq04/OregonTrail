import javax.swing.JOptionPane;

public class Trading {
    private Inventory inventory;

    public Trading(Inventory inventory) {
        this.inventory = inventory;
    }

    public void tradeWith(String trader) {
        switch (trader) {
            case "Trappers":
                tradeWithTrappers();
                break;
            case "Natives":
                tradeWithNatives();
                break;
            case "Other Travelers":
                tradeWithOtherTravelers();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Trader Type!");
                break;
        }
    }

    private void tradeWithTrappers() {
        // implement logic
    }

    private void tradeWithNatives() {
        // implement logic
    }

    private void tradeWithOtherTravelers() {
        // implement logic
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Trading trading = new Trading(inventory);

        trading.tradeWith("Trappers");
        trading.tradeWith("Natives");
        trading.tradeWith("Other Travelers");
    }
}
