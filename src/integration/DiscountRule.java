package integration;

import model.Sale;

public class DiscountRule {
    public double percentageOff;

    public DiscountRule(){
        this.percentageOff = 0;
    }

    public double checkDiscount(int customerID, Sale sale){
        this.percentageOff = 20;
        return percentageOff/100;
    }

    public double getPercentageOff(){
        return this.percentageOff;
    }

}
