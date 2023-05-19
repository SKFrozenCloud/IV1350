package se.kth.iv1350.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.model.ItemDTO;
import se.kth.iv1350.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class MissingItemIDExceptionTest extends RuntimeException {

    private InventorySystem inventorySystem = new InventorySystem();

    @AfterEach
    public void cleanup() {
        inventorySystem = new InventorySystem();
    }

    @Test
    void testGetItemIDShouldThrowException() {
        int falseItemID = 12;

        RuntimeException missingItemIDException = assertThrows(RuntimeException.class,
                () -> inventorySystem.getItemDTOFromDatabase(falseItemID));

        assertEquals(missingItemIDException.getMessage(),
                "Item with itemID " + falseItemID + " was not found in external inventory system");
    }

    @Test
    void testGetItemIDShouldNotThrowException() {
        int realItemID = 121;

        assertDoesNotThrow(() -> inventorySystem.getItemDTOFromDatabase(realItemID));
    }

}