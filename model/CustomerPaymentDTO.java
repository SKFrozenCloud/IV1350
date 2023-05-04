package se.kth.iv1350.model;

/**
 * Represents CustomerPayment Data Transfer Object
 */
public class CustomerPaymentDTO {
    public double amountToPay;
    public double change;

    /**
     * creates a new instance of data transer object for CustomerPayment
     * 
     * @param customerPaymentToDTO - CustomerPayment to extract from
     */
    public CustomerPaymentDTO(CustomerPayment customerPaymentToDTO) {
        change = customerPaymentToDTO.getChange();
        amountToPay = customerPaymentToDTO.getAmount();
    }

}
