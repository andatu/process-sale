package integration;

import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AccountingSystemTest {
    AccountingSystem as;
    Sale sale;
    private OutputStream os;

    @BeforeEach
    void setUp() {
        as = new AccountingSystem();

        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @AfterEach
    void tearDown() {
        as = null;
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    @Test
    void updateAccounting() {
        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        as.updateAccounting(sale);
        String expectedResult = "Accounting";
        String actualResults = os.toString();
        assertTrue(actualResults.contains(expectedResult), "Accounting");
    }
}