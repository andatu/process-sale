package model;


/**
 * Cashregister which keeps balance
 */
public class CashRegister {
    private double cashInRegister = 2000;

    /**
     * Adds payment to register
     * @param payment of the sale
     */
    public void addPayment(Payment payment){
        this.cashInRegister += payment.getAmount() - payment.getChange();
        System.out.println("Adding " + (payment.getAmount() - payment.getChange()) + " to the Cash Register");
    }

    public double getCashInRegister(){
        return this.cashInRegister;
    }
}
