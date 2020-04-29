package model;

import integration.ItemDTO;
import integration.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    Sale sale;
    Payment payment;
    CashRegister cashRegister = new CashRegister();

    @Test
    void addPayment() {
        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        payment = new Payment(sale, 400);
        double total = sale.getTotalPriceAndVAT();
        cashRegister.addPayment(payment);
        assertEquals(cashRegister.getCashInRegister(), 2000 + total); //Starts with 2000
    }
}