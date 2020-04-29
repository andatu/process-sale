package controller;

import integration.*;
import model.CashRegister;
import model.Discount;
import model.Payment;
import model.Sale;
import java.util.Scanner;

/**
 * All calls to model pass through here
 */

public class Controller {

    public SystemCreator sysC;
    public Printer printer;
    public CashRegister cashRegister;
    public SalesLog salesLog;
    public AccountingSystem accountingSystem;
    public InventorySystem inventorySystem;
    public Sale sale;
    public Discount discount;

    public Controller(SystemCreator sysC, Printer printer, CashRegister cashRegister, SalesLog salesLog){
        this.sysC = sysC;
        this.printer = printer;
        this.cashRegister = cashRegister;
        this.salesLog = salesLog;
        this.accountingSystem = sysC.getAccountingSystem();
        this.inventorySystem = sysC.getInventorySystem();
    }

    /**
     * Starts a new sale. This method must be called before doing anything else.
     * Starts the sale with the printer.
     */
    public void newSale(){ sale = new Sale(printer); }

    /**
     *
     * @param itemID item to be added to the sale
     * @param numberOfItems how many of said items
     */
    public String registerItem(int itemID, int numberOfItems){
        ItemDTO item = inventorySystem.getItem(itemID);
        sale.addItem(item, numberOfItems);
        return item.getItemDesc() + " " + item.getItemPrice();
    }

    /**
     * requests discount for a customer and applies the new total price to sale
     * @param customerID unique customerID
     */
    public void discountRequest(int customerID){
        this.discount = new Discount();
        double newTotal = discount.discountRequest(customerID, sale);
        System.out.println(newTotal);
        sale.applyDiscount(newTotal);
    }

    /**
     * Makes the payment of the sale
     * @param amount the amount to be payed
     * @return change back to view so the cashier can see it
     */
    public double payment(double amount){
        Payment payment = sale.pay(amount);
        cashRegister.addPayment(payment);
        inventorySystem.updateInventory(sale);
        accountingSystem.updateAccounting(sale);
        salesLog.updateSalesLog(sale);
        return payment.getChange();
    }

    /**
     * Just ends sale, no function right now, might be added something later.
     */
    public void endSale(){
    }

    public double getTotalPriceAndVat(){
        return sale.getTotalPriceAndVAT();
    }

}
