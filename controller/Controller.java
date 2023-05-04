package se.kth.iv1350.controller;

import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.ItemDTO;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleDTO;

/**
 * Represents a Controller for integration and model layer
 */
public class Controller {
    private AccountingSystem accountSysController;
    private InventorySystem inventorySystemController;
    private Printer printerController;
    private Sale saleController;

    /**
     * Creates a new instance of Controller
     * 
     * @param accountSys
     * @param invSys
     * @param printer
     */
    public Controller(AccountingSystem accountSys, InventorySystem invSys, Printer printer) {
        accountSysController = accountSys;
        inventorySystemController = invSys;
        printerController = printer;
    }

    /**
     * Adds Item found in <code>InventorySystem</code> connected by
     * <code>itemID</code> to <code>Sale</code>
     * 
     * @param itemID
     */
    public void scanItem(int itemID) {
        ItemDTO itemDTOFromDatabase = null;
        itemDTOFromDatabase = inventorySystemController.getItemDTOFromDatabase(itemID);

        Item itemFromDatabase = new Item(itemDTOFromDatabase);
        itemFromDatabase.addToQuantity(1);

        saleController.addNewItemToSale(itemFromDatabase);
    }

    /**
     * Starts a new <code>Sale</code> and links it to controller
     */
    public void startSale() {
        saleController = new Sale();
    }

    /**
     * Ends <code>Sale</code> by updating external systems with current
     * <code>Sale</code>
     */
    public void endSale() {
        SaleDTO saleDTO = null;

        try {
            saleDTO = new SaleDTO(saleController);
        } catch (NullPointerException nullPointerException) {
            return;
        }

        inventorySystemController.updateQuantityFromSale(saleDTO);
        accountSysController.update(saleDTO);
        this.saleController = null;
        printerController.printReceipt(saleDTO.receiptDTO);
    }

    /**
     * Payment for <code>Sale</code> by amount and returning change
     * 
     * @param payment - Given for payment
     * @return Amount exceeding <code>PaymentAmount</code> for current
     *         <code>Sale</code>
     */
    public double paySale(double payment) {
        saleController.getCustomerPaymentForSale().payAmount(payment);
        return saleController.getCustomerPaymentForSale().getChange();
    }

    /**
     * Get <code>SaleDTO</code> for current <code>Sale</code> linked to
     * <code>Controller</code>
     * 
     * @return - data transfer object for <code>Sale</code>
     */
    public SaleDTO getSaleDTO() {
        SaleDTO saleDTO = new SaleDTO(saleController);
        return saleDTO;
    }

    /**
     * Get method for current sale linked to controller
     * 
     * @return - current sale
     */
    public Sale getSaleController() {
        return saleController;
    }
}
