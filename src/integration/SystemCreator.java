package integration;

/**
 * Creates all needed systems.
 */
public class SystemCreator {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    public SystemCreator(){
        //inventorySystem = new InventorySystem();
        inventorySystem = InventorySystem.getInventory();
        accountingSystem = new AccountingSystem();
    }
    public AccountingSystem getAccountingSystem(){
        return accountingSystem;
    }
    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }

}
