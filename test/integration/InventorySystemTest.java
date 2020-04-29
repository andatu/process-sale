package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    InventorySystem invSys;

    @BeforeEach
    void setUp() {
        invSys = new InventorySystem();
    }

    @AfterEach
    void tearDown() {
        invSys = null;
    }

    @Test
    void getItemExists() {
        ItemDTO x = invSys.getItem(3);
        assertSame("Milk", x.itemDesc);
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
    }
}