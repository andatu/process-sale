package integration;

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
        invSys = InventorySystem.getInventory();

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
    void getItemExists() throws ItemNotFoundException {
        ItemDTO x = invSys.getItem(3);
        assertSame("Milk", x.getItemDesc());
    }

    @Test
    void getItemNotExists() {
        int itemID = 500;
        try {
            invSys.getItem(itemID);
            fail("Item not in database found, FAIL");
        }catch(ItemNotFoundException e){
            assertTrue(e.getMessage().contains("No item with that item ID: " + itemID));
        }

        //assertNull(x);
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