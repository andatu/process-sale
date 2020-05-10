package integration;

import model.Sale;

/**
 * Dummy database for discount
 *
 * not used anymore
 *
 */
public class DiscountRule {
    private double percentageOff;

    public DiscountRule(){
        this.percentageOff = 0;
    }

    /**
     * Checks the database for discount
     * @param customerID the customers id
     * @param sale the sale the customer do
     * @return returns the percentage off for the whole sale
     */
    public double checkDiscount(int customerID, Sale sale){
        this.percentageOff = 20;
        return percentageOff/100;
    }

    public double getPercentageOff(){
        return this.percentageOff;
    }

}
