package view;

import integration.Rounder;
import model.Observer;

public class TotalRevenueDisplay implements Observer {
    private double totalRevenue;
    public TotalRevenueDisplay() {
        totalRevenue = 0;
    }

    @Override
    public void addPayment(double paymentToAdd) {
        this.totalRevenue += paymentToAdd;
        System.out.println("\nTOTAL REVENUE: " + Rounder.round(totalRevenue));
    }
}
