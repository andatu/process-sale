package model;

import integration.ItemDTO;
import integration.Printer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Sale sale;
    Payment payment;

    @Test
    void testPayment(){
        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        payment = new Payment(sale, 400);
        assertEquals(400, payment.getAmount());
    }
}