package se.kth.iv1350.view;

import se.kth.iv1350.model.CustomerPaymentObserver;

/**
 * represents the view that shows total revenue
 */
public class TotalRevenueView implements CustomerPaymentObserver {
    private double totalRevenue;

    /**
     * Creates a new instance of the view that shows total revenue starting at 0
     */
    public TotalRevenueView() {
        totalRevenue = 0;
    }

    /**
     * updates the total revenue that prints current state
     * 
     * @param newPayment - increased amount of payment
     */
    @Override
    public void newPayment(double newPayment) {
        totalRevenue += newPayment;
        printCurrentState();

    }

    /**
     * Prints current state of total revenue
     */
    private void printCurrentState() {
        System.out.println("\n##");
        System.out.println("Total Revenue :" + totalRevenue);
        System.out.println("##\n");
    }
}
