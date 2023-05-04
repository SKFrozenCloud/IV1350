package se.kth.iv1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.integration.AccountingSystem;
import se.kth.iv1350.integration.InventorySystem;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.ItemDTO;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleDTO;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private AccountingSystem accountSysController;
    private InventorySystem inventorySystemController;
    private Printer printerController;
    private Sale saleController;
    private Controller controllerToTest;

    @BeforeEach
    private void setUpController() {
        accountSysController = new AccountingSystem();
        printerController = new Printer();
        inventorySystemController = new InventorySystem();
        controllerToTest = new Controller(accountSysController, inventorySystemController, printerController);
        controllerToTest.startSale();
    }

    @AfterEach
    private void resetController() {
        controllerToTest = null;
        saleController = null;
        printerController = null;
        inventorySystemController = null;
        accountSysController = null;
        saleController = null;
    }

    @Test
    void scanItemSuccess() {
        int itemID = 123;
        boolean itemWasAdded = false;

        controllerToTest.scanItem(itemID);
        Item item = new Item(inventorySystemController.getItemDTOFromDatabase(itemID));

        if (controllerToTest.getSaleController().isItemInSale(item))
            itemWasAdded = true;

        assertEquals(itemWasAdded, true);
    }

    @Test
    void startSaleSucceed() {
        controllerToTest.startSale();
        controllerToTest.getSaleController();
        assertNotEquals(controllerToTest.getSaleController(), null);
    }

    @Test
    void endSaleSuccess() {
        controllerToTest.endSale();
        assertEquals(controllerToTest.getSaleController(), null);
    }

    @Test
    void endSaleFailed() {
        boolean isNull;
        controllerToTest.endSale();
        Sale notNullSale = controllerToTest.getSaleController();

        if (notNullSale != null) {
            isNull = false;
        } else
            isNull = true;

        assertTrue(isNull);
    }

    @Test
    void paySaleSuccess() {
        controllerToTest.scanItem(123);
        double changeShouldBe = 190;
        double amount = controllerToTest.paySale(200);
        assertEquals(changeShouldBe, amount);
    }

}