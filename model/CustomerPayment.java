package se.kth.iv1350.model;

import se.kth.iv1350.integration.TotalRevenueFileOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a CustomerPayment
 */
public class CustomerPayment {
    private double amountToPay;
    private double change;
    private double paidAmount;
    private List<CustomerPaymentObserver> customerPaymentObservers = new ArrayList<>();
    private TotalRevenueFileOutput totalRevenueFileOutput;

    /**
     * create a new instance of CustomerPayment with starting values of zero payment
     */
    public CustomerPayment() {
        this.amountToPay = 0;
        this.change = 0;
    }

    /**
     * Increases the amount of amount to pay
     * 
     * @param increasingAmount - the value to increase with
     */
    public void increaseAmountToPay(double increasingAmount) {
        this.amountToPay += increasingAmount;
    }

    /**
     * Gets the amount to pay
     * 
     * @return the value of amount to pay
     */
    public double getAmount() {
        return amountToPay;
    }

    /**
     * Registers the paymentAmount that decides the change for CustomerPayment
     * 
     * @param paymentAmount - the value of paid amount
     */
    public void payAmount(double paymentAmount) {
        change = paymentAmount - amountToPay;
        paidAmount = paymentAmount;
        notifyCustomerPaymentObservers();
        updateTotalRevenueLog();
    }

    /**
     * sets a class that can output to file for this class
     * 
     * @param totalRevenueFileOutput - class that outputs to file
     */
    public void setTotalRevenueFileOutput(TotalRevenueFileOutput totalRevenueFileOutput) {
        this.totalRevenueFileOutput = totalRevenueFileOutput;
    }

    /**
     * Registers observers that will be notified when CustomerPayment changes state
     * 
     * @param customerPaymentObserver - The observer that will be notified of the
     *                                change
     */
    public void addCustomerPaymentObservers(List<CustomerPaymentObserver> customerPaymentObserver) {
        customerPaymentObservers.addAll(customerPaymentObserver);
    }

    /**
     * Notifies observers for CustomerPayment class with amount for sale
     */
    private void notifyCustomerPaymentObservers() {
        for (CustomerPaymentObserver customerPaymentObserver : customerPaymentObservers)
            customerPaymentObserver.newPayment(paidAmount - change);
    }

    /**
     * Updates amount for sale that updates the log
     */
    private void updateTotalRevenueLog() {
        totalRevenueFileOutput.newPayment(paidAmount - change);
    }

    /**
     * Gets change of CustomerAmount
     * 
     * @return the value of change
     */
    public double getChange() {
        return change;
    }

    public double getPaidAmount() {
        return paidAmount;
    }
}
