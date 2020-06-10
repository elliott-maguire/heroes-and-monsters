package adventure.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    Action testAction = new Charge();

    @Before
    void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void printName() {
        testAction.printName();
        assertEquals("Charge\n", outContent.toString());
    }

    @Test
    void printDescription() {
        testAction.printDescription();
        assertEquals("A heavy, unstoppable attack with a run-up.\n", outContent.toString());
    }

    @After
    void restoreStream() {
        System.setOut(originalOut);
    }
}
