package integration;

import model.Receipt;

public class Printer {

    public void printReceipt(Receipt receipt){
        //System.out.println(receipt.toString());
        //receipt.toString();
        receipt.print();
    }
}
