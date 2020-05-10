package model;

import model.CashRegister;

public interface Observer {
    void addPayment(double payment);
}
