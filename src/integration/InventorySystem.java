package integration;

import model.Sale;

/**
 * Dummy inventorysystem which is supposed to get item from database and create ItemDTOs to store.
 * Now ItemDTOs are created manually instead,
 */
public class InventorySystem {

    private ItemDTO[] items = new ItemDTO[10];
    private int numberOfItems = 0;

    InventorySystem(){
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
            if (item.itemID == itemID) {
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
    public ItemDTO getItem(int itemID){
       // boolean tof = itemExists(itemID);
        ItemDTO returnedItem = null;
        for (int i = 0; i < this.numberOfItems; i++) {
            if (itemID == this.items[i].itemID) {
                returnedItem = this.items[i];
                break;
            }
        }
        return returnedItem;
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

        for(int i = 0; i < items.length; i++){
            if(items[i] != null){
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
