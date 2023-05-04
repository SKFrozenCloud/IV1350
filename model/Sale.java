package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a Sale with different attributes
 */
public class Sale {
    private LocalDateTime timeOfStartedSale;
    private ArrayList<Item> itemsCurrentlyInSale = new ArrayList<>();
    private double discount;
    private Receipt receiptForSale;
    private CustomerPayment customerPaymentForSale;

    /**
     * Creates a new instance representing the different parts of a sale
     */
    public Sale() {
        this.timeOfStartedSale = LocalDateTime.now();
        receiptForSale = new Receipt();
        customerPaymentForSale = new CustomerPayment();
    }

    /**
     * Gets an array of the Items in the sale
     * 
     * @return the Items in Sale
     */
    public ArrayList<Item> getItemsCurrentlyInSale() {
        return itemsCurrentlyInSale;
    }

    /**
     * Gets the CustomerPayment for the Sale
     * 
     * @return the CustomerPayment
     */
    public CustomerPayment getCustomerPaymentForSale() {
        return customerPaymentForSale;
    }

    /**
     * Gets discount value in sale
     * 
     * @return the double value of the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * gets Time for when the Sale was created
     * 
     * @return the time stamp of initated sale
     */
    public LocalDateTime getTimeOfStartedSale() {
        return timeOfStartedSale;
    }

    /**
     * Gets the Receipt created for the Sale
     * 
     * @return Receipt for sale
     */
    public Receipt getReceiptForSale() {
        return receiptForSale;
    }

    public void updateExternal(Sale saleForUpdate) {
    }

    /**
     * Shows if the entered item is already in Sale
     * 
     * @param item - the Item to control
     * @return Boolean value for the item check
     */
    public boolean isItemInSale(Item item) {
        boolean isItemInSale = false;

        if (item == null) {
            return isItemInSale;
        }

        for (Item itemSearch : itemsCurrentlyInSale) {
            if (itemSearch.getItemID() == item.getItemID())
                isItemInSale = true;
        }

        return isItemInSale;
    }

    /**
     * adds new entered Item to Sale in quantity and object
     * 
     * @param itemToAddToSale - Item to add in Sale
     */
    public void addNewItemToSale(Item itemToAddToSale) {
        if (isItemInSale(itemToAddToSale)) {
            for (Item item : itemsCurrentlyInSale) {
                if (item.getItemID() == itemToAddToSale.getItemID()) {
                    item.addToQuantity(1);
                }
            }
        }

        else {
            itemsCurrentlyInSale.add(itemToAddToSale);
        }

        customerPaymentForSale.increaseAmountToPay(itemToAddToSale.getPrice());
        receiptForSale.addRow(itemToAddToSale);

    }

}
