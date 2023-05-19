package se.kth.iv1350.integration;

import se.kth.iv1350.exceptions.InventoryDatabaseException;
import se.kth.iv1350.exceptions.MissingItemIDException;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.ItemDTO;
import se.kth.iv1350.model.SaleDTO;

/**
 * Represents an inventory system that is used for fetching items
 */
public class InventorySystem {
    private Item[] itemsInDatabase = { new Item(121, 100, 30, "Pear", 3), new Item(123, 10, 3.33, "Avacado", 3) };

    private final int serverDownItemID = 404;

    public int getServerDownItemID() {
        return serverDownItemID;
    }

    /**
     * Updates quantity of items of sale
     * 
     * @param proccessedSale - sale that is completed
     */
    public void updateQuantityFromSale(SaleDTO proccessedSale) {
    }

    /**
     * Fetches itemDTO from the Inventory System through itemId
     * 
     * @param itemID - itemID to be found in the inventorySystem
     * @return returns an itemDTO if it is found, returns null if it is not found
     * @throws MissingItemIDException     if the given itemID was not found
     * @throws InventoryDatabaseException if the inventory System is unavailable
     */
    public ItemDTO getItemDTOFromDatabase(int itemID) throws MissingItemIDException, InventoryDatabaseException {
        if (itemID == 404) {
            throw new InventoryDatabaseException();
        }

        Item itemToReturn = null;

        for (Item item : itemsInDatabase) {
            if (item.getItemID() == itemID) {
                itemToReturn = item;
            }
        }

        if (itemToReturn == null) {
            throw new MissingItemIDException(itemID);
        }

        return new ItemDTO(itemToReturn);
    }

}
