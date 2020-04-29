package model;

import integration.DiscountRule;

/**
 *
 */
public class Discount {
    public DiscountRule dr = new DiscountRule();

    public double discountRequest(int customerID, Sale sale){
        double discount = dr.checkDiscount(customerID, sale);
        return sale.getTotalPriceAndVAT() * (1-discount);
    }
}
