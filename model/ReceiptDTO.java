package se.kth.iv1350.model;

import java.time.LocalTime;

/**
 * Represents the Data Transfer Object for the receipt
 */
public class ReceiptDTO {
    public double totalVAT;
    public double totalSalePrice;
    public LocalTime date;
    public double change;
    public String[] itemName;
    public double[] itemPrice;
    public double[] itemVAT;
    public int[] itemQuantity;

    /**
     * Creates a new instance representing the ReceiptDTO from Receipt
     * 
     * @param receipt - The Receipt to convert
     */
    public ReceiptDTO(Receipt receipt) {
        totalVAT = receipt.getTotalVAT();
        totalSalePrice = receipt.getTotalSalePrice();
        date = receipt.getDate();
        change = receipt.getChange();
        itemName = receipt.getItemNameArray();
        itemPrice = receipt.getItemPrice();
        itemVAT = receipt.getItemVATArray();
        itemQuantity = receipt.getItemQuantity();
    }
}
