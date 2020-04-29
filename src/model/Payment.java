package model;

/**
 * Payment made by costumer
 */
public class Payment {
    private double amount;
    private double change;

    public Payment(Sale sale, double amount){
        this.amount = amount;
        this.change = (sale.getTotalPriceAndVAT() - amount) * -1;
    }

    public double getAmount() {
        return amount;
    }

    public double getChange() {
        return change;
    }
}
