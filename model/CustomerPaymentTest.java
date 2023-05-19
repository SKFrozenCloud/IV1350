package se.kth.iv1350.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CustomerPaymentTest {
    private CustomerPayment customerPayment = new CustomerPayment();

    @Test
    void increaseAmountToPaySuccess() {
        customerPayment.increaseAmountToPay(10);
        double amountTest = customerPayment.getAmount();
        assertEquals(10, amountTest);
    }

    @Test
    void increaseAmountToPayFail() {
        customerPayment.increaseAmountToPay(10);
        double amountTest = customerPayment.getAmount();
        assertNotEquals(9, amountTest);
    }

    @Test
    void payAmountFail() {
        customerPayment.increaseAmountToPay(10);
        customerPayment.payAmount(9);
        double changeTest = customerPayment.getChange();
        assertNotEquals(2, changeTest);
    }

    @Test
    void payAmountSucess() {
        customerPayment.increaseAmountToPay(10);
        customerPayment.payAmount(9);
        double changeTest = customerPayment.getChange();
        assertEquals(1, changeTest);
    }
}