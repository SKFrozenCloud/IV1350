package se.kth.iv1350.model;

/**
 * Represents an Item
 */
public class Item {
    private int itemID;
    private double price;
    private double VAT;
    private String name;
    private int quantity = 0;

    /**
     * Creates a new instance of an Item with a Data Transfer Object
     * 
     * @param itemDTO - Item Data Transfer Object to extract attributes from
     */
    public Item(ItemDTO itemDTO) {
        this.itemID = itemDTO.itemID;
        this.price = itemDTO.price;
        this.VAT = itemDTO.VAT;
        this.name = itemDTO.name;
    }

    /**
     * creates a new Item with Item, clones Item
     * 
     * @param item - Item to clone
     */
    public Item(Item item) {
        this.itemID = item.itemID;
        this.price = item.price;
        this.VAT = item.VAT;
        this.name = item.name;
    }

    /**
     * Creates an new instance of an Item by inputting values
     * 
     * @param itemID   - ID for new Item
     * @param price    - price for new Item
     * @param VAT      - VAT for new Item
     * @param name     - Name for new Item
     * @param quantity - Quantity of new Item
     */
    public Item(int itemID, double price, double VAT, String name, int quantity) {
        this.itemID = itemID;
        this.price = price;
        this.VAT = VAT;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Increases the quantity for the Item
     * 
     * @param additionalQuantity - Integer value to increase quantity with
     */
    public void addToQuantity(int additionalQuantity) {
        this.quantity += additionalQuantity;
    }

    /**
     * Gets ItemID
     * 
     * @return the ItemID of Item
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Gets the price of Item
     * 
     * @return the value of Item price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the VAT of Item
     * 
     * @return the value of Item VAT
     */
    public double getVAT() {
        return VAT;
    }

    /**
     * Gets the name of Item
     * 
     * @return the String of Item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the quantity of Item
     * 
     * @return the value of Item quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
