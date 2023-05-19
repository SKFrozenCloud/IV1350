package se.kth.iv1350.integration;

import se.kth.iv1350.model.CustomerPaymentObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * Represents a class that is used to output a file that implements the observer
 * interface
 */
public class TotalRevenueFileOutput implements CustomerPaymentObserver {
    private double totalRevenue;
    private PrintWriter logStream;

    /**
     * Creates a new file in folder that can be written to
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("TotalRevenue.txt"), true);
        } catch (IOException ioException) {
            System.out.println("Could not log");
            ioException.printStackTrace();
        }
    }

    /**
     * Implemented method that writes updated total revenue to a file
     * 
     * @param newPayment - new payment that increases total revenue
     */
    @Override
    public void newPayment(double newPayment) {
        totalRevenue += newPayment;
        logStream.println("Time: " + LocalTime.now() + " | Total Current Revenue: " + totalRevenue);
    }
}
