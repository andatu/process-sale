package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemCreatorTest {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    @BeforeEach
    void setUp() {
        inventorySystem = InventorySystem.getInventory();
        accountingSystem = new AccountingSystem();
    }

    @AfterEach
    void tearDown() {
        inventorySystem = null;
        accountingSystem = null;
    }

    @Test
    void getAccountingSystem() {
    }

    @Test
    void getInventorySystem() {
    }
}