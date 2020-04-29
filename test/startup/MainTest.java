package startup;

import controller.Controller;
import integration.Printer;
import integration.SalesLog;
import integration.SystemCreator;
import model.CashRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUp(){
        instanceToTest = new Main();

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
    void testUIHasStarted() {
        String[] args = null;
        Main.main(args);
        String printout = printoutBuffer.toString();
        String expectedOutput = "Start";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");
    }
}