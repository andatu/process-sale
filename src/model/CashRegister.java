package model;

public class CashRegister {
    private double cashInRegister = 2000;


    public void addPayment(Payment payment){
        this.cashInRegister += payment.amount - payment.change;
        System.out.println("Adding " + (payment.amount - payment.change) + " to the Cash Register");
    }

    public double getCashInRegister(){
        return this.cashInRegister;
    }
}
