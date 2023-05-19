package se.kth.iv1350.exceptions;

/**
 * Represents a runtime exception for when an itemID is not found
 */
public class MissingItemIDException extends RuntimeException {
    private int missingItemID;

    /**
     * Creates a new instance of a runtime exception error
     * 
     * @param missingItemID - the itemId that resulted in an exception
     */
    public MissingItemIDException(int missingItemID) {
        super("Item with itemID " + missingItemID + " was not found in external inventory system");
        this.missingItemID = missingItemID;
    }

    /**
     * Returns the itemID that was not registered in the system
     * 
     * @return the integer value of the itemID
     */
    public int getMissingItemID() {
        return missingItemID;
    }
}
