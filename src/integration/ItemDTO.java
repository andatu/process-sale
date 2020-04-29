package integration;


/**
 * Class creating the item to be worked with in the program. From the database.
 */
public class ItemDTO {
    private String itemDesc;
    private double itemPrice;
    private int itemID;
    private int itemVAT;

    public ItemDTO(String itemDesc, double itemPrice, int itemID, int itemVAT){
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemVAT = itemVAT;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemVAT() {
        return itemVAT;
    }
}
