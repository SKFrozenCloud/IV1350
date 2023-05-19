package se.kth.iv1350.exceptions;

/**
 * Represents a runtime exception for when the inventory database is not
 * available
 */

public class InventoryDatabaseException extends RuntimeException {
    /**
     * Creates a new instance of a runtime error for the inventory database
     */

    public InventoryDatabaseException() {
        super("The inventory system server is not available");
    }
}
