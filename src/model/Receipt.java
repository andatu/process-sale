package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Creates receipt of the sale
 */
public class Receipt {
    Sale sale;
    public Receipt(Sale sale){ this.sale = sale; }


    /**
     * Prints out the receipt.
     * Called from printer.
     * Out commented code is the one that should run, but for alignment effects in printout second part is run.
     */
    //public String toString() {
    public void print() {
       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        String string = "\n*******Printing Receipt*******\n" + sale.getLdt().format(formatter) + "\n" + sale.getStoreName() + "\n" + sale.getStoreAdress();
        string += "\n\n" + "Item description  " + "Price  " + "VAT  " + "Quantity";
        for(int i = 0; i < sale.getNumberOfTotalDifferentItems(); i++){
            string += ("\n" + sale.getItems()[i].itemDTO.itemDesc) + "              " + sale.getItems()[i].itemDTO.itemPrice
                    + "     " + sale.getItems()[i].itemDTO.itemVAT+"%" + "      " + sale.getItems()[i].howMany;
        }
        string += "\n\nTotal price: " + sale.getTotalPrice()
                + "\nTotal VAT: " + sale.getTotalVAT()
                + "\nTotal to pay: " + sale.getTotalPriceAndVAT()
                + "\n\nTotal Payed: " + sale.getPayment().amount
                + "\nChange: " + sale.getPayment().change
                + "\n*******Receipt Done*******\n";*/
        //return string;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
        System.out.println("\n*******Printing Receipt*******");
        System.out.print(sale.getLdt().format(formatter) + "\n" + sale.getStoreName() + "\n" + sale.getStoreAdress());
        System.out.println("\n\n" + "Item description  " + "Price  " + "    VAT  " + "Quantity");
        for(int i = 0; i < sale.getNumberOfTotalDifferentItems(); i++) {
            System.out.printf("%-17s %-10.2f %d %4d\n", sale.getItems()[i].getItemDTO().getItemDesc(), sale.getItems()[i].getItemDTO().getItemPrice(),
                    sale.getItems()[i].getItemDTO().getItemVAT(), sale.getItems()[i].getHowMany());
        }
        System.out.println("" + "\nTotal price:      " + sale.getTotalPrice()
                + "\nTotal VAT:        " + sale.getTotalVAT()
                + "\nTotal to pay:     " + sale.getTotalPriceAndVAT()
                + "\n\nTotal Payed:      " + sale.getPayment().getAmount()
                + "\nChange:           " + sale.getPayment().getChange()
                + "\n*******Receipt Done*******\n");
    }
}
