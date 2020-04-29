package startup;

import controller.Controller;
import integration.Printer;
import integration.SalesLog;
import integration.SystemCreator;
import model.CashRegister;
import view.View;

public class Main {
    /**
     * This starts the whole program
     * @param args, nothing to be passed
     */
    public static void main(String[] args) {

        SystemCreator sysC = new SystemCreator();
        Printer printer = new Printer();
        CashRegister cashReg = new CashRegister();
        SalesLog salesLog = new SalesLog();

        Controller contr = new Controller(sysC, printer, cashReg, salesLog);
        new View(contr).fakeExecution();


    }

}
