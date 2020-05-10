package integration.discount;

import model.Sale;

public interface IDiscountBehavior {

    double discountRequest(int CustomerID, Sale sale);
}
