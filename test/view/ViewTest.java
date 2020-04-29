package view;

import controller.Controller;
import integration.Printer;
import integration.SalesLog;
import integration.SystemCreator;
import model.CashRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp(){
       Controller contr = new Controller(new SystemCreator(), new Printer(), new CashRegister(), new SalesLog());
       instanceToTest = new View(contr);

       printoutBuffer = new ByteArrayOutputStream();
       PrintStream inMemSysOut = new PrintStream(printoutBuffer);
       originalSysOut = System.out;
       System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown(){
        instanceToTest = null;
        printoutBuffer = null;

        System.setOut(originalSysOut);

    }

    @Test
    void testFakeExecution() {
        instanceToTest.fakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "Ending";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");
    }
}