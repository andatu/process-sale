package controller;

import integration.*;
import integration.discount.DiscountStrategyOne;
import model.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<Observer> observerList = new ArrayList<>();

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
    public String registerItem(int itemID, int numberOfItems) throws ItemNotFoundException, ConnectionToDBFailedException {
        ItemDTO item = inventorySystem.getItem(itemID);
        sale.addItem(item, numberOfItems);
        return item.getItemDesc() + " " + item.getItemPrice();
    }

    /**
     * requests discount for a customer and applies the new total price to sale
     *
     * Here we could have that depending on customerID and Sale choose
     * which strategy to use, for now we only have one and that is
     * applied here
     *
     * @param customerID unique customerID
     */
    public double discountRequest(int customerID){
        this.discount = new Discount(new DiscountStrategyOne());
        double newTotal = discount.executeStrategy(customerID, sale);
        sale.applyDiscount(newTotal);
        return newTotal;
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
        payment.addPaymentObservers(observerList);
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

    public void addPaymentObserver(Observer obs){
        observerList.add(obs);
    }

}
