package se.kth.iv1350.model;

import java.time.LocalDateTime;

/**
 * Represents a Receipt with its attributes
 */
public class Receipt {
    private double totalVAT;
    private double totalSalePrice;
    private LocalDateTime timeOfReceiptCreation;
    private double change;
    private String[] itemName = new String[0];
    private double[] itemPrice = new double[0];
    private double[] itemVAT = new double[0];
    private int[] itemQuantity = new int[0];
    private int receiptRowPosition = 0;

    /**
     * Creates a new instance of an empty Receipt with a timestamp
     */
    public Receipt() {
        this.timeOfReceiptCreation = LocalDateTime.now();
    }

    /**
     * Gets the array of ItemQuantity connected to itemName, itemPrice, itemVat
     * 
     * @return The array with index connected to itemName, itemPrice, itemVat
     */
    public int[] getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Sets change amount
     * 
     * @param saleChange - change for sale
     */
    public void setChange(double saleChange) {
        change = saleChange;
    }

    /**
     * Gets change amount
     * 
     * @return the change on Receipt
     */
    public double getChange() {
        return change;
    }

    /**
     * Gets an Items name by element in list
     * 
     * @param elementInItemList - which row the fetch
     * @return name of item
     */
    public String getItemNameByElement(int elementInItemList) {
        return itemName[elementInItemList];
    }

    /**
     * gets Items price array with connection to itemName, itemQuantity, itemVat
     * 
     * @return an array with item prices corresponding to indexes in itemName,
     *         itemQuantinty, itemVat
     */
    public double[] getItemPrice() {
        return itemPrice;
    }

    /**
     * Get array with ItemName with connection to itemPrice, itemQuantity, itemVat
     * 
     * @return an array with Item names corresponding to indexes in itemPrice,
     *         itemQuantity, itemVat
     */
    public String[] getItemNameArray() {
        return itemName;
    }

    /**
     * get array with Item VAT with connection to itemName, itemQuantity, itemPrice
     * 
     * @return an array with Item VATS corresponding to indexes in itemPrice,
     *         itemQuantity, itemName
     */
    public double[] getItemVATArray() {
        return itemVAT;
    }

    /**
     * Gets sum of VAT on Receipt
     * 
     * @return Total VAT on Receipt
     */
    public double getTotalVAT() {
        return totalVAT;
    }

    /**
     * Gets sum of SalePRice on Receipt
     * 
     * @return total salePrice on Receipt
     */
    public double getTotalSalePrice() {
        return totalSalePrice;
    }

    /**
     * Gets timestamp on Receipt
     * 
     * @return Date for Receipt creation
     */
    public LocalDateTime getDate() {
        return timeOfReceiptCreation;
    }

    /**
     * Adds Item to Receipt
     * 
     * @param itemToBeAddedOnReceipt - Item to be added on Receipt
     */
    public void addRow(Item itemToBeAddedOnReceipt) {
    }
}
