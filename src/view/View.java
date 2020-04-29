package view;

import controller.Controller;

import java.util.Scanner;

public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Performs a fake sale, by calling the system operations in the controller.
     */
    public void fakeExecution(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Start new sale");
        contr.newSale();

        System.out.println("Registering items\n");

        System.out.println(contr.registerItem(0,1));
        System.out.println(contr.registerItem(1,1));
        System.out.println(contr.registerItem(1,3));
        System.out.println(contr.registerItem(2,1));
        System.out.println(contr.registerItem(3,1));


        System.out.println("\nEnding Sale");
        contr.endSale();
        System.out.println("\nTotal with VAT is: " + contr.getTotalPriceAndVat());
        /*System.out.println("1:Pay or 2:Discount?");
        //int answer = sc.nextInt();   //DISCOUNT FÖR SEM 4
        int answer = 2; //***********
        if(answer == 2){
            System.out.println("Requesting discount...\nEnter customer id: ");
            //int id = sc.nextInt();
            int id = 23; //************
            System.out.println("Customer id: " + id);
            contr.discountRequest(id);
            System.out.println("\nTotal with VAT including discount is: " + contr.sale.totalPriceAndVAT);
        }*/

        System.out.println("How much are you paying?");
        //double moneys = sc.nextDouble();
        double moneys = 1000; //********
        System.out.println("Paying with: " + moneys);
        double change = contr.payment(moneys);
        System.out.println("\nChange back to customer: " + change);

    }
}
