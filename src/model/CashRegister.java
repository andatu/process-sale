package model;


import integration.Rounder;

/**
 * Cashregister which keeps balance.
 */
public class CashRegister {
    private double cashInRegister = 2000;
    private double addedToRegister;

    /**
     * Adds payment to register
     * @param payment of the sale
     */
    public void addPayment(Payment payment) {
        this.addedToRegister = payment.getAddToRegister();
        //this.addedToRegister = payment.getAmount() - payment.getChange();
        this.cashInRegister += payment.getAddToRegister();
        //this.cashInRegister += payment.getAmount() - payment.getChange();
        System.out.println("Adding " + Rounder.round((payment.getAmount() - payment.getChange())) + " to the Cash Register");
    }

    public double getCashInRegister(){
        return this.cashInRegister;
    }
    public double getAddedToRegister(){return this.addedToRegister;}
}
