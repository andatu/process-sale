package integration;


/**
 * Class creating the item to be worked with in the program. From the database.
 */
public class ItemDTO {
    public String itemDesc;
    public double itemPrice;
    public int itemID;
    public int itemVAT;

    public ItemDTO(String itemDesc, double itemPrice, int itemID, int itemVAT){
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemVAT = itemVAT;
    }

}
