package integration;

import model.Sale;

import java.util.ArrayList;

public class SalesLog {
    private ArrayList<Sale> al = new ArrayList<>();

    public void updateSalesLog(Sale sale){
        System.out.println("Updating Sales Log");
        al.add(sale);
    }

}
