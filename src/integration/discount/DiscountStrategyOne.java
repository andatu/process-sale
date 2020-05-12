package integration.discount;

import model.Sale;

public class DiscountStrategyOne implements IDiscountBehavior{

    /**
     * First strategy for a discount
     * Does not do any calculation, hardcoded to give 20% discount
     *
     * could/should call DiscountRule for look-up in database
     */
    public DiscountStrategyOne(){
    }

    @Override
    public double discountRequest(int customerID, Sale sale) {
        return sale.getTotalPriceAndVAT()*0.8;
    }
}
