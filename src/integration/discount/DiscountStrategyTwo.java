package integration.discount;

import model.Sale;

public class DiscountStrategyTwo implements IDiscountBehavior{

    /**
     * Second strategy for a discount
     * Does not do any calculation, hardcoded to give 10% discount
     *
     * could/should call DiscountRule for look-up in database
     */
    public DiscountStrategyTwo(){
    }

    @Override
    public double discountRequest(int customerID, Sale sale) {
        return sale.getTotalPriceAndVAT()*0.9;
    }
}
