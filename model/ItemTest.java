package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item itemToTest;

    @BeforeEach
    private void before() {
        itemToTest = new Item(111, 100, 33, "lampa", 1);
    }

    @AfterEach
    private void breakDown() {
        itemToTest = null;
    }

    @Test
    void addToQuantitySuccess() {
        int amountAdded = 1;
        int amountBefore = itemToTest.getQuantity();

        itemToTest.addToQuantity(amountAdded);
        assertEquals(itemToTest.getQuantity(), amountAdded + amountBefore);
    }

}