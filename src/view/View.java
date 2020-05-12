package view;

import controller.Controller;
import integration.ConnectionToDBFailedException;
import integration.ItemNotFoundException;
import integration.Rounder;
import utilities.LogHandler;

import java.util.Scanner;

public class View {
    private Controller contr;
    private LogHandler logHandler = new LogHandler().getLogHandler();

    public View(Controller contr) {
        this.contr = contr;
        contr.addPaymentObserver(new TotalRevenueDisplay());
    }

    /**
     * Called from View
     * Performs a fake sale, by calling the system operations in the controller.
     * Easy to call executeSale to check the Total Revenue.
     */
    public void fakeExecution(){
        executeSale();
        executeSale();
    }

    /**
     * Calls in needed order for the sale.
     */
    private void executeSale(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Start new sale");
        contr.newSale();

        System.out.println("Registering items\n");
        scanItems();

        System.out.println("\nEnding Sale");
        contr.endSale();

        System.out.println("\nTotal with VAT is: " + Rounder.round(contr.getTotalPriceAndVat()));

        //Applying discount with Strategy pattern
        System.out.println("Price after discount: " + Rounder.round(contr.discountRequest(0)));

        System.out.println("How much are you paying?");
        double moneys = 1000;
        System.out.println("Paying with: " + moneys);
        double change = contr.payment(moneys);
        System.out.println("\nChange back to customer: " + Rounder.round(change));
    }

    private void logException(Exception e){
        logHandler.logException(e);
    }

    private void scanItems(){
        try{
            System.out.println(contr.registerItem(12,1));
        }catch(ItemNotFoundException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: Item not found");
        }catch(ConnectionToDBFailedException e){
            System.out.println("The item was not registered because of network connectivity problems, either on your end or the" +
                    "databases. Check your network and please try again.");
            logException(e);
        }
        try{
            System.out.println(contr.registerItem(10,1));
        }catch(ItemNotFoundException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: Item not found");
        }catch(ConnectionToDBFailedException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: the item was not registered because of network connectivity problems, either on your end or the" +
                    " databases. Check your network and please try again.");
        }
        try{
            System.out.println(contr.registerItem(1,3));
        }catch(ItemNotFoundException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: Item not found");
        }catch(ConnectionToDBFailedException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: the item was not registered because of network connectivity problems, either on your end or the" +
                    " databases. Check your network and please try again.");
        }
        try{
            System.out.println(contr.registerItem(2,1));
        }catch(ItemNotFoundException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: Item not found");
        }catch(ConnectionToDBFailedException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: the item was not registered because of network connectivity problems, either on your end or the" +
                    " databases. Check your network and please try again.");
        }
        try{
            System.out.println(contr.registerItem(3,1));
        }catch(ItemNotFoundException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: Item not found");
        }catch(ConnectionToDBFailedException e){
            System.out.print("For log: ");
            logException(e);
            System.out.println("For user: the item was not registered because of network connectivity problems, either on your end or the" +
                    " databases. Check your network and please try again.");
        }

    }
}
