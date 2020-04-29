package model;

import integration.ItemDTO;
import integration.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import startup.Main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    Sale sale;
    Receipt receipt;

    private OutputStream os;

    @BeforeEach
    public void setUp(){
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @AfterEach
    public void tearDown(){
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    void testToString() {
        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        sale.pay(400);
        receipt = new Receipt(sale);
        receipt.print();
        String actualResults = os.toString();
        String expectedResult = "Banana";
        String expectedResult2 = "*******Receipt Done*******";
        assertTrue(actualResults.contains(expectedResult), "Banana");
        assertTrue(actualResults.contains(expectedResult2), "Receipt");
    }

}