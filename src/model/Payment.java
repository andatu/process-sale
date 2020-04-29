package model;

public class Payment {
    public double amount;
    public double change;

    public Payment(Sale sale, double amount){
        this.amount = amount;
        this.change = (sale.getTotalPriceAndVAT() - amount) * -1;
        //System.out.println(this.amount);
        //System.out.println(this.change);
    }

}
