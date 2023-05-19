package se.kth.iv1350.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.InventorySystem;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDatabaseExceptionTest {
    private InventorySystem inventorySystem = new InventorySystem();

    @AfterEach
    void cleanup() {
        inventorySystem = new InventorySystem();
    }

    @Test
    void testInventoryDataShouldThrowServerDownException() {
        int itemIDDown = 404;

        RuntimeException serverDownItemID = assertThrows(RuntimeException.class,
                () -> inventorySystem.getItemDTOFromDatabase(itemIDDown));

        assertEquals(serverDownItemID.getMessage(), "The inventory system server is not available");
    }

    @Test
    void testInventoryDataShouldNotThrowServerDownException() {
        int itemIDNotDown = 44;

        RuntimeException serverDownItemID = assertThrows(RuntimeException.class,
                () -> inventorySystem.getItemDTOFromDatabase(itemIDNotDown));

        assertNotEquals(serverDownItemID.getMessage(), "The inventory system server is not available");
    }

}