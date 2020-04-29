package model;

import integration.ItemDTO;

/**
 * Creates item which is registered in sale.
 */
public class ItemInSale {
    private ItemDTO itemDTO;
    private int howMany;

    public ItemInSale(ItemDTO item, int numberOfItems) {
        this.itemDTO = item;
        this.howMany = numberOfItems;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany += howMany;
    }
}
