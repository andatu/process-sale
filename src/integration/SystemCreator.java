package integration;

public class SystemCreator {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    public SystemCreator(){
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
    }

    public AccountingSystem getAccountingSystem(){
        return accountingSystem;
    }

    public InventorySystem getInventorySystem(){
        return inventorySystem;
    }

}
