package model;

import controller.Controller;
import integration.ItemDTO;
import integration.Printer;
import integration.SalesLog;
import integration.SystemCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale sale;
    Printer printer;
    Controller contr;
    View view;

    @BeforeEach
    void setUp() {
        contr = new Controller(new SystemCreator(), new Printer(), new CashRegister(), new SalesLog());
        sale = new Sale(printer);
        contr.sale = sale;
        view = new View(contr);
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    void addSingleItem() {
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        assertEquals(2, sale.getNumberOfTotalDifferentItems(), "items not added correctly");
    }

    @Test
    void addMultipleItem(){
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        ItemDTO three = new ItemDTO("Orange", 90, 2, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 3);
        sale.addItem(three, 1);
        assertEquals(640, sale.getTotalPrice());
        assertEquals(3, sale.getItems()[1].getHowMany());
        assertEquals(1, sale.getItems()[1].getItemDTO().getItemID());
        assertNull(sale.getItems()[3]);
    }

    //@Test
    @Test
    void applyDiscount() {
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        ItemDTO three = new ItemDTO("Orange", 90, 2, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        sale.addItem(three, 1);
        contr.discountRequest(32);
        assertEquals(340*1.05*0.8, sale.getTotalPriceAndVAT());
    }

    @Test
    void updateTotal() {
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        //ItemDTO three = new ItemDTO("Orange", 90, 2, 5);
        //ItemDTO four = new ItemDTO("Milk", 70, 3, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        //sale.addItem(three, 1);
        //sale.addItem(four, 1);
        sale.updateTotal();
        assertEquals(250, sale.getTotalPrice(), "wrong");
        assertEquals(sale.getTotalPriceAndVAT(), 250 * 1.05);
    }

    /**
     * Not able to test because of private methods. Will give this another shot for SEM 4
     */
    @Disabled
    void pay() {
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        ItemDTO three = new ItemDTO("Orange", 90, 2, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        sale.addItem(three, 1);
        Payment payment = sale.pay(450);
        assertEquals(450, payment.getAmount(), "this");
        assertEquals(250, payment.getChange(), "that");
    }
}