package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptTest {
    private Receipt receiptToTest;
    private Item itemToTest;

    @BeforeEach
    private void start() {
        receiptToTest = new Receipt();
        itemToTest = new Item(111, 100, 33, "lampa", 1);

    }

    @AfterEach
    private void breakDown() {
        receiptToTest = null;
        itemToTest = null;
    }

    @Test
    void addRow() {
        receiptToTest.addRow(itemToTest);
    }
}