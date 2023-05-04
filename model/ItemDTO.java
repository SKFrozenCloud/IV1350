package se.kth.iv1350.model;

/**
 * Represents a Data Transfer Object of Item
 */
public class ItemDTO {
    public int itemID;
    public double price;
    public double VAT;
    public String name;
    public int quantity;

    /**
     * Creates an instance representing a Data Transfer Object of imp
     * 
     * @param itemID   -
     * @param price
     * @param VAT
     * @param name
     * @param quantity
     */
    public ItemDTO(int itemID, double price, double VAT, String name, int quantity) {
        this.itemID = itemID;
        this.price = price;
        this.VAT = VAT;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Creates an instance representing a Data Transfer Object of an Item
     * 
     * @param item - Item to extract data from
     */
    public ItemDTO(Item item) {
        this.itemID = item.getItemID();
        this.price = item.getPrice();
        this.VAT = item.getVAT();
        this.name = item.getName();
        this.quantity = item.getQuantity();
    }
}
