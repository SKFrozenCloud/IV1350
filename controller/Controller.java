package se.kth.iv1350.controller;

import se.kth.iv1350.exceptions.InventoryDatabaseException;
import se.kth.iv1350.exceptions.MissingItemIDException;
import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Controller for integration and model layer
 */
public class Controller {
    private AccountingSystem accountSysController;
    private InventorySystem inventorySystemController;
    private Printer printerController;
    private Sale saleController;
    private List<CustomerPaymentObserver> customerPaymentObservers = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
    private DeveloperLog developerLog = new DeveloperLog();

    /**
     * Creates a new instance of Controller
     * 
     * @param accountSys - accounting system linked to controller
     * @param invSys     - inventory system linked to controller
     * @param printer    - printer linked to controller
     */
    public Controller(AccountingSystem accountSys, InventorySystem invSys, Printer printer) {
        accountSysController = accountSys;
        inventorySystemController = invSys;
        printerController = printer;
    }

    /**
     * Adds new an observer for CustomerPayment class to the controller
     * 
     * @param customerPaymentObserver - the observer to be added
     */
    public void addCustomerPaymentObserver(CustomerPaymentObserver customerPaymentObserver) {
        customerPaymentObservers.add(customerPaymentObserver);
    }

    /**
     * Adds Item found in <code> InventorySystem </code> connected by
     * <code> itemID </code> to <code>Sale</code>
     * 
     * @param itemID - itemId to be searched for
     * @throws OperationFailedException - thrown if there is server issues or if
     *                                  there is no match for ItemID in the
     *                                  inventriy system
     */
    public void scanItem(int itemID) throws OperationFailedException {
        ItemDTO itemDTOFromDatabase = null;

        try {
            itemDTOFromDatabase = inventorySystemController.getItemDTOFromDatabase(itemID);
        } catch (MissingItemIDException missingItemID) {
            throw new OperationFailedException("Item was not found in inventory", missingItemID);

        } catch (InventoryDatabaseException inventoryDatabaseDown) {
            developerLog.addExceptionToLog(inventoryDatabaseDown.getMessage());
            throw new OperationFailedException("Inventory server is down", inventoryDatabaseDown);
        }

        Item itemFromDatabase = new Item(itemDTOFromDatabase);

        itemFromDatabase.addToQuantity(1);

        saleController.addNewItemToSale(itemFromDatabase);
    }

    /**
     * Starts a new <code>Sale</code> and links it to controller
     */
    public void startSale() {
        saleController = new Sale();
        saleController.getCustomerPaymentForSale().addCustomerPaymentObservers(customerPaymentObservers);
        saleController.getCustomerPaymentForSale().setTotalRevenueFileOutput(totalRevenueFileOutput);
    }

    /**
     * Ends <code>Sale</code> by updating external systems with current
     * <code>Sale</code>
     */
    public void endSale() {
        SaleDTO saleDTO = new SaleDTO(saleController);
        inventorySystemController.updateQuantityFromSale(saleDTO);
        accountSysController.update(saleDTO);
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
}
