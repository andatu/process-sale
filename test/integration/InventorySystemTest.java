package integration;

import controller.Controller;
import model.CashRegister;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    InventorySystem invSys;
    Sale sale;
    private OutputStream os;

    @BeforeEach
    void setUp() {
        invSys = new InventorySystem();

        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
    }

    @AfterEach
    void tearDown() {
        invSys = null;
        PrintStream originalOut = System.out;
        System.setOut(originalOut);

    }

    @Test
    void getItemExists() {
        ItemDTO x = invSys.getItem(3);
        assertSame("Milk", x.getItemDesc());
    }

    @Test
    void getItemNotExists(){
        ItemDTO x = invSys.getItem(412);
        assertNull(x);
    }

    @Test
    void addItems(){
        int numberOfItems = invSys.getNumberOfItems();
        assertEquals(8, numberOfItems, "Items not added correctly");
    }

    @Test
    void updateInventory() {
        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        invSys.updateInventory(sale);
        String expectedResult = "Inventory";
        String actualResults = os.toString();
        assertTrue(actualResults.contains(expectedResult), "Inventory");
    }
}