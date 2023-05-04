package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.model.ReceiptDTO;

/**
 * represent the view that a cahsier would have
 */
public class View {
    private Controller contr;
    int itemID2;
    int itemID1;

    /**
     * creates a new instance of View with method calls that starts a sale process
     * 
     * @param contr
     */
    public View(Controller contr) {
        this.contr = contr;
        itemID2 = 123;
        itemID1 = 121;
    }

    /**
     * preform a fake sale by calling all the system operation in the controller.
     */
    public void runFakeExecution() {
        startSale();
        registerItems();
        concludeSale();
    }

    public void registerItems() {
        System.out.println("Scanning itemID: 121");
        contr.scanItem(itemID1);

        System.out.println("Scanning itemID: 123");
        contr.scanItem(itemID2);

        System.out.println("Scanning itemID: 121");
        contr.scanItem(itemID1);
    }

    private void startSale() {
        contr.startSale();
        System.out.println("A new Sale has started.");
    }

    private void concludeSale() {
        double totalAmount = contr.getSaleDTO().customerPaymentDTO.amountToPay;
        System.out.println("Total is: " + totalAmount + " $.");
        double change = contr.paySale(110);
        System.out.println("Customer pays: 110.0 $");
        System.out.println("Customer receives change: " + change + " $.");

        ReceiptDTO rec = contr.getSaleDTO().receiptDTO;
        logReciept(rec);

        contr.endSale();
        System.out.println("The Sale has concluded.");
    }

    private void logReciept(ReceiptDTO rec) {
        System.out.println("Total VAT: " + rec.totalVAT);
        System.out.println("Total Price: " + rec.totalSalePrice);
        System.out.println("Change: " + rec.date);
        System.out.println("Date: " + rec.change);

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
