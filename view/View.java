package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.exceptions.InventoryDatabaseException;
import se.kth.iv1350.exceptions.MissingItemIDException;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.ItemDTO;
import se.kth.iv1350.model.SaleDTO;

/**
 * represent the view that a cashier would have
 */
public class View {
    private Controller contr;

    /**
     * creates a new instance of View with method calls that starts a sale process
     * 
     * @param contr
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * preform a fake sale by calling all the system operation in the controller.
     */
    public void runFakeExecution() {
        startSale();
        registerItems();
        concludeSale();
    }

    /**
     * fetches item from through itemID
     * 
     * @param itemID - item to be fetched
     */
    private void fetchItem(int itemID) {
        try {
            contr.scanItem(itemID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * preform a fake sale by calling all the system operation in the controller.
     */
    public void registerItems() {
        System.out.println("Scanning itemID: 121");
        fetchItem(121);

        System.out.println("Scanning itemID: 123");
        fetchItem(123);

        System.out.println("Scanning itemID: 121");
        fetchItem(121);
    }

    private void startSale() {
        contr.startSale();
        System.out.println("A new Sale has started.");
    }

    private void concludeSale() {
        double totalAmount = contr.getSaleDTO().customerPaymentDTO.amountToPay;
        System.out.println("Total is: " + totalAmount + " $.");
        double change = contr.paySale(2);
        System.out.println("Customer pays: 120 $");
        System.out.println("Customer receives change: " + change + " $.");

        ReceiptDTO rec = contr.getSaleDTO().receiptDTO;
        logReciept(rec);

        contr.endSale();
        System.out.println("The Sale has concluded.");
    }

    private void logReciept(ReceiptDTO rec) {
        System.out.println("Log Receipt");
        System.out.println("Total VAT: " + rec.totalVAT);
        System.out.println("Total Price: " + rec.totalSalePrice);
        System.out.println("Change: " + rec.change);
        System.out.println("Date: " + rec.date);

        System.out.println("Items in sale:");
        for (int i = 0; i < rec.itemName.length; i++) {
            String name = rec.itemName[i];
            double price = rec.itemPrice[i];
            double vat = rec.itemVAT[i];
            int qty = rec.itemQuantity[i];

            System.out.println("Name: " + name + ", Price: " + price + ", VAT: " + vat + ", Quantity: " + qty);
        }
    }
}
