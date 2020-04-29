package model;

import integration.ItemDTO;

public class ItemInSale {
    public ItemDTO itemDTO;
    public int howMany;

    public ItemInSale(ItemDTO item, int numberOfItems) {
        this.itemDTO = item;
        this.howMany = numberOfItems;
    }
}
