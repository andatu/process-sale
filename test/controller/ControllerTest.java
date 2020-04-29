package controller;

import integration.Printer;
import integration.SalesLog;
import integration.SystemCreator;
import model.CashRegister;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import startup.Main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller contr;
    private OutputStream os;

    @BeforeEach
    public void setUp(){
        contr = new Controller(new SystemCreator(), new Printer(), new CashRegister(), new SalesLog());

        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @AfterEach
    public void tearDown(){
        contr = null;

        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    void newSale() {
        contr.newSale();
        assertNotNull(contr.sale);
    }

    @Test
    void registerItem() {
        contr.newSale();
        String actualResult = contr.registerItem(0,2);
        String expectedResult = "Apple";
        assertTrue(actualResult.contains(expectedResult), "Banana not showing");
    }

    @Test
    void discountRequest() {
    }

    @Test
    void payment() {
        contr.newSale();
        contr.registerItem(0,2);
        double actualResult = contr.payment(400);
        assertEquals(190, actualResult);
    }

    @Test
    void endSale() {
    }
}