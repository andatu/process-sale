package integration;

import model.Sale;

/**
 * Dummy inventory system which is supposed to get item from database and create ItemDTOs to store.
 * Now ItemDTOs are created manually instead,
 */
public class InventorySystem {
    private static final InventorySystem INSTANCE = new InventorySystem();
    private ItemDTO[] items = new ItemDTO[10];
    private int numberOfItems = 0;
    private final int dbCrasher = 10;

    /**
     *
     * @return the only existing instance of this singleton.
     */
    public static InventorySystem getInventory(){
        return INSTANCE;
    }

    private InventorySystem(){
        addItems();
    }

    /**
     * Checks if items exists. This function seems unnecessary
     * @param itemID the item that is being registered
     * @return tof a boolean
     */
    public boolean itemExists(int itemID) {
        //find the item in itemLIST
        boolean tof = false;
        for (ItemDTO item : items) {
            if (item.getItemID() == itemID) {
                tof = true;
                break;
            }
        }
        System.out.println(tof);
        return tof;
    }

    /**
     * Gets the item from database if it exists
     * @param itemID the item that is being registered
     * @return the item if it exists, else null
     */
    public ItemDTO getItem(int itemID) throws ItemNotFoundException {
       // boolean tof = itemExists(itemID);
        if(itemID==dbCrasher){
            throw new ConnectionToDBFailedException("System failed to reach database");
        }else {
            ItemDTO returnedItem = null;
            for (int i = 0; i < this.numberOfItems; i++) {
                if (itemID == this.items[i].getItemID()) {
                    returnedItem = this.items[i];
                    break;
                }
            }
            if(returnedItem==null){
                throw new ItemNotFoundException("No item with that item ID: " + itemID);
            }
            return returnedItem;
        }
    }


    /**
     * Adds items manually and counts how many objects are in the inventoryArray
     */
    private void addItems(){
        //add item database to itemLIST
        items[0] = new ItemDTO("Apple", 100, 0, 5);
        items[1] = new ItemDTO("Banana", 150, 1, 5);
        items[2] = new ItemDTO("Orange", 90, 2, 5);
        items[3] = new ItemDTO("Milk", 70, 3, 5);
        items[4] = new ItemDTO("Coke", 12, 4, 10);
        items[5] = new ItemDTO("Ham", 50, 5, 15);
        items[6] = new ItemDTO("Toothbrush", 30, 6, 20);
        items[7] = new ItemDTO("Shampoo", 25, 7, 20);

        //for(int i = 0; i < items.length; i++){
        for (ItemDTO item : items) {
            if (item != null) {
                this.numberOfItems += 1;
            }
        }
    }

    public int getNumberOfItems(){
        return numberOfItems;
    }

    public void updateInventory(Sale sale){
        System.out.println("Updating Inventory");
    }


}
