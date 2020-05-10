package view;

import integration.Rounder;
import model.Observer;
import model.Payment;

public class TotalRevenueDisplay implements Observer {
    private double totalRevenue;
    public TotalRevenueDisplay() {
        totalRevenue = 0;
    }

    @Override
    public void addPayment(double payment) {
        this.totalRevenue += payment;
        System.out.println("\nTOTAL REVENUE: " + Rounder.round(totalRevenue));
    }
}
