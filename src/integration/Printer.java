package integration;

import model.Receipt;

/**
 * Prinnts the receipt
 */
public class Printer {
    /**
     * Prints the receipt
     * @param receipt the receipt of the sale
     */
    public void printReceipt(Receipt receipt){
        //System.out.println(receipt.toString());
        //receipt.toString();
        receipt.print();
    }
}
