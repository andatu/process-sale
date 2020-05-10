package model;

import integration.discount.IDiscountBehavior;

/**
 *
 */
public class Discount {
    public IDiscountBehavior db;

    public Discount(IDiscountBehavior db){
        this.db = db;
    }

    public double executeStrategy(int customerID, Sale sale){
        return this.db.discountRequest(customerID, sale);
    }

}
