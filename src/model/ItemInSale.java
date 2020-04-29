package model;

import integration.ItemDTO;

/**
 * Creates item which is registered in sale.
 */
public class ItemInSale {
    public ItemDTO itemDTO;
    public int howMany;

    public ItemInSale(ItemDTO item, int numberOfItems) {
        this.itemDTO = item;
        this.howMany = numberOfItems;
    }
}
