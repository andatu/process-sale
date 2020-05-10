package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Payment made by costumer
 */
public class Payment {
    private double amount;
    private double change;
    private double addToRegister;
    private List<Observer> paymentObservers = new ArrayList<>();

    public Payment(Sale sale, double amount){
        this.amount = amount;
        this.change = (sale.getTotalPriceAndVAT() - amount) * -1;
        this.addToRegister = this.amount - this.change;
    }

    public double getAmount() {
        return amount;
    }
    public double getChange() {
        return change;
    }
    public double getAddToRegister() {
        return addToRegister;
    }
    public void addPaymentObserver(Observer obs){
        paymentObservers.add(obs);
    }
    public void addPaymentObservers(List<Observer> observers){
        paymentObservers.addAll(observers);
        notifyObservers();
    }
    private void notifyObservers() {
        for (Observer obs : paymentObservers) {
            obs.addPayment(addToRegister);
        }
    }
}
