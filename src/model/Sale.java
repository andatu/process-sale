package model;

import integration.ItemDTO;
import integration.Printer;
import java.time.LocalDateTime;


/**
 * One single sale made by one costumer and payed with one payment
 */
public class Sale {
    /**
     *  Creates a new instance and saves the time of the sale.
     */
    private Printer printer;
    private Payment payment;
    private LocalDateTime ldt = LocalDateTime.now();
    private ItemInSale[] items = new ItemInSale[10]; //THIS WILL BE CHANGED TO ARRAYLIST FOR LAB 4
    private int numberOfTotalDifferentItems = 0;
    /*public double totalPrice = 0; //VAT excludued
    public double totalVAT = 0; //VAT
    public double totalPriceAndVAT = 0;*/
    private double totalPrice = 0; //VAT excludued
    private double totalVAT = 0; //VAT
    private double totalPriceAndVAT = 0;


    public Sale(Printer printer){
        this.printer = printer;
    }

    /**
     * adds item to ItemInSale array. If it exists it adds the number of items to already existing item
     *
     * @param addItem item to be added from controller
     * @param numberOfItems how many of these specific items
     */
    public void addItem(ItemDTO addItem, int numberOfItems){
        if(!doesExist(addItem.getItemID())){
            aI(addItem, numberOfItems);
        }
        else{
            for(int i = 0; i < numberOfTotalDifferentItems; i++){
                if(addItem.getItemID() == items[i].getItemDTO().getItemPrice()){
                    //items[i].getHowMany() += numberOfItems;
                    items[i].setHowMany(numberOfItems);
                    break;
                }
            }
        }
        updateTotal();
    }

    /**
     * help function for addItem
     * @param id the id of the item to be added
     * @return true or false
     */
    public boolean doesExist(int id){
        boolean tof = false;
        for(int i = 0; i < numberOfTotalDifferentItems; i++){
            if(items[i].getItemDTO().getItemID() == id){
                tof = true;
                break;
            }
        }
        return tof;
    }

    /**
     * help function to actually add the item for addItem
     * @param addItem the item to be added
     * @param numberOfItems how many of the item to be added
     */
    private void aI(ItemDTO addItem, int numberOfItems){
        items[this.numberOfTotalDifferentItems++] = new ItemInSale(addItem, numberOfItems);
        if(numberOfTotalDifferentItems == items.length){
            resizeArray();
        }
    }

    /**
     * help to resize the array when needed. THIS WILL BE CHANGED TO ARRAYLIST FOR LAB 4
     */
    private void resizeArray(){
        ItemInSale[] newItemsArray = new ItemInSale[this.items.length * 2];
        int i = 0;
        for(ItemInSale item : items){
            newItemsArray[i++] = item;
        }
        this.items = newItemsArray;
    }

    public void applyDiscount(double newTotal){
        this.totalPriceAndVAT = newTotal;
    }

    /**
     * updates the price and VAT for the whole sale
     */
    public void updateTotal(){
        double totalPriceI = 0;
        double totalVAT = 0;
        for(int i = 0; i < numberOfTotalDifferentItems; i++){
            totalPriceI += items[i].getItemDTO().getItemPrice() * items[i].getHowMany();
            totalVAT += items[i].getItemDTO().getItemPrice() * items[i].getItemDTO().getItemVAT()/100 * items[i].getHowMany();
        }
        this.totalPrice = totalPriceI;
        this.totalVAT = totalVAT;
        this.totalPriceAndVAT = this.totalPrice + this.totalVAT;
    }

    /**
     * creates a Payment for Sale
     * @param amount which is payed from View->Controller->Here
     * @return returns the payment to controller
     */
    public Payment pay(double amount){
        this.payment = new Payment(this, amount);
        print(createReceipt(this));
        return this.payment;
    }
    private Receipt createReceipt(Sale sale){
        return new Receipt(sale);
    }

    /**
     * Prints receipt
     */
    private void print(Receipt receipt){
        printer.printReceipt(receipt);
    }

    //GETTERS-----------SETTERS
    public LocalDateTime getLdt(){ return this.ldt; }
    public String getStoreAdress(){
        return "Kistavägen 32, 13423 Kista"; }
    public String getStoreName(){
        return "Butiken i hörnet"; }
    public int getNumberOfTotalDifferentItems(){ return this.numberOfTotalDifferentItems; }
    public double getTotalPriceAndVAT() { return this.totalPriceAndVAT; }
    public double getTotalPrice(){ return this.totalPrice; }
    public double getTotalVAT(){ return this.totalVAT; }
    public ItemInSale[] getItems() { return this.items; }
    public Payment getPayment(){ return this.payment; }
    public void setTotalPriceAndVAT(double x){ this.totalPriceAndVAT = x; }
}
