package integration.discount;

import model.Sale;

/**
 * Interface for discount calculations
 */
public interface IDiscountBehavior {

    double discountRequest(int customerID, Sale sale);
}
