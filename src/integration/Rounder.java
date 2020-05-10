package integration;

/**
 * Class i created to show numbers with fewer decimals
 */
public class Rounder {
    public Rounder(){

    }
    public static double round(double numberToBeRounder){
        return Math.round(numberToBeRounder*100.0)/100.0;
    }
}
