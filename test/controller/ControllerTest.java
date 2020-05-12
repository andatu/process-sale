package controller;

import integration.*;
import model.CashRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void registerItem() throws ItemNotFoundException {
        contr.newSale();
        String actualResult = contr.registerItem(0,2);
        String expectedResult = "Apple";
        assertTrue(actualResult.contains(expectedResult), "Banana not showing");
    }

    @Test
    void discountRequest() {
    }

    @Test
    void payment() throws ItemNotFoundException {
        contr.newSale();
        contr.registerItem(0,2);
        double actualResult = contr.payment(400);
        assertEquals(190, actualResult);
    }

    @Test
    void endSale() {
    }

    @Test
    void scanItemNotExist(){
        contr.newSale();
        int itemID = 111;
        try {
            contr.registerItem(itemID, 2);
        }catch(ItemNotFoundException e){
            assertTrue(e.getMessage().contains("No item with that item ID: " + itemID));
        }
    }

    @Test
    void scanItemDBDown() throws ItemNotFoundException{
        contr.newSale();
        int itemID = 10;
        int nrOfitem = 3;
        try{
            contr.registerItem(itemID, nrOfitem);
            fail("Item not in database found, FAIL");
        }catch (ConnectionToDBFailedException e) {
            assertTrue(e.getMessage().contains("System failed to reach database"));
        }

    }
}