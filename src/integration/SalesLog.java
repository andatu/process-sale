package integration;

import model.Sale;

import java.util.ArrayList;

/**
 * Dummy sales log
 */
public class SalesLog {
    private ArrayList<Sale> al = new ArrayList<>();

    /**
     * Updates sales log
     * @param sale is what is added to sales log
     */
    public void updateSalesLog(Sale sale){
        System.out.println("Updating Sales Log");
        al.add(sale);
    }

}
