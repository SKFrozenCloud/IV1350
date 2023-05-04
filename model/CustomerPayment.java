package se.kth.iv1350.model;

/**
 * Represents a CustomerPayment
 */
public class CustomerPayment {
    private double amountToPay;
    private double change;
    private double paidAmount;

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
