package integration;

import model.CashRegister;
import model.Payment;
import model.Receipt;
import model.Sale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import startup.Main;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    Sale sale;
    Printer printer;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @Disabled
    void printReceipt() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        sale = new Sale(new Printer());
        ItemDTO one = new ItemDTO("Apple", 100, 0, 5);
        ItemDTO two = new ItemDTO("Banana", 150, 1, 5);
        sale.addItem(one, 1);
        sale.addItem(two, 1);
        sale.pay(400);
        printer.printReceipt(new Receipt(sale));
        //printer.printReceipt(new Receipt(sale));
        //String printout = printoutBuffer.toString();
        //assertTrue(printout.contains("Apple"), "Not printing correctly");
    }
}