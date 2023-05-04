package se.kth.iv1350.model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents the Data Transfer Object of a Sale
 */
public class SaleDTO {
    public LocalTime timeOfStartedSale;
    public ArrayList<ItemDTO> itemsCurrentlyInSale = new ArrayList<>();
    public double discount;
    public ReceiptDTO receiptDTO;
    public CustomerPaymentDTO customerPaymentDTO;

    /**
     * Creates a new instance, representing the Data Transfer Object of the Sale
     * class
     * 
     * @param saleToDTO - Sale to convert into a DTO
     */
    public SaleDTO(Sale saleToDTO) {
        this.timeOfStartedSale = saleToDTO.getTimeOfStartedSale();
        for (Item item : saleToDTO.getItemsCurrentlyInSale()) {
            this.itemsCurrentlyInSale.add(new ItemDTO(item));
        }

        this.receiptDTO = new ReceiptDTO(saleToDTO.getReceiptForSale());
        this.customerPaymentDTO = new CustomerPaymentDTO(saleToDTO.getCustomerPaymentForSale());

    }

}
