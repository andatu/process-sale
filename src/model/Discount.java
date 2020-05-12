package model;

import integration.discount.IDiscountBehavior;

/**
 * The Discount the sale will have
 */
public class Discount {
    public IDiscountBehavior db;

    public Discount(IDiscountBehavior db){
        this.db = db;
    }

    /**
     * Calculates the discount to be returned
     * @param customerID customers ID
     * @param sale the Sale which discount will be implemented on
     * @return returns the new price for the Sale
     */
    public double executeStrategy(int customerID, Sale sale){
        return this.db.discountRequest(customerID, sale);
    }

}
